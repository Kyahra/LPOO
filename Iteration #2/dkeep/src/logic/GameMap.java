package logic;

import java.awt.Point;
import java.util.ArrayList;

public abstract class GameMap {

	private char[][] map;
	private int rows;
	private int cols;
	
	protected Hero hero;
	
	
	public GameMap(char[][] map) {
		this.map = map;
		rows = map.length;
		cols = map[0].length;
	}

	public char getChar(Point position) {

		char c = 'X';

		c = map[position.y][position.x];

		return c;
	}

	public  void printMap() {

		System.out.println();

		for (int i = 0; i < rows; i++) {
			System.out.print("          ");
			for (int j = 0; j < cols; j++) {
				System.out.print(map[i][j] + " ");

			}

			System.out.println();
		}

		// TENTAR COLOCAR ESTA PARTE NOUTRA FUNÇÂO

		System.out.println("\n Use the WASD keys to control the Hero.");
		System.out.print(" Your Move : ");

	}

	public  void drawCharacter(Character c) {
		map[c.getY()][c.getX()] = c.getChar();

	}

	public  void cleanCharacter(Character c) {
		
	
		map[c.getY()][c.getX()] = ' ';
		


	}

	public  void openDoors() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'I')
					map[i][j] = 'S';
			}
		}

	}
	
	public Point searchChar(char c){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == c)
					return new Point(j,i);
			}
		}
		
		return new Point(-1,-1);
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
	
	public abstract void update(String Direction);
	
	public abstract void clean();

	public abstract void draw();

	public abstract boolean isOver();

	public abstract boolean next();

	public Hero getHero() {
		return hero;
	}

	

	
}
