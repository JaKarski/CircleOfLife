package pl.eco.graficManager;

import pl.eco.Roslina;
import pl.eco.Swiat;
import pl.eco.Zwierze;
import pl.eco.roslina.*;
import pl.eco.zwierzeta.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Formatter;
import java.util.Objects;
import java.util.Scanner;

public class EventManager extends JFrame implements KeyListener {
    Swiat w1;
    buttonPanel ButtonPanel;
    infoPanel InfoPanel;
    JMenuBar menuBar;
    JMenuItem Plik1Z;
    JMenuItem Plik2Z;
    JMenuItem Plik3Z;
    JMenuItem Plik1W;
    JMenuItem Plik2W;
    JMenuItem Plik3W;
    JMenuItem Wyjdz;
    JMenuItem Instrukcja;

    public EventManager(){
        int x = 0;
        int y = 0;
        while((x<=0||y<=0)||(x>50||y>50)) {
            JOptionPane.showMessageDialog(null,"Symulator autorstwa: Kacper Karski, s186044, Informatyka Grupa 2\nW nastepnym kroku podaj wymiary planszy max 50","Symulator",JOptionPane.PLAIN_MESSAGE);
            x = Integer.parseInt(JOptionPane.showInputDialog("Podaj Wymiar X planszy"));
            y = Integer.parseInt(JOptionPane.showInputDialog("Podaj Wymiar Y planszy"));
        }
        w1=new Swiat(x,y);
        ButtonPanel=new buttonPanel(w1);
        InfoPanel = new infoPanel(w1);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000,500+5*y);
        this.setTitle("Kacper Karski, s186044");

        menuBar = new JMenuBar();
        JMenu Zapisz = new JMenu("Zapisz do...");
        Plik1Z = new JMenuItem("Plik 1");
        Plik1Z.addActionListener(e->Zapis("zapis.txt"));
        Plik2Z = new JMenuItem("Plik 2");
        Plik2Z.addActionListener(e->Zapis("zapis2.txt"));
        Plik3Z = new JMenuItem("Plik 3");
        Plik3Z.addActionListener(e->Zapis("zapis3.txt"));
        Zapisz.add(Plik1Z);
        Zapisz.add(Plik2Z);
        Zapisz.add(Plik3Z);


        JMenu Wczytaj = new JMenu("Wczytaj z...");
        Plik1W = new JMenuItem("Plik 1");
        Plik1W.addActionListener(e->Wczytywanie("zapis.txt"));
        Plik2W = new JMenuItem("Plik 2");
        Plik2W.addActionListener(e->Wczytywanie("zapis2.txt"));
        Plik3W = new JMenuItem("Plik 3");
        Plik3W.addActionListener(e->Wczytywanie("zapis3.txt"));
        Wczytaj.add(Plik1W);
        Wczytaj.add(Plik2W);
        Wczytaj.add(Plik3W);

        JMenu Gra = new JMenu("Gra");
        Wyjdz = new JMenuItem("Wyjdz");
        Wyjdz.addActionListener(e->System.exit(0));
        Instrukcja = new JMenuItem("Instrukcja");
        Instrukcja.addActionListener(e->JOptionPane.showMessageDialog(null,"Symulator autorstwa: Kacper Karski, s186044, Informatyka Grupa 2\nNacisnij na wolne pole aby dodac organizm.\nAby przejsc do nastepnej tury wcisnij dowolny przycisk.\nSterowanie czlowiekiem -> strzalki, Umiejetnosc specialna -> 's'.","Symulator",JOptionPane.PLAIN_MESSAGE));
        Gra.add(Instrukcja);
        Gra.add(Wyjdz);

        menuBar.add(Zapisz);
        menuBar.add(Wczytaj);
        menuBar.add(Gra);

        this.setJMenuBar(menuBar);

        this.setVisible(true);


        this.addKeyListener(this);
        this.add(ButtonPanel);
        this.add(InfoPanel);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        w1.wykoajTure(e.getKeyCode());
        //System.out.println(e.getKeyCode());
        InfoPanel.aktualizuj();
        ButtonPanel.aktualizujPlansze();
        for(int i=w1.komentarze.size()-1;i>=0;i--){
            w1.komentarze.remove(i);
        }
    }

    private void Zapis(String sciezka){
        File f = new File(sciezka);
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch(Exception r){
                System.out.println(r.getMessage());
            }
        }
        else
            try {
                f.delete();
                f.createNewFile();
            } catch(Exception r){
                System.out.println(r.getMessage());
            }
        if(f.canWrite()){
            try {
                FileWriter fw = new FileWriter(f, true);
                Formatter fm = new Formatter(fw);
                int x = w1.getX();
                int y = w1.getY();
                fm.format("%d\r\n%d\r\n",x ,y);
                fm.format("%d\r\n",w1.organizmy.size());
                for(int i=0; i<w1.organizmy.size();i++){
                    if(w1.organizmy.get(i) instanceof Czlowiek){
                        fm.format("%s\r\n%d\r\n%d\r\n%d\r\n%d\r\n%d\r\n%d\r\n",w1.organizmy.get(i).getNazwa(),w1.organizmy.get(i).getX() ,w1.organizmy.get(i).getY(),w1.organizmy.get(i).getSila(),w1.organizmy.get(i).getWiek(),((Czlowiek) w1.organizmy.get(i)).getSpecial(),((Czlowiek) w1.organizmy.get(i)).getWait());
                        if(((Czlowiek) w1.organizmy.get(i)).isSpecial_on()==true) {
                            fm.format("1\r\n");
                        }
                        else {
                            fm.format("0\r\n");
                        }
                    }
                    else if(w1.organizmy.get(i) instanceof Zwierze){
                        fm.format("%s\r\n%d\r\n%d\r\n%d\r\n%d\r\n%d\r\n",w1.organizmy.get(i).getNazwa(),w1.organizmy.get(i).getX() ,w1.organizmy.get(i).getY(),w1.organizmy.get(i).getSila(),w1.organizmy.get(i).getWiek(),w1.organizmy.get(i).getPoRozmnozeniu());
                    }
                    else if(w1.organizmy.get(i) instanceof Roslina){
                        fm.format("%s\r\n%d\r\n%d\r\n%d\r\n",w1.organizmy.get(i).getNazwa(),w1.organizmy.get(i).getX() ,w1.organizmy.get(i).getY(),w1.organizmy.get(i).getWiek());
                    }
                }
                fm.close();
                fw.close();
            }catch (Exception r){
                System.out.println(r.getMessage());
            }
        }
    }

    private void Wczytywanie(String sciezka){
        this.remove(ButtonPanel);
        this.remove(InfoPanel);
        File f = new File(sciezka);
        if(f.exists()){
            try {
                Scanner sf = new Scanner(f);
                int x = Integer.parseInt(sf.nextLine());
                System.out.println(x);
                int y = Integer.parseInt(sf.nextLine());
                System.out.println(y);
                int liczbaOrganizmow = Integer.parseInt(sf.nextLine());
                System.out.println(liczbaOrganizmow);
                w1=new Swiat(x,y);
                w1.organizmy.remove(0);
                for(int i=0;i<liczbaOrganizmow;i++){
                    String nazwa=sf.nextLine();
                    if(Objects.equals(nazwa, "czlowiek")){
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int sila = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        int special = Integer.parseInt(sf.nextLine());
                        int wait = Integer.parseInt(sf.nextLine());
                        int special_on = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Czlowiek(x1,y1,w1,sila,wiek,special,wait,special_on));
                    }
                    else if(Objects.equals(nazwa, "antylopa")){
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int sila = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        int poRozmnazaniu = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Antylopa(x1,y1,w1,sila,wiek,poRozmnazaniu));
                    }
                    else if(Objects.equals(nazwa, "lis")){
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int sila = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        int poRozmnazaniu = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Lis(x1,y1,w1,sila,wiek,poRozmnazaniu));
                    }
                    else if(Objects.equals(nazwa, "owca")){
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int sila = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        int poRozmnazaniu = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Owca(x1,y1,w1,sila,wiek,poRozmnazaniu));
                    }
                    else if(Objects.equals(nazwa, "wilk")){
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int sila = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        int poRozmnazaniu = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Wilk(x1,y1,w1,sila,wiek,poRozmnazaniu));
                    }
                    else if(Objects.equals(nazwa, "zolw")){
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int sila = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        int poRozmnazaniu = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Zolw(x1,y1,w1,sila,wiek,poRozmnazaniu));
                    }
                    else if(Objects.equals(nazwa, "barszcz sosnowskiego")) {
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Barszcz(x1, y1, w1, wiek));
                    }
                    else if(Objects.equals(nazwa, "guarana")) {
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Guarana(x1, y1, w1, wiek));
                    }
                    else if(Objects.equals(nazwa, "wilcze jagody")) {
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Jagody(x1, y1, w1, wiek));
                    }
                    else if(Objects.equals(nazwa, "mlecz")) {
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Mlecz(x1, y1, w1, wiek));
                    }
                    else if(Objects.equals(nazwa, "trawa")) {
                        int x1 = Integer.parseInt(sf.nextLine());
                        int y1 = Integer.parseInt(sf.nextLine());
                        int wiek = Integer.parseInt(sf.nextLine());
                        w1.organizmy.add(new Trawa(x1, y1, w1, wiek));
                    }

                }
                sf.close();
                Collections.sort(w1.organizmy);
                Collections.reverse(w1.organizmy);
                w1.uzupelnijTablice();
                ButtonPanel=new buttonPanel(w1);
                InfoPanel = new infoPanel(w1);
                this.add(ButtonPanel);
                this.add(InfoPanel);
                ButtonPanel.aktualizujPlansze();
            } catch(Exception r){
                System.out.println(r.getMessage());
            }
        }
    }

 }
