#include "userutil.h"


UserUtil::UserUtil() {
}


UserUtil::~UserUtil() {
}


/*
 * 登录回调函数
 */
void UserUtil::onLoginCallback(const nim::LoginRes& res) {
	if (res.res_code_ == nim::kNIMResSuccess) {
		if (res.login_step_ == nim::kNIMLoginStepLogin) {
			/*
			*	云信登陆成功
			*	发送登录成功信号
			*/
			SignalController::signalController->emitSignalByType(SignalType::realLoginSuccessSignal);
		}
	}
	else {
		//TODO 云信登录失败处理
		qDebug() << "fail" << res.res_code_;
	}
}

/*
 * 好友详细信息获取回调
 */

void UserUtil::onGetUserCard(const std::list<nim::UserNameCard> friends) {
	std::list<nim::UserNameCard>::const_iterator iter = friends.begin();
	std::vector<nim::UserNameCard> friendsVec;
	for (; iter != friends.end(); ++iter) {
		// friendsVec.push_back(*iter);
		nim::UserNameCard user = *iter;
		friendsVec.push_back(user);
	}
	SignalController::signalController->emitSignalByTypeWithUserParams(
			SignalType::onFriendDetailedInfoGet, friendsVec);
}