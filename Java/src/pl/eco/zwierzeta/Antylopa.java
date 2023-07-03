package pl.eco.zwierzeta;

import pl.eco.Organizm;
import pl.eco.Swiat;
import pl.eco.Zwierze;

import java.util.Random;

import static java.lang.Math.abs;

public class Antylopa extends Zwierze {
    public Antylopa(int x, int y, Swiat moj) {
        sila = 4;
        inicjatywa = 4;
        nazwa = "antylopa";
        symbol = 'A';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    public Antylopa(int x, int y, Swiat moj, int Sila, int Wiek, int poRozmnazaniu) {
        this.sila = sila;
        this.wiek = Wiek;
        this.poRozmnozeniu=poRozmnazaniu;
        inicjatywa = 4;
        nazwa = "antylopa";
        symbol = 'A';
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    void cofanie(int powrot) {
        if (powrot == 0) {
            this.x = this.x - 2;
        } else if (powrot == 1) {
            this.x = this.x + 2;
        } else if (powrot == 2) {
            this.y = this.y + 2;
        } else if (powrot == 3) {
            this.y = this.y - 2;
        }
    }

    @Override
    public void akcja() {
        Random generator = new Random();
        int kierunek = generator.nextInt() % 4;
        kierunek = abs(kierunek);

        if (kierunek == 0) {
            if (this.x >= 1 && this.x < moj.getX() - 2) {
                this.x = this.x + 2;
                if (czyKolizja()) {
                    kolizja(0);
                }
            }
        } else if (kierunek == 1) {
            if (this.x > 1 && this.x <= moj.getX() - 2) {
                this.x = this.x - 2;
                if (czyKolizja()) {
                    kolizja(1);
                }
            }
        } else if (kierunek == 2) {
            if (this.y > 1 && this.y <= moj.getY() - 2) {
                this.y = this.y - 2;
                if (czyKolizja()) {
                    kolizja(2);
                }
            }
        } else if (kierunek == 3) {
            if (this.y >= 1 && this.y < moj.getY() - 2) {
                this.y = this.y + 2;
                if (czyKolizja()) {
                    kolizja(3);
                }
            }
        }
    }

    @Override
    public boolean obrona(Organizm atujacy) {
        Random generator = new Random();
        int ucieczka = generator.nextInt() % 1;
        ucieczka = abs(ucieczka);

        if (ucieczka == 1) {
            return false;
        }
        else {
            if (this.getX() < moj.getX() && this.getY() < moj.getY() && this.getX() > 0 && this.getY() > 0) {
                if (moj.tab[this.getY() + 1][this.getX()] == ' ') {
                    this.y++;
                    moj.komentarze.add("Antylopa ucieka przed Walka");
                    return true;
                } else if (moj.tab[this.getY() - 1][this.getX()] == ' ') {
                    this.y--;
                    moj.komentarze.add("Antylopa ucieka przed Walka");
                    return true;
                } else if (moj.tab[this.getY()][this.getX() + 1] == ' ') {
                    moj.komentarze.add("Antylopa ucieka przed Walka");
                    this.x++;
                    return true;
                } else if (moj.tab[this.getY()][this.getX() - 1] == ' ') {
                    moj.komentarze.add("Antylopa ucieka przed Walka");
                    this.x--;
                    return true;
                }
            } else
                return false;
        }
        return false;
    }
}
