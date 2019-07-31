#include "userutil.h"


UserUtil::UserUtil() {
}


UserUtil::~UserUtil() {
}


/*
 * ��¼�ص�����
 */
void UserUtil::onLoginCallback(const nim::LoginRes& res) {
	if (res.res_code_ == nim::kNIMResSuccess) {
		if (res.login_step_ == nim::kNIMLoginStepLogin) {
			/*
			*	���ŵ�½�ɹ�
			*	���͵�¼�ɹ��ź�
			*/
			SignalController::signalController->emitSignalByType(SignalType::realLoginSuccessSignal);
		}
	}
	else {
		//TODO ���ŵ�¼ʧ�ܴ���
		qDebug() << "fail" << res.res_code_;
	}
}

/*
 * ������ϸ��Ϣ��ȡ�ص�
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