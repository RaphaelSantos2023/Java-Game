package model.Charact;

import model.Equip.*;

public class Guard extends Character {

    public Guard(int level) {
        this.setHP(25);
        this.setLevel(level);
        this.setName("Guarda");
        this.setWeapon(new Spear());
        this.setStr(6);
        this.setDex(2);
        this.setDiceValue(10);
        this.setImagem("image\\Guard_sprite.png");
        this.setBackGround("image\\GateSprite.png");

        this.levelChange();
    }
}