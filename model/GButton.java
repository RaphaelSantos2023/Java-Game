package model;

import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;

import model.Charact.Player;
import model.Equip.Equipamento;

import javax.swing.*;

public class GButton extends JButton {

    private JLabel NameItem = new JLabel();
    private JLabel Special = new JLabel();
    private JLabel Type = new JLabel();
    private JLabel StatusInfo = new JLabel();
    private Font fontInvent = new Font("Times New Romans", Font.PLAIN, 20);

    public GButton(String command, ActionListener ActL) {
        super();
        setFont(new Font("Times New Romans", Font.PLAIN, 20));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusPainted(false);
        setActionCommand(command);
        addActionListener(ActL);
    }

    public GButton() {
        super();
        setFont(new Font("Times New Romans", Font.PLAIN, 20));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusPainted(false);
    }

    public GButton(String Name) {
        super();
        setText(Name);
        setFont(new Font("Times New Romans", Font.PLAIN, 20));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusPainted(false);
    }

    public GButton(Equipamento equip, GPanel ItemInfo, Player player, int itenId) {

        super();
        setFont(new Font("Times New Romans", Font.PLAIN, 20));
        setBackground(Color.BLACK);
        setForeground(Color.white);
        setFocusPainted(false);
        
        ItemInfo.setLayout(new GridLayout(5,1));

        this.setText(equip.getName());
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

                ItemInfo.removeAll();
                ItemInfo.revalidate();
                ItemInfo.repaint();
                GButton Action = new GButton();
                NameItem.setText(equip.getName());
                NameItem.setBounds(15, 15, 50, 50);
                NameItem.setFont(fontInvent);

                Type.setText("Tipo: " + equip.getType());
                Type.setFont(fontInvent);
                Type.setBounds(115, 15, 50, 50);

                switch (equip.getType()) {
                    case "Weapon":
                        StatusInfo.setText("Dano: " + equip.getDamage());
                        Action.setText("Equipar");
                        break;
                    case "eatable":
                        StatusInfo.setText("Saúde: " + equip.getHealth());
                        Action.setText("Comer");
                        break;
                    case "Armo":
                        StatusInfo.setText("Armadura: " + equip.getArmo());
                        Action.setText("Vestir");
                        break;
                }
                StatusInfo.setFont(fontInvent);

                Special.setText("Habilidade: " + equip.getSpecial());
                Special.setFont(fontInvent);
                Special.setBounds(65, 15, 50, 50);

                StatusInfo.setBounds(165, 15, 50, 50);
                Action.setBounds(215, 15, 50, 50);

                Action.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        switch (equip.getType()) {
                            case "Weapon":
                                player.setWeapon(equip);
                                break;

                            case "eatable":
                                player.eat(equip);
                                player.removeInventory(itenId);
                                break;

                            case "Armo":
                                player.Wear(equip);
                                break;
                        }
                    }
                });

                NameItem.setForeground(Color.white);
                Special.setForeground(Color.white);
                Type.setForeground(Color.white);
                StatusInfo.setForeground(Color.white);
                Action.setForeground(Color.white);

                ItemInfo.add(NameItem);
                ItemInfo.add(Type);
                ItemInfo.add(StatusInfo);
                ItemInfo.add(Special);
                ItemInfo.add(Action);
                
                ItemInfo.setVisible(true);
            }
        });
    }
}
