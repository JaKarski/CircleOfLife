#pragma once
#include "Organizm.h"
class Roslina :
    public Organizm
{
    virtual void kolizja(int powrot);
public:
    virtual void akcja();
    virtual bool obrona(Organizm* atujacy);
};

