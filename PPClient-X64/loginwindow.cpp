#include "loginwindow.h"
#include "ui_loginwindow.h"
#include <QDebug>
// TODO ����������������뷨

LoginWindow::LoginWindow(QWidget *parent) :
	QMainWindow(parent),
	ui(new Ui::LoginWindow) {

	ui->setupUi(this);

	// ���ý������������֮����ȥ��������
	this->setWindowFlags(Qt::WindowStaysOnTopHint | Qt::FramelessWindowHint);

	// �źŲ۰�
	connect(ui->bt_quit, SIGNAL(clicked(bool)), this, SLOT(close()));
	// ע��س���ݼ�
	QShortcut *key = new QShortcut(QKeySequence(Qt::Key_Return), this);
	connect(key, SIGNAL(activated()), this, SLOT(on_bt_login_clicked()));
}

LoginWindow::~LoginWindow() {
	delete ui;
}

void LoginWindow::on_bt_register_clicked() {
	QDesktopServices::openUrl(QUrl("http://pp.collegefun.cn"));
}

void LoginWindow::on_bt_login_clicked() {
	ui->lb_login_tip->clear();
	accid = ui->ledt_accid->text().toUtf8();
	password = ui->ledt_password->text().toUtf8();
	/*
	 * ��¼�˺Ÿ�ʽУ��(������)
	 */
	for (int i = 0; i < accid.length(); ++i) {
		QChar c = accid.at(i);
		if (!(c >= '0' && c <= '9')) {
			ui->lb_login_tip->setText(QString::fromLocal8Bit("�˺Ÿ�ʽ����(������)"));
			return;
		}
	}
	if (accid.length() == 0 || password.length() == 0) {
		ui->lb_login_tip->setText(QString::fromLocal8Bit("�û��������벻��Ϊ��"));
	}
	else {
		waitingDialog = new WaitingDialog();
		waitingDialog->show();

		QNetworkAccessManager *loginManager = new QNetworkAccessManager();
		QNetworkRequest request;
		QUrl loginUrl = QUrl(QString("http://pp.collegefun.cn/appLogin"));

		request.setUrl(loginUrl);
		request.setHeader(QNetworkRequest::ContentTypeHeader, "application/x-www-form-urlencoded");

		QByteArray postData;
		postData.append("accid=" + accid + "&password=" + password);

		loginManager->post(request, postData);

		connect(loginManager, SIGNAL(finished(QNetworkReply*)),
			this, SLOT(loginPostFinished(QNetworkReply*)));
	}

}

void LoginWindow::loginPostFinished(QNetworkReply *reply) {
	QThread::sleep(1);
	if (reply->error() == QNetworkReply::NoError) {
		QByteArray array = reply->readAll();
		QJsonObject object = QJsonDocument::fromJson(array).object();
		/*
		 * �û�������У��ʧ��
		 */
		if (!object.contains("accid")) {
			waitingDialog->close();
			ui->lb_login_tip->setText(QString::fromLocal8Bit("�û��������벻ƥ��"));
		}
		else {
			QString token = object.value("token").toString();
			waitingDialog->close();
			this->close();
			userWindow = new UserWindow();
			userWindow->setAccid(accid);
			userWindow->setToken(token);
			userWindow->setPassword(password);
			userWindow->init();
			userWindow->show();
		}
	}
	else {
		ui->lb_login_tip->setText(QString::fromLocal8Bit("����������"));
	}
}

/*
 * ��д��������¼�ʹ���ޱ߿򴰿ڿ��ƶ�
 */
void LoginWindow::mousePressEvent(QMouseEvent *e) {
	if (e->button() == Qt::LeftButton) {
		mMousePoint = e->globalPos() - this->pos();
		e->accept();
		mDragWindow = true;
	}
}

void LoginWindow::mouseMoveEvent(QMouseEvent *e) {
	if (mDragWindow && (e->buttons() && Qt::LeftButton)) {
		this->move(e->globalPos() - mMousePoint);
		e->accept();
	}
}

void LoginWindow::mouseReleaseEvent() {
	mDragWindow = false;
}
