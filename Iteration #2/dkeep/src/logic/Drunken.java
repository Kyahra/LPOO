package logic;

import java.awt.Point;
import java.util.Random;

public class Drunken extends Guard {

	private boolean isSleeping = false;
	private int moveNumber = 4;

	public Drunken(Point position) {
		super(position);

	}

	public void updateGuard(){

		Random rand = new Random();		
		int random_number = rand.nextInt(4);
		
		
		if(isSleeping){
			if(moveNumber <= 0){
				isSleeping  = false;
				c = 'G';
				moveNumber = 4;
			}else{
				moveNumber--;			
			}	
		}else{
			
			if(random_number <3){
				if(guard_idx >= 23)
					guard_idx = 0;
				else guard_idx++;
			}else{
				isSleeping = true;
				c= 'g';
			}
		}
			
		
		position = new Point(guard_x[guard_idx],guard_y[guard_idx]);

	}

	public boolean isSleeping() {
		return isSleeping;
	}

}
