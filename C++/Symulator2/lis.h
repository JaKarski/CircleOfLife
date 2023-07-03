#pragma once
#include "Zwierze.h"
class lis :
    public Zwierze
{
public:
    lis(int x, int y, Swiat* moj);
    void akcja();
    bool wech(int kierunek);
    bool czySilniejszy(int x, int y);
    bool czyKolizje(int x, int y);
};

