#include "Zolw.h"
#include <iostream>
#include <random>
#include <iostream>
#include <Windows.h>

using namespace std;


Zolw::Zolw(int x, int y, Swiat* moj) {
	sila = 2;
	inicjatywa = 1;
	symbol = 'Z';
	nazwa = "zolw";
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
}

bool Zolw::obrona(Organizm* atujacy) {
	if (atujacy->getSila() < 5) {
		std::cout << "Zolw odbil atak" << endl;
		Sleep(200);
		return true;
	}
	else {
		return false;
	}
}

void Zolw::akcja() {
	random_device rd;
	mt19937 gen(rd());
	unsigned int kierunek = gen() % 4;

	if (this->wiek % 4 == 0) {
		if (kierunek == 0) {
			if (this->x >= 0 && this->x < moj->getX() - 1) {
				this->x++;
				if (czyKolizja()) {
					kolizja(0);
				}
			}
		}
		else if (kierunek == 1) {
			if (this->x > 0 && this->x <= moj->getX() - 1) {
				this->x--;
				if (czyKolizja()) {
					kolizja(1);
				}
			}
		}
		else if (kierunek == 2) {
			if (this->y > 0 && this->y <= moj->getY() - 1) {
				this->y--;
				if (czyKolizja()) {
					kolizja(2);
				}
			}
		}
		else if (kierunek == 3) {
			if (this->y >= 0 && this->y < moj->getY() - 1) {
				this->y++;
				if (czyKolizja()) {
					kolizja(3);
				}
			}
		}
	}
}