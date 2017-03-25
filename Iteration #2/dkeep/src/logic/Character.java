package logic;

import java.awt.Point;

public class Character {

	protected Point position;
	protected char c;
	
	public Character(){}

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
	
	public void setPosition(Point p){
		this.position =p;
	}

	public char getChar() {
		return c;
	}

	public void setChar(char c){
		this.c = c;
	}
	
	
	
	public Point getNewPosition(Point actual_pos,int direction){
		Point new_pos = new Point();
		
		switch(direction){
		case 0:
			new_pos.x = actual_pos.x+ 1;
			new_pos.y = actual_pos.y;
			break;
		case 1:
			new_pos.x = actual_pos.x - 1;
			new_pos.y = actual_pos.y;
			break;
		case 2:
			new_pos.x = actual_pos.x;
			new_pos.y = actual_pos.y + 1;
			break;
		case 3:
			new_pos.x = actual_pos.x;
			new_pos.y = actual_pos.y - 1;
			break;
		default:
			break;
		}
		
		return new_pos;

	}
		
	
}

