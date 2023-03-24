package game;

import java.util.Random;
import java.util.Scanner;

public class Fight{
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	
	public int initStat(Hero hero) {
		return hero.getAtk();
	}
	
	public void fight(Hero hero, Monster mon) {
		System.out.printf("���� ü�� [%d/%d]\n",mon.getHp(),mon.getMaxHp());
		System.out.println("1. ���� 2. ��ų 3. ������");
		int sel = scan.nextInt();
		if(sel == 1)
			attack(hero, mon);
		else if(sel == 2 && hero.getMp() > 15)
			skills(hero, mon);
	}
	
	public void attack(Hero hero, Monster mon) {
		int attack = ran.nextInt(4) + hero.getAtk()-2 - mon.getDef();
		if(attack > 0) {
			mon.setHp(mon.getHp() - attack);
			System.out.printf("��!! dmg:%d\n",attack);
		}
		else
			System.out.println("�͹��� ���� ����...");
	}
	
	public void skills(Hero hero, Monster mon) {
		System.out.println("1. ��Ʈ����ũ 2. ��\n3. ������ �Լ� 4. ������ �Լ�");
		int sel = scan.nextInt();
		if(sel == 1)
			strike(hero, mon);
		else if(sel == 2)
			heal(hero);
		else if(sel == 3)
			debuff(hero, mon);
		else if(sel == 4)
			buff(hero);
		hero.setMp(hero.getMp()- 15);
	}
	
	public void heal(Hero hero) {
		int heal = ran.nextInt(5)+ hero.getLvl()*3;
		
		if(hero.getHp() < hero.getMaxHp()) {
			if(hero.getMaxHp() - hero.getHp() > heal)
				heal = hero.getMaxHp() - hero.getHp();
			
			hero.setHp(hero.getHp()+ heal);
			System.out.printf("��!! my hp+%d\n", heal);
		}
		else
			System.out.println("ȸ�� �Ұ�");
		
	}
	
	public void strike(Hero hero, Monster mon) {
		int strike = ran.nextInt(5) + hero.getAtk()*2 - mon.getDef();
		
		if(strike > 0) {
			mon.setHp(mon.getHp() - strike);
			System.out.printf("��Ʈ����ũ!! dmg:%d\n",strike);
		}
		else
			System.out.println("�͹��� ���� ����...");
	}
	
	public void debuff(Hero hero, Monster mon) {
		int debuff = ran.nextInt(1) + hero.getLvl();
		mon.setDef(mon.getDef() - debuff);
		
		System.out.printf("�Ͼ����� �ַ��̾�!! mon def -%d\n",debuff);
	}
	
	public void buff(Hero hero) {
		
		int buff = ran.nextInt(3)+ hero.getLvl()*2;
		hero.setAtk(hero.getAtk() + buff);
		System.out.printf("����!! my dmg+%d\n",buff);
	}
	
	public boolean isWin(Monster mon) {
		if(mon.getHp() <= 0)
			return true;
		return false;
	}
	
	public boolean isDie(Hero hero) {
		if(hero.getHp() <= 0)
			return true;
		return false;
	}
}
