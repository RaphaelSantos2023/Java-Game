//Goblin.java
package model.Charact;

import model.Equip.knife;

public class Goblin extends Character{
    
    public Goblin(int level){
        super(level);
        this.setHP(10);
        this.setLevel(level);
        this.setName("Goblin");
        this.setWeapon(new knife());
        this.setStr(3);
        this.setDex(7);
        this.setDiceValue(10);
        this.setImagem("image\\Goblin_sprite.png");
        this.setBackGround("image\\Forest_bg.png");
        this.levelChange();
    }
}