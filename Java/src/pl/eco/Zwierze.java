package pl.eco;

import pl.eco.zwierzeta.*;

import java.util.Random;

import static java.lang.Math.abs;

public abstract class Zwierze extends Organizm{

    private void cofanie(int powrot) {
        if (powrot == 0) {
            this.x--;
        }
        else if (powrot == 1) {
            this.x++;
        }
        else if (powrot == 2) {
            this.y++;
        }
        else if (powrot == 3) {
            this.y--;
        }
    }
    public boolean czyWalka() {
        if (moj.tab[this.y][this.x] == symbol) {
            return false;
        }
	    else
            return true;
    }
    public boolean czyKolizja() {
        if (moj.tab[this.y][this.x] == ' ') {
            return false;
        }
	else
        return true;
    }
    private Organizm generator(Organizm o, int x, int y){
        if(o instanceof Wilk){
            return new Wilk(x,y,moj);
        }
        else if(o instanceof Owca){
            return new Owca(x,y,moj);
        }
        else if(o instanceof Lis){
            return new Lis(x,y,moj);
        }
        else if(o instanceof Zolw){
            return new Zolw(x,y,moj);
        }
        else if(o instanceof Antylopa){
            return new Antylopa(x,y,moj);
        }
        return null;
    }
    public void rozmnazanie(){
        if(x+1<moj.getX()-1) {
            if (moj.tab[y][x + 1] == ' ') {
                moj.organizmy.add(generator(this, this.x + 1, this.y));
                moj.komentarze.add("Organizm "+this.getNazwa()+" rozmozyl sie, "+"nowy organizm na x="+(this.getX()+1)+", y="+this.getY());
                this.poRozmnozeniu=0;
                return;
            }
        }
        if(x-1>0) {
            if (moj.tab[y][x - 1] == ' ') {
                moj.organizmy.add(generator(this, this.x - 1, this.y));
                moj.komentarze.add("Organizm "+this.getNazwa()+" rozmozyl sie, "+"nowy organizm na x="+(this.getX()-1)+", y="+this.getY());
                this.poRozmnozeniu=0;
                return;
            }
        }
        if(y+1<moj.getY()-1) {
            if (moj.tab[y+1][x] == ' ') {
                moj.organizmy.add(generator(this, this.x, this.y+1));
                moj.komentarze.add("Organizm "+this.getNazwa()+" rozmozyl sie, "+"nowy organizm na x="+this.getX()+", y="+(this.getY()+1));
                this.poRozmnozeniu=0;
                return;
            }
        }
        if(y-1>0) {
            if (moj.tab[y-1][x] == ' ') {
                moj.organizmy.add(generator(this, this.x, this.y-1));
                moj.komentarze.add("Organizm "+this.getNazwa()+" rozmozyl sie, "+"nowy organizm na x="+this.getX()+", y="+(this.getY()-1));
                this.poRozmnozeniu=0;
                return;
            }
        }
    }


    @Override
    public void kolizja(int powrot) {
        if (czyWalka()) {
            for (int i = 0; i < moj.organizmy.size(); i++) {
                if (moj.organizmy.get(i).czyZyje == true) {
                    if (moj.organizmy.get(i).getX() == this.x && moj.organizmy.get(i).getY() == this.y && moj.organizmy.get(i).getSymbol() != this.symbol) {
                        if (moj.organizmy.get(i).obrona(this)) {
                            cofanie(powrot);
                        }
					    else {
                            if (moj.organizmy.get(i).getSila() <= this.sila) {
                                moj.komentarze.add("Organizm "+this.getNazwa()+" zaatakowal, "+moj.organizmy.get(i).getNazwa()+ " na x="+this.getX()+", y="+this.getY()+" i wygral");
                                moj.organizmy.get(i).czyZyje = false;
                            }
						    else {
                                moj.komentarze.add("Organizm "+this.getNazwa()+" zaatakowal, "+moj.organizmy.get(i).getNazwa()+ " na x="+this.getX()+", y="+this.getY()+" i przegral");
                                this.czyZyje = false;
                            }
                        }
                    }
                }
            }
        }
        else {
            cofanie(powrot);
            if(poRozmnozeniu>3) {
                rozmnazanie();
            }
        }
    }

    @Override
    public void akcja() {
        Random generator = new Random();
        int kierunek = generator.nextInt()%4;
        kierunek =abs(kierunek);

        if (kierunek == 0) {
            if (this.x >= 0 && this.x < moj.getX()-1) {
                this.x++;
                if (czyKolizja()) {
                    kolizja(0);
                }
            }
        }
        else if (kierunek == 1) {
            if (this.x > 0 && this.x <= moj.getX()-1) {
                this.x--;
                if (czyKolizja()) {
                    kolizja(1);
                }
            }
        }
        else if (kierunek == 2) {
            if (this.y > 0 && this.y <= moj.getY()-1) {
                this.y--;
                if (czyKolizja()) {
                    kolizja(2);
                }
            }
        }
        else if (kierunek == 3) {
            if (this.y >= 0 && this.y < moj.getY()-1) {
                this.y++;
                if (czyKolizja()) {
                    kolizja(3);
                }
            }
        }
    }
}
