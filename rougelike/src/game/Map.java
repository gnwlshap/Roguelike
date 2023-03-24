package game;

import java.util.Random;
import java.util.Scanner;

public class Map{
	private Random ran = new Random();
	private Scanner scan = new Scanner(System.in);
	private int x;
	private int y;
	public int[][] pos;
	public int meetMonPosY;
	public int meetMonPosX;
	private int wallCount;
	private final int ROAD = 0;
	private final int WALL = 1;
	private final int MONSTER = 7;
	private final int BOSS = 8;
	private final int HERO = 9;
	
	
	public Map() {
		this.y = 23;
		this.x = 21;
		this.pos = new int[this.y][this.x];
		this.wallCount = 70;
	}
	
	public void genWall() {
		// ¿Ü°û º®
		for(int i=0; i<this.x; i++) {
			this.pos[0][i] = 1;
			this.pos[this.y-1][i] = WALL;
		}
		
		for(int i=0; i<this.y; i++) {
			this.pos[i][0] = 1;
			this.pos[i][this.x-1] = WALL;
		}
		
		// º¸½º·ë
		for(int i=0; i<this.x; i++) {
			if(i>5 && i<15)
				this.pos[3][i] = WALL;
		}
		this.pos[1][6] = WALL;
		this.pos[1][14] = WALL;
		this.pos[2][6] = WALL;
		this.pos[2][14] = WALL;
		
		// ÇÊµå º®
		for(int i=0; i<this.wallCount; i++) {
			int ranY = this.ran.nextInt(this.y-6)+4;
			int ranX = this.ran.nextInt(this.x-3)+1;
			if(this.pos[ranY][ranX] != WALL)
				this.pos[ranY][ranX] = WALL;
			else
				i--;
		}
	}
	
	public void genBoss(Boss boss) {
		this.pos[1][10] = BOSS;
	}
	
	public void genMonster(Monster mon) {
		while(true) {
			int ranY = this.ran.nextInt(this.y-7)+4;
			int ranX = this.ran.nextInt(this.x-3)+1;
			if(this.pos[ranY][ranX] != MONSTER && this.pos[ranY][ranX] != WALL && 
					(this.pos[ranY-1][ranX] == ROAD 
					|| this.pos[ranY+1][ranX]  == ROAD 
					|| this.pos[ranY][ranX-1]  == ROAD 
					|| this.pos[ranY][ranX+1]  == ROAD)) {
				this.pos[ranY][ranX] = MONSTER;
				break;
			}
		}
	}
	
	public void genHero(Unit unit) {
		this.pos[unit.getY()][unit.getX()] = HERO;
	}

	public boolean move(Unit unit) {
		int recentPosY = unit.getY();
		int recentPosX = unit.getX();
		
		String move = scan.next();
		
		if(move.equals("w")) {
			unit.setY(recentPosY-1);
		}
		else if(move.equals("s")) {
			unit.setY(recentPosY+1);
		}
		else if(move.equals("a")) {
			unit.setX(recentPosX-1);
		}
		else if(move.equals("d")) {
			unit.setX(recentPosX+1);
		}
		int curPosY = unit.getY();
		int curPosX = unit.getX();
		if(this.pos[curPosY][curPosX] == ROAD) {
			this.pos[curPosY][curPosX] = HERO;
			this.pos[recentPosY][recentPosX] = ROAD;
		}
		else if(this.pos[curPosY][curPosX] == MONSTER) {
			this.meetMonPosY = curPosY;
			this.meetMonPosX = curPosX;
			unit.setY(recentPosY);
			unit.setX(recentPosX);
			return true;
		}
		else {
			unit.setY(recentPosY);
			unit.setX(recentPosX);
		}
		return false;
	}

	public void printMap() {
		for(int i=0; i<this.y; i++) {
			for(int j=0; j<this.x; j++) {
				if(this.pos[i][j] == ROAD)
					System.out.print("  ");
				else if(this.pos[i][j] == WALL)
					System.out.print("¡á ");
				else if(this.pos[i][j] == MONSTER)
					System.out.print("M ");
				else if(this.pos[i][j] == BOSS)
					System.out.print("B ");
				else if(this.pos[i][j] == HERO)
					System.out.print("¡Û ");
			}
			System.out.println();
		}
	}
	
	public int getROAD() {
		return ROAD;
	}
}
