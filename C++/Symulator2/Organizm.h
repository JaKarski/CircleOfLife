#pragma once
#include "Swiat.h"
#include <string>

using namespace std;

class Swiat;
class Organizm
{
protected:
	int sila, inicjatywa, wiek, x, y;
	char symbol;
	string nazwa;
	virtual void kolizja(int powrot) = 0;
	Swiat *moj;
public:
	bool czyZyje = true;
	virtual void akcja() = 0;
	virtual int getX();
	virtual string getNazwa();
	virtual int getY();
	virtual void SetX(int x);
	virtual void SetY(int y);
	virtual bool getZycie();
	virtual int getWiek();
	virtual int getSila();
	virtual void SetSila(int sila);
	virtual char getSymbol();
	virtual void wiekWzrasta();
	virtual bool obrona(Organizm* atujacy);
	virtual ~Organizm();
};

