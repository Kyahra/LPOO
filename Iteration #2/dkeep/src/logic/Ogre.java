package logic;

import java.awt.Point;
import java.util.Random;


	public class Ogre extends Character{
		
	public enum OgreState { KEY, MOVE};

	private Point new_position;
	private OgreState state;
	private Character club;
	
	public Ogre(Point position, char c) {
		super(position, c);
		
		new_position = new Point(position);
		state = OgreState.MOVE;
		club = new Character(new Point(getX()-1, getY()), '*');
		

	}
	
	//private int[] move = {0,1,0,1,0,1,0,1,0,1,0,1};
	
	//int i = 0;
	public Point getNewPosition() {

		Random rand = new Random();		
		int direction = rand.nextInt(4);

		Point new_pos = new Point();

		/*
		int direction = move[i];
		i++;
		switch(direction){
		case 0:
			new_position.x = getX()+ 1;
			new_position.y = getY();
			break;
		case 1:
			new_position.x = getX()- 1;
			new_position.y = getY();
			break;
		case 2:
			new_position.x = getX();
			new_position.y = getY() + 1;
			break;
		case 3:
			new_position.x = getX();
			new_position.y = getY()- 1;
			break;
		default:
			break;
		}
		
		return new_position;*/

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
			setChar('O');
			return true;
		case 'S':
			return false;
		case 'k':
			setPosition(new_position);
			state = OgreState.KEY;
			setChar('$');	
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
		
		club.setPosition(super.getNewPosition(getPosition(), direction));
		
		return club.getPosition();
		
	}
	
	public boolean updateClub(char c){
		switch (c) {
		case 'X':
			return false;
		case 'I':
			return false;
		case ' ':
			club.setChar('*');
			return true;
		case 'S':
			return false;
		case 'k':
			club.setChar('$');
			return true;
		default:
			break;
		}
		
		return false;
	}
	
	public Character getClub(){
		return club;
	}
	
	
	
}
