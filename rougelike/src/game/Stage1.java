package game;

public class Stage1 extends Map{
	Lv1Boss boss = new Lv1Boss(500,10,1,100);
	Monster mon = new Monster(50,2,0,10);
	private int monNum;
	
	public Stage1(Unit unit) {
		monNum = 3;
		super.genWall();
		for(int i=0; i<monNum; i++)
			super.genMonster(mon);
		super.genBoss(boss);
		super.genHero(unit);
	}
}
