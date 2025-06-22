# Classaria - Turn-Based RPG Character System ⚔️

**Classaria** is a console-based, turn-based RPG built in Java. It demonstrates OOP principles (inheritance, interfaces, encapsulation, polymorphism) and features a variety of playable classes, unique enemies, and a scalable, balanced combat loop.

> **Status:** Stable & Extensible 🚀

---

## ✨ Features

### 🧑‍🎮 Playable Character Classes

Each class is based on the abstract `Character` class, with unique stats and skills:

- **Warrior**: Balanced fighter with strong attack and defense.
- **Assassin**: Fast, high-damage, but fragile.
- **Mage**: Magic attacks and healing.
- **Trickster**: Steals stats from enemies (HP, ATK, SPD).
- **Paladin**: Defensive holy knight with healing and protection.

### 👾 Enemies & Bosses

- **Speedster**: Strikes first with high speed.
- **Razor Egg**: Aggressive, spinning attacker.
- **Shadow Phantom**: Can become invisible and deal bonus damage.
- **Boos** (Boss): High stats, scales up each round.
- **Chaos Dragon** (Boss): Multi-attack, enrages, and regenerates.

### 🛠️ Core Mechanics

- `displaySkills()`: Shows class abilities.
- `levelUp()`: Increases stats and skill power.
- `nextRound()`: Enemies grow stronger each round.
- `basicAttack()`: Standard attack.
- Modular interfaces: `LevelUp`, `BasicAttack`, `NextRound`.

---

## ⚖️ Balancing & Scaling

- **Players**: +10 HP, +5 DEF, +5 ATK, +5 SPD per level. Skills and healing scale by +10% per level.
- **Trickster**: Steals 10% of enemy stat (min 5).
- **Monsters**: +8~10 HP, +5~6 ATK, +3~4 SPD per level.
- **Bosses**: +12~15 HP, +7~8 ATK, +4~5 SPD per level.
- **Gameplay**: Designed for fair, challenging progression.

---

## 🗂️ Project Structure

```
Classaria/
├── characters/
│   ├── Character.java
│   ├── Warrior.java
│   ├── Assasin.java
│   ├── Mage.java
│   ├── Trickster.java
│   ├── Paladin.java
│   ├── BasicAttack.java
│   └── LevelUp.java
├── monsters/
│   ├── Enemy.java
│   ├── Speedster.java
│   ├── RazorEgg.java
│   ├── ShadowPhantom.java
│   ├── Boos.java
│   ├── ChaosDragon.java
│   ├── BasicAttack.java
│   └── NextRound.java
├── mains/
│   └── Classaria.java
```

---

## 🎮 Gameplay Overview

1. Choose your class and view its skills.
2. Battle random enemies and bosses each round.
3. Turn order is based on speed.
4. Level up after each victory; enemies also grow stronger.
5. Survive as long as you can!

---

## ▶️ Running the Project

1. **Compile:**
   ```bash
   javac Classaria/mains/Classaria.java
   ```
2. **Run:**
   ```bash
   java Classaria.mains.Classaria
   ```

---

## 📌 Notes

- Console-based, ideal for learning or extending.
- Clean, modular code for easy expansion.
- Try adding new classes, monsters, or mechanics!

---

## 🌱 Contributing

- Fork and extend: new classes, monsters, or features welcome.
- Open issues for bugs or suggestions.
- Pull requests are reviewed before merging.

---

## 👨‍💻 Author

Crafted by **Tristan** – OOP/game design enthusiast. 💡

---

_Ready to test your logic and Java skills? Fork, play, and build your own fantasy!_
