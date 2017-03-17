package logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import logic.Game.GameState;
import logic.Hero.HeroState;

public class DungeonMap extends GameMap {

	private Guard guard;
	private Character lever;

	boolean next_map = false;

	public DungeonMap(char[][] map, char g) {
		super(map);
		Point hero_pos = super.searchChar('H');
		Point guard_pos = super.searchChar('G');
		Point lever_pos = super.searchChar('k');

		hero = new Hero(hero_pos);
		lever = new Character(lever_pos, 'k');

		switch (g) {
		case 'S':
			guard = new Suspicious(guard_pos);
			break;
		case 'R':
			guard = new Rookie(guard_pos);
			break;
		case 'D':
			guard = new Drunken(guard_pos);
			break;

		}
	}

	@Override
	public void update(String direction) {

		hero.move(direction, this);

		guard.updateGuard();

		if (hero.getState() == HeroState.STAIR) {
			next_map = true;
			hero.setKey(false);

		}

		if (hero.gotKey())
			super.openDoors();

	}

	@Override
	public void draw() {
		drawCharacter(lever);
		drawCharacter(hero);
		drawCharacter(guard);
	}

	@Override
	public void clean() {
		cleanCharacter(hero);
		cleanCharacter(guard);

	}

	public boolean isOver() {

		return super.isCaptured(hero, guard);
			
	}
	
	public boolean next(){
		return next_map;
	}
	
	public void setGuard(Guard g){
		guard = g;
	}
	
	public Guard getGuard(){
		return guard;
	}

}