package logic;

import logic.Character;
import java.awt.Point;

public class Hero extends Character {

	Point new_position;
	public enum HeroState { K, STAIR, MOVE,DOOR};
	
	private HeroState state;

	public Hero(Point position, char c) {
		super(position, c);
		new_position = new Point(getX(), getY());
		state = HeroState.MOVE;

	}

	public Point getNewPosition(char direction) {

		
		switch (direction) {
		case 'D':
			new_position.x = getX() + 1;
			new_position.y = getY();
			break;
		case 'A':
			new_position.x = getX() - 1;
			new_position.y = getY();
			break;
		case 'S':
			new_position.x = getX();
			new_position.y = getY() + 1;
			break;
		case 'W':
			new_position.x = getX();
			new_position.y = getY() - 1;
			break;

		default:
			break;

		}
		

		return new_position;
	}

	void updateHero(char c) {
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
			state =HeroState.STAIR;
			break;
		case 'k':
			setX(new_position.x);
			setY(new_position.y);
			state = HeroState.K;
			break;
		default:
			break;
		}
		
	}
	
	public HeroState getState(){
		return state;
	}

}
