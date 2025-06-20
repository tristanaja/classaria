# Classaria - Turn-Based RPG Character System ⚔️

<p align="justify">
<strong>Classaria</strong> is a fully functional, console-based turn-based RPG built with Java. It serves as a foundational project for demonstrating Object-Oriented Programming (OOP) principles, including inheritance, interfaces, encapsulation, and polymorphism. The system features various playable character classes, unique enemies, and a scalable combat loop.
</p>

> ✅ **Project Status:**
> **Feature-Complete** for its initial scope. The core mechanics and game logic are fully implemented and stable. Designed with extensibility in mind, this project is ideal for learning, experimenting, and expanding.

---

## ✨ Features

### 🧙‍♂️ Playable Character Classes:

Each class is built upon a shared abstract `Character` base class with distinct abilities and stats:

* **Warrior**: Well-balanced physical fighter with solid attack and defense.
* **Assasin**: High-speed, high-damage dealer with low defense; excels at quick kills.
* **Mage**: Focuses on magic-based attacks and healing skills.
* **Trickster**: A unique class with the ability to steal and temporarily adopt enemy stats:

  * `gotYoHP()` ❤️
  * `gotYoAttack()` 🗡️
  * `gotYoSpeed()` 💨

### 👾 Enemies:

* **Speedster**: Prioritizes speed to strike early.
* **Razor Egg**: Physically aggressive enemy with spinning attacks.
* **Boos**: A boss enemy with high base stats and progressive difficulty scaling.

### 🛠️ Core Game Mechanics:

* `displaySkills()`: Outputs character-specific abilities.
* `levelUp()`: Increases character stats and skill damage.
* `nextRound()`: Enhances enemy stats as rounds progress.
* `basicAttack()`: Executes standard physical attacks.
* Modular interfaces:

  * `LevelUp`
  * `BasicAttack`
  * `NextRound`

---

## 🗂️ Project Directory Structure

```
Classaria/
├── characters/
│   ├── Character.java          # Abstract base class
│   ├── Warrior.java            # Warrior class
│   ├── Assasin.java            # Assassin class
│   ├── Mage.java               # Mage class
│   ├── Trickster.java          # Trickster class
│   ├── BasicAttack.java        # Interface (character -> enemy)
│   └── LevelUp.java            # Leveling interface
├── monsters/
│   ├── Enemy.java              # Base class for enemies
│   ├── Speedster.java          # Speed-focused enemy
│   ├── RazorEgg.java           # Physical attacker
│   ├── Boos.java               # Boss enemy
│   ├── BasicAttack.java        # Interface (enemy -> character)
│   └── NextRound.java         # Enemy scaling interface
├── mains/
│   └── Classaria.java          # Main game logic
```

---

## 🧪 Gameplay Overview

1. Player selects a character class.
2. Encounters with random enemies occur each round.
3. Turn order is determined by speed.
4. After winning, the player levels up while enemies grow stronger.
5. The loop continues until defeat or user termination.

---

## ▶️ Running the Project

1. **Compile** the project:

```bash
javac Classaria/mains/Classaria.java
```

2. **Run** the game:

```bash
java Classaria.mains.Classaria
```

---

## 📌 Notes

* Console-based game, suitable for academic or personal learning.
* Emphasizes code clarity and modularity.
* Trickster class is ideal for exploring more advanced OOP patterns.
* Easily extensible for new features like item systems, skill trees, or multiplayer turn simulation.

---

## 🌱 Contributing & Extending

You are welcome to fork and evolve the project with:

* New character classes or monsters
* Refined combat systems
* Inventory and item usage
* Enhanced game loops or UI elements

**Contribution Guidelines:**

* Open issues for bugs or suggestions.
* Submit pull requests (PRs) for any contributions.
* PRs must be reviewed and approved before merging to the `master` branch.

---

## 👨‍💻 Author/CODEOWNERS

Crafted with care by **Tristan** – a student of OOP and game design, using Java to turn concepts into code. 💡

---

*Ready to test your logic and Java skills? Fork, play, and build your own fantasy experience!*
