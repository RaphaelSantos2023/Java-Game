package model.Equip.food;
import model.Equip.Equipamento;

public class bread extends Equipamento {

    public bread() {
        this.setName("Pão");
        this.setHealth(3);
        this.setType("eatable");
        this.setSpecial("Uma Laranja doce");
        this.setCost(5);
    }
}