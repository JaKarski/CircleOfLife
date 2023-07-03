#pragma once
#include "Organizm.h"
class Zwierze :
    public Organizm
{
public:
	virtual void akcja();
	virtual void kolizja(int powrot);
	virtual void cofanie(int powrot);
	virtual bool czyKolizja();
	bool czyWalka();
	virtual ~Zwierze();
};

