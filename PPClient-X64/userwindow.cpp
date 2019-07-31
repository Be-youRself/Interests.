#include "userwindow.h"
#include "ui_userwindow.h"

// CaptainShen last modified on 2018.6.12

UserWindow::UserWindow(QWidget *parent) :
	QMainWindow(parent),
	ui(new Ui::UserWindow) {
	ui->setupUi(this);
	//控制主界面出现在屏幕右侧可修改
	this->setGeometry(1500, 150, 255, 750);
	this->setWindowTitle(QString::fromLocal8Bit("PP即时通讯v0.99"));
	this->setWindowFlags(Qt::WindowStaysOnTopHint);
	// layout初始化!
	QVBoxLayout *Layout_Friends = new QVBoxLayout(ui->Friends);
	Layout_Friends->setSpacing(10);
	Layout_Friends->setContentsMargins(10, 10, 10, 10);
	Layout_Friends->setAlignment(Qt::AlignTop);
	QVBoxLayout *Layout_BlackList = new QVBoxLayout(ui->BlackList);
	Layout_BlackList->addStretch();
	Layout_BlackList->setSpacing(10);
	Layout_BlackList->setContentsMargins(10, 10, 10, 10);
	Layout_BlackList->setAlignment(Qt::AlignTop);

	// 信号槽绑定
	connect(SignalController::signalController, SIGNAL(realLoginSuccessSignal()), this, SLOT(realLoginSuccessSlot()));
	connect(SignalController::signalController, SIGNAL(onFriendListAccidGet(std::vector<std::string>)),
			this, SLOT(onFriendAccidGetSlot(std::vector<std::string>)));
	connect(SignalController::signalController, SIGNAL(onFriendDetailedInfoGet(std::vector<nim::UserNameCard>)),
			this, SLOT(onFriendDetailedInfoGetSlot(std::vector<nim::UserNameCard>)));
	connect(SignalController::signalController, SIGNAL(onMessageSent(nim::SendMessageArc)),
			this, SLOT(onMessageSent(nim::SendMessageArc)));
	connect(SignalController::signalController, SIGNAL(onMessageReceived(nim::IMMessage)),
			this, SLOT(onMessageReceived(nim::IMMessage)));
	connect(SignalController::signalController, SIGNAL(onMessagesReceived(std::list<nim::IMMessage>)),
			this, SLOT(onMessagesReceived(std::list<nim::IMMessage>)));
}

UserWindow::~UserWindow() {
	delete ui;
}

/*
 * 退出前清理工作
 */
void UserWindow::closeEvent(QCloseEvent* event) {
	nim::Client::Cleanup();
	std::set<ChatWindow*>::iterator iter = onShowingChatWindow.begin();
	while (iter != onShowingChatWindow.end()) {
		ChatWindow* window = *iter;
		window->close();
		++iter;
	}
}
void UserWindow::setAccid(QString accid) {
	this->accid = accid;
}

QString UserWindow::getAccid() {
	return this->accid;
}

void UserWindow::setToken(QString token) {
	this->token = token;
}

QString UserWindow::getToken() {
	return this->token;
}

void UserWindow::setPassword(QString password) {
	this->password = password;
}

QString UserWindow::getPassword() {
	return this->password;
}

//////////////////////////////////
////////////SDK相关///////////////
//////////////////////////////////

void UserWindow::init() {
	/*
	 * 载入云信SDK
	 * 初始化用户目录 AppData\local\PP
	 * 动态库在exe文件同级目录
	 */
	std::string app_key = "1a731c12193eda390008211dda639e97";
	nim::SDKConfig config;
	config.database_encrypt_key_ = "canyouhearthesingledogsing";

	bool ret = nim::Client::Init(app_key, "PP", "", config);

	if (ret) {
		/*
		 * SDK加载成功
		 * 登录
		 * 同步离线消息 系统通知
		 */
		nim::Client::Login(app_key, accid.toStdString(), token.toStdString(), &UserUtil::onLoginCallback, "");
	}
	else {
		QMessageBox message(QMessageBox::Warning, QString::fromLocal8Bit("错误"),
							QString::fromLocal8Bit("SDK缺失"), QMessageBox::Ok);
		if (message.exec() == QMessageBox::Ok) {
			this->close();
		}
	}
}

//////////////////////////////////
//////////Qt信号槽相关////////////
//////////////////////////////////

void UserWindow::realLoginSuccessSlot() {
	/*
	 *	注册回调
	 */
	nim::Friend::RegChangeCb(FriendUtil::onFriendListChange);
	nim::Friend::GetList(FriendUtil::onGetFriendList);
	nim::Talk::RegSendMsgCb(MessageUtil::onSendTextMsg);
	nim::Talk::RegReceiveCb(MessageUtil::receiveMsgCallback);
	nim::Talk::RegReceiveMessagesCb(MessageUtil::receiveMsgsCallback);
}

/*
 * 好友ID获取成功
 */
void UserWindow::onFriendAccidGetSlot(std::vector<std::string> accids) {
	accids.push_back(this->getAccid().toStdString());
	std::list<std::string> accidList;
	int index = 0;
	int friendNum = accids.size();
	for (int i = 0; i < friendNum; ++i) {
		++index;
		accidList.push_back(accids[i]);
		// 单次查询上限150人
		if (i == friendNum - 1 || index == 150) {
			//TODO 本地保存用户查询
			nim::User::GetUserNameCardOnline(accidList, UserUtil::onGetUserCard);
			index = 0;
			accidList.clear();
		}
	}
}

/*
 * 用户详细信息获取成功
 */
void UserWindow::onFriendDetailedInfoGetSlot(std::vector<nim::UserNameCard> friends) {
	QVBoxLayout *vlayout = new QVBoxLayout();
	for (int i = 0; i < friends.size(); ++i) {
		/* 在UI界面绘制好友信息
		 * 用户名格式 username(accid)
		 */
		nim::UserNameCard user = friends[i];
		if (user.GetAccId() == this->getAccid().toStdString()) {
			// 登录用户自身信息
			QString username = QString::fromStdString(user.GetName());
			QString signature =  QString::fromStdString(user.GetSignature());
			this->ui->name->setText(username);
			if (signature == NULL || signature == "") {
				this->ui->signature->setText(QString::fromLocal8Bit("这个人很懒,什么都没有留下"));
			}
			else {
				this->ui->signature->setText(signature);
			}
		}
		else {
			this->addFriend(QString::fromStdString(user.GetName()),
							QString::fromStdString(user.GetAccId()),
							QString::fromStdString(user.GetIconUrl()),
							QString::fromStdString(user.GetSignature()));
		}
		
	}
}
/*
 * 格式 username + (accid) + "\n" + signature
 */
void UserWindow::addFriend(QString friendName, QString accid,QString icon, QString signature) {
	friendName += "(";
	friendName += accid;
	friendName += ")";
	if (signature == NULL || signature == "") {
		signature = QString::fromLocal8Bit("这个人很懒,什么都没有留下");
	}
	//TODO 修改头像URL地址
	icon = QString::fromStdString(":/img/portrait.png");
	QToolButton *friendBtn = new QToolButton(this->ui->Friends);
	QPixmap *pixmap = new QPixmap(icon);
	friendBtn->setText(friendName + "\n" + signature);
	friendBtn->setIcon(*pixmap);
	//设置头像大小
	friendBtn->setIconSize(QSize(60, 60));
	friendBtn->setAutoRaise(true);
	friendBtn->setToolButtonStyle(Qt::ToolButtonTextBesideIcon);
	friendBtn->setFixedWidth(266);

	ui->Friends->layout()->addWidget(friendBtn);
	// 按钮信号槽连接
	connect(friendBtn, SIGNAL(clicked()),
			this, SLOT(openChatWindow()));
}

/*
 * 打开个人聊天窗口
 */
void UserWindow::openChatWindow() {
	QToolButton* chosenBtn = (QToolButton*)sender();
	QString info = chosenBtn->text();
	/*
	 * 解析包含用户名、账号、签名的字符串
	 * 获取accid
	 */
	QString friendName = "";
	QString receiverAccid = "";
	info = info.trimmed();
	int index = 0;
	while (info[index] != '(') {
		friendName.append(info[index]);
		++index;
	}
	++index;
	while (info[index] != ')') {
		receiverAccid.append(info[index]);
		++index;
	}
	std::set<ChatWindow*>::iterator iter = onShowingChatWindow.begin();
	bool isNewWindow = true;
	ChatWindow* window = nullptr;
	while (iter != onShowingChatWindow.end()) {
		window = *iter;
		// 该聊天窗口对象已经存在
		if (window->getReceiverAccid() == receiverAccid) {
			isNewWindow = false;
			break;
		}
		++iter;
	}
	/*
	 * 初始化聊天窗口对象
	 */
	if (isNewWindow) {
		ChatWindow *chatWindow = new ChatWindow();
		chatWindow->setFriendName(friendName);
		chatWindow->setReceiverAccid(receiverAccid);
		chatWindow->updateWindowTitle();
		chatWindow->show();
		this->onShowingChatWindow.insert(chatWindow);
	}
	else {
		window->show();
	}
}

/*
 * 消息发送回执处理
 */

void UserWindow::onMessageSent(nim::SendMessageArc arc) {
	if (arc.rescode_ == nim::NIMResCode::kNIMResSuccess) {
		QString receiverAccid = QString::fromStdString(arc.talk_id_);
		std::set<ChatWindow*>::iterator iter = onShowingChatWindow.begin();
		while (iter != onShowingChatWindow.end()) {
			ChatWindow* window = *iter;
			if (window->getReceiverAccid() == receiverAccid) {
				QDateTime time = QDateTime::fromTime_t(arc.msg_timetag_ / 1000);
				window->realSendMessageSuccess(time.toLocalTime().toString());
			}
			++iter;
		}
	}
	else {
		//TODO 消息发送错误处理
	}
}

/*
 * 单条消息获取
 */
void UserWindow::onMessageReceived(nim::IMMessage msg) {
	qDebug() << QString::fromStdString(msg.ToJsonString(false));
	this->showReceivedInfo(msg);
}

/*
 * 多条消息获取
 */

void UserWindow::onMessagesReceived(std::list<nim::IMMessage> msgs) {
	std::list<nim::IMMessage>::iterator iter = msgs.begin();
	while (iter != msgs.end()) {
		qDebug() << QString::fromStdString((*iter).ToJsonString(false));
		nim::IMMessage msg = *iter;
		this->showReceivedInfo(msg);
		++iter;
	}
}

/*
 * UserWindow把消息分发给各窗口
 */
void UserWindow::showReceivedInfo(nim::IMMessage msg) {
	bool received = false;
	QString receiverAccid = QString::fromStdString(msg.sender_accid_);
	std::set<ChatWindow*>::iterator iter = onShowingChatWindow.begin();
	while (iter != onShowingChatWindow.end()) {
		ChatWindow* window = *iter;
		if (window->getReceiverAccid() == receiverAccid) {
			window->receiveMessage(msg);
			received = true;
		}
		++iter;
	}
	// 创建和该好友的聊天对象窗口
	if (!received) {
		ChatWindow* newChatWindow = new ChatWindow();
		newChatWindow->setReceiverAccid(QString::fromStdString(msg.sender_accid_));
		newChatWindow->setFriendName(QString::fromStdString(msg.readonly_sender_nickname_));
		newChatWindow->setReceiverAccid(receiverAccid);
		newChatWindow->updateWindowTitle();
		newChatWindow->receiveMessage(msg);
		onShowingChatWindow.insert(newChatWindow);
	}
}