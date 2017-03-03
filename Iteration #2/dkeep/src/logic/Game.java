package logic;

import logic.Hero;
import logic.Guard;
import java.awt.Point;
import java.util.Scanner;

public class Game {
	
	public enum GameState { WON, LEVEL_1, LEVEL_2, LOST };


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

	public Game() {
		state = GameState.LEVEL_1;


		Point hero_init_pos = new Point(1, 1);
		hero = new Hero(hero_init_pos, 'H');

		Point guard_init_pos = new Point(8, 1);
		guard = new Guard(guard_init_pos, 'G');

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
		// atualizar a posição do ogre
		// atualizar a moca

	}

	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		String input = keyboard.nextLine().toUpperCase();
		
		direction = input.charAt(0);

		
	}
	
	public void updateGame(){
		Point new_hero_pos;
		
		new_hero_pos = hero.getNewPosition(direction);
		hero.updateHero(getChar(new_hero_pos));
		
		
	}
	
	public void cleanCharacter(Character c){
		switch (state) {
		case LEVEL_1:
			map_1[c.getY()][c.getX()] = ' ';
			break;
		case LEVEL_2:
			map_2[c.getY()][c.getX()] = ' ';
			break;
		}
	}
	
	public void cleanMap(){
		cleanCharacter(hero);
		cleanCharacter(guard);
	}
}
