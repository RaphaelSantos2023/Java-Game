package control;

import model.GButton;
import model.GPanel;
import model.Charact.Character;
import model.Charact.Player;
import java.awt.event.ActionListener;

import view.Main;

import java.util.Random;

import javax.swing.BoxLayout;

import java.awt.*;

public class control {

    private Main main;

    public control(Main main) {
        this.main = main;
    }

    private Random rand = new Random();
    private boolean Defending = false;

    public String Moviments(Player striker, Character enemy, String Comand) {
        String StrikerLog;
        String EnemyLog;

        StrikerLog = Decision(striker, enemy, Comand);
        EnemyLog = Decision(enemy, striker, "Ataque");
        
        Defending = false;

        System.out.println(striker.getName()+": tá com "+ striker.getHP());
        System.out.println(enemy.getName()+": tá com "+ enemy.getHP());

        main.EnemyHP.setText("HP: " + String.valueOf(main.enemy.getHP()));
        main.EnemyLevel.setText("Lv: " + String.valueOf(main.enemy.getLevel()));

        System.out.println("-----------------------------------");

        if (striker.getHP() <= 0) {
            return "- Você morreu";
        } else if(enemy.getHP() <= 0){
            return "- Você ganhou";
        }

        return "- " + StrikerLog + "\n- " + EnemyLog;

    }

    public String Decision(Character striker, Character enemy, String Comand) {

        int Dice = rand.nextInt(19) + 1;

        if (Comand.equals("Ataque")) {
            if (Dice >= enemy.getDiceValue() && !Defending) {
                int hit = striker.Atack(enemy);
                return striker.getName() + " deu " + Integer.toString(hit);
            }
            return striker.getName() + " Falhou";
        } else {
            Defending = true;
            return striker.getName() + " ficou em posição defensiva";
        }
    }

    public void SetItenspanel(GPanel InventoryPanel, GPanel Itenspanel, GPanel InfoPanel, GPanel ActionPanel, Player player) {

    // Definindo um layout BoxLayout para garantir uma coluna única
    Itenspanel.setLayout(new BoxLayout(Itenspanel, BoxLayout.Y_AXIS));

    GButton CloseBtn = new GButton("<");
    Itenspanel.add(CloseBtn);

    // Adicionando um ActionListener ao botão de fechamento
    CloseBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            InventoryPanel.setVisible(false);  // Esconde o painel de inventário
            ActionPanel.setVisible(true);      // Mostra o painel de ação
        }
    });

    // Adicionando os itens do jogador ao painel
    for (int i = 0; i < player.getInventeorySize(); i++) {
        GButton ItemBtn = new GButton(player.getItem(i), InfoPanel, player, i);
        Itenspanel.add(ItemBtn);

        // Ajustando o tamanho dos botões dos itens
        ItemBtn.setPreferredSize(new Dimension(100, 30));  // Ajuste o tamanho conforme necessário
    }

}

}
