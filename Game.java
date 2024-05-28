

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Charact.Guard;
import model.Charact.Player;
import model.GButton;
import model.GPanelButton;
import model.GTextArea;
import view.CombatView;

public class Game{

    JFrame window;
    String position;
    JPanel panelTitleLabel,ButtonStartPanel;
    GPanelButton TxtPanel,ButtonsPanel,StartPanel, CenterStartLocation,mainPanel;
    Container con;
    ChoiceCross Cross = new ChoiceCross();
    GTextArea Moving, combatLog;
    GButton StartButton, ch1,ch2,ch3,ch4;
    JLabel titleLabel;
    public CombatView CV;
    Player p1 = new Player();
    Font fontTitleLabel = new Font("Times New Romans",Font.PLAIN,60);

    public static void main(String[] args){
        Game game = new Game();
        game.SetingWindow();
    }

    
    public void SetingWindow(){
        position = "Start";
    
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setSize(1200,700);
        window.getContentPane().setBackground(Color.BLACK);
    
        titleLabel = new JLabel("TesteRPG");
        panelTitleLabel = new GPanelButton(titleLabel);
        StartButton = new GButton("Start", Cross);
        ButtonStartPanel = new GPanelButton(StartButton);

        StartPanel = new GPanelButton();

        CenterStartLocation = new GPanelButton();
        CenterStartLocation.setLayout(new GridLayout(2,1));
        
        titleLabel.setFont(fontTitleLabel);
        titleLabel.setForeground(Color.white);
        
        StartButton.setFont(new Font("Times New Romans",Font.PLAIN,30));
        StartButton.setText("Start");
        
        CenterStartLocation.add(panelTitleLabel);
        CenterStartLocation.add(StartButton);

        StartPanel.add(CenterStartLocation,BorderLayout.CENTER);

        con = window.getContentPane();
        
        con.add(StartPanel,BorderLayout.CENTER);
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

        mainPanel = new GPanelButton();
        mainPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(TxtPanel);
        mainPanel.add(ButtonsPanel);

        con.add(mainPanel, BorderLayout.CENTER);
    }
    
    public void Introduction(){
        position = "Introduction";
        setComponents();
        SetingTxtACj("Vindo de uma longe viage,\nvocê é um goblin quequer estabelecer\numa vida na cidade de Morabi. \nFinalmente,os portões massisos estão a sua frente",">","","","");
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
                            StartPanel.setVisible(false);
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
                        mainPanel.setVisible(false);
                        CV = new CombatView(p1, new Guard());
                        window.add(CV);
                        break;
                    }
                break;
            }
        }
        
    }

}