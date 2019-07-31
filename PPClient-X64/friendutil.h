#pragma once

#include <QDebug>

#include <iostream>
#include "nim_cpp_api.h"
#include "signalcontroller.h"

class FriendUtil {
public:
	FriendUtil();
	~FriendUtil();

	/*
	 * SDKœ‡πÿ
	 */
	static void onFriendListChange(const nim::FriendChangeEvent &);
	static void onGetFriendList(nim::NIMResCode, const std::list<nim::FriendProfile>&);
};

