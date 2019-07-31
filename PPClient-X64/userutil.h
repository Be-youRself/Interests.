#pragma once

#include <QDebug>

#include "nim_cpp_api.h"
#include "signalcontroller.h"

class UserUtil {
public:
	UserUtil();
	~UserUtil();

	/*
	 * SDK���
	 */
	static void onLoginCallback(const nim::LoginRes&);
	static void onGetUserCard(const std::list<nim::UserNameCard>);
};

