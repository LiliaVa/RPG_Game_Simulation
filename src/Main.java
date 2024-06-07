public class Main {
    public static void main(String[] args){
        Warrior warrior = new Warrior("Warrior", 4000, 50, 1, 20, 15);
        Mage mage = new Mage("Mage", 3800, 120, 1, 30, 40);
        Rogue rogue = new Rogue("Rogue", 3900, 60, 1, 50, 35);

        System.out.println();
        warrior.quickStrike(mage);
        System.out.println();
        warrior.attack(rogue);
        System.out.println();
        warrior.levelUp();
        System.out.println();


        mage.castSpell(warrior);
        System.out.println();
        mage.frostfireBolt(rogue);
        System.out.println();
        mage.levelUp();
        System.out.println();

        rogue.attack(mage);
        System.out.println();
        rogue.specialMove();
        System.out.println();
        rogue.attack(mage);
        System.out.println();
        rogue.instantPoison(warrior);
        System.out.println();
        rogue.levelUp();
        System.out.println();

        System.exit(0);

    }
}