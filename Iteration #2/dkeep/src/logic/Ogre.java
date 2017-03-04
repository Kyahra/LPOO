package logic;

import java.awt.Point;
import java.util.Random;
import logic.Hero.HeroState;

	public class Ogre extends Character{

	Point new_position;

	public enum OgreState { KEY, MOVE};

	private OgreState state;

	public Ogre(Point position, char c) {
		super(position, c);
		new_position = new Point(getX(), getY());
		state = OgreState.MOVE;

	}

	public Point getNewPosition() {

		Random rand = new Random();		
		int direction = rand.nextInt(4);

		switch(direction){
		case 0:
			this.setX(new_position.x++);
			break;
		case 1:
			this.setX(new_position.x--);
			break;
		case 2:
			this.setY(new_position.y++);
			break;
		case 3:
			this.setY(new_position.y--);
			break;
		default:
			break;
		}

		return new_position;
	}


	void updateOgre(char c) {

		switch (c) {
		case 'X':
			break;
		case 'I':
			break;
		case ' ':
			this.setX(new_position.x);
			this.setY(new_position.y);
			state = OgreState.MOVE;
			break;
		case 'S':
			break;
		case 'k':
			setX(new_position.x);
			setY(new_position.y);
			state = OgreState.KEY;
			break;
		default:
			break;
		}
	}
	
	
	public OgreState getState(){
		return state;
	}
}
