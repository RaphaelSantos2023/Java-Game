package model;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

public class GTextArea extends JTextArea{
    
    public GTextArea(){
        super();
        setFont( new Font("Times New Romans", Font.PLAIN, 28));
        setForeground(Color.WHITE);
        setBackground(Color.red);
    }
    
    public GTextArea(String txt){
        super();
        setText(txt);
        setFont( new Font("Times New Romans", Font.PLAIN, 28));
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
    }
}
