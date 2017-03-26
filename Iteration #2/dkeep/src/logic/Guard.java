package logic;

import logic.Character;
import java.awt.Point;
import java.util.Random;

public class Guard extends Character{

	protected int[] guard_y= {1,1,2,3,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,5,4,3,2};
	protected int[] guard_x= {8,7,7,7,7,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,8,8,8,8};
	protected int guard_idx;
	protected int moveNumber = 4;
	protected boolean front = true;
	
	
	public Guard(Point position){
	
		setPosition(position);
		c= 'G';
		guard_idx =0;
	
	}
	
	public void updateGuard(){};
	
	public int getIdxDirection(){
		
		Random rand = new Random();		
		int direction = rand.nextInt(4);
		return direction;
		
	}
	


	public int getMoveNumber() {
		return moveNumber;
	}


	public boolean isFront() {
		return front;
	}

	public void setFront(boolean front) {
		this.front = front;
	}
	
}