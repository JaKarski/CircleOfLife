package pl.eco.graficManager;

import pl.eco.Swiat;

import javax.swing.*;
import java.awt.*;

public class infoPanel extends JPanel {
    private Swiat w;
    JTextArea label = new JTextArea();;
    public infoPanel(Swiat w){
        this.w=w;
        this.setBounds(500,0,500,500);
        this.setBackground(Color.white);
        JScrollPane scroll = new
                JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    public void aktualizuj(){
        String komentarz="";
        for(int i=0;i<w.komentarze.size();i++){
            komentarz=komentarz+w.komentarze.get(i)+'\n';
        }
        label.setText(komentarz);
        label.setFocusable(false);
        label.setEditable(false);
        this.add(label);
    }


}
