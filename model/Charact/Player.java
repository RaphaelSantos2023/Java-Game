package model.Charact;

import model.Equip.*;

public class Player extends Character{
    
    public Player(){
        this.setHP(10);
        this.setMoney(0);
        this.setName("Você");
        this.setWeapon(new knife());
    }
}
