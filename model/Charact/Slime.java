package model.Charact;

import model.Equip.Hand;

public class Slime extends Character{
    
    public Slime(){
        this.setHP(5);
        this.setName("Slime");
        this.setWeapon(new Hand());
        this.setStr(1);
        this.setDex(5);
        this.setDiceValue(5);
        this.setImagem("image\\slime_sprite.png");
        this.setBackGround("image\\GateSprite.png");
    }
}
