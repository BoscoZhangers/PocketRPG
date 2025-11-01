import java.io.*;

public abstract class Enemy {
	String Name;
	int HP;
	int AttackPower;
	int Exp; // the exp obtained upon defeating enemy.

	// Accessor Methods
    int getHP() {
        return HP;
    }

    int getAttackPower() {
        return AttackPower;
    }

    int getExp() {
        return Exp;
    }

    void dealDamage(int dmg) {
        HP -= dmg;
    }
}