#include "friendutil.h"


//////////////////////////////////
////////////SDK���///////////////
//////////////////////////////////

FriendUtil::FriendUtil() {
}


FriendUtil::~FriendUtil() {
}


/*
 * 1.��ȡ������Ϣ�ص�
 * 2.��ȡaccid�����ź�
 * 3.�ڲۺ����и���accid��ȡ���Ѿ�����Ϣ
 */
void FriendUtil::onGetFriendList(nim::NIMResCode res, const std::list<nim::FriendProfile>& friendList) {
	std::vector<std::string> accids;

	std::list<nim::FriendProfile>::const_iterator iter = friendList.begin();
	for (; iter != friendList.end(); ++iter) {
		nim::FriendProfile profile = *iter;
		std::string accid = profile.GetAccId();
		accids.push_back(accid);
	}
	SignalController::signalController->emitSignalByTypeWithStringParams(SignalType::onFriendListAccidGet, accids);
}
/*
* ������Ϣ����ص�
*/
void FriendUtil::onFriendListChange(const nim::FriendChangeEvent& event) {
	switch (event.type_) {
		// ɾ������
		case nim::kNIMFriendChangeTypeDel: {
			break;
		}
		// ����������� | ������Ӻ���
		case nim::kNIMFriendChangeTypeRequest: {
			break;
		}
		// �����б�ͬ������
		case nim::kNIMFriendChangeTypeSyncList: {
			break;
		}
		// ���º���
		case nim::kNIMFriendChangeTypeUpdate: {
			break;
		}
		default:
		break;
	}
}