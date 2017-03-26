package logic;

import java.awt.Point;
import java.util.Random;

public class Drunken extends Guard {

	protected boolean isSleeping = false;

	public Drunken(Point position) {
		super(position);

	}
	
	public void sleepingAction(int rand){
		
		if(moveNumber <= 0){
			isSleeping  = false;
			c = 'G';
			moveNumber = 4;
			if(rand > 1)
				front = true;
			else front  = false;				
		}else{
			moveNumber--;			
		}			
	}
	
	public void awakeAction(int rand){
		
		if(rand <3){
			if(front){
				if(guard_idx >= 23)
					guard_idx = 0;
				else guard_idx++;
			}
			else {
				if(guard_idx <= 0)
					guard_idx = 23;
				else guard_idx--;
			}
		}else{
			isSleeping = true;
			c= 'g';
		}
	}
	
	
	public void updateGuard(){
		
		int random_number = getIdxDirection();
			
		if(isSleeping){
			sleepingAction(random_number);
		}else{			
			awakeAction(random_number);
		}
					
		position = new Point(guard_x[guard_idx],guard_y[guard_idx]);

	}

	public boolean isSleeping() {
		return isSleeping;
	}
	

//	public void setSleeping(boolean isSleeping) {
//		this.isSleeping = isSleeping;
//	}

}
