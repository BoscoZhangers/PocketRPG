# 🎮 Pokémon RPG
*A Java-based console RPG inspired by the world of Pokémon*

---

## 📖 Preface
For my Grade 12 Computer Science class (**ICS4U1**), I was tasked with building an RPG game that leverages basic data manipulation through I/O and supports a spontaneous stream of input from users to create a smooth, dynamic, and immersive experience.  

Inspired by my interest in Pokémon, I took to building my own simulated version of the famous Pokémon role-playing game — where the player can traverse a world, gain experience, encounter Pokémon, and face foes deployed by none other than **Team Rocket**.  

Most of the Pokémon-replicated graphical elements were hand-made using **Pixilart**.

### ${}$

## ⚙️ Technologies Used
- **Language:** Java  
- **Library:** [`arc.jar`](https://arc.teach.cs.utoronto.ca) — for console I/O and simple graphics  
- **IDE:** Visual Studio Code  
- **Assets:** Custom pixel art created with [Pixilart](https://www.pixilart.com)

### ${}$

## 🧩 Features
- Explore a simulated Pokémon world  
- Encounter wild Pokémon   
- Battle and (hopefully) defeat Team Rocket’s trainers  
- Gain XP and level up your Pokémon  
- Save and load game progress via file I/O  
- Custom-made pixel graphics displayed through the `arc` library

### ${}$
## 🚀 How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/BoscoZhangers/PokemonRPG.git
   ```

2. **Enter the Repo:**
   ```bash
   cd PokemonRPG
   ```
   
3. **Ensure you have `arc.jar` in the project directory.**
   (it must be located in the same directory as `RPG.class`).
   
5. **Run:**

   > **Mac Users:**
   > ```bash
   > java -cp .:arc.jar RPG
   > ```

   > **Windows Users:**
   > ```bash
   > java -cp .;arc.jar RPG
   > ```

### ${}$

## 🧱 File Structure 

```
PokemonRPG/
 │ 
 ├── RPG.class \n
 ├── arc.jar
 │    ├── BattleGUI.png
 │    ├── Chansey.png
 │    ├── ChanseySelect.png
 │    ├── Eevee.png
 │    ├── EeveeSelect.png
 │    ├── Pikachu.png
 │    ├── PikachuSelect.png
 │    ├── BattleGUI.png
 │    ├── IntroGUI.png
 │    ├── GUI1.png
 │    ├── GUI2.png
 │    ├── GUI3.png
 │    ├── GUI4.png
 │    ├── HelpGUI.png
 │    ├── HomeNavGUI.png
 │    ├── Pokeball.png
 │    ├── Play.png
 │    └── PlayMapGUI.png
 │    
 ├── Data/
 │    ├── Data.txt
 │    ├── Hold.txt
 │    ├── Level1.csv
 │    ├── Level2.csv
 │    └── Level3.csv
 │ 
 ├── Images_Pokemon_RPG/
 │   └── Terrain/
 │       ├── Grass1.png
 │       ├── Grass2.png
 │       ├── HealBL.png
 │       ├── HealBR.png
 │       ├── HealTL.png
 │       ├── HealTR.png
 │       ├── MountainBR.png
 │       ├── Tree.png
 │       └── Water.png
 │   └── Enemies/
 │       ├── RocketTrainer.png
 │       ├── James.png
 │       ├── Jessie.png
 │       └── Zubat.png
 │ 
 └── README.md
```

### ${}$

## 🧠 Design Notes


### ${}$

## ✨ Credits
* **Developer:** Bosco Zhang
* **Course:** ICS 4U1 (Grade 12 Computer Science)
* **Instructor:** Alfred Ron Cadawas
* **Art Assets:**

### ${}$

📜 License

This project was developed for educational purposes and is not affiliated with or endorsed by Nintendo, Game Freak, or The Pokémon Company.
* **Framework:** ARC Java Library (for console graphics and sound)
* **Graphic Design and Overall Inspiration:** Nintendo and the Pokémon Company



