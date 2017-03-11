package test;

import static org.junit.Assert.*;
import org.junit.Test;

import logic.DungeonMap;
import logic.Game;
import logic.GameMap;
import logic.Hero;
import logic.KeepMap;
import logic.Game.GameState;

import java.awt.Point;


public class TestDungeonGameLogic {
	char[][] map ={
			{'X','I','X','X','X'},
			{'X','H',' ','G','X'},
			{'X',' ',' ',' ','X'},
			{'X','k',' ',' ','X'},
			{'X','X','X','X','X'}
		};
	
	@Test
	public void moveHeroIntoFreeCell(){
		 Game g = new Game();
		 g.setMap(new GameMap(map));
		 assertEquals(new Point(1,1),g.getHero().getPosition());
		 g.getHero().move("S", g.getMap());
		 assertEquals(new Point(1,2),g.getHero().getPosition());
	}
	
	
	@Test
	public void moveHeroIntoWall(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map));
		 g.getHero().move("A", g.getMap());
		 assertEquals(new Point(1,1),g.getHero().getPosition());
	}
	
	@Test
	public void heroIsCaptured(){
		Game g = new Game();
		g.setMap(new DungeonMap(map));
		g.getGuard().setPosition(new Point(3,1));
		assertFalse(g.isOver());
		g.getHero().move("D", g.getMap());
		assertTrue(g.isOver());
		
	}
	
	@Test
	public void moveHeroIntoClosedDoor(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map));
		 g.getHero().move("W", g.getMap());
		 assertEquals(new Point(1,1),g.getHero().getPosition());
	}
	
	@Test
	public void doorsOpenWhenLeverActivated(){
		Game g = new Game();
		 g.setMap(new DungeonMap(map));
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
		 g.setMap(new DungeonMap(map));
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
	


}
