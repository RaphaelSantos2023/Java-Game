package model.Charact;

import model.Equip.*;
import java.util.Random;

public class Character {

    private int hp;
    private String name;
    private int Level = 1;
    private String StateEfect = "none";
    private Equipamento weapon;
    private int Dex, Str, Luck, Inte, HpMax, StrMax;
    private int money, DiceValue;
    private String imagem, BackGround;
    private Random rand = new Random();

    public int getDex() {
        return this.Dex;
    }

    public int getStr() {
        return this.Str;
    }

    public int getLuck() {
        return this.Luck;
    }

    public int getInte() {
        return this.Inte;
    }

    public String getName() {
        return name;
    }

    public String getStateEfect() {
        return StateEfect;
    }

    public int getHP() {
        return hp;
    }

    public Equipamento getWeapon() {
        return weapon;
    }

    public int getMoney() {
        return money;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDiceValue() {
        return DiceValue;
    }

    public String getBackGround() {
        return BackGround;
    }

    public void setDex(int Dex) {
        this.Dex = Dex;
    }

    public void setStr(int Str) {
        this.Str = Str;
    }

    public void setLuck(int Luck) {
        this.Luck = Luck;
    }

    public void setInte(int Inte) {
        this.Inte = Inte;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStateEfect(String StateEfect) {
        this.StateEfect = StateEfect;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setWeapon(Equipamento weapon) {
        this.weapon = weapon;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setBackGround(String BackGround) {
        this.BackGround = BackGround;
    }

    public void setDiceValue(int dice) {
        this.DiceValue = dice;
    }

    public int Atack(Character chart) {
        int damage = rand.nextInt(this.getWeapon().getDamage());
        if (chart.getStr() > 0) {
            chart.setStr(chart.getStr() - damage);
        } else {
            chart.setHP(chart.getHP() - damage);
        }
        return damage;
    }

    public int getHpMax() {
        return this.HpMax;
    }

    public void setHpMax(int HpMax) {
        this.HpMax = HpMax;
    }

    public int getStrMax() {
        return this.StrMax;
    }

    public int getLevel(){
        return this.Level;
    }

    public void setLevel(int level){
        this.Level = level;
    }

    public void setStrMx(int str) {
        this.StrMax = str;
    }

    public void Wear(Equipamento equip) {
        setStr(getStrMax() + equip.getArmo());
    }

    public void levelChange(){
        setHpMax(this.HpMax*Level);
        setHP(this.hp*Level);
    }
}