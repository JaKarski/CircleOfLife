#include "Zwierze.h"
#include <random>
#include <iostream>
#include <Windows.h>

using namespace std;


void Zwierze::cofanie(int powrot) {
	if (powrot == 0) {
		this->x--;
	}
	else if (powrot == 1) {
		this->x++;
	}
	else if (powrot == 2) {
		this->y++;
	}
	else if (powrot == 3) {
		this->y--;
	}
}

void Zwierze::kolizja(int powrot) {
	if (czyWalka()) {
		for (int i = 0; i < moj->organizmy.size(); i++) {
			if (moj->organizmy[i]->czyZyje == true) {
				if (moj->organizmy[i]->getX() == this->x && moj->organizmy[i]->getY() == this->y && moj->organizmy[i]->getSymbol() != this->symbol) {
					if (moj->organizmy[i]->obrona(this)) {
						cofanie(powrot);
					}
					else {
						if (moj->organizmy[i]->getSila() <= this->sila) {
							moj->organizmy[i]->czyZyje = false;
							cout << endl << "Organizm *" << moj->organizmy[i]->getNazwa() << "* zostal zabity przez *" << this->getNazwa() << "*" << endl;
							Sleep(2000);
						}
						else {
							this->czyZyje = false;
							cout << endl << "Organizm *" << this->getNazwa() << "* zostal zabity przez *" << moj->organizmy[i]->getNazwa() << "*" << endl;
							Sleep(2000);
						}
					}
				}
			}
		}
	}
	else {
		cofanie(powrot);
	}
}

bool Zwierze::czyKolizja() {
	if (moj->tab[this->y][this->x] == ' ') {
		return false;
	}
	else
	return true;
}

bool Zwierze::czyWalka() {
	if (moj->tab[this->y][this->x] == symbol) {
		return false;
	}
	else
		return true;
}

void Zwierze::akcja() {
	random_device rd; 
	mt19937 gen(rd());
	unsigned int kierunek = gen() % 4;

	if (kierunek == 0) {
		if (this->x >= 0 && this->x < moj->getX()-1) {
			this->x++;
			if (czyKolizja()) {
				kolizja(0);
			}
		}
	}
	else if (kierunek == 1) {
		if (this->x > 0 && this->x <= moj->getX()-1) {
			this->x--;
			if (czyKolizja()) {
				kolizja(1);
			}
		}
	}
	else if (kierunek == 2) {
		if (this->y > 0 && this->y <= moj->getY()-1) {
			this->y--;
			if (czyKolizja()) {
				kolizja(2);
			}
		}
	}
	else if (kierunek == 3) {
		if (this->y >= 0 && this->y < moj->getY()-1) {
			this->y++;
			if (czyKolizja()) {
				kolizja(3);
			}
		}
	}
}

Zwierze::~Zwierze() {

}