package control;

import model.GButton;
import model.GPanel;
import model.Charact.Character;
import model.Charact.Player;
import java.awt.event.ActionListener;

import java.util.Random;
import java.awt.*;

public class control {

    public control() {
    }

    private Random rand = new Random();
    private boolean Defending = false;

    public String Moviments(Character striker, Character enemy, String Comand) {
        String StrikerLog;
        String EnemyLog;

        StrikerLog = Decision(striker, enemy, Comand);
        EnemyLog = Decision(enemy, striker, "Ataque");
        Defending = false;
        if (striker.getHP() > 0 && enemy.getHP() > 0) {
            return "- " + StrikerLog + "\n- " + EnemyLog;
        } else if (striker.getHP() < 0) {
            return "- Você morreu";
        } else {
            return "- Você ganhou";
        }

    }

    public String Decision(Character striker, Character enemy, String Comand) {
        int Dice = rand.nextInt(19) + 1;

        if (Comand.equals("Ataque")) {
            if (Dice >= enemy.getDiceValue() && !Defending) {
                int hit = striker.Atack(enemy);
                return striker.getName() + " deu " + Integer.toString(hit) + " em " + enemy.getName();
            }
            return striker.getName() + " Falhou";
        } else {
            Defending = true;
            return striker.getName() + " ficou em posição defensiva";
        }
    }

    public void SetItenspanel(GPanel InventoryPanel, GPanel Itenspanel, GPanel InfoPanel, GPanel ActionPanel,
            Player player) {
        Itenspanel.setLayout(new GridLayout(player.getInventeorySize(), 1));
        GButton CloseBtn = new GButton("<");

        CloseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                InventoryPanel.setVisible(false);
                ActionPanel.setVisible(true);
            }
        });
        Itenspanel.add(CloseBtn);
        for (int i = 0; i < player.getInventeorySize(); i++) {
            GButton ItemBtn = new GButton(player.getItem(i), InfoPanel, player);
            Itenspanel.add(ItemBtn);
        }

    }
}
