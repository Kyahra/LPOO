package dkeep.logic;

import java.awt.Point;

public class Character {
	
	private Point position;
	private char c;
	
	public Character(Point position){
		
		this.position = position;
	}
	
	public int getX(){
		return position.x;
	}
	
	public int getY(){
		return position.y;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public char getCharacter(){
		return c;
	}
}
