#include <QApplication>
#include <QMetaType>

#include "nim_cpp_api.h"
#include "loginwindow.h"
#include "chatwindow.h"
int main(int argc, char *argv[])
{
	QApplication a(argc, argv);
	// 注册自定义数据结构
	qRegisterMetaType <std::vector<std::string>>("std::vector<std::string>");
	qRegisterMetaType <std::vector<nim::UserNameCard>>("std::vector<nim::UserNameCard>");
	qRegisterMetaType <nim::SendMessageArc>("nim::SendMessageArc");
	qRegisterMetaType <ChatWindow*>("ChatWindow*");
	qRegisterMetaType <std::list<nim::IMMessage>>("std::list<nim::IMMessage>");
	qRegisterMetaType <nim::IMMessage>("nim::IMMessage");
	LoginWindow w;
	w.show();
	return a.exec();
}
