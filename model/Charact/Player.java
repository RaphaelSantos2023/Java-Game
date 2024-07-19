package model.Charact;

import model.Equip.*;
import java.util.ArrayList;
import model.Equip.food.*;

public class Player extends Character {

    ArrayList<Equipamento> Inventory = new ArrayList<Equipamento>();

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
    }

    public void addInventory(Equipamento equip) {
        Inventory.add(equip);
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
