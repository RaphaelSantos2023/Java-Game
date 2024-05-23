package view;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import model.Charact.Character;
import model.GButton;
import model.GPanelButton;
import model.GTextArea;

public class CombatView {
    
    public JTextArea Log = new JTextArea();
    public JLabel ImagemEnemy,StatusPlayer, EnemyHealth, BackGround;

    public GButton Ch1,Ch2,Ch3;

    public GPanelButton CombatPanel = new GPanelButton();
    public GPanelButton BackGroundPanel = new GPanelButton();
    public GPanelButton ImagemPlayerPanel;
    public GPanelButton CombatLogPanel = new GPanelButton(Log);
    public GPanelButton ButtonsPanel = new GPanelButton(Ch1,Ch2,Ch3);

    public GridBagConstraints constraints = new GridBagConstraints();
    public GPanelButton StatusPlayerPanel = new GPanelButton();
    public GPanelButton PlayerImage = new GPanelButton();
    public GPanelButton EnemyPanel;

    public void setCombatUI(Character enemy, Character Player){
        ImagemEnemy = new JLabel(enemy.getImagem());
        StatusPlayer = new JLabel("HP: "+ Player.getHP()+ " Weapon: "+ Player.getWeapon());
        EnemyHealth = new JLabel(enemy.getName()+": "+enemy.getHP());

    }

    public void setScreen(Character enemy, GTextArea CombatLog){
    }

    public void setButtonsPanel(){
        Ch1 = new GButton("Action",null);
        Ch2 = new GButton("Talk",null);
        Ch3 = new GButton("Run",null);
    }
}