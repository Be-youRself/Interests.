#pragma once
#include <QObject>
#include <QDebug>
#include "nim_cpp_api.h"
#include "chatwindow.h"

//TODO 了解前置声明
class ChatWindow;
/** @enum 信号类型 */
enum SignalType {
	realLoginSuccessSignal =  1,	/**< 网易云信登录成功 */
	onFriendListAccidGet = 2,	    /**< 好友ACCID获取成功 */
	onFriendDetailedInfoGet = 3,    /**< 好友详细信息获取成功 */
	onMessageSent = 4,				/**< 获取消息发送回执成功 */
	receiveMessage = 5,				/**< 收到单条消息 */
	receiveMessages = 6,			/**< 收到多条消息 */
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

