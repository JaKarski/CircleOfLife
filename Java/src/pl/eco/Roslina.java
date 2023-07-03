package pl.eco;

import pl.eco.roslina.*;

import java.util.Random;

import static java.lang.Math.abs;

public abstract class Roslina extends Organizm {

    @Override
    protected void kolizja(int powrot) {

    }

    @Override
    public void akcja() {
        Random generator = new Random();
        int prawdopodobienstwo = abs(generator.nextInt() % 10);
        if (prawdopodobienstwo == 0) {
                for (int j = 0; j < 10; j++) {
                    int x1 = abs(generator.nextInt() % moj.getX());
                    int y1 = abs(generator.nextInt() % moj.getY());
                    if (moj.tab[y1][x1] == ' ') {
                        if (nazwa == "trawa") {
                            moj.organizmy.add(new Trawa(x1, y1, moj));
                            moj.komentarze.add("Trawa rozmnozyl sie na x=" + x1 + ", y=" + y1);
                        } else if (nazwa == "wilcze jagody") {
                            moj.organizmy.add(new Jagody(x1, y1, moj));
                            moj.komentarze.add("Jagoda rozmnozyl sie na x=" + x1 + ", y=" + y1);
                        } else if (nazwa == "guarana") {
                            moj.organizmy.add(new Guarana(x1, y1, moj));
                            moj.komentarze.add("Guarana rozmnozyl sie na x=" + x1 + ", y=" + y1);
                        }
                        break;
                    }
                }
        }
    }
}
