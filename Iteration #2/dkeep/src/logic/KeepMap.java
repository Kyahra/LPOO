package logic;

import java.util.ArrayList;


public class KeepMap extends GameMap {

	public KeepMap(char[][] map) {
		super(map);

	} 
	
	// ao inicializar o map ler as componentes e atualizar variaveis que vai ser do map hero guard k etc
	// pode dar merda para a parte gráfica

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