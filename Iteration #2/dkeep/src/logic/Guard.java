package logic;

import logic.Character;
import java.awt.Point;

public abstract class Guard extends Character{

	private int[] guard_y= {1,1,2,3,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,5,4,3,2};
	private int[] guard_x= {8,7,7,7,7,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,8,8,8,8};
	private int guard_x_idx;
	private int guard_y_idx;
	
	public enum GuardState {
		ROOKIE, SUSPICIOUS, DRUNKEN
	};
	
	public Guard(Point position){
	
		setPosition(position);
		setChar('G');
		guard_x_idx = 0;
		guard_y_idx = 0;
	
	}
	
	public abstract void updateGuard();
	
	
}