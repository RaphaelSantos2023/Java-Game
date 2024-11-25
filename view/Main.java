//Main.java
package view;
import model.*;
import model.Charact.*;
import model.Charact.Character;
import control.ChoiceCross;
import control.control;

import javax.swing.*;
import java.awt.*;

public class Main {

    public JFrame window;
    public Container con;
    public GPanel StartPanel, ActionPanel, buttonsPanel, StatusPlayer, InventoryPanel, Itenspanel, InfoPanel;
    public GPanel PanelEnemy, PanelEnStatus;

    public JLabel TextLabel = new JLabel();
    public JLabel DexLabel = new JLabel();
    public JLabel StrLabel = new JLabel();
    public JLabel Hp = new JLabel();
    public JLabel Money = new JLabel();
    public JLabel Weapon = new JLabel();
    public JLabel LuckLabel = new JLabel();
    public JLabel InteLabel = new JLabel();

    public JLabel EnemyHP = new JLabel();
    public JLabel EnemyLevel = new JLabel();

    public GTextArea TextAction = new GTextArea();
    public GButton Btn1, Btn2, Btn3, Btn4, St1, St2, St3, St4, InventoryBtn;
    public int Dex, Str, Luck, Inte;
    public ChoiceCross Cross;
    public String position, PreviousPosition;
    public Font fontTitleLabel = new Font("Times New Romans", Font.PLAIN, 60);
    public control control = new control(this);

    public Font TextFont = new Font("Times New Romans", Font.PLAIN, 28);
    public Player player;

    public Character enemy;

    public Main() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        con = window.getContentPane();

        StartPanel = new GPanel();
        StartPanel.setLayout(null);

        Cross = new ChoiceCross(this); // Passando a referência da classe Main

        Btn1 = new GButton("ch1", Cross);

        TextLabel.setFont(fontTitleLabel);
        Start();

        StartPanel.add(TextLabel);
        StartPanel.add(Btn1);

        con.add(StartPanel);
        window.setVisible(true);
    }

    public void setStartPanel(String Text, String TextButton) {
        player = new Player(4, 4, 5, 3);

        TextLabel.setText(Text);
        Btn1.setText(TextButton);
        TextLabel.setBounds(323, 100, 150, 150);
        TextLabel.setForeground(Color.white);
        Btn1.setBounds(312, 350, 150, 50);
    }

    public static void main(String[] args) {
        new Main();
    }

     public void SetingTxt(String txt, String chT1, String chT2, String chT3, String chT4) {
        TextAction.setText(txt);
        Btn1.setText(chT1);
        Btn2.setText(chT2);
        Btn3.setText(chT3);
        Btn4.setText(chT4);
    }

    public void setComponents() {
        StartPanel.setVisible(false);

        ActionPanel = new GPanel();
        ActionPanel.setLayout(null);

        StatusPlayer = new GPanel(Hp,Money,1,2);
        StatusPlayer.setBounds(50, 20, 650, 70);

        Btn2 = new GButton("ch2", Cross);
        Btn3 = new GButton("ch3", Cross);
        Btn4 = new GButton("ch4", Cross);

        InventoryBtn = new GButton("ch5", Cross);
        InventoryBtn.setText("Inventario");

        buttonsPanel = new GPanel(Btn1, Btn2, Btn3, Btn4);
        buttonsPanel.add(InventoryBtn);
        buttonsPanel.setBounds(273, 350, 200, 200);
        buttonsPanel.setLayout(new GridLayout(5, 1));
        buttonsPanel.setBackground(Color.black);

        TextAction.setBounds(50, 90, 650, 250);

        ActionPanel.add(StatusPlayer);
        ActionPanel.add(buttonsPanel);
        ActionPanel.add(TextAction);

        con.add(ActionPanel);
    }

    public void CombatUI() {
        PreviousPosition = position;
        position = "CombatUI";

        buttonsPanel.setBounds(460, 340, 200, 200);
        
        TextAction.setBounds(460, 110, 240, 230);
        TextAction.setFont(TextFont);

        PanelEnStatus = new GPanel(EnemyHP,EnemyLevel,1,2);
        PanelEnStatus.setBounds(50,420,400,40);

        EnemyHP.setText("HP: "+ String.valueOf(enemy.getHP()));
        EnemyLevel.setText("Lv: "+ String.valueOf(enemy.getLevel()));

        Hp.setText("HP: "+ String.valueOf(player.getHP()));
        Money.setText("$: "+ String.valueOf(player.getMoney()));

        PanelEnemy = new GPanel(enemy.getBackGround(), enemy.getImagem());
        PanelEnemy.setBounds(50, 110, 400, 300);

        SetingTxt(enemy.getName() + " aparece no seu caminho", "Attack", "Defense", "Run", "");

        ActionPanel.add(PanelEnStatus);
        ActionPanel.add(PanelEnemy);

        
    }
    
    public void SetInventory() {

        ActionPanel.setVisible(false);
        InventoryPanel = new GPanel();
        InventoryPanel.setLayout(new GridLayout(1,2));
        
        Itenspanel = new GPanel();

        InfoPanel = new GPanel();
        InfoPanel.setVisible(false);

        control.SetItenspanel(InventoryPanel, Itenspanel, InfoPanel, ActionPanel, player);

        InventoryPanel.add(Itenspanel);
        InventoryPanel.add(InfoPanel);
        con.add(InventoryPanel);
    }

    public void ChecarVitoria() {

        switch (TextAction.getText()) {
            case "- Você morreu":
                position = "Morte";
                SetingTxt(TextAction.getText(), ">", "", "", "");
                break;
            case "- Você ganhou":
                position = "Vitoria";
                SetingTxt(TextAction.getText(), ">", "", "", "");
                break;
        }

    }

    public void DeadScreen() {
        position = "DeadScreen";

        ActionPanel.setVisible(false);
        StartPanel.setVisible(true);
        StartPanel.add(Btn1);

        setStartPanel("Você morreu", "Reiniciar");
    }

    public void Start() {
        position = "Start";
        setStartPanel("Rpg", "Start");
    }

    public void Introduction() {
        position = "Introduction";
        setComponents();
        SetingTxt(
                "Vindo de uma longa viagem,\nvocê é um goblin quequer estabelecer\numa vida na cidade de Morabi. Finalmente,\nos portões massisos estão a sua frente",
                ">", "", "", "");
    }

    public void GateFront() {
        position = "GateFront";
        SetingTxt("Um guarda espera aos pés do portão", "Falar", "Lutar", "Sair", "");
    }

    public void TalkGuard() {
        position = "GuardTalk";
        SetingTxt("Guard:O que você quer?", "*Entrar*", "Ofender", "...", "");
    }

    public void InsultingGuard() {
        position = "GuardInsulted";
        SetingTxt("Guard:O que você disse?", "Ofender", "*Nada não...*", "", "");
    }

    public void EntreRequest() {
        position = "EntreRequest";
        SetingTxt("Guard:Não deixamos qualquer um entrar.",
                "*Tem algo que posso fazer?*", "*...*", "", "");
    }

    public void ReciveQuest() {
        position = "ReciveQuest";
        SetingTxt(
                "Guard:(Pensativo)Se você provar utilidade\npara a cidade ou receber a \nautorização de um morador, talvez",
                "*Vou ver o que consigo*", "", "", "");
    }

    public void CrossRoad() {
        position = "CrossRoad";
        SetingTxt(
                "Você etá numa encruzilhada lamacenta.\nAo norte tem uma floresta.\nAo leste tem uma taverna.\nAo oeste um acampamento.\nAo Sul a cidade",
                "Floresta", "Taverna", "Acampamento", "Cidade");
    }

    public void FightGuard() {
        position = "FightGuard";
        SetingTxt("Guard:Hora essa, seu ladrãosinho!", ">", "", "", "");
    }

}
