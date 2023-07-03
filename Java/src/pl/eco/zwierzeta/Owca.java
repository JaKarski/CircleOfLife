package pl.eco.zwierzeta;

import pl.eco.Swiat;
import pl.eco.Zwierze;

public class Owca extends Zwierze {
    public Owca(int x, int y, Swiat moj) {
        sila = 4;
        inicjatywa = 4;
        nazwa = "owca";
        symbol = 'O';
        wiek = 0;
        poRozmnozeniu=0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
    public Owca(int x, int y, Swiat moj, int Sila, int Wiek, int poRozmnazaniu) {
        this.sila = sila;
        this.wiek = Wiek;
        this.poRozmnozeniu=poRozmnazaniu;
        inicjatywa = 4;
        nazwa = "owca";
        symbol = 'O';
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
}
