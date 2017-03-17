package logic;

import logic.Character;
import java.awt.Point;

public class Guard extends Character{

	protected int[] guard_y= {1,1,2,3,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,5,4,3,2};
	protected int[] guard_x= {8,7,7,7,7,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,8,8,8,8};
	protected int guard_idx;
	
	
	public Guard(Point position){
	
		setPosition(position);
		c= 'G';
		guard_idx =0;
	
	}
	
	public void updateGuard(){};
	
	
}