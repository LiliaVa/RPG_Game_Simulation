public class Character {
    public String charName;
    public int charHealth;
    public int charMana;
    public int charLevel;

    public Character(String name, int health, int mana, int level){
        this.charName = name;
        this.charHealth = health;
        this.charMana = mana;
        this.charLevel = level;
    }

    public String getCharName() {
        return charName;
    }


    public void attack(Character target) {
        int damage;
        if (isEffective(target)) {
            damage = 20;
        } else {
            damage = 10;
        }
        System.out.println(this.charName + " attacks " + target.getCharName() + "! " + isEffective(target)
                + "! Deals " + damage + " damage!");
        target.takeDamage(damage);
    }

    public void defend(){
        this.charHealth -= 1;
        System.out.println(this.charName + " successfully defends! Damage taken reduced! -1 HP");
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

    public void levelUp() {
        this.charLevel++;
        this.charHealth += 20;
        this.charMana += 10;
        System.out.println(this.charName + " reached level " + this.charLevel + "!");
    }

    public void takeDamage(int damage) {
        this.charHealth -= damage;
        System.out.println(this.charName + " is hurt! -" + damage + " HP! Health is now " + this.charHealth + "!");
        if (this.charHealth <= 0) {
            System.out.println(this.charName + " has been defeated!");
        }
    }

    private boolean isEffective(Character target) {
        return false;
    }

    public String stats() {
        return this.charName + " [Health: " + this.charHealth + ", Mana: " + this.charMana
                + ", Level: " + this.charLevel + "]";
    }

}
