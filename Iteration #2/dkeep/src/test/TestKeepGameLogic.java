package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import logic.Character;
import logic.DungeonMap;
import logic.Game;
import logic.Hero.HeroState;
import logic.KeepMap;

public class TestKeepGameLogic {
	char[][] map = {
			
			{ 'X', 'I', 'X', 'X', 'X' },
			{ 'X', 'H', ' ', 'O', 'X' }, 
			{ 'X', ' ', ' ', '*', 'X' },
			{ 'X', 'k', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } 
			};
	
	void normalizePositions(Game g){
		((KeepMap) g.getMap()).getOgres().get(0).setPosition(3, 1);
		((KeepMap) g.getMap()).getOgres().get(0).getClub().setPosition(3, 1);
	}


	@Test
	public void heroIsCapturedByOgre() {
		Game g = new Game();
		g.setMap(new KeepMap(map,1));
		((KeepMap) g.getMap()).getOgres().get(0).setPosition(3, 1);
		
		assertFalse(g.isOver());
	
		g.setDirection("D");
		g.updateGame();
		normalizePositions(g);
		
		
		assertTrue(g.isOver());

	}
	
	@Test
	public void heroHoldingKey(){
		Game g = new Game();
		g.setMap(new KeepMap(map,1));
		 
		((KeepMap) g.getMap()).getOgres().get(0).setPosition(3, 1);
		 
		 g.setDirection("S");
		 g.updateGame();
		 g.setDirection("S");
		 g.updateGame();
		 
		 assertTrue(g.getHero().gotKey());
			 
	}
	
	
	@Test
	public void heroMovesIntoClosedDoor() {
		Game g = new Game();
		g.setMap(new KeepMap(map,1));
		((KeepMap) g.getMap()).getOgres().get(0).setPosition(3, 1);
		
		assertEquals('I',g.getMap().getChar(new Point(1,0)));
		
		g.setDirection("W");;
		g.updateGame();
		
		
		assertEquals('I',g.getMap().getChar(new Point(1,0)));

	}
	
	
	@Test
	public void heroMovesIntoDoor() {
		Game g = new Game();
		g.setMap(new KeepMap(map,1));
	
		
		assertEquals('I',g.getMap().getChar(new Point(1,0)));
		
		
		 g.clean();
		 g.setDirection("S");
		 g.updateGame();

		 
		 g.setDirection("S");
		 g.updateGame();
		 
		 assertTrue(g.getHero().gotKey());
		 
		 g.setDirection("W");
		 g.updateGame();
		
		 
		 g.setDirection("W");
		 g.updateGame();
		 
		 g.setDirection("W");
		 g.updateGame();
	
		assertEquals('S',g.getMap().getChar(new Point(1,0)));

	}
	
/*
	@Test
	public void heroWins() {
		Game g = new Game();
		g.setMap(new KeepMap(map));
		g.setNumberOgres(1);
	
		
		g.getOgres().get(0).setPosition(new Point(3, 1));
		g.getOgres().get(0).getClub().setPosition(new Point(3,2));
		g.getK().setPosition(new Point(1,3));
		g.getClub().setPosition(new Point(3,2));
		
		assertEquals('I',g.getMap().getChar(new Point(1,0)));
		
		
		 g.clean();
		 g.setDirection("S");
		 g.updateGame();

		 
		 g.setDirection("S");
		 g.updateGame();
		 
		 assertTrue(g.getHero().gotKey());
		 
		 g.setDirection("W");
		 g.updateGame();
		
		 
		 g.setDirection("W");
		 g.updateGame();
		 
		 g.setDirection("W");
		 g.updateGame();
	
		assertEquals('S',g.getMap().getChar(new Point(1,0)));
		
		g.setDirection("W");
		g.updateGame();
		
		assertTrue(g.isOver());

	}
	
	
	@Test
	public void testUpdateMap(){
		Game g = new Game();
		g.setMap(new KeepMap(map));
		
		g.getOgres().get(0).setPosition(new Point(3, 1));
		g.getOgres().get(0).getClub().setPosition(new Point(3,2));
		
	
		 g.clean();
		 g.setDirection("S");
		 g.updateGame();
	
		g.getOgres().get(0).setPosition(new Point(3, 1));
		g.getOgres().get(0).getClub().setPosition(new Point(3,2));
		g.getK().setPosition(new Point(1,3));
		g.getClub().setPosition(new Point(3,2));
			
		 g.updateMap();
		 g.printMap();

			 
	}


	
	*/
	
	
	

}
