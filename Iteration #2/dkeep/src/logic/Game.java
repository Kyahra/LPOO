package logic;

import logic.Hero;
import logic.Hero.HeroState;
import logic.Guard;
import logic.Ogre;

import java.awt.Point;

import java.util.ArrayList;

import java.util.Random;

import java.util.Scanner;

public class Game {

	public enum GameState {
		WON, RUNNING, LOST
	};

	private char[][] map_1 = { 
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

	private char[][] map_2 = {
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'k', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'H', ' ', '*', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };


	private GameState state;
	private String direction;
	private GameMap map; 
	
	public Game() {
		state = GameState.RUNNING;

		map = new DungeonMap(map_1);
	}

	public GameMap getMap() {
		return map;
	}
	

	public void setMap(GameMap map) {
		this.map = map;
	}

	
	public void setDirection(String direction) {
		this.direction = direction;
	}


	public void printMap() {
		map.printMap();

	}

	public void clean() {
		map.clean();
	
	}

	public void updateMap() {
		map.draw();
	
	}

	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		direction = keyboard.nextLine().toUpperCase();

	}

	public void updateGame() {
		
		map.update(direction);
		
		if (map instanceof DungeonMap && map.next()){
			map = new KeepMap(map_2,1);
		}
		
		if (map instanceof KeepMap && map.next()){
			state = GameState.WON;
		}
		
		 
	}


	public boolean isOver() {
		
		
		if(map.isOver()){
			state = GameState.LOST;
			return true;
		}
		
		
		if( state == GameState.WON) return true;
		
		
		return false;
	
	}

	public void printEnd() {
		System.out.println();
		System.out.println();

		switch (state) {
		case LOST:
			System.out.print("--------------");
			System.out.print(" GAME OVER ");
			System.out.print("--------------");
			break;
		case WON:
			System.out.println();
			System.out.println();

			System.out.print("---------------");
			System.out.print(" VICTORY ");
			System.out.print("---------------");
			break;
		default:
			break;
		}

	}
	



}
