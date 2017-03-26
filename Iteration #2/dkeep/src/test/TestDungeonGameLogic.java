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
import java.util.ArrayList;

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
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
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
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));

		g.setDirection("A");
		g.updateGame();

		assertEquals(new Point(1, 1), g.getHero().getPosition());
	}
	
	@Test
	public void testInvalidDirection() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));

		g.setDirection("X");
		g.updateGame();

		assertEquals(new Point(1, 1), g.getHero().getPosition());
	}
	
	

	@Test
	public void heroIsCapturedLeft() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
		((DungeonMap) g.getMap()).setGuard(new Guard(new Point(3, 1)));

		assertFalse(g.isOver());

		g.setDirection("D");
		g.updateGame();

		assertTrue(g.isOver());

	}

	@Test
	public void heroIsCapturedDown() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
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
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
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
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
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
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));

		g.setDirection("W");
		g.updateGame();

		assertEquals(new Point(1, 1), g.getHero().getPosition());
		assertFalse(g.isOver());

	}

	@Test
	public void doorsOpenWhenLeverActivated() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
		assertEquals('I', g.getMap().getChar(new Point(1, 0)));

		g.setDirection("S");
		g.updateGame();
		g.setDirection("S");
		g.updateGame();

		assertEquals('S', g.getMap().getChar(new Point(1, 0)));
	}

	@Test
	public void testDoors() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));;
		assertEquals('I', g.getMap().getChar(new Point(1, 0)));

		g.setDirection("S");
		g.updateGame();

		assertEquals('I', g.getMap().getChar(new Point(1, 0)));
	}

	@Test
	public void levelUpUponReachingStairs() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
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
		Game g = new Game(1,"Druken");
		g.setMap(new DungeonMap(map_1,"Druken"));

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
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_2,"Rookie"));
		
		boolean left= false;
		boolean right= false;
		boolean up = false;
		boolean down = false;
		
		Point old_pos;
		Point new_pos;
		
		while(!left || !right || !up || !down){
			
			old_pos = ((DungeonMap) g.getMap()).getGuard().getPosition();
		
			((DungeonMap) g.getMap()).getGuard().updateGuard();
			
			new_pos = ((DungeonMap) g.getMap()).getGuard().getPosition();
			
			if(isLeft(new_pos, old_pos))
				left = true;
			
			if(isRight(new_pos, old_pos))
				right = true;
			
			if( isUp(new_pos, old_pos))
				up = true;
			
			if( isDown(new_pos, old_pos))
				down = true;
			
	
		}
	}

	@Test
	public void testRookiePath() {
		Game g = new Game(1,"Rookie");
		g.setMap(new DungeonMap(map_1,"Rookie"));
		
		boolean completePath= false;
		int numSteps = 0;
		
		ArrayList<Point> path = new ArrayList<Point>();
		
		Point old_pos;
		Point new_pos;
		
		while(!completePath){
			
			if(numSteps > 23){
			
			old_pos = ((DungeonMap) g.getMap()).getGuard().getPosition();
		
			((DungeonMap) g.getMap()).getGuard().updateGuard();
			
			new_pos = ((DungeonMap) g.getMap()).getGuard().getPosition();
			
			
			}
	
		}
	}

	
	
	@Test
	public void testSuspicious() {
		Game g = new Game(1,"Suspicious");
		g.setMap(new DungeonMap(map_1,"Suspicious"));

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
		Game g = new Game(1,"Suspicious");
		g.setMap(new DungeonMap(map_1,"Suspicious"));
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
	
	
	private boolean isLeft(Point new_pos, Point old_pos) {

		if (new_pos.getX() == old_pos.getX() - 1 && new_pos.getY() == old_pos.getY())
			return true;
		else
			return false;
	}
	
	private boolean isRight(Point new_pos, Point old_pos) {

		if (new_pos.getX() == old_pos.getX() + 1 && new_pos.getY() == old_pos.getY())
			return true;
		else
			return false;
	}
	
	private boolean isUp(Point new_pos, Point old_pos) {

		if (new_pos.getX() == old_pos.getX()  && new_pos.getY() == old_pos.getY()-1)
			return true;
		else
			return false;
		
	}
	
	private boolean isDown(Point new_pos, Point old_pos) {

		if (new_pos.getX() == old_pos.getX()  && new_pos.getY() == old_pos.getY()+1)
			return true;
		else
			return false;
		
	}
}
