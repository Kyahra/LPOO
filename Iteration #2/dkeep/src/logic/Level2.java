package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import logic.Hero;
import logic.Hero.HeroState;
import logic.Guard;
import logic.Ogre;
import logic.Ogre.OgreState;

import logic.Game.GameState;


public class Level2 extends Level1{

	public Level2(){

		char[][] map_2 =  { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, 
		};

		map = map_2;

		Point hero_init_pos = new Point(1, 8);
		hero = new Hero(hero_init_pos, 'H');

		Point lever_init_pos = new Point(8, 1);
		k = new Character(lever_init_pos, 'k');

		for(int i =0; i <3; i++){
			Point ogre_init_pos =new Point(7,1);
			ogres.add(new Ogre(ogre_init_pos, 'O'));
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

		if (!hero.gotKey())
			drawCharacter(k);

		for(Ogre ogre: ogres){
			drawCharacter(ogre);
			drawCharacter(ogre.getClub());
		}

	}
	
	public void updateGame() {
		Point new_hero_pos, new_ogre_pos, new_club_pos;

		new_hero_pos = hero.getNewPosition(direction);
		hero.updateHero(getChar(new_hero_pos));


		if (hero.getState() == HeroState.K)
			hero.setChar('K');

		for(Ogre ogre: ogres){

			do {
				new_ogre_pos = ogre.getNewPosition();
			} while (!ogre.updateOgre(getChar(new_ogre_pos)));

			do {
				new_club_pos = ogre.getNewClubPosition();

			} while (!ogre.updateClub(getChar(new_club_pos)));
		}

		if (hero.getState() == HeroState.DOOR)
			openDoors();

		if (hero.getState() == HeroState.STAIR)
			state = LevelState.WON;

	}
	
	public void cleanCharacter(Character c) {
	
		map[c.getY()][c.getX()] = ' ';

	}
	
	public void cleanMap() {
		cleanCharacter(hero);

		for(Ogre ogre: ogres){

			if (isHeroCaptured(ogre))
				state = LevelState.LOST;
			if (isHeroCaptured(ogre.getClub()))
				state = LevelState.LOST;
			cleanCharacter(ogre);
			cleanCharacter(ogre.getClub());
		}

		if (!hero.gotKey())
			drawCharacter(k);

	}

	public void openDoors() {

		map[1][0] = 'S';
	}
	

}
