package game;

import java.util.Random;

public class Monster extends Unit{
	private int maxHp;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	
	public Monster(int hp, int atk, int def, int exp) {
		this.maxHp = hp;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
	}
	
	public Monster() {
		
	}
	
	public void attack(Hero hero) {
		Random ran = new Random();
		int dmg = this.atk - hero.getDef();
		if(dmg <= 0)
			dmg = 1;
		hero.setHp(hero.getHp()-dmg);
		System.out.printf("ŸyÀ¸°Ô¿Ç¿Ç¿Ç!!! dmg:%d\n\n",dmg);
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
	}

}
