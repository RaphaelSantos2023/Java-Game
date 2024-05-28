package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GButton extends JButton{
    
    public GButton( String command, ActionListener ActL){
        super();
        setFont(new Font("Times New Romans",Font.PLAIN,20));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusPainted(false);
        setActionCommand(command);
        addActionListener(ActL);
    }

}
