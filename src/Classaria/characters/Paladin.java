package Classaria.characters;

import Classaria.monsters.Enemy;

public class Paladin extends Character implements LevelUp, BasicAttack {
    private int pATK;
    private int guardPower;
    private int holyDamage;
    private int healPower;
    private int initialHP;
    private boolean isGuarding;
    
    public Paladin() {
        setClassName("Paladin");
        this.pATK = 15;
        this.guardPower = 10;
        this.holyDamage = 25;
        this.healPower = 15;
        setHp(40);
        setDef(20);
        setSpd(8);
        setLvl(1);
        this.isGuarding = false;
        setInitialHP(getHp());
    }
    
    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
    }
    
    @Override
    public int getAtk() {
        return pATK;
    }
    
    @Override
    public int getDef() {
        return isGuarding ? super.getDef() + guardPower : super.getDef();
    }
    
    @Override
    void firstSkill(Enemy target) {
        System.out.println("Paladin raises their shield in a defensive stance!");
        isGuarding = true;
        System.out.println("Defense increased by " + guardPower + "!");
    }
    
    @Override
    public void secondSkill(Enemy target) {
        System.out.println("Paladin channels divine energy and unleashes Holy Strike!");
        
        target.setHp(Math.max(0, target.getHp() - holyDamage));
        
        System.out.println("Paladin deals " + holyDamage + " holy damage to the enemy!");
        
        // Self-heal for 20% of damage dealt
        int healAmount = holyDamage / 5;
        if (getHp() < initialHP) {
            setHp(Math.min(initialHP, getHp() + healAmount));
            System.out.println("Paladin restores " + healAmount + " HP from divine energy!");
        }
    }
    
    @Override
    public void thirdSkill(Enemy target) {
        System.out.println("Paladin casts Divine Blessing!");
        
        int healAmount = healPower;
        if (getHp() < initialHP) {
            setHp(Math.min(initialHP, getHp() + healAmount));
            System.out.println("Paladin restores " + healAmount + " HP!");
            
            // Bonus defense for one turn
            isGuarding = true;
            System.out.println("Divine protection increases defense!");
        } else {
            System.out.println("HP is already full!");
        }
    }
    
    public void basicAttack(Enemy target) {
        System.out.println("Paladin strikes with their holy sword!");
        
        target.setHp(Math.max(0, target.getHp() - pATK));
        
        System.out.println("Paladin deals " + pATK + " damage to the enemy!");
        isGuarding = false; // Reset guard after attacking
    }
    
    public void flushInitialStats() {
        setHp(initialHP);
        isGuarding = false;
    }
    
    @Override
    public void displaySkills() {
        System.out.printf("1. Divine Guard => +%d DEF%n", guardPower);
        System.out.printf("2. Holy Strike => -%d DMG (Heals for 20%%)%n", holyDamage);
        System.out.printf("3. Divine Blessing => +%d HP and Temporary DEF boost%n", healPower);
    }
    
    @Override
    public void levelUp() {
        flushInitialStats();
        this.pATK += 5;
        this.guardPower = (int)Math.ceil(this.guardPower * 1.1);
        this.holyDamage = (int)Math.ceil(this.holyDamage * 1.1);
        this.healPower = (int)Math.ceil(this.healPower * 1.1);
        setHp(getHp() + 10);
        setDef(getDef() + 5);
        setSpd(getSpd() + 5);
        setLvl(getLvl() + 1);
    }
}
