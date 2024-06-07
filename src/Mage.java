public class Mage extends Character {
    private int intelligence;
    private int spellPower;

    public Mage(String name, int health, int mana, int level, int intelligence, int spellPower) {
        super(name, health, mana, level);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }

    public void castSpell(Character target) {
        int manaUsed = 10;
        int damage = 0;
        if (this.charMana >= manaUsed) {
            if (isEffective(target)) {
                damage += 30;
            } else {
                damage += 15;
            }
            this.charMana -= manaUsed;
            System.out.println(this.charName + " casts a spell on " + target.getCharName() + "! " + isEffective(target)
                    + "! Deals " + damage + " damage!");
            target.takeDamage(damage); }
        else {
            System.out.println("Not enough mana!");
        }
    }

    public void frostfireBolt(Character target) {
        int manaCost = 30;
        int reqIntelligence = 15;
        if (this.charMana >= manaCost && this.intelligence>= reqIntelligence) {
            int minDamage = 484;
            int maxDamage = 564;
            int damage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
            this.charMana -= manaCost;
            System.out.println(this.charName + " launches a bolt of frostfire at " + target.getCharName() + " ! Deals "
                    + damage + " damage!");
            target.takeDamage(damage);
        } else {
            System.out.println("Not enough mana!");
        }
    }

    private boolean isEffective(Character target) {
        return target instanceof Warrior;
    }

    public void levelUp() {
        super.levelUp();
        this.intelligence += 10;
        this.spellPower += 10;
    }

    public String stats() {
        return super.stats();
    }

}
