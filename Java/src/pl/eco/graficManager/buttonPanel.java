package pl.eco.graficManager;

import pl.eco.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonPanel extends JPanel implements ActionListener{
    private Swiat w;
    private JButton[][] buttons;
    public buttonPanel(Swiat w) {
        this.w=w;
        buttons=new JButton[w.getY()][w.getX()];
        this.setBackground(Color.white);
        this.setBounds(0,0,500,500);
        this.setLayout(new GridLayout(w.getY(),w.getX()));

        for(int i=0;i<w.getY();i++){
            for(int j=0;j<w.getX();j++){
                buttons[i][j]=new JButton();
                buttons[i][j].setFont(Font.getFont("Comic Sans"));
                buttons[i][j].setBorder(BorderFactory.createEtchedBorder());
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
                if(w.tab[i][j]=='C'){
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='W'){
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.gray);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='O') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.black);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='L') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.yellow);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='Z') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.green);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='A') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.MAGENTA);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='t') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.GREEN);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='g') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.pink);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='*') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.black);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='b') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.yellow);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='m') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setEnabled(false);
                }
                else if (w.tab[i][j]==' '){
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setEnabled(true);
                }
                this.add(buttons[i][j]);
            }
        }

    }
    public void aktualizujPlansze(){
        for(int i=0;i<w.getY();i++){
            for(int j=0;j<w.getX();j++){
                buttons[i][j].setFocusable(false);
                if(w.tab[i][j]=='C'){
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.red);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='W'){
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.gray);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='O') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.black);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='L') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.yellow);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='Z') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.green);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='A') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.MAGENTA);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='t') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.GREEN);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='g') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.pink);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='*') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.black);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='b') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.yellow);
                    buttons[i][j].setEnabled(false);
                }
                else if(w.tab[i][j]=='m') {
                    buttons[i][j].setText(String.valueOf(w.tab[i][j]));
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setEnabled(false);
                }
                else if (w.tab[i][j]==' '){
                    buttons[i][j].setText(null);
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setEnabled(true);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<w.getY();i++) {
            for (int j = 0; j < w.getX(); j++) {
                if(e.getSource()==buttons[i][j]){
                    comboBoxes comboBox = new comboBoxes(this,j,i,w);
                }
            }
        }
    }
}
