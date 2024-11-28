package model.Equip;

public class Equipamento {

    private String name;
    private int Damage;
    private int speed;
    private int Health;
    private String type;
    private String Special;
    private int armo;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return this.Health;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public String getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        this.Special = special;
    }

    public int getArmo() {
        return this.armo;
    }

    public void setArmo(int armo) {
        this.armo = armo;
    }

    public int getCost(){
        return this.cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }
}