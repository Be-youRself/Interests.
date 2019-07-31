#pragma once
#ifndef CHATWINDOW_H
#define CHATWINDOW_H

#include <QMainWindow>
#include <QTime>
#include <QShortcut>
#include <QPoint>
#include <QMouseEvent>

#include "messageutil.h"
#include "signalcontroller.h"
namespace Ui {
	class ChatWindow;
}

class ChatWindow : public QMainWindow {
	Q_OBJECT

public:
	explicit ChatWindow(QWidget *parent = 0);
	~ChatWindow();
	QString friendName;
	QString	receiverAccid;

	QString getFriendName();
	QString getReceiverAccid();
	
	void setFriendName(QString friendName);
	void setReceiverAccid(QString receiverAccid);
	void realSendMessageSuccess(QString time);
	void updateWindowTitle();
	void receiveMessage(nim::IMMessage msg);
public slots:
	void sendMessage();
	
protected:
	virtual void mousePressEvent(QMouseEvent *e);
	virtual void mouseMoveEvent(QMouseEvent *e);
	virtual void mouseReleaseEvent();

private:
	Ui::ChatWindow *ui;
	QPoint mMousePoint;
	bool mDragWindow;
};

#endif // PP_CHAT_H


