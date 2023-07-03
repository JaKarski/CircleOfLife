#include "Antylopa.h"
#include <random>
#include <iostream>

using namespace std;


Antylopa::Antylopa(int x, int y, Swiat* moj) {
	sila = 4;
	inicjatywa = 4;
	nazwa = "antylopa";
	symbol = 'A';
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
}

void Antylopa::cofanie(int powrot) {
	if (powrot == 0) {
		this->x = this->x - 2;
	}
	else if (powrot == 1) {
		this->x=this->x + 2;
	}
	else if (powrot == 2) {
		this->y=this->y + 2;
	}
	else if (powrot == 3) {
		this->y=this->y - 2;
	}
}

void Antylopa::akcja() {
	random_device rd;
	mt19937 gen(rd());
	unsigned int kierunek = gen() % 4;

	if (kierunek == 0) {
		if (this->x >= 1 && this->x < moj->getX() - 2) {
			this->x = this->x + 2;
			if (czyKolizja()) {
				kolizja(0);
			}
		}
	}
	else if (kierunek == 1) {
		if (this->x > 1 && this->x <= moj->getX() - 2) {
			this->x = this->x - 2;
			if (czyKolizja()) {
				kolizja(1);
			}
		}
	}
	else if (kierunek == 2) {
		if (this->y > 1 && this->y <= moj->getY() - 2) {
			this->y = this->y - 2;
			if (czyKolizja()) {
				kolizja(2);
			}
		}
	}
	else if (kierunek == 3) {
		if (this->y >= 1 && this->y < moj->getY() - 2) {
			this->y = this->y + 2;
			if (czyKolizja()) {
				kolizja(3);
			}
		}
	}
}

bool Antylopa::obrona(Organizm* atujacy) {
	random_device rd;
	mt19937 gen(rd());
	unsigned int ucieczka = gen() % 2;
	if (ucieczka == 0) {
		return false;
	}
	else {
		cout << "Antylopa ucieka" << endl;
		if (this->getX() < moj->getX() && this->getY() < moj->getY() && this->getX() > 0 && this->getY() > 0) {
			if (moj->tab[this->getY() + 1][this->getX()] == ' ') {
				this->y++;
				return true;
			}
			else if (moj->tab[this->getY() - 1][this->getX()] == ' ') {
				this->y--;
				return true;
			}
			else if (moj->tab[this->getY()][this->getX() + 1] == ' ') {
				this->x++;
				return true;
			}
			else if (moj->tab[this->getY()][this->getX() - 1] == ' ') {
				this->x--;
				return true;
			}
		}
		else
			cout << "Antylopa nie ma gdzie uciec";
			return false;
	}
}