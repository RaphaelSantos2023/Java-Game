package control;

import java.util.Random;
import model.Charact.Character;
import model.Charact.Player;
import model.GPanelButton;
import model.GTextArea;

public class control {

    public Player player;
    public Character enemy;
    public GPanelButton ButtonP;
    public Random rand = new Random();
    public String Description;
    public GTextArea txt;

    public control(Player player, Character enemy, GTextArea txt, GPanelButton ButtonP){
        this.player = player;
        this.enemy = enemy;
        this.txt = txt;
        this.ButtonP = ButtonP;
    }

    public void turns(String actPlayer){
        Description= "-O que você vai fazer?";
        ButtonP.setVisible(false);
        System.out.println("Aqui1");
        switch(actPlayer){
            case "Atack":
                txt.setText(Description+"\n"+CombatTurn(player,enemy));    
            break;
            case "Defend":
                txt.setText(Description+"\n"+DefendTurn(player,enemy));
            break;
        }
        System.out.println("Aqui2");
        EnemyAction();
        ButtonP.setVisible(true);
        
    }

    public String CombatTurn(Character ch1, Character ch2){
        int Hit = rand.nextInt(19);
        if(Hit>= ch2.getChanceHit()){
            ch1.Atack(ch2);
            Description += "\n- "+ ch1.getName()+ " conseguiu acertar "+ ch2.getName()+ "\ncom um(a) " + ch1.getWeapon().getName();
        }else{
            Description += "\n- "+ ch1.getName()+ " falhou em acertar "+ ch2.getName()+ "\ncom um(a) " + ch1.getWeapon().getName();
        }
        
        return Description;
    }

    public String DefendTurn(Character ch1, Character ch2){
        int Hit = rand.nextInt(19);
        if(Hit <= ch1.getChanceHit()){
            ch1.Atack(ch1);
            Description += "\n- "+ ch1.getName()+ " conseguiu se defender de "+ ch1.getName()+ "\nque usava um(a) " + ch1.getWeapon().getName();
        }else{
            Description += "\n- "+ ch2.getName()+ " falhou em defender de "+ ch1.getName()+ "\nque usava um(a) " + ch2.getWeapon().getName();
        }
        return Description;
    }

    public void EnemyAction(){
        int Hit = rand.nextInt(19);
        if(Hit <= player.getAggressiveness()){
            txt.setText(DefendTurn(enemy,player));
        }else{
            txt.setText(CombatTurn(enemy,player));
        }
    }
}
