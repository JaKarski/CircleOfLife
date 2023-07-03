#include "Guarana.h"
#include <iostream>
#include <Windows.h>

using namespace std;

Guarana::Guarana(int x, int y, Swiat* moj) {
	sila = 0;
	inicjatywa = 0;
	nazwa = "guarana";
	symbol = 'g';
	wiek = 0;
	this->x = x;
	this->y = y;
	this->moj = moj;
}

bool Guarana::obrona(Organizm* atujacy) {
	cout << "Guarana zjedzona przez " << atujacy->getNazwa() << " jego sila wzrasta o 3" << endl;
	Sleep(2000);
	atujacy->SetSila(atujacy->getSila() + 3);
	return false;
}