#include "signalcontroller.h"

/** 非整型常量静态成员初始化 */
SignalController* SignalController::signalController = new SignalController;

SignalController::SignalController(){
}


SignalController::~SignalController(){
}

void SignalController::emitSignalByType(SignalType type) {
	if (type == SignalType::realLoginSuccessSignal) {
		emit realLoginSuccessSignal();
	}
}

void SignalController::emitSignalByTypeWithStringParams(SignalType type, std::vector<std::string> params) {
	if (type == SignalType::onFriendListAccidGet) {
		emit onFriendListAccidGet(params);
	}
}


void SignalController::emitSignalByTypeWithUserParams(SignalType type, std::vector<nim::UserNameCard> params){
	if (type == SignalType::onFriendDetailedInfoGet) {
		emit onFriendDetailedInfoGet(params);
	}
}

void SignalController::emitSignalByTypeWithMessageArc(SignalType type, nim::SendMessageArc arc) {
	if (type == SignalType::onMessageSent) {
		emit onMessageSent(arc);
	}
}

void SignalController::emitSignalByTypeWithIMMessage(SignalType type, nim::IMMessage msg) {
	if (type == SignalType::receiveMessage) {
		emit onMessageReceived(msg);
	}
}
void SignalController::emitSignalByTypeWithIMMessages(SignalType type, std::list<nim::IMMessage> msgs) {
	if (type == SignalType::receiveMessages) {
		emit onMessagesReceived(msgs);
	}
}