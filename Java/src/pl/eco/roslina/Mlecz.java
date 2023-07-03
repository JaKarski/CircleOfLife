package pl.eco.roslina;

import pl.eco.Roslina;
import pl.eco.Swiat;

import java.util.Random;

import static java.lang.Math.abs;

public class Mlecz extends Roslina {
    public Mlecz(int x, int y, Swiat moj){
        sila = 0;
        inicjatywa = 0;
        nazwa = "mlecz";
        symbol = 'm';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }
    public Mlecz(int x, int y,Swiat moj,int wiek){
        sila = 0;
        inicjatywa = 0;
        nazwa = "mlecz";
        symbol = 'm';

        this.wiek = wiek;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    @Override
    public void akcja() {
        Random generator = new Random();
        for(int i=0;i<3;i++){
            int prawdopodobienstwo = abs(generator.nextInt()%50);
            if(prawdopodobienstwo==0){
             if(moj.ileOgranizmow<moj.getX()*moj.getY()){
                 for(int j=0;j<10;j++) {
                     int x1 = abs(generator.nextInt()%moj.getX());
                     int y1 = abs(generator.nextInt()%moj.getY());
                     if (moj.tab[y1][x1] == ' ') {
                         moj.organizmy.add(new Mlecz(x1, y1, moj));
                         moj.komentarze.add("Mlecz rozmnozyl sie na x="+x1+", y="+y1);
                         break;
                     }
                 }
             }
            }
        }
    }
}
