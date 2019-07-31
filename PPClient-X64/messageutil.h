#pragma once

#include <QUuid>
#include <QDateTime>
#include <QDebug>
#include <string>

#include "nim_cpp_api.h"
#include "signalcontroller.h"

class MessageUtil {
public:
	MessageUtil();
	~MessageUtil();

	static void sendTextMsg(std::string receiverId, std::string message);
	static void onSendTextMsg(const nim::SendMessageArc arc);
	static void receiveMsgCallback(const nim::IMMessage& msg);	/**< ������Ϣ֪ͨ�ص� */
	static void receiveMsgsCallback(const std::list<nim::IMMessage>& msgs); /**< ����������Ϣ֪ͨ�ص� */
};

