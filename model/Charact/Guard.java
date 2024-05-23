package model.Charact;
import model.Equip.*;

public class Guard extends Character{

    public Guard(){
        this.setHP(25);
        this.setName("Guarda");
        this.setWeapon(new Spear());
    }
}