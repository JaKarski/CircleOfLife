package pl.eco.roslina;

import pl.eco.Organizm;
import pl.eco.Roslina;
import pl.eco.Swiat;

public class Guarana extends Roslina {
    public Guarana(int x, int y, Swiat moj) {
        sila = 0;
        inicjatywa = 0;
        nazwa = "guarana";
        symbol = 'g';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    public Guarana(int x, int y,Swiat w1,int wiek){
        sila = 0;
        inicjatywa = 0;
        nazwa = "guarana";
        symbol = 'g';

        this.wiek = wiek;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    @Override
    public boolean obrona(Organizm atujacy) {
        atujacy.setSila(atujacy.getSila() + 3);
        this.czyZyje=false;
        atujacy.moj.komentarze.add("Guarana wzmocnila "+atujacy.getNazwa());
        return false;
    }
}
