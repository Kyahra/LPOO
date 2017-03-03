package cli;

import logic.Game;


public class CommandLineInterface {

	public static void main(String[] args){
		Game g = new Game();
	
		while(true){


		g.updateMap();
		g.printMap();
		g.cleanMap();
		g.readMove();
		g.updateGame();
		
		
		}
	}
	
}
