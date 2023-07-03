#include "WilczeJagody.h"

WilczeJagody::WilczeJagody(int x, int y, Swiat* moj) {
	sila = 99;
	inicjatywa = 0;
	nazwa = "wilcze jagody";
	symbol = '*';
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
}