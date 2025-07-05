package Classaria.characters;

import Classaria.monsters.Enemy;

public abstract class Character implements LevelUp {
    private String className;
    private int hp;
    private int def;
    private int spd;
    private int lvl;
    private int atk;

    public static Character chooseClass(int chosenClass) {
        return switch (chosenClass) {
            case 1 -> new Warrior();
            case 2 -> new Assasin();
            case 3 -> new Mage();
            case 4 -> new Trickster();
            case 5 -> new Paladin();
            case 6 -> new Necromancer();
            case 7 -> new Ranger();
            case 8 -> new Berserker();
            default -> null;
        };
    }

    public static void chooseSkill(int chosenSkill, Character player, Enemy enemy) {
        if (chosenSkill < 1 || chosenSkill > 3) {
            System.out.println("Invalid Skill Choice! (1-3)");
            return;
        }

        switch (chosenSkill) {
            case 1 -> player.firstSkill(enemy);
            case 2 -> player.secondSkill(enemy);
            case 3 -> {
                player.thirdSkill();
                player.thirdSkill(enemy);
            }
        }
    }

    // Setters with validation
    public void setHp(int hp) {
        this.hp = Math.max(0, hp); // Prevent negative HP
    }

    public void setDef(int def) {
        this.def = Math.max(0, def); // Prevent negative defense
    }

    public void setSpd(int spd) {
        this.spd = Math.max(0, spd); // Prevent negative speed
    }

    public void setLvl(int lvl) {
        this.lvl = Math.max(1, lvl); // Level should start from 1
    }

    // Getters
    public int getHp() {
        return hp;
    }

    public int getDef() {
        return def;
    }

    public int getSpd() {
        return spd;
    }

    public int getLvl() {
        return lvl;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = Math.max(0, atk);
    }

    public void displaySkills() {
        System.out.println("No Skills");
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    abstract void firstSkill(Enemy target);

    public abstract void levelUp();

    public void secondSkill(Enemy target) {}

    public void thirdSkill(Enemy target) {}

    public void thirdSkill() {}

    public int getFirstSkillDMG() {
        return 0;
    }

    public int getSecondSkillDMG() {
        return 0;
    }

    public int getThirdSkillDMG() {
        return 0;
    }
}
