#pragma once
#include <QObject>
#include <QDebug>
#include "nim_cpp_api.h"
#include "chatwindow.h"

//TODO �˽�ǰ������
class ChatWindow;
/** @enum �ź����� */
enum SignalType {
	realLoginSuccessSignal =  1,	/**< �������ŵ�¼�ɹ� */
	onFriendListAccidGet = 2,	    /**< ����ACCID��ȡ�ɹ� */
	onFriendDetailedInfoGet = 3,    /**< ������ϸ��Ϣ��ȡ�ɹ� */
	onMessageSent = 4,				/**< ��ȡ��Ϣ���ͻ�ִ�ɹ� */
	receiveMessage = 5,				/**< �յ�������Ϣ */
	receiveMessages = 6,			/**< �յ�������Ϣ */
};
class SignalController : public QObject{
	Q_OBJECT
public:
	SignalController();
	~SignalController();
	void emitSignalByType(SignalType);
	void emitSignalByTypeWithStringParams(SignalType, std::vector<std::string>);
	void emitSignalByTypeWithUserParams(SignalType type, std::vector<nim::UserNameCard>);
	void emitSignalByTypeWithMessageArc(SignalType type, nim::SendMessageArc arc);
	void emitSignalByTypeWithIMMessage(SignalType type, nim::IMMessage msg);
	void emitSignalByTypeWithIMMessages(SignalType type, std::list<nim::IMMessage> msgs);
	static SignalController* signalController;
signals:
	void realLoginSuccessSignal();
	void onFriendListAccidGet(std::vector<std::string>);
	void onFriendDetailedInfoGet(std::vector<nim::UserNameCard>);
	void onMessageSent(nim::SendMessageArc);
	void onMessageReceived(nim::IMMessage);
	void onMessagesReceived(std::list<nim::IMMessage>);
};

