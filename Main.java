import model.GPanel;
import model.*;
import model.Charact.*;
import model.Charact.Character;
import control.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import model.GButton;

public class Main {

    public JFrame window;
    public Container con;
    public GPanel StartPanel, ActionPanel, buttonsPanel, InventoryPanel, Itenspanel, InfoPanel;
    public JLabel TextLabel = new JLabel();
    public JLabel DexLabel = new JLabel();
    public JLabel StrLabel = new JLabel();
    public JLabel LuckLabel = new JLabel();
    public JLabel InteLabel = new JLabel();
    public GTextArea TextAction = new GTextArea();
    public GButton Btn1, Btn2, Btn3, Btn4, St1, St2, St3, St4, InventoryBtn;
    public int Dex, Str, Luck, Inte;
    public ChoiceCross Cross = new ChoiceCross();
    public String position, PreviousPosition;
    public Font fontTitleLabel = new Font("Times New Romans", Font.PLAIN, 60);
    public control control = new control();

    public Player player = new Player(4, 4, 5, 3);
    public Character enemy;

    public Main() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        con = window.getContentPane();

        StartPanel = new GPanel();
        StartPanel.setLayout(null);

        Btn1 = new GButton("ch1", Cross);

        TextLabel.setFont(fontTitleLabel);
        Start();

        StartPanel.add(TextLabel);
        StartPanel.add(Btn1);

        con.add(StartPanel);
        window.setVisible(true);
    }

    public void setStartPanel(String Text, String TextButton) {
        TextLabel.setText(Text);
        Btn1.setText(TextButton);
        TextLabel.setBounds(150, 100, 450, 250);
        TextLabel.setForeground(Color.white);
        Btn1.setBounds(350, 350, 150, 50);
    }

    public static void main(String[] args) {
        new Main();
    }

    /*
     * public void setPlayerStatus() {
     * position = "Creation";
     * GPanel PlusButtons = new GPanel();
     * GPanel MinusButtons = new GPanel();
     * GPanel StatusLabel = new GPanel();
     * 
     * StatusLabel.setLayout(new GridLayout(4, 1));
     * 
     * Dex = 5;
     * Str = 5;
     * Luck = 5;
     * Inte = 5;
     * 
     * DexLabel.setText("Dex(" + Dex + ")");
     * StrLabel.setText("Str(" + Str + ")");
     * LuckLabel.setText("Luck(" + Luck + ")");
     * InteLabel.setText("Int(" + Inte + ")");
     * StatusLabel.add(DexLabel);
     * StatusLabel.add(StrLabel);
     * StatusLabel.add(LuckLabel);
     * StatusLabel.add(InteLabel);
     * 
     * SettingStatus(PlusButtons, MinusButtons, StatusLabel);
     * 
     * PlusButtons.setBounds(100, 100, 50, 100);
     * MinusButtons.setBounds(100, 100, 50, 100);
     * StatusLabel.setBounds(100, 100, 50, 100);
     * 
     * con.add(PlusButtons);
     * con.add(MinusButtons);
     * con.add(StatusLabel);
     * }
     * 
     * public void SettingStatus(GPanel Plus, GPanel Minus, GPanel Status) {
     * Plus.setLayout(new GridLayout(4, 1));
     * Minus.setLayout(new GridLayout(4, 1));
     * Status.add(DexLabel);
     * Status.add(StrLabel);
     * Status.add(LuckLabel);
     * Status.add(InteLabel);
     * int[] ADex = { Dex };
     * int[] AStr = { Str };
     * int[] ALuck = { Luck };
     * int[] AInte = { Inte };
     * Plus.add(SettingStatusButton("Soma", ADex));
     * Plus.add(SettingStatusButton("Soma", AStr));
     * Plus.add(SettingStatusButton("Soma", ALuck));
     * Plus.add(SettingStatusButton("Soma", AInte));
     * 
     * Minus.add(SettingStatusButton("Subitrair", ADex));
     * Minus.add(SettingStatusButton("Subitrair", AStr));
     * Minus.add(SettingStatusButton("Subitrair", ALuck));
     * Minus.add(SettingStatusButton("Subitrair", AInte));
     * }
     * 
     * public GButton SettingStatusButton(String Operation, int[] vStatusArray) {
     * GButton button = new GButton();
     * switch (Operation) {
     * case "Soma":
     * button.setText("+");
     * button.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * vStatusArray[0] += 1;
     * }
     * });
     * break;
     * case "Subitrair":
     * button.setText("-");
     * button.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * vStatusArray[0] -= 1;
     * }
     * });
     * break;
     * }
     * return button;
     * }
     */
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

        Btn2 = new GButton("ch2", Cross);
        Btn3 = new GButton("ch3", Cross);
        Btn4 = new GButton("ch4", Cross);
        InventoryBtn = new GButton("ch5", Cross);
        InventoryBtn.setText("Inventario");

        buttonsPanel = new GPanel(Btn1, Btn2, Btn3, Btn4);
        buttonsPanel.add(InventoryBtn);
        buttonsPanel.setBounds(250, 350, 200, 200);
        buttonsPanel.setLayout(new GridLayout(5, 1));
        buttonsPanel.setBackground(Color.black);

        TextAction.setBounds(50, 50, 650, 300);

        ActionPanel.add(buttonsPanel);
        ActionPanel.add(TextAction);

        con.add(ActionPanel);
    }

    public void CombatUI() {
        PreviousPosition = position;
        position = "CombatUI";

        buttonsPanel.setBounds(50, 350, 200, 200);
        TextAction.setBounds(250, 350, 500, 200);
        TextAction.setFont(new Font("Times New Romans", Font.PLAIN, 28));

        GPanel PanelEnemy = new GPanel(enemy.getBackGround(), enemy.getImagem());
        PanelEnemy.setBounds(180, 25, 400, 300);
        SetingTxt(enemy.getName() + " aparece no seu caminho", "Attack", "Defense", "Magic", "Run");
        ActionPanel.add(PanelEnemy);
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

    public void SetInventory() {

        ActionPanel.setVisible(false);
        InventoryPanel = new GPanel();

        Itenspanel = new GPanel();
        Itenspanel.setBounds(50, 50, 150, 300);
        InfoPanel = new GPanel();
        InfoPanel.setBounds(200, 50, 150, 300);
        InfoPanel.setVisible(false);

        control.SetItenspanel(InventoryPanel, Itenspanel, InfoPanel, ActionPanel, player);

        InventoryPanel.add(Itenspanel);
        InventoryPanel.add(InfoPanel);
        con.add(InventoryPanel);
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
        setStartPanel("Rpg de fantasia", "Start");
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

    public class ChoiceCross implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();

            switch (choice) {
                case "ch5":
                    SetInventory();
                    break;
            }

            switch (position) {
                case "Start":
                    switch (choice) {
                        case "ch1":
                            StartPanel.setVisible(false);
                            Introduction();
                            break;
                    }
                    break;
                case "Introduction":
                    switch (choice) {
                        case "ch1":
                            GateFront();
                            break;
                    }
                    break;
                case "GateFront":
                    switch (choice) {
                        case "ch1":
                            TalkGuard();
                            break;
                        case "ch2":
                            FightGuard();
                            break;
                        case "ch3":
                            CrossRoad();
                            break;
                    }

                    break;
                case "CrossRoad":
                    break;
                case "GuardTalk":
                    switch (choice) {
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
                    switch (choice) {
                        case "ch1":
                            ReciveQuest();
                            break;
                        case "ch2":
                            TalkGuard();
                            break;
                    }
                    break;
                case "ReciveQuest":
                    switch (choice) {
                        case "ch1":
                            TalkGuard();
                            break;
                    }
                    break;
                case "FightGuard":
                    switch (choice) {
                        case "ch1":
                            System.out.println("Aqui");
                            enemy = new Guard();
                            CombatUI();
                            break;
                    }
                    break;
                case "CombatUI":
                    switch (choice) {
                        case "ch1":
                            TextAction.setText(control.Moviments(player, enemy, "Ataque"));
                            ChecarVitoria();
                            break;
                        case "ch2":
                            TextAction.setText(control.Moviments(player, enemy, "Defense"));
                            ChecarVitoria();
                            break;
                    }
                    break;
                case "Morte":
                    switch (choice) {
                        case "ch1":
                            DeadScreen();
                            break;
                    }
                    break;
                case "Vitoria":
                    switch (choice) {
                        case "ch1":
                            position = PreviousPosition;
                            break;
                    }
                    break;
                case "DeadScreen":
                    switch (choice) {
                        case "ch1":
                            Start();
                            break;
                    }
            }
        }

    }

}
