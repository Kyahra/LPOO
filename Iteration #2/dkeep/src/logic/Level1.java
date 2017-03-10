package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import logic.Hero;
import logic.Hero.HeroState;
import logic.Level.LevelState;
import logic.Guard;


import logic.Game.GameState;

public class Level1 extends Level{

	
	public Level1(){
		
		char[][] map_1 =  { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, 
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, 
				};
		
		map = map_1;
		
		state = LevelState.LEVEL_1;

		Random rand = new Random();		
		int guar = rand.nextInt(3);
		
		Point hero_init_pos = new Point(1, 1);
		hero = new Hero(hero_init_pos, 'H');

		Point lever_init_pos = new Point(7, 8);
		k = new Character(lever_init_pos, 'k');

			
		Point guard_init_pos = new Point(8, 1);
		
		switch(guar){		
		case 0:
			guard = new Suspicious(guard_init_pos, 'G');
			break;
		case 1:
			guard = new Rookie(guard_init_pos, 'G');
			break;
		case 2:
			guard = new Drunken(guard_init_pos, 'G');
			break;		

		}
		
	}
	
	public char getChar(Point position) {

		char c = 'X';

		c = map[position.y][position.x];

		return c;
	}
	
	public void drawCharacter(Character c) {
			
		map[c.getY()][c.getX()] = c.getChar();
	}

	public void updateMap() {

		drawCharacter(hero);

		drawCharacter(guard);
	
	}
	

	public void updateGame() {
		Point new_hero_pos;

		new_hero_pos = hero.getNewPosition(direction);
		hero.updateHero(getChar(new_hero_pos));

		guard.updateGuard();

		if (hero.getState() == HeroState.STAIR) {
			state = LevelState.LEVEL_2;
			hero.setPosition(1, 8);
			k.setPosition(8, 1);

		}

		if (hero.getState() == HeroState.K)
			openDoors();

	}
	

	public void cleanCharacter(Character c) {

		map[c.getY()][c.getX()] = ' ';
	}
	
	public void cleanMap() {
		cleanCharacter(hero);

		if (hero.getState() == HeroState.K)
			drawCharacter(k);

		if (isHeroCaptured(guard))
			state = LevelState.LOST;

		cleanCharacter(guard);

	}

	
	
	public void openDoors() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'I')
					map[i][j] = 'S';
			}
		}
	}
	
	
}
