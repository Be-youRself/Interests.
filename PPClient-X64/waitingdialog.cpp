#include "waitingdialog.h"
#include "ui_waitingdialog.h"

WaitingDialog::WaitingDialog(QWidget *parent) :
	QDialog(parent),
	ui(new Ui::WaitingDialog) {

	ui->setupUi(this);
	this->setWindowFlags(Qt::WindowStaysOnTopHint | Qt::FramelessWindowHint);
}

WaitingDialog::~WaitingDialog() {
	delete ui;
}
