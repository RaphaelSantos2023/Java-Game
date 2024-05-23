package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.GButton;
import model.GPanelButton;
import model.GTextArea;

public class SettingComumView {
    

    public void SetWindows( Container con, JLabel titleLabel, JPanel panelTitleLabel, JPanel ButtonStartPanel, Font fontTitleLabel, GButton StartButton){
        
        titleLabel.setFont(fontTitleLabel);
        titleLabel.setForeground(Color.white);
        panelTitleLabel.setBounds(250, 150, 300, 150);
        
        StartButton.setFont(new Font("Times New Romans",Font.PLAIN,30));
        StartButton.setText("Start");
        ButtonStartPanel.setBounds(300,350,200,100);
        
        con.add(panelTitleLabel);
        con.add(ButtonStartPanel);
    }

    public void setComponentGame(Container con, GTextArea Moving, GPanelButton TxtPanel, GPanelButton ButtonsPanel , GButton ch1, GButton ch2, GButton ch3, GButton ch4){
        
        Moving.setBounds(0,5, 600, 200);
        Moving.setLineWrap(true);
        TxtPanel.setBounds(100, 70, 600, 200);
        ButtonsPanel.setBounds(275,300,250,250);
        
        con.add(TxtPanel);
        con.add(ButtonsPanel);
    }
}
