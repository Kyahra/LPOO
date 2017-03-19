package test;

import static org.junit.Assert.*;
import org.junit.Test;

import logic.Drunken;
import logic.DungeonMap;
import logic.Game;
import logic.GameMap;
import logic.Guard;
import logic.Hero;
import logic.KeepMap;
import logic.Rookie;
import logic.Suspicious;
import logic.Game.GameState;

import java.awt.Point;

public class TestDungeonGameLogic {
	char[][] map_1 = { { 'X', 'I', 'X', 'X', 'X' }, { 'X', 'H', ' ', 'G', 'X' }, { 'X', ' ', ' ', ' ', 'X' },
			{ 'X', 'k', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X' } };

	private char[][] map_2 = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

	@Test
	public void moveHeroIntoFreeCell() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(3, 1)));

		assertEquals(new Point(1, 1), g.getHero().getPosition());

		g.setDirection("S");
		g.updateGame();
		g.updateMap();

		assertEquals(new Point(1, 2), g.getHero().getPosition());
		assertEquals(g.getMap().getChar(new Point(1, 2)), 'H');
	}

	@Test
	public void moveHeroIntoWall() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));

		g.setDirection("A");
		g.updateGame();

		assertEquals(new Point(1, 1), g.getHero().getPosition());
	}
	
	@Test
	public void testInvalidDirection() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));

		g.setDirection("X");
		g.updateGame();

		assertEquals(new Point(1, 1), g.getHero().getPosition());
	}
	
	

	@Test
	public void heroIsCapturedLeft() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(3, 1)));

		assertFalse(g.isOver());

		g.setDirection("D");
		g.updateGame();

		assertTrue(g.isOver());

	}

	@Test
	public void heroIsCapturedDown() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(3, 1)));

		assertEquals(g.getMap().getChar(new Point(3, 1)), 'G');

		assertFalse(g.isOver());

		g.setDirection("S");
		g.updateGame();
		g.setDirection("D");
		g.updateGame();
		g.setDirection("D");
		g.updateGame();

		assertTrue(g.isOver());

	}

	@Test
	public void heroIsCapturedUp() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(2, 2)));

		g.clean();
		g.updateMap();

		assertFalse(g.isOver());

		g.setDirection("D");
		g.updateGame();

		assertTrue(g.isOver());

	}

	@Test
	public void heroIsCapturedRight() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(2, 3)));

		g.clean();
		g.updateMap();

		assertFalse(g.isOver());

		g.setDirection("D");
		g.updateGame();
		g.setDirection("D");
		g.updateGame();
		g.setDirection("S");
		g.updateGame();
		g.setDirection("S");
		g.updateGame();

		assertTrue(g.isOver());

	}

	@Test
	public void moveHeroIntoClosedDoor() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));

		g.setDirection("W");
		g.updateGame();

		assertEquals(new Point(1, 1), g.getHero().getPosition());
		assertFalse(g.isOver());

	}

	@Test
	public void doorsOpenWhenLeverActivated() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		assertEquals('I', g.getMap().getChar(new Point(1, 0)));

		g.setDirection("S");
		g.updateGame();
		g.setDirection("S");
		g.updateGame();

		assertEquals('S', g.getMap().getChar(new Point(1, 0)));
	}

	@Test
	public void testDoors() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));;
		assertEquals('I', g.getMap().getChar(new Point(1, 0)));

		g.setDirection("S");
		g.updateGame();

		assertEquals('I', g.getMap().getChar(new Point(1, 0)));
	}

	@Test
	public void levelUpUponReachingStairs() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(3, 1)));

		g.clean();
		g.setDirection("S");
		g.updateGame();

		g.clean();
		g.setDirection("S");
		g.updateGame();

		g.clean();
		g.setDirection("W");
		g.updateGame();

		g.clean();
		g.setDirection("W");
		g.updateGame();

		g.clean();
		g.setDirection("W");
		g.updateGame();

		assertTrue(g.getMap() instanceof KeepMap);

	}


	@Test
	public void heroNotCapuredByDrunken() {
		Game g = new Game(1,'D');
		g.setMap(new DungeonMap(map_1,'D'));

		((DungeonMap) g.getMap()).setGuard(new Drunken(new Point(3, 1)));

		assertFalse(g.isOver());

		g.clean();
		g.updateMap();
		g.setDirection("S");
		g.updateGame();

		((DungeonMap) g.getMap()).getGuard().setPosition(3, 1);

		assertFalse(g.isOver());
	}
	
	@Test
	public void testRookie() {
		Game g = new Game(1,'R');
		g.setMap(new DungeonMap(map_1,'R'));
		
		((DungeonMap) g.getMap()).setGuard(new Rookie(new Point(8, 1)));
		assertEquals(((DungeonMap) g.getMap()).getGuard().getPosition(), new Point(8, 1));

		for (int i = 0; i < 30; i++) {

			g.setDirection("W");
			g.updateGame();
	
		}

		assertEquals(((DungeonMap) g.getMap()).getGuard().getPosition(), new Point(6, 5));

	}

	@Test
	public void testSuspicious() {
		Game g = new Game(1,'S');
		g.setMap(new DungeonMap(map_1,'S'));

		((DungeonMap) g.getMap()).setGuard(new Suspicious(new Point(8, 1)));
		
		Point oldp;
		Point newp;

		for (int i = 0; i < 100; i++) {
			
			oldp = ((DungeonMap) g.getMap()).getGuard().getPosition();

		
			g.setDirection("W");
			g.updateGame();
	
			
			newp = ((DungeonMap) g.getMap()).getGuard().getPosition();
			
			assertTrue(adjacent(oldp,newp));
			
		}

	}

	

	@Test
	public void testDrunken() {
		Game g = new Game(1,'S');
		g.setMap(new DungeonMap(map_1,'S'));
		((DungeonMap) g.getMap()).setGuard(new Drunken(new Point(8, 1)));

		Point oldp;
		Point newp;

		for (int i = 0; i < 100; i++) {
			oldp = ((DungeonMap) g.getMap()).getGuard().getPosition();

	
			g.setDirection("W");
			g.updateGame();

			
			newp = ((DungeonMap) g.getMap()).getGuard().getPosition();
			
			assertTrue(adjacent(oldp,newp));

			if (((Drunken) ((DungeonMap) g.getMap()).getGuard()).isSleeping()){
				assertEquals(((DungeonMap) g.getMap()).getGuard().getChar(), 'g');
				assertEquals(newp,oldp);
			}

			

		}
	}
	
	private boolean adjacent(Point oldp, Point newp) {

		if (oldp.getX() == newp.getX() + 1 && oldp.getY() == newp.getY())
			return true;

		if (oldp.getX() == newp.getX() - 1 && oldp.getY() == newp.getY())
			return true;

		if (oldp.getX() == newp.getX() && oldp.getY() == newp.getY() + 1)
			return true;

		if (oldp.getX() == newp.getX() && oldp.getY() == newp.getY() - 1)
			return true;

		if (oldp.getX() == newp.getX() && oldp.getY() == newp.getY())
			return true;

		return false;
	}
}
