package view;

import control.control;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Charact.Character;
import model.Charact.Player;
import model.GButton;
import model.GPanelButton;
import model.GTextArea;

public class CombatView extends JPanel{

    public CombatChoiceCross Cross = new CombatChoiceCross();
    public GPanelButton ButtonP,TextP,TurnP,StatusPlayer, SouthPanel;
    public Player player;
    public ImageIcon BackGround;
    public Character enemy;
    public GButton Botao1,Botao2,Botao3;
    public Font textStatus = new Font("Times New Romans",Font.PLAIN,30);
    public String position,statusPlayerS,statusEnemyS;
    public GTextArea txt;
    public control crt;

    public CombatView(Player p1, Character en, JFrame window){

        player = p1;
        enemy = en;
        BackGround = new  ImageIcon(en.getBackground());

        setLayout(new BorderLayout());

        Botao1 = new GButton("Atack",Cross);
        Botao1.setText("Atack");
        Botao2 = new GButton("Defend",Cross);
        Botao2.setText("Defend");
        Botao3 = new GButton("Run",Cross);
        Botao3.setText("Run");

        ButtonP = new GPanelButton();
        ButtonP.setLayout(new GridLayout(1,3));

        ButtonP.add(Botao1);
        ButtonP.add(Botao2);
        ButtonP.add(Botao3);

        txt = new GTextArea(window);
        txt.setFont(new Font("Times New Romans",Font.PLAIN,25));
        txt.setText("-Um "+en.getName() +" Apareceu no caminho");

        TextP = new GPanelButton();
        TextP.add(txt);

        StatusPlayer = new GPanelButton();
        StatusPlayer.add(LabelUpdate(1));

        ButtonP.add(StatusPlayer);
        ButtonP.add(Botao1);
        ButtonP.add(Botao2);
        ButtonP.add(Botao3);

        TurnP = new GPanelButton();
        TurnP.add(LabelUpdate(2));

        crt = new control(p1, en, txt, ButtonP);

        add(ButtonP, BorderLayout.SOUTH);
        add(TextP,BorderLayout.EAST);
        add(TurnP,BorderLayout.NORTH);
        add(new JLabel(BackGround),BorderLayout.CENTER);

        setVisible(true);
    }

    public JLabel LabelUpdate(int caseCharacter){
        statusPlayerS = "HP: "+ player.getHP()+"\n Weapon: "+ player.getWeapon().getName();
        statusEnemyS = enemy.getName() + ":" + enemy.getHP();

        if(caseCharacter == 1){
            JLabel StatusLabelPlayer = new JLabel(statusPlayerS);
            StatusLabelPlayer.setFont(textStatus);
            return  StatusLabelPlayer;
        }else{
            JLabel StatusLabelEnemy = new JLabel(statusEnemyS);
            StatusLabelEnemy.setFont(textStatus);
            return  StatusLabelEnemy;
        }
    }

    public class CombatChoiceCross implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            ButtonP.setVisible(false);
            switch(choice){
                
                case "Atack":
                     crt.turns("Atack");
                break;
                case "Defend":
                    crt.turns("Defend");
                break;
            }
            
        }
    }
}