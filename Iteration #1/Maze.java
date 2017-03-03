import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class Maze {

	char[][] map_1 = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, 
			};
	
	char[][] map_2 = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'k', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, 
			};

	int rows = 10;
	int cols = 10;

	
	char hero = 'H';
			
	int hero_x = 1;
	int hero_y = 1;

	int new_x;
	int new_y;

	int guard_x_idx = 0;
	int guard_y_idx = 0;
	
	int ogre_x=1;
	int ogre_y=4;
	
	int club_x=2;
	int club_y=4;
	
	int[] guard_x= {1,1,2,3,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,5,4,3,2};
	int[] guard_y= {8,7,7,7,7,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,8,8,8,8};
	

	boolean lever = false;
	boolean move_guard = false;

	boolean lost= false;
	boolean won= false;
	
	boolean stop;
	boolean stair;
	
	int level =1;
	
	Random rand = new Random();
	

	public static void main(String[] args) {
		Maze m = new Maze();

		m.run();
	}


	public void run() {

		while (!lost && !won) {
	
		stop = false;
		
		updateGame();
		printMap();
		if(stop) continue;
		readMove();
		
		switch(level){
		case 1:
			makeMove1();
			updateGuard();
			break;
		case 2:
			makeMove2();
			updateOgre();
			swingClub();
			break;
		
		}

		
		}
		
		if(lost) Defeat();
		if(won) Victory();


	}

	public void printMap() {

		System.out.println();
	
		for (int i = 0; i < rows; i++) {
			System.out.print("          ");
			for (int j = 0; j < cols; j++) {

				switch(level){
				case 1:
					System.out.print(map_1[i][j] + " ");
					break;
					
				case 2:
					System.out.print(map_2[i][j] + " ");
					break;
				}
			}

			System.out.println();
		}

		System.out.println("\n Use the WASD keys to control the Hero.");
		System.out.print(" Your Move : ");

	}

	public void readMove() {

		Scanner keyboard = new Scanner(System.in);

		String input = keyboard.nextLine().toUpperCase();

		switch (input) {
		case "W":
			new_x = hero_x - 1;
			new_y = hero_y;
			break;
		case "A":
			new_x = hero_x;
			new_y = hero_y - 1;
			break;
		case "S":
			new_x = hero_x + 1;
			new_y = hero_y;
			break;
		case "D":
			new_x = hero_x;
			new_y = hero_y + 1;
			break;

		default:
			break;

		}

	}

	public void makeMove1() {
		

		if (map_1[new_x][new_y] == 'X' || map_1[new_x][new_y] == 'I'){
			move_guard = false;
			return;
		}

		if (map_1[new_x][new_y] == ' ') {

			if (lever) {
				map_1[hero_x][hero_y] = 'k';
				lever = false;
			} else
				map_1[hero_x][hero_y] = ' ';

			map_1[new_x][new_y] = 'H';

			hero_x = new_x;
			hero_y = new_y;
			
			move_guard = true;
			
			return;

		}
		
		if (map_1[new_x][new_y] == 'S') {
			stair = true;
			
			map_1[new_x][new_y] = 'H';

			hero_x = new_x;
			hero_y = new_y;
			
			
			return;

		}

		if (map_1[new_x][new_y] == 'k') {
			lever = true;
			openDoors();

			map_1[hero_x][hero_y] = ' ';

			map_1[new_x][new_y] = 'H';
			
			hero_x = new_x;
			hero_y = new_y;
			
			move_guard = true;
			return;

		}
			

	}
	
	public void makeMove2() {

		if (map_2[new_x][new_y] == ' ') {

			map_2[hero_x][hero_y] = ' ';

			map_2[new_x][new_y] = hero;

			hero_x = new_x;
			hero_y = new_y;
			
						
			return;

		}
		
		if (map_2[new_x][new_y] == 'k') {
			hero = 'K';

			map_2[hero_x][hero_y] = ' ';
			

			map_2[new_x][new_y] = hero;
			
			hero_x = new_x;
			hero_y = new_y;
			
			return;

		}
		
		
		
		if (map_2[new_x][new_y] == 'S') {
			stair = true;
			
			map_2[hero_x][hero_y] = ' ';
			
			map_2[new_x][new_y] = hero;

			hero_x = new_x;
			hero_y = new_y;
			
			
			return;

		}
		
		if (map_2[new_x][new_y] == 'I' && hero == 'K') map_2[new_x][new_y] = 'S'; 

			

	}

	public void openDoors() {

		switch(level){
		case 1:
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map_1[i][j] == 'I')
					map_1[i][j] = 'S';
			}
		}
		break;
		
		case 2:
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (map_2[i][j] == 'I')
						map_2[i][j] = 'S';
				}
			}
			break;
		
		}
	}
	
	public boolean isCaptured(int enemy_x , int enemy_y){
		
			if(hero_x == enemy_x+1 && hero_y == enemy_y)
				return true;
			
			if(hero_x == enemy_x-1 && hero_y == enemy_y)
				return true;
			
			if(hero_x == enemy_x && hero_y == enemy_y+1)
				return true;
			
			if(hero_x == enemy_x&& hero_y == enemy_y-1)
				return true;
		
		
		return false;
	}
	

	
	public void Defeat(){
		System.out.println();
		System.out.println();
		
		System.out.print("--------------");
		System.out.print(" GAME OVER ");
		System.out.print("--------------");
		
		
	}
	
	public void Victory(){
		System.out.println();
		System.out.println();
		
		System.out.print("---------------");
		System.out.print(" VICTORY ");
		System.out.print("---------------");
		
		
	}
	
	public void updateGuard(){
		
		if(!move_guard) return;
		
		map_1[guard_x[guard_x_idx]][guard_y[guard_y_idx]] = ' ';
				
		if(guard_x_idx >= 23){
			guard_x_idx =0;
			guard_y_idx =0;
		}else{
		guard_x_idx++;
		guard_y_idx++;
		}
		
		map_1[guard_x[guard_x_idx]][guard_y[guard_y_idx]] = 'G';
		
	}
	
	public void updateOgre(){
		int new_ogre_x = ogre_x;
		int new_ogre_y = ogre_y;
		int direction = rand.nextInt(4);
		
		
		switch(direction){
		case 0:
			new_ogre_x++;
			break;
		case 1:
			new_ogre_x--;
			break;
		case 2:
			new_ogre_y++;
			break;
		case 3:
			new_ogre_y--;
			break;
	
		}
		
		char next_pos = map_2[new_ogre_x][new_ogre_y];
		char actual_pos = map_2[ogre_x][ogre_y];
		
		if(next_pos == 'X' || next_pos == 'I') updateOgre();
		
		if(next_pos == ' '){
			
			if(actual_pos == '$') map_2[ogre_x][ogre_y] = 'k';
			if(actual_pos == 'O') map_2[ogre_x][ogre_y] = ' ';
			
			ogre_x = new_ogre_x;
			ogre_y = new_ogre_y;
			
			map_2[ogre_x][ogre_y] = 'O';
				
		}
		
		if(next_pos == 'k'){
			map_2[ogre_x][ogre_y] = ' ';
			 
			 ogre_x = new_ogre_x;
			ogre_y = new_ogre_y;
				
			map_2[ogre_x][ogre_y] = '$';
			 
			 
		}	
		
	}
	
	void swingClub(){
        int direction = rand.nextInt(4);
        int new_club_x= ogre_x;
        int new_club_y= ogre_y;
		
		
		switch(direction){
		case 0:
			new_club_x++;
			break;
		case 1:
			new_club_x--;
			break;
		case 2:
			new_club_y++;
			break;
		case 3:
			new_club_y--;
			break;
	
		}
		
		char next_pos = map_2[new_club_x][new_club_y];
		char actual_pos = map_2[club_x][club_y];
		
		if(next_pos == 'X' || next_pos == 'I') swingClub();
		
		if(next_pos == ' '){
			
			if(actual_pos == '$') map_2[club_x][club_y] = 'k';
			if(actual_pos == '*') map_2[club_x][club_y] = ' ';
			
			club_x = new_club_x;
			club_y = new_club_y;
			
			map_2[club_x][club_y] = '*';
				
		}
		
		if(next_pos == 'k'){
			map_2[club_x][club_y] = ' ';
			 
			club_x = new_club_x;
			club_y = new_club_y;
				
			map_2[club_x][club_y] = '$';
			 
			 
		}	
		
	}
	
	void updateGame(){
		
		switch(level){
			case 1:
				if(isCaptured(guard_x[guard_x_idx],guard_y[guard_y_idx])) {
					stop = true;
					lost = true;
				}
				
				if(stair){
					level++;
					hero_x = 8;
					hero_y =1;
					
					stair = false;
					stop = true;
				}
				
				break;
				
			case 2:
				if(isCaptured(ogre_x, ogre_y) || isCaptured(club_x,club_y)){
					stop = true;
					lost = true;
				}
				
				if(stair){
					won = true;
					
					stair = false;
					stop = true;
				}
				break;
				
				
		}
	}
}

	


