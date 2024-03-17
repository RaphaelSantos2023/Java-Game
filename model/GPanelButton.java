package model;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class GPanelButton extends JPanel{
    
    public GPanelButton(){
        super();
        setBackground(Color.yellow);
    }
    
    public GPanelButton(JLabel label){
        super();
        setBackground(Color.GRAY);
        add(label);
    }
    
    public GPanelButton(JTextArea txt){
        super();
        setBackground(Color.DARK_GRAY);
        add(txt);
    }
    
    public GPanelButton(JButton button){
        super();
        setBackground(Color.ORANGE);
        add(button);
    }
    
    public GPanelButton(JPanel panel){
        add(panel);
    }
    
    public GPanelButton(JButton but1, JButton but2, JButton but3, JButton but4){
        super();
        setBackground(Color.red);
        setLayout(new GridLayout(4,1));
        add(but1);
        add(but2);
        add(but3);
        add(but4);
    }
    
    public GPanelButton(JLabel label1, JLabel label2){
        super();
        setBackground(Color.blue);
        setLayout(new GridLayout(2,1));
        add(label1);
        add(label2);
    }
    
    public GPanelButton(JLabel label1, JLabel label2,JButton but1, JButton but2, JButton but3, JButton but4){
        super();
        setBackground(Color.green);
        setLayout(new GridLayout(3,2));
        add(label1);
        add(label2);
        add(but1);
        add(but2);
        add(but3);
        add(but4);
    }
}
