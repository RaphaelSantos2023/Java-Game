package model.Charact;

import model.Equip.*;
import javax.swing.ImageIcon;

public class Character {

    private int hp;
    private String name;
    private Equipamento weapon;
    private int money;
    private ImageIcon imagem;

    public Character(){}

    public String getName(){
        return name;
    }

    public int getHP(){
        return hp;
    }

    public Equipamento getWeapon(){
        return weapon;
    }

    public int getMoney(){
        return money;
    }

    public ImageIcon getImagem(){
        return imagem;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public void setWeapon(Equipamento weapon){
        this.weapon = weapon;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public void setImagem(ImageIcon imagem){
        this.imagem = imagem;
    }

    public void Atack(Character chart){
        chart.setHp(chart.getHp() - this.getWeapon().getDamege());
    }
}