package pl.eco.zwierzeta;

import pl.eco.Swiat;
import pl.eco.Zwierze;

public class Czlowiek extends Zwierze {
   protected int special = 0;
    protected int wait = 0;
    protected boolean special_on = false;

    public Czlowiek(int x, int y, Swiat moj) {
        sila = 5;
        nazwa = "czlowiek";
        inicjatywa = 4;
        symbol = 'C';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
        special = 0;
        wait = 0;
    }
    public Czlowiek(int x, int y, Swiat moj, int Sila, int Wiek, int special, int wait, int special_on) {
        nazwa = "czlowiek";
        inicjatywa = 4;
        symbol = 'C';
        this.wiek = Wiek;
        this.x = x;
        this.y = y;
        this.moj = moj;
        this.special = special;
        this.wait = wait;
        this.sila=Sila;
        if(special_on==1)
            this.special_on = true;
        else
            this.special_on=false;
    }
    
    @Override
    public void akcja() {
        int kierunek = moj.getMove();

        if (special_on == true && wait > 5) {
            moj.komentarze.add("Umiejetnosc Czlowieka - calopalenie, wlaczona ");
            for (int i = 0; i < moj.organizmy.size(); i++) {
                if (moj.organizmy.get(i).isCzyZyje() == true) {
                    if (moj.organizmy.get(i).getX() == this.x + 1 && moj.organizmy.get(i).getY() == this.y) {
                        moj.komentarze.add("Czlowiek zabil organizm "+moj.organizmy.get(i).getNazwa()+", umiejetnoscia calopalenie");
                        moj.organizmy.get(i).czyZyje = false;
                    }
				else if (moj.organizmy.get(i).getX() == this.x - 1 && moj.organizmy.get(i).getY() == this.y) {
                        moj.komentarze.add("Czlowiek zabil organizm "+moj.organizmy.get(i).getNazwa()+", umiejetnoscia calopalenie");
                        moj.organizmy.get(i).czyZyje = false;
                    }
				else if (moj.organizmy.get(i).getX() == this.x && moj.organizmy.get(i).getY() == this.y + 1) {
                        moj.komentarze.add("Czlowiek zabil organizm "+moj.organizmy.get(i).getNazwa()+", umiejetnoscia calopalenie");
                        moj.organizmy.get(i).czyZyje = false;
                    }
				else if (moj.organizmy.get(i).getX() == this.x && moj.organizmy.get(i).getY() == this.y - 1) {
                        moj.komentarze.add("Czlowiek zabil organizm "+moj.organizmy.get(i).getNazwa()+", umiejetnoscia calopalenie");
                        moj.organizmy.get(i).czyZyje = false;
                    }
                }
            }
        }
    
        if (kierunek == 39) {
            if (this.x >= 0 && this.x < moj.getX() - 1) {
                this.x++;
                if (czyKolizja()) {
                    kolizja(0);
                }
            }
        }
        else if (kierunek == 37) {
            if (this.x > 0 && this.x <= moj.getX() - 1) {
                this.x--;
                if (czyKolizja()) {
                    kolizja(1);
                }
            }
        }
        else if (kierunek == 38) {
            if (this.y > 0 && this.y <= moj.getY() - 1) {
                this.y--;
                if (czyKolizja()) {
                    kolizja(2);
                }
            }
        }
        else if (kierunek == 40) {
            if (this.y >= 0 && this.y < moj.getY() - 1) {
                this.y++;
                if (czyKolizja()) {
                    kolizja(3);
                }
            }
        }
        else if (kierunek == 83) {
            special_on = true;
        }
    }

    public int getSpecial() {
        return special;
    }

    public int getWait() {
        return wait;
    }

    public boolean isSpecial_on() {
        return special_on;
    }

    @Override
    public void wiekWzrasta() {
        this.wiek++;
        if (special_on == true && wait>5) {
            special++;
            if (special == 6) {
                special = 0;
                wait = 0;
                special_on = false;
            }
        }
        wait++;
    }
}
