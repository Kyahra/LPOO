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

	@Test
	public void heroIsCaptured() {
		Game g = new Game();
		g.setMap(new KeepMap(map));
		g.setNumberOgres(1);
		
		for(int i =0; i <g.getOgres().size(); i++)
		g.getOgres().get(i).setPosition(new Point(3, 1));
		
		assertFalse(g.isOver());
		g.getHero().move("D", g.getMap());
		assertTrue(g.isOver());

	}
	
	@Test
	public void heroHoldingKey(){
		Game g = new Game();
		g.setMap(new KeepMap(map));
		 
		g.setNumberOgres(1);
		 for(int i =0; i <g.getOgres().size(); i++)
				g.getOgres().get(i).setPosition(new Point(3, 1));
		 
		 g.setDirection("S");
		 g.updateGame();
		 g.setDirection("S");
		 g.updateGame();
		 
		 assertTrue(g.getHero().gotKey());
			 
	}
	
	@Test
	public void heroMovesIntoClosedDoor() {
		Game g = new Game();
		g.setMap(new KeepMap(map));
		g.setNumberOgres(1);
	
		
		for(int i =0; i <g.getOgres().size(); i++)
		g.getOgres().get(i).setPosition(new Point(3, 1));
		
		assertEquals('I',g.getMap().getChar(new Point(1,0)));
		
		g.setDirection("W");;
		g.updateGame();
		
		
		assertEquals('I',g.getMap().getChar(new Point(1,0)));

	}
	
	@Test
	public void heroMovesIntoDoor() {
		Game g = new Game();
		g.setMap(new KeepMap(map));
		g.setNumberOgres(1);
	
		
		g.getOgres().get(0).setPosition(new Point(3, 1));
		g.getOgres().get(0).getClub().setPosition(new Point(3,2));
		g.getK().setPosition(new Point(1,3));
		g.setClub(new Character(new Point(3,2), '*'));
		
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
	

	@Test
	public void heroWins() {
		Game g = new Game();
		g.setMap(new KeepMap(map));
		g.setNumberOgres(1);
	
		
		g.getOgres().get(0).setPosition(new Point(3, 1));
		g.getOgres().get(0).getClub().setPosition(new Point(3,2));
		g.getK().setPosition(new Point(1,3));
		g.setClub(new Character(new Point(3,2), '*'));
		
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
	

	
	
	
	
	

}
