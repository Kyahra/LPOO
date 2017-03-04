package cli;

import logic.Game;
import logic.Game.GameState;


public class CommandLineInterface {

	public static void main(String[] args){
		Game g = new Game();
	
		while(true){

		g.updateMap();
		g.printMap();
		g.cleanMap();
		
		if(g.getState() == GameState.LOST || g.getState() == GameState.WON)
			break;
		
		g.readMove();
		g.updateGame();
		
		
		}
		
		if(g.getState() == GameState.LOST){
			System.out.println();
			System.out.println();
			
			System.out.print("--------------");
			System.out.print(" GAME OVER ");
			System.out.print("--------------");
			
		}
		
		if(g.getState() == GameState.WON){
			System.out.println();
			System.out.println();
			
			System.out.print("---------------");
			System.out.print(" VICTORY ");
			System.out.print("---------------");
			
			
		}
	}
	
}
