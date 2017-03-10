package logic;

import java.awt.Point;
import java.util.Random;

public class Suspicious extends Guard{

	private int[] guard_y= {1,1,2,3,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,5,4,3,2};
	private int[] guard_x= {8,7,7,7,7,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,8,8,8,8};
	private int guard_x_idx;
	private int guard_y_idx;
	
	public Suspicious(Point position, char c){
		super(position, c);

		guard_x_idx = 0;
		guard_y_idx = 0;
	
	}
		
	void updateGuard(){

		Random rand = new Random();		
		int direction = rand.nextInt(4);
		
		if(guard_x_idx >= 23){
			guard_x_idx = 0;
			guard_y_idx = 0;
		}else{

			if(direction < 3){
				guard_x_idx++;
				guard_y_idx++;
			}
			else{
				if(guard_x_idx > 0){
					guard_x_idx--;
					guard_y_idx--;
				}
			}
		}

		this.setX(guard_x[guard_x_idx]);
		this.setY(guard_y[guard_y_idx]);

	}
	
	
}
