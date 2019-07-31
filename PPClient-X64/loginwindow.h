#ifndef LOGINWINDOW_H
#define LOGINWINDOW_H

#include <QMainWindow>
#include <QDesktopServices>
#include <QtGui/QMouseEvent>
#include <QUrl>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QJsonObject>
#include <QJsonDocument>
#include <QJsonArray>
#include <QThread>
#include <QShortcut>

#include "nim_cpp_api.h"
#include "waitingdialog.h"
#include "userwindow.h"

namespace Ui {
	class LoginWindow;
}

class LoginWindow : public QMainWindow
{
	Q_OBJECT

public:
	explicit LoginWindow(QWidget *parent = 0);
	~LoginWindow();

private:
	Ui::LoginWindow *ui;
	WaitingDialog *waitingDialog;
	UserWindow *userWindow;

	QString accid;
	QString password;
	QPoint mMousePoint;
	bool mDragWindow;
protected:
	virtual void mousePressEvent(QMouseEvent *e);
	virtual void mouseMoveEvent(QMouseEvent *e);
	virtual void mouseReleaseEvent();

private slots:
	void loginPostFinished(QNetworkReply*);

	void on_bt_register_clicked();
	void on_bt_login_clicked();
};

#endif // LOGINWINDOW_H
