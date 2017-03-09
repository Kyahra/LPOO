package logic;

import logic.Hero;
import logic.Hero.HeroState;
import logic.Guard;
import logic.Ogre;
import logic.Ogre.OgreState;

import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public enum GameState {
		WON, LEVEL_1, LEVEL_2, LOST
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

	private Hero hero;
	private Guard guard;
	private Character k;
	private Ogre ogre;

	public Game() {
		state = GameState.LEVEL_1;

		Random rand = new Random();		
		int guar = rand.nextInt(3);
		
		Point hero_init_pos = new Point(1, 1);
		hero = new Hero(hero_init_pos, 'H');

		Point lever_init_pos = new Point(7, 8);
		k = new Character(lever_init_pos, 'k');

		Point ogre_init_pos = new Point(7, 1);
		ogre = new Ogre(ogre_init_pos, 'O');
		
		Point guard_init_pos = new Point(8, 1);
		
		switch(guar){		
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

	}

	public char getChar(Point position) {

		char c = 'X';

		switch (state) {

		case LEVEL_1:
			c = map_1[position.y][position.x];
			break;
		case LEVEL_2:
			c = map_2[position.y][position.x];
			break;
		default:
			break;
		}

		return c;
	}

	public void printMap() {

		System.out.println();

		for (int i = 0; i < rows; i++) {
			System.out.print("          ");
			for (int j = 0; j < cols; j++) {

				switch (state) {
				case LEVEL_1:
					System.out.print(map_1[i][j] + " ");
					break;

				case LEVEL_2:
					System.out.print(map_2[i][j] + " ");
					break;
				case WON:
					System.out.print(map_2[i][j] + " ");
					break;
				}
				
				
					
			}

			System.out.println();
		}

		System.out.println("\n Use the WASD keys to control the Hero.");
		System.out.print(" Your Move : ");

	}

	public void drawCharacter(Character c) {

		switch (state) {
		case LEVEL_1:
			map_1[c.getY()][c.getX()] = c.getChar();
			break;
		case LEVEL_2:
			map_2[c.getY()][c.getX()] = c.getChar();
			break;
		}

	}

	public void updateMap() {

		drawCharacter(hero);

		switch (state) {
		case LEVEL_1:
			drawCharacter(guard);
			break;

		case LEVEL_2:
			if (!hero.gotKey())
				drawCharacter(k);

			drawCharacter(ogre);
			drawCharacter(ogre.getClub());
			break;

		default:
			break;
		}

	}

	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		direction = keyboard.nextLine().toUpperCase();

	}

	public void updateGame() {
		Point new_hero_pos, new_ogre_pos, new_club_pos;

		new_hero_pos = hero.getNewPosition(direction);
		hero.updateHero(getChar(new_hero_pos));

	

		switch (state) {
		case LEVEL_1:
			guard.updateGuard();

			if (hero.getState() == HeroState.STAIR) {
				state = GameState.LEVEL_2;
				hero.setPosition(1, 8);
				k.setPosition(8, 1);

			}
			
			if (hero.getState() == HeroState.K)
				openDoors();

			break;

		case LEVEL_2:

			if (hero.getState() == HeroState.K)
				hero.setChar('K');
			

			do {
				new_ogre_pos = ogre.getNewPosition();
			} while (!ogre.updateOgre(getChar(new_ogre_pos)));

			do {
				new_club_pos = ogre.getNewClubPosition();

			} while (!ogre.updateClub(getChar(new_club_pos)));

			if (hero.getState() == HeroState.DOOR)
				openDoors();
			
			if (hero.getState() == HeroState.STAIR)
				state = GameState.WON;


			break;
		}

	}

	public void cleanCharacter(Character c) {
		switch (state) {
		case LEVEL_1:
			map_1[c.getY()][c.getX()] = ' ';
			break;
		case LEVEL_2:
			map_2[c.getY()][c.getX()] = ' ';
			break;
		}
	}

	public void cleanMap() {
		cleanCharacter(hero);

		switch (state) {
		case LEVEL_1:
			if (hero.getState() == HeroState.K)
				drawCharacter(k);

			if (isHeroCaptured(guard))
				state = GameState.LOST;

			cleanCharacter(guard);

			break;

		case LEVEL_2:

			if (isHeroCaptured(ogre))
				state = GameState.LOST;

			if (isHeroCaptured(ogre.getClub()))
				state = GameState.LOST;
			
			

			cleanCharacter(ogre);
			cleanCharacter(ogre.getClub());

			if (!hero.gotKey())
				drawCharacter(k);

			break;
		}

	}

	
	public void openDoors() {

		switch (state) {
		case LEVEL_1:
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (map_1[i][j] == 'I')
						map_1[i][j] = 'S';
				}
			}
			break;
		case LEVEL_2:
			map_2[1][0] = 'S';
			break;
		default:
			break;
		}
	}
	
	

	public boolean isHeroCaptured(Character enemy) {

		if(enemy.getChar() == 'g')
			return false;
		
		if (hero.getX() == enemy.getX() + 1 && hero.getY() == enemy.getY())
			return true;

		if (hero.getX() == enemy.getX() - 1 && hero.getY() == enemy.getY())
			return true;

		if (hero.getX() == enemy.getX() && hero.getY() == enemy.getY() + 1)
			return true;

		if (hero.getX() == enemy.getX() && hero.getY() == enemy.getY() - 1)
			return true;

		return false;
	}

	public GameState getState() {
		return state;
	}
}
