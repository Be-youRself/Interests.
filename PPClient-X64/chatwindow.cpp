#include "chatwindow.h"
#include "ui_chatwindow.h"

ChatWindow::ChatWindow(QWidget *parent) :
	QMainWindow(parent),
	ui(new Ui::ChatWindow) {
	ui->setupUi(this);
	this->setWindowFlags(Qt::FramelessWindowHint);
	//����һ����ݼ���ctrl+return����ϼ� ���̰���������Ϣ
	QShortcut *key = new QShortcut(QKeySequence(tr("ctrl+return")), this);
	connect(key, SIGNAL(activated()), this, SLOT(sendMessage()));
	
	connect(this->ui->Send, SIGNAL(clicked()), this, SLOT(sendMessage()));
	connect(this->ui->quit, SIGNAL(clicked()), this, SLOT(hide()));
}


ChatWindow::~ChatWindow() {
	// delete ui;
}


void ChatWindow::setFriendName(QString friendName) {
	this->friendName = friendName;
}

void ChatWindow::setReceiverAccid(QString receiverAccid) {
	this->receiverAccid = receiverAccid;
}

QString ChatWindow::getFriendName() {
	return this->friendName;
}

QString ChatWindow::getReceiverAccid() {
	return this->receiverAccid;
}

void ChatWindow::updateWindowTitle() {
	QString title = QString::fromLocal8Bit("������");
	title += friendName;
	title += QString::fromLocal8Bit("����");
	this->ui->title->setText(title);
}
void ChatWindow::sendMessage() {
	ui->Tip->clear();
	QString message = ui->Writer->toPlainText().toHtmlEscaped();
	if (message == "") {
		ui->Tip->setText(QString::fromLocal8Bit("�������ݲ���Ϊ�գ����������룡"));
	}
	else {
		/*
		 *	������Ϣ,ͨ���ص������ж��Ƿ��ͳɹ�, �����ź��޸�UI����
		 */
		MessageUtil::sendTextMsg(this->getReceiverAccid().toStdString(), message.toStdString());
		/*
		QTime current_time = QTime::currentTime();
		QString text = QString::fromLocal8Bit("<p align = 'left'><font color=green>��");
		text += current_time.toString();
		text += QString::fromLocal8Bit("</font></p>");
		QString text1 = QString::fromLocal8Bit("<p align = 'left'>");
		text1 += message;
		text1 += QString::fromLocal8Bit("</p>");
		ui->Reader->append(text);
		ui->Reader->append(text1);
		ui->Writer->clear();
		receiveMessage();
		*/
	}
}

/*
 * ������Ϣ��ִ��ʾ�ɹ� ����UI����
 */
void ChatWindow::realSendMessageSuccess(QString time) {
	QString message = ui->Writer->toPlainText().toHtmlEscaped();
	QString tipText = QString::fromLocal8Bit("<p align = 'left'><font color=green>�� ");
	tipText += time;
	tipText += QString::fromLocal8Bit("</font></p>");
	QString messageText = QString::fromLocal8Bit("<p align = 'left'>");
	messageText += message;
	messageText += QString::fromLocal8Bit("</p>");
	ui->Writer->clear();
	ui->Reader->append(tipText);
	ui->Reader->append(messageText);
}


void ChatWindow::receiveMessage(nim::IMMessage msg) {
	/*
	QTime current_time = QTime::currentTime();
	QString message = QString::fromLocal8Bit("���");
	QString text = QString::fromLocal8Bit("<p align = 'left'><font color=blue>");
	text += friendName;
	text += current_time.toString();
	text += QString::fromLocal8Bit("</font></p>");
	QString a = QString::fromLocal8Bit("<p align = 'left'>");
	a += message;
	a += QString::fromLocal8Bit("</p>");
	ui->Reader->append(text);
	ui->Reader->append(a);
	*/

	//TODO ������ HTML�������
	if (msg.rescode_ == nim::kNIMResSuccess) {
		QString tipText = QString::fromLocal8Bit("<p align = 'left'><font color=blue>");
		QString friendName = QString::fromStdString(msg.readonly_sender_nickname_);

		QDateTime sendTime = QDateTime::fromTime_t(msg.timetag_ / 1000);
		tipText += friendName;
		tipText += QString::fromLocal8Bit(" ");
		tipText += sendTime.toString();
		tipText += QString::fromLocal8Bit("</font></p>");

		QString text = QString::fromLocal8Bit("<p align = 'left'>");
		text += QString::fromStdString(msg.content_);
		text += QString::fromLocal8Bit("</p>");
		this->ui->Reader->append(tipText);
		this->ui->Reader->append(text);
	}
	else {
		
	}
	//TODO ��Ϣ��ʾ ��ֱ����ʾ
	this->show();
}
/*
* ��д��������¼�ʹ���ޱ߿򴰿ڿ��ƶ�
*/
void ChatWindow::mousePressEvent(QMouseEvent *e) {
	if (e->button() == Qt::LeftButton) {
		mMousePoint = e->globalPos() - this->pos();
		e->accept();
		mDragWindow = true;
	}
}

void ChatWindow::mouseMoveEvent(QMouseEvent *e) {
	if (mDragWindow && (e->buttons() && Qt::LeftButton)) {
		this->move(e->globalPos() - mMousePoint);
		e->accept();
	}
}

void ChatWindow::mouseReleaseEvent() {
	mDragWindow = false;
}
