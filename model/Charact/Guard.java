package model.Charact;

import model.Equip.*;

public class Guard extends Character {

    public Guard() {
        this.setHP(25);
        this.setName("Guarda");
        this.setWeapon(new Spear());
        this.setStr(12);
        this.setDex(10);
        this.setDiceValue(16);
        this.setImagem("image\\Guard_sprite.png");
        this.setBackGround("image\\GateSprite.png");
    }
}