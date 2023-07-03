package pl.eco.zwierzeta;

import pl.eco.Organizm;
import pl.eco.Swiat;
import pl.eco.Zwierze;

import java.util.Random;

import static java.lang.Math.abs;

public class Zolw extends Zwierze {
    public Zolw(int x, int y, Swiat moj) {
        sila = 2;
        inicjatywa = 1;
        symbol = 'Z';
        nazwa = "zolw";
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    public Zolw(int x, int y, Swiat moj, int Sila, int Wiek, int poRozmnazaniu) {
        this.sila = sila;
        this.wiek = Wiek;
        this.poRozmnozeniu=poRozmnazaniu;
        inicjatywa = 1;
        nazwa = "zolw";
        symbol = 'Z';
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    @Override
    public boolean obrona(Organizm atujacy) {
        if (atujacy.getSila() < 5) {
            moj.komentarze.add("Zolw odbija atak "+ atujacy.getNazwa()+" na x="+this.getX()+", y="+this.getY());
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void akcja() {
        Random generator = new Random();
        int kierunek = generator.nextInt()%4;
        kierunek =abs(kierunek);

        if (this.wiek % 4 == 0) {
            if (kierunek == 0) {
                if (this.x >= 0 && this.x < moj.getX() - 1) {
                    this.x++;
                    if (czyKolizja()) {
                        kolizja(0);
                    }
                }
            }
            else if (kierunek == 1) {
                if (this.x > 0 && this.x <= moj.getX() - 1) {
                    this.x--;
                    if (czyKolizja()) {
                        kolizja(1);
                    }
                }
            }
            else if (kierunek == 2) {
                if (this.y > 0 && this.y <= moj.getY() - 1) {
                    this.y--;
                    if (czyKolizja()) {
                        kolizja(2);
                    }
                }
            }
            else if (kierunek == 3) {
                if (this.y >= 0 && this.y < moj.getY() - 1) {
                    this.y++;
                    if (czyKolizja()) {
                        kolizja(3);
                    }
                }
            }
        }
    }
}
