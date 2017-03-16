package logic;

import java.awt.Point;
import java.util.ArrayList;

import logic.Hero.HeroState;

public class KeepMap extends GameMap {

	private Hero hero;
	private Character key;
	private Character club;
	private ArrayList<Ogre> ogres = new ArrayList<Ogre>();

	boolean won = false;

	public KeepMap(char[][] map, int num_ogres) {
		super(map);

		Point hero_pos = super.searchChar('H');
		Point club_pos = super.searchChar('*');
		Point key_pos = super.searchChar('k');

		hero = new Hero(hero_pos);
		key = new Character(key_pos, 'k');
		club = new Character(club_pos, '*');

		for (int i = 0; i < num_ogres; i++)
			ogres.add(new Ogre(new Point(7, 1), 'O'));

	}

	@Override
	public void update(String direction) {
		Point new_ogre_pos;
		Point new_club_pos;

		hero.move(direction, this);

		if (hero.gotKey())
			hero.setChar('K');

		for (Ogre ogre : ogres) {

			do {
				new_ogre_pos = ogre.getNewPosition();
			} while (!ogre.updateOgre(getChar(new_ogre_pos)));

			do {
				new_club_pos = ogre.getNewClubPosition();

			} while (!ogre.updateClub(getChar(new_club_pos)));

		}

		if (hero.getState() == HeroState.DOOR && hero.gotKey())
			openDoors();

		if (hero.getState() == HeroState.STAIR)
			won = true;

	}

	@Override
	public void clean() {
		cleanCharacter(hero);

		for (Ogre ogre : ogres) {
			cleanCharacter(ogre);
			cleanCharacter(ogre.getClub());
		}

	}

	@Override
	public void draw() {
		drawCharacter(hero);

		if (!hero.gotKey())
			drawCharacter(key);

		if (!hero.isArmed())
			drawCharacter(club);

		for (Ogre ogre : ogres) {
			drawCharacter(ogre);
			drawCharacter(ogre.getClub());
		}

	}

	@Override
	public boolean isOver() {
		for (Ogre ogre : ogres) {

			if (isCaptured(ogre, hero) && hero.isArmed())
				ogre.getStuned();

			if (isCaptured(hero, ogre) && !hero.isArmed()) {
				return true;
			}

			if (isCaptured(hero, ogre.getClub())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean next() {
		return won;
	}


}