package logic;

import logic.Hero;
import logic.Hero.HeroState;
import logic.Guard;
import logic.Ogre;
import logic.Ogre.OgreState;

import java.awt.Point;

import java.util.ArrayList;

import java.util.Random;

import java.util.Scanner;

public class Game {

	public enum GameState {
		WON, RUNNING, LOST
	};

	private char[][] map_1 = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, { 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

	private char[][] map_2 = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

	private int rows = 10;
	private int cols = 10;

	private GameState state;
	private String direction;

	private GameMap map;
	private Hero hero;
	private Guard guard;
	private Character k;
	private Character club;
	private ArrayList<Ogre> ogres = new ArrayList<Ogre>();

	public Game() {
		state = GameState.RUNNING;

		Random rand = new Random();
		int guar = rand.nextInt(3);

		hero = new Hero(new Point(1, 1), 'H');
		k = new Character(new Point(7, 8), 'k');
		club = new Character(new Point(3, 8), '*');

		for (int i = 0; i < 1; i++)
			ogres.add(new Ogre(new Point(7, 1), 'O'));

		Point guard_init_pos = new Point(8, 1);

		switch (guar) {
		case 0:
			guard = new Suspicious(guard_init_pos, 'G');
			break;
		case 1:
			guard = new Rookie(guard_init_pos, 'G');
			break;
		case 2:
			guard = new Drunken(guard_init_pos, 'G');
			break;

		}

		//map = new DungeonMap(map_1);
		map = new KeepMap(map_2);

	}

	public void printMap() {
		map.printMap();

	}

	public void clean() {
		map.clean(hero, guard, k, ogres);

	}

	public void updateMap() {
		map.update(hero, guard, k, club, ogres);
	}

	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		direction = keyboard.nextLine().toUpperCase();

	}

	public void updateGame() {
		Point new_hero_pos, new_ogre_pos, new_club_pos;

		new_hero_pos = hero.getNewPosition(direction);
		hero.updateHero(map.getChar(new_hero_pos));

		if (map instanceof DungeonMap) {
			guard.updateGuard();

			if (hero.getState() == HeroState.STAIR) {
				map = new KeepMap(map_2);
				hero.setPosition(1, 8);
				k.setPosition(8, 1);

			}

			if (hero.getState() == HeroState.K)
				map.openDoors();

		}
		else{
		 
		  
		  if (hero.getState() == HeroState.K) hero.setChar('K');
		  
		  for(Ogre ogre: ogres){
		  
		  do { new_ogre_pos = ogre.getNewPosition(); } while
		  (!ogre.updateOgre(map.getChar(new_ogre_pos)));
		  
		  do { new_club_pos = ogre.getNewClubPosition();
		  
		  } while (!ogre.updateClub(map.getChar(new_club_pos)));
		  
		  }
		  
		  if (hero.getState() == HeroState.DOOR) 
			  map.openDoors();
		  
		//  if (hero.getState() == HeroState.STAIR) state = GameState.WON;
		  
		  
		}
		 
	}

	public boolean isCaptured(Character victim, Character captor) {

		if (captor.getChar() == 'g')
			return false;

		if (victim.getX() == captor.getX() + 1 && victim.getY() == captor.getY())
			return true;

		if (victim.getX() == captor.getX() - 1 && victim.getY() == captor.getY())
			return true;

		if (victim.getX() == captor.getX() && victim.getY() == captor.getY() + 1)
			return true;

		if (victim.getX() == captor.getX() && victim.getY() == captor.getY() - 1)
			return true;

		if (victim.getX() == captor.getX() && victim.getY() == captor.getY())
			return true;

		return false;
	}

	public boolean isOver() {

		if (map instanceof DungeonMap) {
			if (isCaptured(hero, guard)) {
				state = GameState.LOST;
				return true;

			}

		} else {
			for (Ogre ogre : ogres) {
				
				if (isCaptured(ogre, hero) && hero.isArmed())
					ogre.getStuned();

				if (isCaptured(hero, ogre) && !hero.isArmed()){
					state = GameState.LOST;
					return true;
				}
				
				if (isCaptured(hero, ogre.getClub())){
					state = GameState.LOST;
					return true;
				}
			}
			
			 if (hero.getState() == HeroState.STAIR){
				 state = GameState.WON;
				 return true;
			 }
		}

		return false;

	}

	public void printEnd() {
		System.out.println();
		System.out.println();

		switch (state) {
		case LOST:
			System.out.print("--------------");
			System.out.print(" GAME OVER ");
			System.out.print("--------------");
			break;
		case WON:
			System.out.println();
			System.out.println();

			System.out.print("---------------");
			System.out.print(" VICTORY ");
			System.out.print("---------------");
			break;
		default:
			break;
		}

	}

}
