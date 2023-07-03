#include "Czlowiek.h"
#include <iostream>
#include <Windows.h>

#define right 77
#define left 75
#define up 72
#define down 80

using namespace std;

Czlowiek::Czlowiek(int x, int y, Swiat* moj) {
	sila = 5;
	nazwa = "czlowiek";
	inicjatywa = 4;
	symbol = 'C';
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
	special = 0;
	wait = 0;
}

void Czlowiek::akcja() {
	char kierunek = moj->getMove();

	if (special_on == true && wait > 5) {
		for (int i = 0; i < moj->organizmy.size(); i++) {
			if (moj->organizmy[i]->getZycie() == true) {
				if (moj->organizmy[i]->getX() == this->x + 1 && moj->organizmy[i]->getY() == this->y) {
					moj->organizmy[i]->czyZyje = false;
					cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu: umiejetnos Calopalenie" << endl;
					Sleep(2000);
				}
				else if (moj->organizmy[i]->getX() == this->x - 1 && moj->organizmy[i]->getY() == this->y) {
					moj->organizmy[i]->czyZyje = false;
					cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu: umiejetnos Calopalenie" << endl;
					Sleep(2000);
				}
				else if (moj->organizmy[i]->getX() == this->x && moj->organizmy[i]->getY() == this->y + 1) {
					moj->organizmy[i]->czyZyje = false;
					cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu: umiejetnos Calopalenie" << endl;
					Sleep(2000);
				}
				else if (moj->organizmy[i]->getX() == this->x && moj->organizmy[i]->getY() == this->y - 1) {
					moj->organizmy[i]->czyZyje = false;
					cout << endl << this->getNazwa() << " Zabil " << moj->organizmy[i]->getNazwa() << " ktory byl w jego poblizu: umiejetnos Calopalenie" << endl;
					Sleep(2000);
				}
			}
		}
	}

	if (kierunek == right) {
		if (this->x >= 0 && this->x < moj->getX() - 1) {
			this->x++;
			if (czyKolizja()) {
				kolizja(0);
			}
		}
	}
	else if (kierunek == left) {
		if (this->x > 0 && this->x <= moj->getX() - 1) {
			this->x--;
			if (czyKolizja()) {
				kolizja(1);
			}
		}
	}
	else if (kierunek == up) {
		if (this->y > 0 && this->y <= moj->getY() - 1) {
			this->y--;
			if (czyKolizja()) {
				kolizja(2);
			}
		}
	}
	else if (kierunek == down) {
		if (this->y >= 0 && this->y < moj->getY() - 1) {
			this->y++;
			if (czyKolizja()) {
				kolizja(3);
			}
		}
	}
	else if (kierunek == 's') {
		special_on = true;
	}
}

void Czlowiek::wiekWzrasta() {
	this->wiek++;
	if (special_on == true && wait>5) {
		cout << endl << "Umiejetnosc wlaczona" << endl;
		Sleep(500);
		special++;
		if (special == 6) {
			special = 0;
			wait = 0;
			special_on = false;
			cout << endl << "Umiejetnosc wylaczona" << endl;
			Sleep(2000);
		}
	}
	wait++;
	this->wiek++;
}
