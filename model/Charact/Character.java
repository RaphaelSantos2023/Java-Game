package model.Charact;

import model.Charact.Character;
import model.Equip.*;

public class Character {

    private int hp;
    private int ChanceHit;
    private int aggressiveness;
    private String name;
    private Equipamento weapon;
    private int money;
    private String imagem, backGroundImg;
    private boolean Atacking;

    public Character(){}

    public String getName(){
        return name;
    }

    public int getHP(){
        return hp;
    }

    public int getChanceHit(){
        return ChanceHit;
    }
    public Equipamento getWeapon(){
        return weapon;
    }

    public int getMoney(){
        return money;
    }

    public String getImagem(){
        return imagem;
    }

    public String getBackground(){
        return backGroundImg;
    }

    public boolean getAtacking(){
        return Atacking;
    }

    public int getAggressiveness(){
        return aggressiveness;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public void setChanceHit(int hit){
        this.ChanceHit = hit;
    }

    public void setAggressiveness(int aggressiveness){
        this.aggressiveness = aggressiveness;
    }

    public void setWeapon(Equipamento weapon){
        this.weapon = weapon;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public void setImagem(String imagem){
        this.imagem = imagem;
    }

    public void setBackGroundImg(String backGroundImg) {
        this.backGroundImg = backGroundImg;
    }
    
    public void setAtacking(boolean Atacking){
        this.Atacking = Atacking;
    }
    public void Atack(Character chart){
        chart.setHP(chart.getHP()- this.getWeapon().getDamege());
        Atacking= true;
    }

    public void Defend(Character chart){
        if(chart.getAtacking()){
            this.setHP(this.getHP()+chart.getWeapon().getDamege());
        }
    }
}