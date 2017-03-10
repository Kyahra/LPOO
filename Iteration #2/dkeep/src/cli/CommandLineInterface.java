package cli;

import logic.Game;
import logic.Game.GameState;



public class CommandLineInterface {

	public static void main(String[] args){
		
		
		Game g = new Game();
	
		while(true){

		g.updateMap();
		g.printMap();
		g.clean();
		
		if(g.isOver())
			break;
		
		g.readMove();
		g.updateGame();
		
			
		}
		
		
		g.printEnd();
		
	}
	
}
