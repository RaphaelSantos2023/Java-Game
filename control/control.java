package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import model.Charact.Character;
import model.Charact.Player;
import model.GTextArea;
import org.w3c.dom.Text;

public class control {

    public Player player = new Player();
    public Character enemy = new Character();
    public Random rand = new Random();
    public String Description;
    public GTextArea txt;

    public control(Player player, Character enemy, GTextArea txt){
        this.player = player;
        this.enemy = enemy;
        this.txt = txt;
    }

    public void turns(){
        CombatTurn(player,enemy);
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText("Turno do inimigo...");
                CombatTurn(enemy,player);
            }
        });
        timer.setRepeats(false); // Para que o timer não repita
        timer.start();

    }

    public void CombatTurn(Character ch1, Character ch2){
        int Hit = rand.nextInt(19);
        if(Hit>= ch2.getChanceHit()){
            ch1.Atack(ch2);
            Description += "- "+ ch1.getName()+ "conseguiu acertar "+ ch2.getName()+ " com um(a) " + ch1.getWeapon().getName();
        }else{
            Description += "- "+ ch1.getName()+ "falhou em acertar "+ ch2.getName()+ " com um(a) " + ch1.getWeapon().getName();
        }
    }
}
