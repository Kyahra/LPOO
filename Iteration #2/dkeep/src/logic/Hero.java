package logic;

import logic.Character;
import java.awt.Point;

public class Hero extends Character {

	public enum HeroState {
		K, STAIR, MOVE, DOOR, ARMED
	};

	private HeroState state;
	private boolean armed = false;
	private boolean key = false;

	public Hero(Point position, char c) {
		super(position, c);
		state = HeroState.MOVE;

	}

	public void move(String direction, GameMap map) {

		Point new_position = new Point(getX(), getY());
		char c;

		switch (direction) {
		case "D":
			new_position.x = getX() + 1;
			new_position.y = getY();
			break;
		case "A":
			new_position.x = getX() - 1;
			new_position.y = getY();
			break;
		case "S":
			new_position.x = getX();
			new_position.y = getY() + 1;
			break;
		case "W":
			new_position.x = getX();
			new_position.y = getY() - 1;
			break;

		default:
			break;

		}

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
			state = HeroState.K;
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
