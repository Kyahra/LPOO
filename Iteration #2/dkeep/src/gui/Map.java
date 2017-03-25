package gui;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Map  extends JPanel {
	
	protected ImageIcon wall;
	protected ImageIcon guard;
	protected ImageIcon black_cell;
	protected ImageIcon hero;
	protected ImageIcon key;
	protected ImageIcon door;
	protected ImageIcon ogre;
	protected ImageIcon club;
	protected ImageIcon stuned_ogre;
	protected ImageIcon armed_hero;
	protected ImageIcon end;
	
	public Map() {
		super();

	}
	
	protected void loadImages() {

		wall = new ImageIcon(this.getClass().getResource("res/wall.png"));

		guard = new ImageIcon(this.getClass().getResource("res/guard.png"));
		black_cell = new ImageIcon(this.getClass().getResource("res/black.png"));
		hero = new ImageIcon(this.getClass().getResource("res/HeroR.png"));
		key = new ImageIcon(this.getClass().getResource("res/Key3.png"));
		door = new ImageIcon(this.getClass().getResource("res/door.png"));
		ogre = new ImageIcon(this.getClass().getResource("res/ogre.png"));
		club = new ImageIcon(this.getClass().getResource("res/Sword.png"));
		stuned_ogre = new ImageIcon(this.getClass().getResource("res/stuned_ogre.png"));
		end = new ImageIcon(this.getClass().getResource("res/end.png"));

		wall = scaleImage(wall);
		guard = scaleImage(guard);
		black_cell = scaleImage(black_cell);
		hero = scaleImage(hero);
		key = scaleImage(key);
		door = scaleImage(door);
		ogre = scaleImage(ogre);
		club = scaleImage(club);
		stuned_ogre= scaleImage(stuned_ogre);
	

	}

	private ImageIcon scaleImage(ImageIcon im) {

		Image img = im.getImage();
		Image newimg = img.getScaledInstance(this.getWidth() / 10, this.getHeight() / 10, Image.SCALE_FAST);

		return new ImageIcon(newimg);
	}

}
