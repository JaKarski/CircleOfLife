package pl.eco.zwierzeta;

import pl.eco.Swiat;
import pl.eco.Zwierze;

import java.util.Random;

import static java.lang.Math.abs;

public class Lis extends Zwierze {
    public Lis(int x, int y, Swiat moj) {
        sila = 3;
        nazwa = "lis";
        inicjatywa = 7;
        symbol = 'L';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    public Lis(int x, int y, Swiat moj, int Sila, int Wiek, int poRozmnazaniu) {
        this.sila = sila;
        this.wiek = Wiek;
        this.poRozmnozeniu=poRozmnazaniu;
        inicjatywa = 7;
        nazwa = "lis";
        symbol = 'L';
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    protected boolean czyKolizje(int x, int y) {
        if (moj.tab[y][x] == ' ') {
            return false;
        } else
            return true;
    }

    protected boolean czySilniejszy(int x, int y) {
        for (int i = 0; i < moj.organizmy.size(); i++) {
            if (moj.organizmy.get(i).getX() == x && moj.organizmy.get(i).getY() == y && moj.organizmy.get(i).getSymbol() != symbol && this.sila < moj.organizmy.get(i).getSila()) {
                return true;
            }
        }
        return false;
    }

    protected boolean wech(int kierunek) {
        if (kierunek == 0) {
            if (this.x >= 0 && this.x < moj.getX() - 1) {
                if (czyKolizje(this.x + 1, this.y)) {
                    if (czySilniejszy(this.x + 1, this.y)) {
                        moj.komentarze.add("Lis Spryciarz");
                        return false;
                    }
                } else
                    return true;
            }
        } else if (kierunek == 1) {
            if (this.x > 0 && this.x <= moj.getX() - 1) {
                if (czyKolizje(this.x - 1, this.y)) {
                    if (czySilniejszy(this.x - 1, this.y)) {
                        moj.komentarze.add("Lis Spryciarz");
                        return false;
                    }
                } else
                    return true;
            }
        } else if (kierunek == 2) {
            if (this.y > 0 && this.y <= moj.getY() - 1) {
                if (czyKolizje(this.x, this.y - 1)) {
                    if (czySilniejszy(this.x, this.y - 1)) {
                        moj.komentarze.add("Lis Spryciarz");
                        return false;
                    }
                } else
                    return true;
            }
        } else if (kierunek == 3) {
            if (this.y >= 0 && this.y < moj.getY() - 1) {
                if (czyKolizje(this.x, this.y + 1)) {
                    if (czySilniejszy(this.x, this.y + 1)) {
                        moj.komentarze.add("Lis Spryciarz");
                        return false;
                    }
                } else
                    return true;
            }
        }
        return false;
    }

    @Override
    public void akcja() {
        Random generator = new Random();
        int kierunek = generator.nextInt() % 4;
        kierunek = abs(kierunek);
        int licznik=1;
        while (true) {
            if(licznik > 4)
                return;
            else if (wech(kierunek) == false) {
                kierunek=(kierunek+1)%4;
                licznik++;
            }
            else
                break;
        }

        if (kierunek == 0) {
            if (this.x >= 0 && this.x < moj.getX() - 1) {
                this.x++;
                if (czyKolizja()) {
                    kolizja(0);
                }
            }
        } else if (kierunek == 1) {
            if (this.x > 0 && this.x <= moj.getX() - 1) {
                this.x--;
                if (czyKolizja()) {
                    kolizja(1);
                }
            }
        } else if (kierunek == 2) {
            if (this.y > 0 && this.y <= moj.getY() - 1) {
                this.y--;
                if (czyKolizja()) {
                    kolizja(2);
                }
            }
        } else if (kierunek == 3) {
            if (this.y >= 0 && this.y < moj.getY() - 1) {
                this.y++;
                if (czyKolizja()) {
                    kolizja(3);
                }
            }
        }
    }
}