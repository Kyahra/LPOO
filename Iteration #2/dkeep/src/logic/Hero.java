package logic;

import logic.Character;
import java.awt.Point;

public class Hero extends Character {

	public enum HeroState {
		STAIR, MOVE, DOOR, ARMED
	};

	private HeroState state;
	private boolean armed = false;
	private boolean key = false;

	public Hero(Point position) {
	
		setPosition(position);
		setChar('H');
		state = HeroState.MOVE;

	}

	public void move(String direction, GameMap map) {

		Point new_position = new Point(getX(), getY());
		char c;
		int direction_int=4;

		switch (direction) {
		case "D":
			direction_int =0;
			break;
		case "A":
			direction_int =1;
			break;
		case "S":
			direction_int =2;
			break;
		case "W":
			direction_int = 3;
			break;

		default:
			break;
		}
		
		new_position = super.getNewPosition(getPosition(), direction_int);
		

		c = map.getChar(new_position);

		switch (c) {
		case 'X':
			break;
		case 'I':
			state = HeroState.DOOR;
			break;
		case ' ':
			this.setX(new_position.x);
			this.setY(new_position.y);
			state = HeroState.MOVE;
			break;
		case 'S':
			setX(new_position.x);
			setY(new_position.y);
			state = HeroState.STAIR;
			break;
		case 'k':
			setX(new_position.x);
			setY(new_position.y);
			key = true;
			break;

		case '*':
			setX(new_position.x);
			setY(new_position.y);
			armed = true;
			setChar('A');

		default:
			break;
		}

	}



	public HeroState getState() {
		return state;
	}

	public boolean gotKey() {

		return key;
	}

	public boolean isArmed(){
		return armed;
	}
	
	public void setKey(boolean key){
		this.key = key;
	}
	
}
