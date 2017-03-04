package logic;

import java.awt.Point;
import java.util.Random;


	public class Ogre extends Character{

	private Point club_position;
	private Point new_position;

	public enum OgreState { KEY, MOVE};

	private OgreState state;

	public Ogre(Point position, char c) {
		super(position, c);
		new_position = new Point(getX(),getY());
		state = OgreState.MOVE;
		

	}
	

	
	public Point getNewPosition() {

		Random rand = new Random();		
		int direction = rand.nextInt(4);
		

		new_position = super.getNewPosition(getPosition(), direction);
		
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
	
	public Point getNewClubPosition(){
		Random rand = new Random();	
		
		int direction = rand.nextInt(4);
		
		club_position = super.getNewPosition(getPosition(), direction);
		
		return club_position;
		
	}
	
	
}
