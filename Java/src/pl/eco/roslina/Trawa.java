package pl.eco.roslina;

import pl.eco.Roslina;
import pl.eco.Swiat;

public class Trawa extends Roslina {
    public Trawa(int x, int y, Swiat moj) {
        sila = 0;
        inicjatywa = 0;
        nazwa = "trawa";
        symbol = 't';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
    public Trawa(int x, int y,Swiat moj,int wiek){
        sila = 0;
        inicjatywa = 0;
        nazwa = "trawa";
        symbol = 't';

        this.wiek = wiek;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
}
