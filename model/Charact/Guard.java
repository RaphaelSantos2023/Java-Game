package model.Charact;
import model.Charact.Character;
import model.Equip.*;

public class Guard extends Character{

    public Guard(){
        this.setHP(25);
        setChanceHit(17);
        this.setName("Guarda");
        this.setWeapon(new Spear());
        this.setBackGroundImg("image/GateBackGround_Sprite.png");
    }
}