package game;

public class Hero extends Unit{
	private int maxHp;
	private int MaxMp;
	private int hp;
	private int mp;
	private int atk;
	private int def;
	private int lvl;
	private int maxExp;
	private int exp;

	public Hero(int hp, int mp, int atk, int def, int lvl) {
		this.maxHp = hp;
		this.hp = hp;
		this.MaxMp = mp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.lvl = lvl;
		this.maxExp = lvl*50+20;
		super.setY(21);
		super.setX(10);
	}

	
	public void printStat() {
		System.out.printf("레벨 : %d 경험치 [%d/%d]\n", this.lvl, this.exp, this.maxExp);
		System.out.printf("HP [%d/%d] MP[%d/%d]\n", this.hp, maxHp, this.mp, MaxMp);
		System.out.printf("공격력 : %d 방어력 : %d\n", this.atk, this.def);
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMaxMp() {
		return MaxMp;
	}
	
	public int getMp() {
		return mp;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public int getLvl() {
		return lvl;
	}

	public int getExp() {
		return exp;
	}
	
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setMaxMp(int maxMp) {
		MaxMp = maxMp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

}
