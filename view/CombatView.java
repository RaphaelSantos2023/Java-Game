package view;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.GButton;
import model.GPanelButton;
import model.Charact.*;
import model.Charact.Character;
import model.Equip.*;

public class CombatView {
    
    public JTextArea Log = new JTextArea();
    public JLabel ImagemEnemy,StatusPlayer;

    public GButton Ch1,Ch2,Ch3;

    public GPanelButton CombatPanel = new GPanelButton();
    public GPanelButton ImagePanel;
    public GPanelButton CombatLog = new GPanelButton(Log);
    public GPanelButton ButtonsPanel = new GPanelButton(Ch1,Ch2,Ch3);
    public GPanelButton StatusPlayerPanel;
    public GPanelButton NomeEnemy;

    public void setCombatUI(Character enemy, Character Player){
        ImagemEnemy = new JLabel(enemy.getImagem());
        StatusPlayer = new JLabel("HP: "+ Player.getHP()+ " Weapon: "+ Player.getWeapon());
    }
}