package logic;

import logic.Character;
import java.awt.Point;

public class Hero extends Character {

	Point new_position;

	public Hero(Point position, char c) {
		super(position, c);
		new_position = new Point(getX(), getY());

	}

	public Point getNewPosition(char direction) {

		
		switch (direction) {
		case 'D':
			new_position.x = getX() + 1;
			new_position.y = getY();
			System.out.println("yo");
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
		
		System.out.println(new_position.x);
		System.out.println(new_position.y);

		return new_position;
	}

	void updateHero(char c) {
		switch (c) {
		case 'X':
			break;
		case 'I':
			break;
		case ' ':
			this.setX(new_position.x);
			this.setY(new_position.y);
			break;
		case 'S':
			setX(new_position.x);
			setY(new_position.y);
			break;
		case 'k':
			setX(new_position.x);
			setY(new_position.y);
			break;
		default:
			break;
		}
		
	
	}

}
