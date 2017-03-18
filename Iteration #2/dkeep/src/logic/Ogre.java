package logic;

import java.awt.Point;
import java.util.Random;

import logic.Hero.HeroState;


	public class Ogre extends Character{
		
	private Character club;
	private boolean stuned ;
	private int stun_counter;
	
	public Ogre(Point position) {
		setPosition(position);
		c= 'O';
		club = new Character(new Point(getX(), getY()+1), '*');
		stuned = false;
		stun_counter = 0;

	}


	public void move(GameMap map){
		Random rand = new Random();		
		int direction = rand.nextInt(4);
		Point new_pos = new Point();
		char c;
		
		
		new_pos= super.getNewPosition(getPosition(), direction);

		if(stuned){
			stun_counter++;
			
			if(stun_counter == 2){
				stuned = false;
				return;
			}
		}
		
		c = map.getChar(new_pos);
		
		this.c= 'O';
		
		switch (c) {
		case 'X':
			break;
		case 'I':
			break;
		case ' ':
			position = new_pos;
			break;
		case 'S':
			break;
		case 'k':
			position = new_pos;
			this.c = '$';	
			break;
		default:
			break;
		}
		
		
	}
	
	public void swingClub(GameMap map) {
		Random rand = new Random();	
		int direction;
		Point new_pos = new Point();
		char c;
		
		do{
		
		direction = rand.nextInt(4);
			
		new_pos = super.getNewPosition(position, direction);
		
		c = map.getChar(new_pos);
		
		}while(!validPosition(c));
		
		club.setPosition(new_pos);
		
	}
	
	public boolean validPosition(char c){
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
	
	
	public void getStuned(){
		stuned = true;
		c= '8';
	}
	
	
	public boolean isStuned(){
		return stuned;
	}
	


	

	
	
}
