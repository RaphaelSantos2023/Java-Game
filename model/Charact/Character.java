package model.Charact;

import javax.swing.ImageIcon;
import model.Charact.Character;
import model.Equip.*;

public class Character {

    private int hp;
    private String name;
    private Equipamento weapon;
    private int money;
    private ImageIcon imagem, backGroundImg;

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

    public ImageIcon getBackground(){
        return backGroundImg;
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
        chart.setHP(chart.getHP()- this.getWeapon().getDamege());
    }

    public void setBackGroundImg(String backGroundImg) {
        this.backGroundImg = new ImageIcon(backGroundImg);
    }
    
}