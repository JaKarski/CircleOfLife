#pragma once
#include "Zwierze.h"
class Antylopa :
    public Zwierze
{
public:
    Antylopa(int x, int y, Swiat* moj);
    void akcja() override;
    void cofanie(int powrot) override;
    bool obrona(Organizm* atujacy);

};

