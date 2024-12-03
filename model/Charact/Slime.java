//Slime.java
package model.Charact;

import model.Equip.Hand;

public class Slime extends Character{
    
    public Slime(int level){
        super(level);
        this.setHP(5);
        this.setLevel(level);
        this.setName("Slime");
        this.setWeapon(new Hand());
        this.setStr(1);
        this.setDex(5);
        this.setDiceValue(5);
        this.setImagem("image\\slime_sprite.png");
        this.setBackGround("image\\Forest_bg.png");
        this.levelChange();
    }
}
