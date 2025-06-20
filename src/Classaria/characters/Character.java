package Classaria.characters;

import Classaria.monsters.Enemy;

public abstract class Character implements LevelUp {
    private String className;
    private int hp;
    private int def;
    private int spd;
    private int lvl;

    public static Character chooseClass(int chosenClass) {
        return switch (chosenClass) {
            case 1 -> new Warrior();
            case 2 -> new Assasin();
            case 3 -> new Mage();
            case 4 -> new Trickster();
            default -> null;
        };
    }

    public static void chooseSkill(int chosenSkill, Character player, Enemy enemy) {
        switch (chosenSkill) {
            case 1:
                player.firstSkill(enemy);
                break;
            case 2:
                player.secondSkill(enemy);
                break;
            case 3:
                player.thirdSkill();
                player.thirdSkill(enemy);
                break;
            default:
                System.out.println("Invalid Skill Choice!");
                break;
        }
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

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
        return 0;
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
