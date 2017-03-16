package logic;

import java.awt.Point;
import java.util.Random;

public class Suspicious extends Guard{

	
	
	public Suspicious(Point position){
		
		super(position);
	
	}
		
	public void updateGuard(){

		Random rand = new Random();		
		int direction = rand.nextInt(4);
		
		
		if(direction <3){
			if(guard_idx >= 23)
				guard_idx = 0;
			else
				guard_idx++;
			
		}else{
			if(guard_idx > 0){
				guard_idx--;
			}else{
				guard_idx++;
			}
		}
		
		position = new Point(guard_x[guard_idx],guard_y[guard_idx]);

		
	}
	
	
}
