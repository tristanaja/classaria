package Classaria.characters;

import Classaria.monsters.Enemy;

public class Necromancer extends Character implements LevelUp, BasicAttack {
    private int mATK;
    private int skillDMG;
    private int lifeSteal;
    private int initialHP;

    public Necromancer() {
        setClassName("Necromancer");
        this.mATK = 12;
        this.skillDMG = 18;
        this.lifeSteal = 5;
        setHp(30);
        setDef(5);
        setSpd(8);
        setLvl(1);
        setInitialHP(getHp());
    }

    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
    }

    @Override
    public int getAtk() {
        return mATK;
    }

    @Override
    void firstSkill(Enemy target) {
        this.basicAttack(target);
    }

    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Player chants and casted Soul Siphon!");
        int damageDealt = Math.min(target.getHp(), skillDMG);
        target.setHp(Math.max(0, target.getHp() - skillDMG));
        int healedHP = Math.min(initialHP, getHp() + lifeSteal);
        setHp(healedHP);
        System.out.println("Player deals " + damageDealt + " of Damage to the enemy and heals for " + lifeSteal + " HP!");
    }

    @Override
    public void thirdSkill() {
        System.out.println("Player summons a skeleton warrior!");
        // For now, this skill will just deal damage.
        // In the future, this could summon a temporary minion.
        System.out.println("The skeleton warrior attacks the enemy!");
    }

    public void flushInitialStats() {
        setHp(initialHP);
    }

    @Override
    public int getFirstSkillDMG() {
        return mATK;
    }

    @Override
    public int getSecondSkillDMG() {
        return skillDMG;
    }

    @Override
    public int getThirdSkillDMG() {
        return 15; // Placeholder for minion damage
    }

    public void basicAttack(Enemy target) {
        System.out.println("Player casted a Shadow Bolt to the enemy!");
        target.setHp(Math.max(0, target.getHp() - mATK));
        System.out.println("Player deals " + mATK + " of Damage to the enemy!");
    }

    @Override
    public void displaySkills() {
        System.out.printf("1. Shadow Bolt => -%d DMG%n", getFirstSkillDMG());
        System.out.printf("2. Soul Siphon => -%d DMG, +%d HP%n", getSecondSkillDMG(), lifeSteal);
        System.out.printf("3. Summon Skeleton => -%d DMG%n", getThirdSkillDMG());
    }

    @Override
    public void levelUp() {
        flushInitialStats();
        this.mATK += 4;
        this.skillDMG = (int)Math.ceil(this.skillDMG * 1.1); // +10% per level
        this.lifeSteal = (int)Math.ceil(this.lifeSteal * 1.15); // +15% per level
        setHp(getHp() + 12);
        setDef(getDef() + 4);
        setSpd(getSpd() + 4);
        setLvl(getLvl() + 1);
    }
}
