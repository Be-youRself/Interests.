#ifndef USERWINDOW_H
#define USERWINDOW_H

#include <set>

#include <QMainWindow>
#include <QMessageBox>
#include <QToolButton>
#include <QPixmap>
#include <QWidget>
#include <QThread>
#include <QCloseEvent>
#include <QDebug>

#include "signalcontroller.h"
#include "nim_cpp_api.h"
#include "friendutil.h"
#include "userutil.h"
#include "signalcontroller.h"
#include "messageutil.h"
#include "chatwindow.h"

namespace Ui {
	class UserWindow;
}


class UserWindow : public QMainWindow
{
	Q_OBJECT

public:
	explicit UserWindow(QWidget *parent = 0);
	~UserWindow();
	void init();
	QString getToken();
	QString getAccid();
	QString getPassword();
	void setToken(QString);
	void setAccid(QString);
	void setPassword(QString);
	void addFriend(QString username, QString accid, QString icon, QString description);
	void showReceivedInfo(nim::IMMessage msg);

protected:
	void closeEvent(QCloseEvent* event);
private:
	Ui::UserWindow *ui;
	QString accid;
	QString token;
	QString password;
	// 已经显示的聊天窗口的集合	
	std::set<ChatWindow* > onShowingChatWindow;

signals:

private slots:
	void realLoginSuccessSlot();
	void onFriendAccidGetSlot(std::vector<std::string>);
	void onFriendDetailedInfoGetSlot(std::vector<nim::UserNameCard>);
	void onMessageSent(nim::SendMessageArc arc);
	void openChatWindow();
	void onMessagesReceived(std::list<nim::IMMessage> msgs);
	void onMessageReceived(nim::IMMessage msg);
};

#endif // USERWINDOW_H
