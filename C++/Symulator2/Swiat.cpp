#include "Swiat.h"
#include "Wilk.h"
#include "Owca.h"
#include "lis.h"
#include "Zolw.h"
#include "Antylopa.h"
#include "Czlowiek.h"
#include "Trawa.h"
#include "Guarana.h"
#include "WilczeJagody.h"
#include "BarszczSosnowskiego.h"
#include <iostream>

using namespace std;

Swiat::Swiat(int x, int y) {
	this->x = x;
	this->y = y;
	stworzTablice();
	organizmy.push_back(new lis(5, 5, this));
	organizmy.push_back(new Wilk(0, 0, this));
	organizmy.push_back(new Wilk(1, 0, this));
	organizmy.push_back(new Wilk(1, 0, this));
	organizmy.push_back(new Wilk(1,1 , this));
	organizmy.push_back(new Wilk(1, 2, this));
	organizmy.push_back(new Wilk(8, 7, this));
	organizmy.push_back(new Wilk(7, 8, this));
	organizmy.push_back(new Czlowiek(1, 5, this));
	organizmy.push_back(new Owca(5, 0, this));
	organizmy.push_back(new Owca(5, 1, this));
	organizmy.push_back(new Antylopa(6, 6, this));
	organizmy.push_back(new Zolw(9, 9, this));
	organizmy.push_back(new Trawa(4, 3, this));
	organizmy.push_back(new Trawa(3, 4, this));
	organizmy.push_back(new Guarana(7, 7, this));
	organizmy.push_back(new WilczeJagody(8, 8, this));
	organizmy.push_back(new BarszczSosnowskiego(0, 9, this));
	uzupelnijTablice();
}

void Swiat::rysujSwiat() {
	for (int i = 0; i < y; i++) {
		for (int j = 0; j < x; j++) {
			cout << tab[i][j];
		}
		cout << endl;
	}
	cout << endl;
	for (int i = 0; i < organizmy.size(); i++) {
		if (organizmy[i]->czyZyje == false) {
			cout << "Organizm: " << organizmy[i]->getNazwa() << " nie zyje :(" << " Zyl: "<< organizmy[i]->getWiek()<<" tur" << endl;
		}
		else
			cout << "Organizm: " << organizmy[i]->getNazwa() << " zyje i jest na pozycji x=" << organizmy[i]->getX() << " i y=" << organizmy[i]->getY() << endl;
	}
}

void Swiat::stworzTablice() {
	tab = new char* [y];
	for (int i = 0; i < y; i++)
		tab[i] = new char[x];
}

void Swiat::uzupelnijTablice() {
	for (int i = 0; i < y; i++) {
		for (int j = 0; j < x; j++) {
			for (int k = 0; k < organizmy.size(); k++) {
				if (organizmy[k] != NULL) {
					if (organizmy[k]->getX() == j && organizmy[k]->getY() == i && organizmy[k]->getZycie()==true) {
						tab[i][j] = organizmy[k]->getSymbol();
						break;
					}
					else {
						tab[i][j] = ' ';
					}
				}
			}
		}
	}
}

void Swiat::wykoajTure(char input) {
	this->move = input;
	for (int i = 0; i < organizmy.size(); i++) {
		if (organizmy[i]->getZycie() == true) {
			organizmy[i]->akcja();
			uzupelnijTablice();
		}
	}
	
	for (int i = 0; i < organizmy.size(); i++) {
		if (organizmy[i]->getZycie()==true) {
			organizmy[i]->wiekWzrasta();
		}
	}
}

int Swiat::getX() {
	return x;
}

int Swiat::getY() {
	return y;
}
char Swiat::getMove() {
	return move;
}

Swiat::~Swiat() {
}