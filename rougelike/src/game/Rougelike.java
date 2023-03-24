package game;

import java.util.Scanner;

public class Rougelike {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Hero hero = new Hero(100, 100, 5, 0, 1);
			
		Stage1 stage = new Stage1(hero);
		
		while(true) {
			stage.printMap();
			hero.printStat();
			if(stage.move(hero)) {
				Fight fight = new Fight();
				int atk = hero.getAtk();
				while(true) {
					if(fight.isDie(hero)) {
						System.out.println("you died...");
						stage.pos[hero.getY()][hero.getX()] = stage.getROAD();
						break;
					}
					hero.printStat();
					System.out.println("");
					fight.fight(hero, stage.mon);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("");
					if(fight.isWin(stage.mon)) {
						System.out.println("win!!");
						hero.setAtk(atk);
						stage.pos[stage.meetMonPosY][stage.meetMonPosX] = stage.getROAD();
						break;
					}
					stage.mon.attack(hero);
				}
			}
		}
	}
}
