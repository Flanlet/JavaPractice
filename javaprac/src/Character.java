public class Character {
    private String name;
    private int hp;
    private int damage;

    public Character(){}
    public Character(String name ,int hp, int damage){
        this.name=name;
        this.hp = hp;
        this.damage = damage;

    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public void getDamage(int hp, int damage){
        hp -=damage;
        this.hp = hp;
    }

    public boolean isalive(){
        if(this.hp>0){
            return true;
        }
        else{
            System.out.println(this.name+"is dead!");
            return false;
        }

    }

    public void attack(Character character){
        character.getDamage(character.hp, this.damage);
        System.out.println(this.name+"打了一下"+character.name+"造成了"+this.getDamage()+"点伤害!，"+character.name+"还剩"+character.hp+"点血！");
    }


}
