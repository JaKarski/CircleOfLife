#pragma once
#include "Roslina.h"
class Guarana :
    public Roslina
{
public:
    Guarana(int x, int y, Swiat* moj);
    bool obrona(Organizm* atujacy) override;
};

