#include "userwindow.h"
#include "ui_userwindow.h"

// CaptainShen last modified on 2018.6.12

UserWindow::UserWindow(QWidget *parent) :
	QMainWindow(parent),
	ui(new Ui::UserWindow) {
	ui->setupUi(this);
	//�����������������Ļ�Ҳ���޸�
	this->setGeometry(1500, 150, 255, 750);
	this->setWindowTitle(QString::fromLocal8Bit("PP��ʱͨѶv0.99"));
	this->setWindowFlags(Qt::WindowStaysOnTopHint);
	// layout��ʼ��!
	QVBoxLayout *Layout_Friends = new QVBoxLayout(ui->Friends);
	Layout_Friends->setSpacing(10);
	Layout_Friends->setContentsMargins(10, 10, 10, 10);
	Layout_Friends->setAlignment(Qt::AlignTop);
	QVBoxLayout *Layout_BlackList = new QVBoxLayout(ui->BlackList);
	Layout_BlackList->addStretch();
	Layout_BlackList->setSpacing(10);
	Layout_BlackList->setContentsMargins(10, 10, 10, 10);
	Layout_BlackList->setAlignment(Qt::AlignTop);

	// �źŲ۰�
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
 * �˳�ǰ������
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
////////////SDK���///////////////
//////////////////////////////////

void UserWindow::init() {
	/*
	 * ��������SDK
	 * ��ʼ���û�Ŀ¼ AppData\local\PP
	 * ��̬����exe�ļ�ͬ��Ŀ¼
	 */
	std::string app_key = "1a731c12193eda390008211dda639e97";
	nim::SDKConfig config;
	config.database_encrypt_key_ = "canyouhearthesingledogsing";

	bool ret = nim::Client::Init(app_key, "PP", "", config);

	if (ret) {
		/*
		 * SDK���سɹ�
		 * ��¼
		 * ͬ��������Ϣ ϵͳ֪ͨ
		 */
		nim::Client::Login(app_key, accid.toStdString(), token.toStdString(), &UserUtil::onLoginCallback, "");
	}
	else {
		QMessageBox message(QMessageBox::Warning, QString::fromLocal8Bit("����"),
							QString::fromLocal8Bit("SDKȱʧ"), QMessageBox::Ok);
		if (message.exec() == QMessageBox::Ok) {
			this->close();
		}
	}
}

//////////////////////////////////
//////////Qt�źŲ����////////////
//////////////////////////////////

void UserWindow::realLoginSuccessSlot() {
	/*
	 *	ע��ص�
	 */
	nim::Friend::RegChangeCb(FriendUtil::onFriendListChange);
	nim::Friend::GetList(FriendUtil::onGetFriendList);
	nim::Talk::RegSendMsgCb(MessageUtil::onSendTextMsg);
	nim::Talk::RegReceiveCb(MessageUtil::receiveMsgCallback);
	nim::Talk::RegReceiveMessagesCb(MessageUtil::receiveMsgsCallback);
}

/*
 * ����ID��ȡ�ɹ�
 */
void UserWindow::onFriendAccidGetSlot(std::vector<std::string> accids) {
	accids.push_back(this->getAccid().toStdString());
	std::list<std::string> accidList;
	int index = 0;
	int friendNum = accids.size();
	for (int i = 0; i < friendNum; ++i) {
		++index;
		accidList.push_back(accids[i]);
		// ���β�ѯ����150��
		if (i == friendNum - 1 || index == 150) {
			//TODO ���ر����û���ѯ
			nim::User::GetUserNameCardOnline(accidList, UserUtil::onGetUserCard);
			index = 0;
			accidList.clear();
		}
	}
}

/*
 * �û���ϸ��Ϣ��ȡ�ɹ�
 */
void UserWindow::onFriendDetailedInfoGetSlot(std::vector<nim::UserNameCard> friends) {
	QVBoxLayout *vlayout = new QVBoxLayout();
	for (int i = 0; i < friends.size(); ++i) {
		/* ��UI������ƺ�����Ϣ
		 * �û�����ʽ username(accid)
		 */
		nim::UserNameCard user = friends[i];
		if (user.GetAccId() == this->getAccid().toStdString()) {
			// ��¼�û�������Ϣ
			QString username = QString::fromStdString(user.GetName());
			QString signature =  QString::fromStdString(user.GetSignature());
			this->ui->name->setText(username);
			if (signature == NULL || signature == "") {
				this->ui->signature->setText(QString::fromLocal8Bit("����˺���,ʲô��û������"));
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
 * ��ʽ username + (accid) + "\n" + signature
 */
void UserWindow::addFriend(QString friendName, QString accid,QString icon, QString signature) {
	friendName += "(";
	friendName += accid;
	friendName += ")";
	if (signature == NULL || signature == "") {
		signature = QString::fromLocal8Bit("����˺���,ʲô��û������");
	}
	//TODO �޸�ͷ��URL��ַ
	icon = QString::fromStdString(":/img/portrait.png");
	QToolButton *friendBtn = new QToolButton(this->ui->Friends);
	QPixmap *pixmap = new QPixmap(icon);
	friendBtn->setText(friendName + "\n" + signature);
	friendBtn->setIcon(*pixmap);
	//����ͷ���С
	friendBtn->setIconSize(QSize(60, 60));
	friendBtn->setAutoRaise(true);
	friendBtn->setToolButtonStyle(Qt::ToolButtonTextBesideIcon);
	friendBtn->setFixedWidth(266);

	ui->Friends->layout()->addWidget(friendBtn);
	// ��ť�źŲ�����
	connect(friendBtn, SIGNAL(clicked()),
			this, SLOT(openChatWindow()));
}

/*
 * �򿪸������촰��
 */
void UserWindow::openChatWindow() {
	QToolButton* chosenBtn = (QToolButton*)sender();
	QString info = chosenBtn->text();
	/*
	 * ���������û������˺š�ǩ�����ַ���
	 * ��ȡaccid
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
		// �����촰�ڶ����Ѿ�����
		if (window->getReceiverAccid() == receiverAccid) {
			isNewWindow = false;
			break;
		}
		++iter;
	}
	/*
	 * ��ʼ�����촰�ڶ���
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
 * ��Ϣ���ͻ�ִ����
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
		//TODO ��Ϣ���ʹ�����
	}
}

/*
 * ������Ϣ��ȡ
 */
void UserWindow::onMessageReceived(nim::IMMessage msg) {
	qDebug() << QString::fromStdString(msg.ToJsonString(false));
	this->showReceivedInfo(msg);
}

/*
 * ������Ϣ��ȡ
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
 * UserWindow����Ϣ�ַ���������
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
	// �����͸ú��ѵ�������󴰿�
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