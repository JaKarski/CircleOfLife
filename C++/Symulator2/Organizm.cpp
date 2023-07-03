#include <iostream>
#include "Organizm.h"

using namespace std;


void Organizm::wiekWzrasta() {
	this->wiek++;
}

Organizm::~Organizm() {
}

int Organizm::getX() {
	return x;
}

bool Organizm::getZycie() {
	return czyZyje;
}

int Organizm::getWiek() {
	return wiek;
}

int Organizm::getSila() {
	return sila;
}

void Organizm::SetX(int x) {
	 this->x = x;
}

void Organizm::SetY(int y) {
	this->y = y;
}

void Organizm::SetSila(int sila) {
	this->sila = sila;
}

int Organizm::getY() {
	return y;
}

char Organizm::getSymbol() {
	return symbol;
}

string Organizm::getNazwa() {
	return nazwa;
}

bool Organizm::obrona(Organizm* atujacy) {
	return false;
}