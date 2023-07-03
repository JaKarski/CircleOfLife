#pragma once
#include "Zwierze.h"
class Zolw :
    public Zwierze
{
public:
    Zolw(int x, int y, Swiat* moj);
    void akcja();
    bool obrona(Organizm* atujacy);
};

