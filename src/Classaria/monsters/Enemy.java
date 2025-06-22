package Classaria.monsters;

import Classaria.characters.Character;

public abstract class Enemy implements NextRound, BasicAttack {
    private String enemyName;
    private int hp;
    private int atk;
    private int spd;
    private int lvl;
    
    public Enemy() {
        setLvl(0);
        setHp(0);
        setAtk(0);
        setSpd(0);
    }
    
    public static Enemy randomizedNormalEnemy(int randomNormalIndex, int level) {
        return switch (randomNormalIndex) {
            case 1 -> new Speedster(level);
            case 2 -> new RazorEgg(level);
            case 3 -> new ShadowPhantom(level);
            default -> null;
        };
    }
    
    public static Enemy randomizedBossEnemy(int randomBossIndex, int level) {
        return switch (randomBossIndex) {
            case 1 -> new Boos(level);
            case 2 -> new ChaosDragon(level);
            default -> null;
        };
    }
    
    public String getEnemyName() {
        return enemyName;
    }
    
    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
    
    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(hp, getMaxHp())); // Ensure HP doesn't exceed max
    }
    
    public void setAtk(int atk) {
        this.atk = atk;
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
    
    public int getAtk() {
        return atk;
    }
    
    public int getSpd() {
        return spd;
    }
    
    public int getLvl() {
        return lvl;
    }
    
    // New method to get max HP based on level
    protected int getMaxHp() {
        // Default implementation, can be overridden by specific enemies
        return 999999; // High number by default to maintain backward compatibility
    }
    
    public abstract void basicAttack(Character target);
    
    public abstract void nextRound();
    
    public static void monsterAttack(Character target, Enemy enemy) {
        enemy.basicAttack(target);
    }
}
