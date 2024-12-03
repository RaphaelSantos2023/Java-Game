package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Main;
import model.Charact.*;
import model.Equip.food.*;

public class ChoiceCross implements ActionListener {

    private Main main;
    private control con;

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
                switch (choice) {
                    case "ch1":
                        main.FlorestEntrance();
                    break;
                    case "ch2":
                        main.Tavern();
                    break;
                    case "ch3":
                        main.GateFront();
                    break;
                    case "ch4":
                        main.GateFront();
                    break;
                }
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
            case "FlorestEntrance":
                switch (choice) {
                    case "ch1":
                        con = new control(main);
                        main.enemy = con.ChooseEnemy(1);
                        main.CombatUI();
                    break;
                    case "ch2":
                        main.CrossRoad();
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
                        main.enemy = new Guard(5);
                        main.CombatUI();
                        break;
                }
                break;
            case "CombatUI":
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
                if (main.enemy != null) {
                    main.EnemyHP.setText("HP: " + String.valueOf(main.enemy.getHP()));
                    main.EnemyLevel.setText("Lv: " + String.valueOf(main.enemy.getLevel()));
                } else {
                    // Tratamento caso o inimigo ou algum dado esteja nulo
                    main.EnemyHP.setText("HP: Não disponível");
                    main.EnemyLevel.setText("Lv: Não disponível");
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
            main.Weapon.setText("Weapon: " + main.player.getWeapon().getName());
        } else {
            // Tratamento caso o player ou algum dado esteja nulo
            main.Hp.setText("HP: Não disponível");
            main.Weapon.setText("Weapon: Não disponível");
        }
    }
}
