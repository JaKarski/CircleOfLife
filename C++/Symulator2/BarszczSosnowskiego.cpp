#include "BarszczSosnowskiego.h"
#include <iostream>
#include <Windows.h>

using namespace std;

BarszczSosnowskiego::BarszczSosnowskiego(int x, int y, Swiat* moj) {
	sila = 10;
	inicjatywa = 0;
	nazwa = "Barszcz sosnowskiego";
	symbol = 'b';
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
}

void BarszczSosnowskiego::akcja() {
	for (int i = 0; i < moj->organizmy.size(); i++) {
		if (moj->organizmy[i]->czyZyje == true) {
			if (moj->organizmy[i]->getX() == this->x + 1 && moj->organizmy[i]->getY() == this->y) {
				moj->organizmy[i]->czyZyje = false;
				cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu" << endl;
				Sleep(2000);
			}
			else if (moj->organizmy[i]->getX() == this->x - 1 && moj->organizmy[i]->getY() == this->y) {
				moj->organizmy[i]->czyZyje = false;
				cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu" << endl;
				Sleep(2000);
			}
			else if (moj->organizmy[i]->getX() == this->x && moj->organizmy[i]->getY() == this->y + 1) {
				moj->organizmy[i]->czyZyje = false;
				cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu" << endl;
				Sleep(2000);
			}
			else if (moj->organizmy[i]->getX() == this->x && moj->organizmy[i]->getY() == this->y - 1) {
				moj->organizmy[i]->czyZyje = false;
				cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu" << endl;
				Sleep(2000);
			}
		}
	}
}