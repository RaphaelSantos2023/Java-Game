

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.GButton;
import model.GPanelButton;
import model.GTextArea;
import view.SettingComumView;

public class Game{

    JFrame window;
    String position;
    JPanel panelTitleLabel,ButtonStartPanel;
    GPanelButton TxtPanel,ButtonsPanel;
    Container con;
    ChoiceCross Cross = new ChoiceCross();
    GTextArea Moving, combatLog;
    SettingComumView SCV = new  SettingComumView();
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
        window.getContentPane().setBackground(Color.BLACK);
    
        titleLabel = new JLabel("TesteRPG");
        panelTitleLabel = new GPanelButton(titleLabel);
        StartButton = new GButton("Start", Cross);
        ButtonStartPanel = new GPanelButton(StartButton);
    
        con = window.getContentPane();
    
        SCV.SetWindows(con, titleLabel, panelTitleLabel, ButtonStartPanel, fontTitleLabel, StartButton);
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
        ch1 = new GButton("ch1",Cross);
        ch2 = new GButton("ch2",Cross);
        ch3 = new GButton("ch3",Cross);
        ch4 = new GButton("ch4",Cross);
        TxtPanel = new GPanelButton(Moving);
        ButtonsPanel = new GPanelButton(ch1,ch2,ch3,ch4);

        SCV.setComponentGame(con, Moving, TxtPanel, ButtonsPanel , ch1, ch2, ch3, ch4);
    }
    
    public void Introduction(){
        position = "Introduction";
        setComponents();
        SetingTxtACj("Vindo de uma longe viage,você é um goblin quequer estabelecer\numa vida na cidade de Morabi. Finalmente,os portões massisos estão a sua frente",">","","","");
    }
    
    public void GateFront(){
        position = "GateFront";
        SetingTxtACj("Um guarda espera aos pés do portão","Falar com ele","Lutar","Sair","");
    }
    
    public void TalkGuard(){
        position = "GuardTalk";
        SetingTxtACj("Guard:O que você quer?","*Gostaria de entrar*","*Você fede*","*Nada de mais*","");
    }

    public  void InsultingGuard(){
        position = "GuardInsulted";
        SetingTxtACj("Guard:O que você disse?","*Além de fedido é surdo?*","*Nada não...*","","");
    }

    public void EntreRequest(){
        position = "EntreRequest";
        SetingTxtACj("Guard:(Olhando-te de cima a baixo)Não deixamos qualquer um entrar.","*Tem algo que posso fazer?*","*...*","","");
    }

    public void ReciveQuest(){
        position = "ReciveQuest";
        SetingTxtACj("Guard:(Pensativo)Se você provar utilidade a cidade ou receber a altorização de um morador, talvez","*Vou ver o que consigo*","","","");
    }

    public void CrossRoad(){
        position = "CrossRoad";
        SetingTxtACj("Você etá numa encruzilhada lamacenta.\nAo norte tem uma floresta.\nAo leste tem uma taverna.\nAo oeste um acampamento.\nAo Sul a cidade","Floresta","Taverna","Acampamento","Cidade");
    }

    public void FightGuard(){
        position = "FightGuard";
        SetingTxtACj("Guard:Hora essa, seu ladrãosinho!", ">","", "", "");
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
                        case  "ch2":
                            FightGuard();
                        break;
                        case "ch3":
                            CrossRoad();
                        break;
                    }
                    
                break;
                case "GuardTalk":
                    switch(choice){
                        case "ch1":
                            EntreRequest();
                        break;
                        case "ch2":
                            FightGuard();
                        break;
                        case "ch3":
                            GateFront();
                        break;
                    }
                break;
                case "EntreRequest":
                    switch(choice){
                        case "ch1":
                            ReciveQuest();
                        break;
                        case "ch2":
                            TalkGuard();
                        break;
                    }
                break;
                case "ReciveQuest":
                    switch(choice){
                        case "ch1":
                            TalkGuard();
                        break;
                    }
                break;
                case "FightGuard":
                    switch(choice){
                        case "ch1":
                            
                        break;
                    }
                break;
            }
        }
        
    }

}