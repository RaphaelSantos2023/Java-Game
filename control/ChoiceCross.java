package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Main;
import model.Charact.Guard;

public class ChoiceCross implements ActionListener {

    private Main main;

    public ChoiceCross(Main main) {
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();

        switch (choice) {
            case "ch5":
                main.SetInventory();
                break;
        }

        switch (main.position) {
            case "Start":
                switch (choice) {
                    case "ch1":
                        main.StartPanel.setVisible(false);
                        main.Introduction();
                        break;
                }
                break;
            case "Introduction":
                switch (choice) {
                    case "ch1":
                        main.GateFront();
                        break;
                }
                break;
            case "GateFront":
                switch (choice) {
                    case "ch1":
                        main.TalkGuard();
                        break;
                    case "ch2":
                        main.FightGuard();
                        break;
                    case "ch3":
                        main.CrossRoad();
                        break;
                }
                break;
            case "CrossRoad":
                break;
            case "GuardTalk":
                switch (choice) {
                    case "ch1":
                        main.EntreRequest();
                        break;
                    case "ch2":
                        main.FightGuard();
                        break;
                    case "ch3":
                        main.GateFront();
                        break;
                }
                break;
            case "EntreRequest":
                switch (choice) {
                    case "ch1":
                        main.ReciveQuest();
                        break;
                    case "ch2":
                        main.TalkGuard();
                        break;
                }
                break;
            case "ReciveQuest":
                switch (choice) {
                    case "ch1":
                        main.TalkGuard();
                        break;
                }
                break;
            case "FightGuard":
                switch (choice) {
                    case "ch1":
                        System.out.println("Aqui");
                        main.enemy = new Guard(5);
                        main.CombatUI();
                        break;
                }
                break;
            case "CombatUI":

                if (main.enemy != null) {
                    main.EnemyHP.setText("HP: " + String.valueOf(main.enemy.getHP()));
                    main.EnemyLevel.setText("Lv: " + String.valueOf(main.enemy.getLevel()));
                } else {
                    // Tratamento caso o inimigo ou algum dado esteja nulo
                    main.EnemyHP.setText("HP: Não disponível");
                    main.EnemyLevel.setText("Lv: Não disponível");
                }

                switch (choice) {
                    case "ch1":
                        main.TextAction.setText(main.control.Moviments(main.player, main.enemy, "Ataque"));
                        main.ChecarVitoria();
                        break;
                    case "ch2":
                        main.TextAction.setText(main.control.Moviments(main.player, main.enemy, "Defense"));
                        main.ChecarVitoria();
                        break;
                }
                break;
            case "Morte":
                switch (choice) {
                    case "ch1":
                        main.DeadScreen();
                        break;
                }
                break;
            case "Vitoria":
                switch (choice) {
                    case "ch1":
                        main.position = main.PreviousPosition;
                        break;
                }
                break;
            case "DeadScreen":
                switch (choice) {
                    case "ch1":
                        main.Start();
                        break;
                }
        }

        if (main.player != null) {
            main.Hp.setText("HP: " + String.valueOf(main.player.getHP()));
            main.Money.setText("$: " + String.valueOf(main.player.getMoney()));
        } else {
            // Tratamento caso o player ou algum dado esteja nulo
            main.Hp.setText("HP: Não disponível");
            main.Money.setText("$: Não disponível");
        }
    }
}
