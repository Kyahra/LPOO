package logic;

import java.awt.Point;

public class Character {

	private Point position;
	private char c;

	public Character(Point position, char c) {

		this.position = position;
		this.c = c;
	}

	public int getX() {
		return position.x;
	}

	public int getY() {
		return position.y;
	}

	public void setX(int x) {
		this.position.x = x;
	}

	public void setY(int y) {
		this.position.y = y;
	}

	public Point getPosition() {
		return position;
	}
	
	public void setPosition(int x, int y){
		this.position.x = x;
		this.position.y = y;
	}

	public char getCharacter() {
		return c;
	}
}
