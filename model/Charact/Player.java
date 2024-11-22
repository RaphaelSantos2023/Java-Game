//Player.java
package model.Charact;

import model.Equip.*;
import java.util.ArrayList;
import model.Equip.food.*;

public class Player extends Character {

    private ArrayList<Equipamento> Inventory = new ArrayList<Equipamento>();
    private String iconMax = "image\\player_sprites\\Player_HP_high_sprite.png";
    private String iconMid = "image\\player_sprites\\Player_HP_mid_sprite.png";
    private String iconLow = "image\\player_sprites\\Player_HP_low_sprite.png";

    private String icon = "";

    public Player(int Dex, int Str, int Inte, int Luck) {
        this.setHP(10);
        this.setHpMax(10);
        this.setMoney(0);
        this.setName("Você");
        this.setWeapon(new knife());
        this.setDiceValue(10);
        this.setDex(Dex);
        this.setInte(Inte);
        this.setStr(Str);
        this.setStrMx(Str);
        this.setLuck(Luck);
        addInventory(new knife());
        addInventory(new orange());
        this.icon = this.iconMax;
    }

    public void addInventory(Equipamento equip) {
        Inventory.add(equip);
    }

    public String getIcon(){
        return this.icon;
    }

    public void setIcon(){
        if(this.getHP() <= (this.getHpMax()/3)){
            this.icon = this.iconLow;
        }else if(this.getHP() <= (this.getHpMax()/3)*2){
            this.icon = this.iconMid;
        }else{
            this.icon = this.iconMax;
        }
    }

    public void removeInventory(int item) {
        Inventory.remove(item);
    }

    public void removeInventory(Equipamento equip) {
        for (int i = 0; i <= getInventeorySize(); i++) {
            if (getItem(i) == equip) {
                removeInventory(i);
            }
        }
    }

    public Equipamento getItem(int item) {
        return Inventory.get(item);
    }

    public int getInventeorySize() {
        return Inventory.size();
    }

    public void eat(Equipamento equip) {
        int live = 0;
        for (int i = 0; i <= equip.getHealth(); i++) {
            if (getHP() < getHpMax()) {
                live++;
                setHP(getHP() + live);
            }
        }
    }

}
