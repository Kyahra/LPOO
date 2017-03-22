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
	

		if(stuned){
			stun_counter++;
			
			if(stun_counter == 2){
				stuned = false;
				return;
			}
			
			return;
		}
		
		do{
			
			direction = rand.nextInt(4);
				
			new_pos= super.getNewPosition(position, direction);
			
			
			c = map.getChar(new_pos);
			
			if(new_pos.getX() == map.getKPos().getX() && new_pos.getY() == map.getKPos().getY()){
				position= new_pos;
				setChar('$');
				return;
				
			}
			
			}while(!validPosition(c, 'O',this));
			
		position= new_pos;
			
		
		

		
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
		

		
		if(new_pos.getX() == map.getKPos().getX() && new_pos.getY() == map.getKPos().getY()){
			club.setPosition(new_pos);
			club.setChar('$');
			return;
			
		}
		
		
		}while(!validPosition(c,'*',club));
		
		club.setPosition(new_pos);
		
	}
	
	public boolean validPosition(char c, char normal, Character x){
		switch (c) {
		case 'X':
			return false;
		case 'I':
			return false;
		case ' ':
			x.setChar(normal);
			return true;
		case 'S':
			return false;
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
