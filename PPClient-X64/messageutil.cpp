#include "messageutil.h"



MessageUtil::MessageUtil() {
}


MessageUtil::~MessageUtil() {
}

/*
 * 发送文本消息
 */
//TODO 富文本消息支持
void MessageUtil::sendTextMsg(std::string receiverId, std::string message) {
	// 封装发送的消息
	QUuid id = QUuid::createUuid();
	std::string client_msg_id = id.toString().toStdString();
	// 消息属性设置
	// http://dev.yunxin.163.com/docs/product/IM%E5%8D%B3%E6%97%B6%E9%80%9A%E8%AE%AF/SDK%E5%BC%80%E5%8F%91%E9%9B%86%E6%88%90/Windows%E5%BC%80%E5%8F%91%E9%9B%86%E6%88%90/%E7%B1%BB%E4%B8%8E%E5%B8%B8%E9%87%8F%E5%AE%9A%E4%B9%89%E8%AF%B4%E6%98%8E#MessageSetting
	nim::MessageSetting setting;
	setting.anti_apam_using_yidun_ = 0;
	// timetag
	QDateTime time = QDateTime::currentDateTime();
	int64_t timetag = time.toTime_t();
	std::string jsonMsg = nim::Talk::CreateTextMessage(receiverId, nim::NIMSessionType::kNIMSessionTypeP2P,
													   client_msg_id, message, setting, timetag);
	nim::Talk::SendMsg(jsonMsg);
}

/*
 * 发送消息回调
 */
void MessageUtil::onSendTextMsg(const nim::SendMessageArc arc) {
	// qDebug() << QString::fromStdString(arc.msg_id_);
	// qDebug() << QString::fromStdString(std::to_string(arc.rescode_));
	// 返回值/1000 获取正常日期
	// qDebug() << arc.msg_timetag_;
	// qDebug() << QDateTime::fromTime_t(arc.msg_timetag_ / 1000).toString();
	// talk_id_ 信息接收方id
	// qDebug() << QString::fromStdString(arc.talk_id_);
	SignalController::signalController->emitSignalByTypeWithMessageArc(SignalType::onMessageSent, arc);
}

/*
 * 接收单条消息回调
 */
void MessageUtil::receiveMsgCallback(const nim::IMMessage& msg) {
	SignalController::signalController->emitSignalByTypeWithIMMessage(SignalType::receiveMessage, msg);
}

/*
 * 批量接收消息回调
 */
void MessageUtil::receiveMsgsCallback(const std::list<nim::IMMessage>& msgs) {
	SignalController::signalController->emitSignalByTypeWithIMMessages(SignalType::receiveMessages, msgs);
}