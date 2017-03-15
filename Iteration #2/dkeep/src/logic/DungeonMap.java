package logic;

import java.util.ArrayList;


public class DungeonMap extends GameMap {

	public DungeonMap(char[][] map) {
		super(map);
		
	}
	

	public void clean(Hero hero, Character guard, Character k, ArrayList<Ogre> ogres) {
		cleanCharacter(hero);
		cleanCharacter(guard);

	}

	@Override
	public void update(Hero hero, Guard guard, Character k, Character club, ArrayList<Ogre> ogres) {
		drawCharacter(k);
		drawCharacter(hero);
		drawCharacter(guard);
	}

	
	

}