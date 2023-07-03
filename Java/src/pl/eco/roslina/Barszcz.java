package pl.eco.roslina;

import pl.eco.Roslina;
import pl.eco.Swiat;
import pl.eco.Zwierze;

import java.util.Random;

import static java.lang.Math.abs;

public class Barszcz extends Roslina {
    public Barszcz(int x, int y, Swiat moj) {
        sila = 10;
        inicjatywa = 0;
        nazwa = "barszcz sosnowskiego";
        symbol = 'b';
        wiek = 0;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    public Barszcz(int x, int y,Swiat moj,int wiek){
        sila = 10;
        inicjatywa = 0;
        nazwa = "barszcz sosnowskiego";
        symbol = 'b';

        this.wiek = wiek;
        this.x = x;
        this.y = y;
        this.moj = moj;
    }

    @Override
    public void akcja() {
        for (int i = 0; i < moj.organizmy.size(); i++) {
            if (moj.organizmy.get(i).czyZyje == true) {
                if (moj.organizmy.get(i).getSymbol() != 'b') {
                    if (moj.organizmy.get(i).getX() == this.x + 1 && moj.organizmy.get(i).getY() == this.y) {
                        if(moj.organizmy.get(i) instanceof Zwierze){
                        moj.organizmy.get(i).czyZyje = false;
                        moj.komentarze.add("Barszcz sosnowskiego zabil organizm "+moj.organizmy.get(i).getNazwa()+", ktory byl w jego poblizu");
                    }
                    } else if (moj.organizmy.get(i).getX() == this.x - 1 && moj.organizmy.get(i).getY() == this.y) {
                        if(moj.organizmy.get(i) instanceof Zwierze){
                        moj.organizmy.get(i).czyZyje = false;
                        moj.komentarze.add("Barszcz sosnowskiego zabil organizm " + moj.organizmy.get(i).getNazwa() + ", ktory byl w jego poblizu");
                    }
                    } else if (moj.organizmy.get(i).getX() == this.x && moj.organizmy.get(i).getY() == this.y + 1) {
                    if(moj.organizmy.get(i) instanceof Zwierze){
                        moj.organizmy.get(i).czyZyje = false;
                        moj.komentarze.add("Barszcz sosnowskiego zabil organizm " + moj.organizmy.get(i).getNazwa() + ", ktory byl w jego poblizu");
                    }
                    } else if (moj.organizmy.get(i).getX() == this.x && moj.organizmy.get(i).getY() == this.y - 1) {
                    if (moj.organizmy.get(i) instanceof Zwierze){
                    moj.organizmy.get(i).czyZyje = false;
                    moj.komentarze.add("Barszcz sosnowskiego zabil organizm " + moj.organizmy.get(i).getNazwa() + ", ktory byl w jego poblizu");
                    }
                    }
                }
            }
        }
        Random generator = new Random();
        int prawdopodobienstwo = abs(generator.nextInt() % 150);
        if (prawdopodobienstwo == 0) {
            for (int j = 0; j < 10; j++) {
                int x1 = abs(generator.nextInt() % moj.getX());
                int y1 = abs(generator.nextInt() % moj.getY());
                if (moj.tab[y1][x1] == ' ') {
                    moj.organizmy.add(new Barszcz(x1, y1, moj));
                    moj.komentarze.add("Barscz rozmnozyl sie na x=" + x1 + ", y=" + y1);
                    break;
                    }
                }
            }
        }
    }
