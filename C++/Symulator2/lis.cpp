#include "lis.h"
#include <random>
#include <iostream>
#include <Windows.h>

using namespace std;

lis::lis(int x, int y, Swiat* moj) {
	sila = 3;
	nazwa = "lis";
	inicjatywa = 7;
	symbol = 'L';
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
}
bool lis::czyKolizje(int x, int y) {
	if (moj->tab[y][x] == ' ') {
		return false;
	}
	else
		return true;
}

bool lis::czySilniejszy(int x, int y) {
	for (int i = 0; i < moj->organizmy.size(); i++) {
		if (moj->organizmy[i]->getX() == x && moj->organizmy[i]->getY() == y && moj->organizmy[i]->getSymbol() != symbol && this->sila < moj->organizmy[i]->getSila()) {
			return true;
		}
	}
	return false;
}

bool lis::wech(int kierunek) {
	if (kierunek == 0) {
		if (this->x >= 0 && this->x < moj->getX() - 1) {
			if (czyKolizje(this->x+1, this->y)) {
				if (czySilniejszy(this->x + 1, this->y)) {
					return false;
				}
			}
			else
				return true;
		}
	}
	else if (kierunek == 1) {
		if (this->x > 0 && this->x <= moj->getX() - 1) {
			if (czyKolizje(this->x - 1, this->y)) {
				if (czySilniejszy(this->x - 1, this->y)) {
					return false;
				}
			}
			else
				return true;
		}
	}
	else if (kierunek == 2) {
		if (this->y > 0 && this->y <= moj->getY() - 1) {
			if (czyKolizje(this->x, this->y-1)) {
				if (czySilniejszy(this->x, this->y-1)) {
					return false;
				}
			}
			else
				return true;
		}
	}
	else if (kierunek == 3) {
		if (this->y >= 0 && this->y < moj->getY() - 1) {
			if (czyKolizje(this->x, this->y+1)) {
				if (czySilniejszy(this->x, this->y+1)) {
					return false;
				}
			}
			else
				return true;
		}
	}
	return false;
}

void lis::akcja() {
		random_device rd;
		mt19937 gen(rd());
		unsigned int kierunek = gen() % 4;

		while (true) {
			if (wech(kierunek) == false) {
				cout << "Lis spryciarz" << endl;
				Sleep(200);
				kierunek = (gen()+1) % 4;
			}
			else {
				break;
			}
		}

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