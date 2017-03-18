package logic;

import java.awt.Point;

public class Rookie extends Guard{

	private int[] guard_y= {1,1,2,3,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,5,4,3,2};
	private int[] guard_x= {8,7,7,7,7,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,8,8,8,8};
	private int guard_x_idx;
	private int guard_y_idx;
	
	public Rookie(Point position){
		super(position);

	
	}
	
	public void updateGuard(){

		if(guard_x_idx >= 23){
			guard_x_idx = 0;
			guard_y_idx = 0;
		}else{
			guard_x_idx++;
			guard_y_idx++;
		}

		this.setX(guard_x[guard_x_idx]);
		this.setY(guard_y[guard_y_idx]);

	}
	
}
