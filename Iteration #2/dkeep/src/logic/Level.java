package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import logic.Game.GameState;

public abstract class Level {

	protected Hero hero;
	protected Guard guard;
	protected Character k;
	protected ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	
	protected int rows = 10;
	protected int cols = 10;
	protected char[][] map= new char[rows][cols];
	
	protected String direction;
	
	public enum LevelState {
		WON, LEVEL_1, LEVEL_2, LOST
	};
	
	protected LevelState state;
	
	public Level(){
		state = LevelState.LEVEL_1;
	}
	
	public abstract char getChar(Point position);
	public abstract void drawCharacter(Character c);
	public abstract void updateMap();
	public abstract void updateGame();
	public abstract void cleanCharacter(Character c);
	public abstract void cleanMap();
	public abstract void openDoors();
	
	public void printMap() {

		System.out.println();

		for (int i = 0; i < rows; i++) {
			System.out.print("          ");
			for (int j = 0; j < cols; j++) {
				System.out.print(map[i][j] + " ");
			
			}	
			System.out.println();
		}

		System.out.println("\n Use the WASD keys to control the Hero.");
		System.out.print(" Your Move : ");

	}
	
	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		direction = keyboard.nextLine().toUpperCase();

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

	public LevelState getState() {
		return state;
	}
}
