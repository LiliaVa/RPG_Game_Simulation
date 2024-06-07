import java.util.Random;

public class Warrior extends Character {
    private int warrStrength;
    private int warrArmor;

    public Warrior(String name, int health, int mana, int level, int strength, int armor) {
        super(name, health, mana, level);
        this.warrStrength = strength;
        this.warrArmor = armor;
    }

    public void quickStrike(Character target) {
        int manaCost = 10;
        if (this.charMana >= manaCost) {
            Random random = new Random();
            int minDamage = (this.warrStrength * 10) / 100;
            int maxDamage = (this.warrStrength * 20) / 100;
            int damage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
            this.charMana -= manaCost;
        System.out.println(this.charName + " does a quick strike on " + target.getCharName() + "! Deals "
                + damage + " damage!");
        target.takeDamage(damage); }
        else {
            System.out.println("Not enough mana!");
        }
    }

    public void attack(Character target) {
        int damage;
        if (isEffective(target)) {
            damage = this.warrStrength * 2;
        } else {
            damage = this.warrStrength;
        }
        System.out.println(this.charName + " swings their weapon at " + target.getCharName() + " with strength "
                + this.warrStrength + "! Deals " + damage + " damage!");
        target.takeDamage(damage);
    }

    public void defend(){
        super.defend();
        this.warrArmor--;
    }

    public void levelUp() {
        super.levelUp();
        this.warrArmor += 10;
    }

    private boolean isEffective(Character target) {
        return target instanceof Rogue;
    }

    public String stats() {
        return super.stats();
    }
}
