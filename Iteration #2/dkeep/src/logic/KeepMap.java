package logic;

import java.util.ArrayList;

import logic.Game.GameState;
import logic.Hero.HeroState;

public class KeepMap extends GameMap {

	KeepMap(char[][] map) {
		super(map);

	}

	public void clean(Hero hero, Character guard, Character k, ArrayList<Ogre> ogres) {
		cleanCharacter(hero);

		for (Ogre ogre : ogres) {
			cleanCharacter(ogre);
			cleanCharacter(ogre.getClub());
		}

	}

	@Override
	public void update(Hero hero, Guard guard, Character k, Character club, ArrayList<Ogre> ogres) {
		drawCharacter(hero);

		if (!hero.gotKey())
			drawCharacter(k);

		if (!hero.isArmed())
			drawCharacter(club);

		for (Ogre ogre : ogres) {
			drawCharacter(ogre);
			drawCharacter(ogre.getClub());
		}

	}

}