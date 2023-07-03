package pl.eco.graficManager;

import pl.eco.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class comboBoxes extends JFrame implements ActionListener {
    JComboBox comboBox;
    int x ,y;
    buttonPanel B;
    Swiat w;
    comboBoxes(buttonPanel B, int x, int y, Swiat w){
        this.w=w;
        this.x=x;
        this.y=y;
        this.B=B;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        String[] organizmy = {"Owca","Wilk","Lis","Zolw","Antylopa","trawa","guarana","wilcze jagody","barszcz sosnowskiego","mlecz"};

        comboBox=new JComboBox(organizmy);
        comboBox.addActionListener(this);

        this.add(comboBox);
        this.setSize(250,300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            w.dodajOrganizm(x,y, (String) comboBox.getSelectedItem());
            B.aktualizujPlansze();
            this.dispose();
        }
    }
}
