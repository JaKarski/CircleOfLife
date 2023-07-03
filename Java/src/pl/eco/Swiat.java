package pl.eco;

import pl.eco.roslina.*;
import pl.eco.zwierzeta.*;

import java.util.ArrayList;
import java.util.Collections;

public class Swiat {
    private int x = 10, y = 10;
    private int move;
    public char[][] tab;
    public ArrayList<Organizm> organizmy = new ArrayList<>();
    public ArrayList<String> komentarze = new ArrayList<>();
    public int ileOgranizmow;

    public Swiat(int x, int y){
        this.x = x;
        this.y = y;
        tab=new char[y][x];
        organizmy.add(new Czlowiek(0,0,this));
        this.ileOgranizmow= organizmy.size();

        Collections.sort(organizmy);
        Collections.reverse(organizmy);
        uzupelnijTablice();
    }

    public void uzupelnijTablice() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < organizmy.size(); k++) {
                    if (organizmy.get(k) != null) {
                        if (organizmy.get(k).getX() == j && organizmy.get(k).getY() == i && organizmy.get(k).isCzyZyje()==true) {
                            tab[i][j] = organizmy.get(k).getSymbol();
                            break;
                        }
					else {
                            tab[i][j] = ' ';
                        }
                    }
                }
            }
        }
    }

    public void wykoajTure(int input) {
        this.move = input;
        for (int i = 0; i < organizmy.size(); i++) {
            if (organizmy.get(i).isCzyZyje() == true) {
                organizmy.get(i).akcja();
                uzupelnijTablice();
            }
        }

        for (int i = 0; i < organizmy.size(); i++) {
            if (organizmy.get(i).isCzyZyje()==true) {
                organizmy.get(i).wiekWzrasta();
                organizmy.get(i).rozmnazanieWzrasta();
            }
        }
        Collections.sort(organizmy);
        Collections.reverse(organizmy);
        for(int i=organizmy.size()-1;i>=0 ;i--){
            if(organizmy.get(i).isCzyZyje()==false){
                organizmy.remove(i);
            }
        }
        this.ileOgranizmow= organizmy.size();
    }

    public void dodajOrganizm(int x, int y, String zwierze){
        if(zwierze=="Wilk"){
            organizmy.add(new Wilk(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="Owca"){
            organizmy.add(new Owca(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="Lis"){
            organizmy.add(new Lis(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="Zolw"){
            organizmy.add(new Zolw(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="Antylopa"){
            organizmy.add(new Antylopa(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="trawa"){
            organizmy.add(new Trawa(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="guarana"){
            organizmy.add(new Guarana(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="wilcze jagody"){
            organizmy.add(new Jagody(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="barszcz sosnowskiego"){
            organizmy.add(new Barszcz(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        else if(zwierze=="mlecz"){
            organizmy.add(new Mlecz(x,y, this));
            Collections.sort(organizmy);
            Collections.reverse(organizmy);
            uzupelnijTablice();
        }
        this.ileOgranizmow= organizmy.size();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMove() {
        return move;
    }
}