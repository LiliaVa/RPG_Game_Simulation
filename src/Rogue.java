import java.util.Random;
public class Rogue extends Character {
    private int agility;
    private int dexterity;
    private boolean isWeaponPoisoned;

    public Rogue(String name, int health, int mana, int level, int agility, int dexterity) {
        super(name, health, mana, level);
        this.agility = agility;
        this.dexterity = dexterity;
        this.isWeaponPoisoned = false;
    }

    public void attack(Character target) {
        int damage;
        if (isEffective(target)) {
            damage = agility * 2;
        } else {
            damage = agility;
        }
        System.out.println(this.charName + " attacks " + target.getCharName() + " with agility " + agility
                + " ! Deals " + damage + " damage!");
        target.takeDamage(damage);
        if (isWeaponPoisoned) {
            instantPoison(target);
        }
    }

    public void specialMove() {
        int manaCost = 10;
        if (this.charMana >= manaCost) {
            this.charMana -= manaCost;
            isWeaponPoisoned = true;
            System.out.println(this.charName + " coats their weapon with poison!");
        } else {
            System.out.println("Not enough mana!");
        }
    }

    public void instantPoison(Character target) {
        Random random = new Random();
        int reqDexterity = 20;
        if (this.dexterity == reqDexterity) {
            if (random.nextInt(100) < 20) {
                int minDamage = 19;
                int maxDamage = 25;
                int poisonDamage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
                System.out.println(this.charName + " poisons " + target.getCharName() + " ! Deals "
                        + poisonDamage + " Nature damage");
                target.takeDamage(poisonDamage);
            }
        } else {
            System.out.println("Not enough dexterity!");
        }
    }

    public void levelUp() {
        super.levelUp();
        this.dexterity += 10;
        this.agility += 10;
    }

    private boolean isEffective(Character target) {
        return target instanceof Mage;
    }

    public String stats() {
        return super.stats();
    }

}
