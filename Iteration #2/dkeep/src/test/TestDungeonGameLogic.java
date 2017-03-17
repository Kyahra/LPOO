package test;

import static org.junit.Assert.*;
import org.junit.Test;

import logic.DungeonMap;
import logic.Game;
import logic.GameMap;
import logic.Hero;
import logic.KeepMap;
import logic.Rookie;
import logic.Suspicious;
import logic.Game.GameState;

import java.awt.Point;


public class TestDungeonGameLogic {
	char[][] map_1 ={
			{'X','I','X','X','X'},
			{'X','H',' ','G','X'},
			{'X',' ',' ',' ','X'},
			{'X','k',' ',' ','X'},
			{'X','X','X','X','X'}
		};
	
	private char[][] map_2 = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, 
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };
	
	@Test
	public void moveHeroIntoFreeCell(){
		 Game g = new Game();
		 g.setMap(new GameMap(map_1));
		 assertEquals(new Point(1,1),g.getHero().getPosition());
		 g.getHero().move("S", g.getMap());
		 assertEquals(new Point(1,2),g.getHero().getPosition());
	}
	
	
	@Test
	public void moveHeroIntoWall(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map_1));
		 g.getHero().move("A", g.getMap());
		 assertEquals(new Point(1,1),g.getHero().getPosition());
	}
	
	@Test
	public void heroIsCaptured(){
		Game g = new Game();
		g.setMap(new DungeonMap(map_1));
		g.getGuard().setPosition(new Point(3,1));
		assertFalse(g.isOver());
		g.getHero().move("D", g.getMap());
		assertTrue(g.isOver());
		
	}
	
	@Test
	public void moveHeroIntoClosedDoor(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map_1));
		 g.getHero().move("W", g.getMap());
		 assertEquals(new Point(1,1),g.getHero().getPosition());
	}
	
	@Test
	public void doorsOpenWhenLeverActivated(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map_1));
		 assertEquals('I',g.getMap().getChar(new Point(1,0)));
		 g.setDirection("S");
		 g.updateGame();
		 g.setDirection("S");
		 g.updateGame();
		 assertEquals('S',g.getMap().getChar(new Point(1,0)));
	}
	
	@Test
	public void levelUpUponReachingStairs(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map_1));
		 g.getGuard().setPosition(new Point(3,1));
		 
		 g.clean();
		 g.setDirection("S");
		 g.updateGame();
		 
		 g.setDirection("S");
		 g.updateGame();
	
		 g.setDirection("W");
		 g.updateGame();
	
		 g.setDirection("W");
		 g.updateGame();
	
		 g.setDirection("W");
		 g.updateGame();
		
		 assertTrue(g.getMap() instanceof KeepMap);
		
	}
	

	@Test
	public void testUpdateMap(){
		Game g = new Game();
		g.setMap(new DungeonMap(map_1));
		g.getGuard().setPosition(new Point(3,1));
		g.getK().setPosition(new Point(1,3));
		
		
		 g.clean();
		 g.setDirection("S");
		 g.updateGame();
		 g.getGuard().setPosition(new Point(3,1));
		 g.updateMap();
		 g.printMap();

			 
	}
	
	
	
	
	@Test
	public void testRookkie(){
		Game g = new Game();
		g.setMap(new DungeonMap(map_2));
		g.setGuard(new Rookie(new Point(8, 1), 'G'));
		
		assertEquals(g.getGuard().getPosition(),new Point(8, 1));
		
		g.setDirection("W");
		g.updateGame();
		
		assertEquals(g.getGuard().getPosition(),new Point(7, 1));
		
			 
	}

	
	@Test
	public void testSuspicious(){
		Game g = new Game();
		g.setMap(new DungeonMap(map_2));
		g.setGuard(new Suspicious(new Point(8, 1), 'G'));
		
		assertEquals(g.getGuard().getPosition(),new Point(8, 1));
		
	
		for(int i  = 0 ; i < 100; i++){
		g.setDirection("W");
		g.updateGame();
		}
		//assertEquals(g.getGuard().getPosition(),new Point(7, 1));
		
			 
	}
	
	@Test
	public void testValidLimits(){
	
		Game g = new Game();
		g.setMap(new DungeonMap(map_2));
		g.setGuard(new Suspicious(new Point(8, 1), 'G'));
		
		assertTrue(g.getGuard().isLimitValid(2,1,3));
	}
	
}
