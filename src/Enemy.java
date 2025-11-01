import java.io.*;

public abstract class Enemy {
	String Name;
	int HP;
	int AttackPower;
	int Exp; // the exp obtained upon defeating enemy.

	// Accessor Methods
    int getHP() {
        return this.HP();
    }

    int getAttackPower() {
        return this.AttackPower;
    }

    int getExp() {
        return this.Exp;
    }
}