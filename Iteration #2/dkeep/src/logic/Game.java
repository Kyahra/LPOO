package logic;

import logic.Hero;
import logic.Hero.HeroState;
import logic.Guard;
import java.awt.Point;
import java.util.Scanner;

public class Game {

	public enum GameState {
		WON, LEVEL_1, LEVEL_2, LOST
	};

	private char[][] map_1 = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, 
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			};

	private char[][] map_2 = {
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'k', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, 
			};

	private int rows = 10;
	private int cols = 10;

	private GameState state;
	private char direction;

	private Hero hero;
	private Guard guard;
	private Character lever;

	public Game() {
		state = GameState.LEVEL_1;

		Point hero_init_pos = new Point(1, 1);
		hero = new Hero(hero_init_pos, 'H');

		Point guard_init_pos = new Point(8, 1);
		guard = new Guard(guard_init_pos, 'G');

		Point lever_init_pos = new Point(7, 8);
		lever = new Character(lever_init_pos, 'k');

	}

	public char getChar(Point position) {

		char c = '0';

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
			map_1[c.getY()][c.getX()] = c.getCharacter();
			break;
		case LEVEL_2:
			map_2[c.getY()][c.getX()] = c.getCharacter();
			break;
		}

	}

	public void updateMap() {

		drawCharacter(hero);
		drawCharacter(guard);

	}

	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		String input = keyboard.nextLine().toUpperCase();

		direction = input.charAt(0);

	}

	public void updateGame() {
		Point new_hero_pos;

		new_hero_pos = hero.getNewPosition(direction);
		hero.updateHero(getChar(new_hero_pos));

		if (hero.getState() == HeroState.LEVER)
			openDoors();

		guard.updateGuard();

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
		if (hero.getState() == HeroState.LEVER)
			drawCharacter(lever);
		if (hero.getState() == HeroState.STAIR)
			state = GameState.LEVEL_2;
		
		if(isHeroCaptured(guard))
			state = GameState.LOST;

		cleanCharacter(guard);
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
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (map_2[i][j] == 'I')
						map_2[i][j] = 'S';
				}
			}
			break;

		default:
			break;
		}
	}

	public boolean isHeroCaptured(Character enemy) {

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
	
	
	public GameState getState(){
		return state;
	}
}
