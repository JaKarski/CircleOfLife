package pl.eco.roslina;

import pl.eco.Organizm;
import pl.eco.Roslina;
import pl.eco.Swiat;

public class Jagody extends Roslina {
    public Jagody(int x, int y, Swiat moj) {
        sila = 99;
        inicjatywa = 0;
        nazwa = "wilcze jagody";
        symbol = '*';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
    public Jagody(int x, int y,Swiat moj,int wiek){
        sila = 99;
        inicjatywa = 0;
        nazwa = "wilcze jagody";
        symbol = '*';

        this.wiek = wiek;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    @Override
    public boolean obrona(Organizm atujacy) {
        this.czyZyje=false;
        return false;
    }
}
