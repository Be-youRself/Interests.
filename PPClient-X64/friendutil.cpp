#include "friendutil.h"


//////////////////////////////////
////////////SDK相关///////////////
//////////////////////////////////

FriendUtil::FriendUtil() {
}


FriendUtil::~FriendUtil() {
}


/*
 * 1.获取好友信息回调
 * 2.获取accid发送信号
 * 3.在槽函数中根据accid获取好友具体信息
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
* 好友信息变更回调
*/
void FriendUtil::onFriendListChange(const nim::FriendChangeEvent& event) {
	switch (event.type_) {
		// 删除好友
		case nim::kNIMFriendChangeTypeDel: {
			break;
		}
		// 处理好友请求 | 请求添加好友
		case nim::kNIMFriendChangeTypeRequest: {
			break;
		}
		// 好友列表同步更新
		case nim::kNIMFriendChangeTypeSyncList: {
			break;
		}
		// 更新好友
		case nim::kNIMFriendChangeTypeUpdate: {
			break;
		}
		default:
		break;
	}
}