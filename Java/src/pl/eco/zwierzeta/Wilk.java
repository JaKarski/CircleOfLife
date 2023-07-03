package pl.eco.zwierzeta;

import pl.eco.Swiat;
import pl.eco.Zwierze;

public class Wilk extends Zwierze {
    public Wilk(int x, int y, Swiat moj) {
        sila = 9;
        inicjatywa = 5;
        symbol = 'W';
        nazwa = "wilk";
        wiek = 0;
        poRozmnozeniu=0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
    public Wilk(int x, int y, Swiat moj, int Sila, int Wiek, int poRozmnazaniu) {
        this.sila = sila;
        this.wiek = Wiek;
        this.poRozmnozeniu=poRozmnazaniu;
        inicjatywa = 5;
        nazwa = "wilk";
        symbol = 'W';
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
}
