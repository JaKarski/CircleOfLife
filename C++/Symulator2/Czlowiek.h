#pragma once
#include "Zwierze.h"
class Czlowiek :
    public Zwierze
{
    int special = 0;
    int wait = 0;
    bool special_on = false;
public:
    Czlowiek(int x, int y, Swiat* moj);
    void akcja() override;
    void wiekWzrasta() override;
};

