package view;

import model.GButton;
import model.GPanelButton;
import model.GTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game{

    JFrame window;
    String position;
    JPanel panelTitleLabel,ButtonStartPanel,TxtPanel,ButtonsPanel;
    Container con;
    ChoiceCross Cross = new ChoiceCross();
    GTextArea Moving,ocombatLog;
    GButton StartButton, ch1,ch2,ch3,ch4;
    JLabel titleLabel;
    Font fontTitleLabel = new Font("Times New Romans",Font.PLAIN,50);

    public static void main(String[] args){
        Game game = new Game();
        game.SetingWindow();
    }

    
    public void SetingWindow(){
        position = "Start";
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(800,600);
        window.getContentPane().setBackground(Color.black);
        
        con = window.getContentPane();
        
        titleLabel = new JLabel("TesteRPG");
        titleLabel.setFont(fontTitleLabel);
        titleLabel.setForeground(Color.white);
        
        panelTitleLabel = new GPanelButton(titleLabel);
        panelTitleLabel.setBounds(250, 150, 300, 150);
        
        StartButton = new GButton("Start", Cross);
        StartButton.setFont(new Font("Times New Romans",Font.PLAIN,30));
        StartButton.setText("Start");
        
        ButtonStartPanel = new GPanelButton(StartButton);
        ButtonStartPanel.setBounds(300,350,200,100);
        
        con.add(panelTitleLabel);
        con.add(ButtonStartPanel);
        
        window.setVisible(true);
    }
    
    public void SetingTxtACj(String txt, String chT1, String chT2, String chT3, String chT4){
        Moving.setText(txt);
        ch1.setText(chT1);
        ch2.setText(chT2);
        ch3.setText(chT3);
        ch4.setText(chT4);
    }
    
    public void setComponents(){
        Moving = new GTextArea();
        Moving.setBounds(0,5, 600, 200);
        Moving.setLineWrap(true);
        
        ch1 = new GButton("ch1",Cross);
        ch2 = new GButton("ch2",Cross);
        ch3 = new GButton("ch3",Cross);
        ch4 = new GButton("ch4",Cross);
        
        TxtPanel = new GPanelButton(Moving);
        TxtPanel.setBounds(100, 70, 600, 200);
        
        ButtonsPanel = new GPanelButton(ch1,ch2,ch3,ch4);
        ButtonsPanel.setBounds(275,300,250,250);
        
        con.add(TxtPanel);
        con.add(ButtonsPanel);
    }
    
    public void Introduction(){
        position = "Introduction";
        setComponents();
        SetingTxtACj("Vindo de uma longe viage,você é um goblin quequer estabelecer\numa vida na cidade de Morabi. Finalmente,os portões massisos estão a sua frente",">","","","");
    }
    
    public void TalkGuard(){
        position = "Guard";
        SetingTxtACj("Logo que o guarda percebe sua presença, a fese se contorce em um misto de nojo e desprezo\n\n\nGuard:O que você quer?","*Gostaria de entrar*","*Você fede*","*Nada de mais*","");
    }
    
    public void GateFront(){
        position = "GateFront";
        SetingTxtACj("Um guarda espera aos pés do portão","Falar com ele","Lutar","Sair","");
    }
    
    public void CrossRoad(){
        position = "CrossRoad";
        SetingTxtACj("Você etá numa encruzilhada lamacenta.\nAo norte tem uma floresta.\nAo leste tem uma taverna.\nAo oeste um acampamento.\nAo Sul a cidade","Floresta","Taverna","Acampamento","Cidade");
    }
    public class ChoiceCross implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            
            switch(position){
                case "Start":
                    switch(choice){
                        case "Start":
                            panelTitleLabel.setVisible(false);
                            ButtonStartPanel.setVisible(false);
                            Introduction();
                        break;
                    }
                break;
                case "Introduction":
                    switch(choice){
                        case "ch1":
                            GateFront();
                        break;
                    }
                break;
                case "GateFront":
                    switch(choice){
                        case "ch1":
                            TalkGuard();
                        break;
                        case "ch3":
                            CrossRoad();
                        break;
                    }
                    
                break;
            }
        }
        
    }

}