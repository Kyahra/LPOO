package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logic.Game;
import logic.KeepMap;

public class TestRandomBehaviour {

	
	private char[][] map = {
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'H', ' ', '*', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
	
	
	@Test(timeout =1000)
	public void testOgreDiferentPositions() {
		Game g = new Game();
		g.setMap(new KeepMap(map,1));
		
		boolean left= false;
		boolean right= false;
		boolean up = false;
		boolean down = false;
		
		while(!left && !right && !up && !down){
			
		}
		
		
		
		

	}
}
