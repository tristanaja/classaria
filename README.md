# Classaria - Turn-Based RPG Character System ⚔️

**Classaria** is a simple Java-based turn-based RPG character and enemy simulation framework. It demonstrates OOP concepts through different playable character classes and a shared enemy type, complete with custom stats, skills, and leveling mechanisms.

> 🚧 **Note:** This project is still in progress. Expect more features, polish, and content soon!

---

## ✨ Features

### 🧙‍♂️ Character Classes:

* **Warrior**: Balanced in physical attack and defense.
* **Assasin**: High attack and speed, lower defense.
* **Mage**: Specializes in magic attacks and healing.
* **Trickster**: Steals stats (HP, ATK, SPD) from enemies and has dual-state variables.

### 👾 Enemy:

* A generic enemy with HP, ATK, and SPD.

### 🛠️ Core Functionalities:

* `getDescription()`: Shows current stats.
* `levelUp()`: Increases attributes and skills per level.
* Trickster-exclusive skills to steal enemy attributes:

    * `gotYoHP()` ❤️
    * `gotYoAttack()` 🗡️
    * `gotYoSpeed()` 💨

---

## 🗂️ Project Structure

```
Classaria/
├── characters/
│   ├── Character.java        # Base class for all characters
│   ├── Warrior.java          # Physical damage and tank
│   ├── Assasin.java          # High speed burst damage
│   ├── Mage.java             # Magic and healing
│   └── Trickster.java        # Steal-based unique class
├── monsters/
│   └── Enemy.java            # Basic enemy with stats
└── mains/
    └── Classaria.java        # Main driver class for testing
```

---

## 🧪 Sample Output

A run of the `Classaria` main class demonstrates:

* Initialization of a Trickster and an Enemy
* Display of their stats
* Stat stealing in action (HP and ATK)
* Leveling up Trickster
* Continued stat interaction and display

---

## ▶️ How to Run

1. Compile the project:

```bash
javac Classaria/mains/Classaria.java
```

2. Run the program:

```bash
java Classaria.mains.Classaria
```

---

## 📌 Notes

* This is a console-based simulation meant for learning and testing OOP principles.
* Trickster uses a secondary stat system to simulate temporary buffs through stealing.

---

## 🌱 Possible Extensions

* Implement `Enemy` subclasses with different behaviors.
* Add more character skills and effects.
* Build a GUI or text-based battle engine.
* Introduce item systems, status effects, or multiplayer logic.

---

## 👨‍💻 Author

Made with care by Tristan practicing Java OOP in the context of game logic 💡
