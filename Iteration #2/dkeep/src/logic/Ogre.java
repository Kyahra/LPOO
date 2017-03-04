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
		new_position = new Point(position);
		club_position = new Point(getX()-1, getY());
		state = OgreState.MOVE;
		

	}
	

	
	public Point getNewPosition() {

		Random rand = new Random();		
		int direction = rand.nextInt(4);
		

		new_position = super.getNewPosition(getPosition(), direction);
		
		return new_position;
		
		
	}


	public boolean updateOgre(char c) {

		switch (c) {
		case 'X':
			return false;
		case 'I':
			break;
		case ' ':
			setPosition(new_position);
			state = OgreState.MOVE;
			return true;
		case 'S':
			return false;
		case 'k':
			setPosition(new_position);
			state = OgreState.KEY;
			return true;
		default:
			break;
		}
		
		return false;
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
	
	public boolean updateClub(char c){
		switch (c) {
		case 'X':
			return false;
		case 'I':
			return false;
		case ' ':
			return true;
		case 'S':
			return false;
		case 'k':
			return true;
		default:
			break;
		}
		
		return false;
	}
	
	public Point getClubPos(){
		return club_position;
	}
	
	
}
