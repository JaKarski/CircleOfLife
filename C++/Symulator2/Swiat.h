#pragma once
#include <vector>
#include "Organizm.h"

class Organizm;
class Swiat
{
	int x, y;
	void stworzTablice();
	void uzupelnijTablice();
	char move;
public:
	char** tab;
	std::vector<Organizm*>organizmy;
	Swiat(int x, int y);
	void wykoajTure(char input);
	void rysujSwiat();
	virtual int getX();
	virtual int getY();
	virtual char getMove();
	~Swiat();
};

