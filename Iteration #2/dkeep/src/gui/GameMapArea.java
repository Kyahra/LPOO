package gui;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.Point;

import com.sun.prism.paint.Color;

public class GameMapArea extends JPanel {

	private ImageIcon wall;
	private ImageIcon guard;
	private ImageIcon black_cell;
	private ImageIcon hero;
	private ImageIcon key;
	private ImageIcon door;
	private ImageIcon ogre;
	private ImageIcon club;
	private ImageIcon stuned_ogre;
	private ImageIcon armed_hero;
	private ImageIcon end;
	
	
	public GameMapArea(int width, int height) {
		super();

		this.setBorder(new EmptyBorder(4, 4, 4, 4));

		setBackground(java.awt.Color.BLACK);
		this.setSize(width, height);
		this.setLayout(new GridLayout(10, 10));

		loadImages();



	}

	private void loadImages() {

		wall = new ImageIcon(this.getClass().getResource("res/wall.png"));

		guard = new ImageIcon(this.getClass().getResource("res/guard.png"));
		black_cell = new ImageIcon(this.getClass().getResource("res/black.png"));
		hero = new ImageIcon(this.getClass().getResource("res/heroWing.png"));
		key = new ImageIcon(this.getClass().getResource("res/key.png"));
		door = new ImageIcon(this.getClass().getResource("res/door.png"));
		ogre = new ImageIcon(this.getClass().getResource("res/ogre.png"));
		club = new ImageIcon(this.getClass().getResource("res/club.png"));
		stuned_ogre = new ImageIcon(this.getClass().getResource("res/stuned_ogre.png"));
		armed_hero = new ImageIcon(this.getClass().getResource("res/heroSuperWing.png"));
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
		armed_hero = scaleImage(armed_hero);
		//end = scaleEnd(end);

	}

	private ImageIcon scaleImage(ImageIcon im) {

		Image img = im.getImage();
		Image newimg = img.getScaledInstance(this.getWidth() / 10, this.getHeight() / 10, Image.SCALE_FAST);

		return new ImageIcon(newimg);
	}

	private ImageIcon scaleEnd(ImageIcon im) {

		Image img = im.getImage();
		Image newimg = img.getScaledInstance(this.getWidth() / 2, this.getHeight() * 2, Image.SCALE_FAST);

		return new ImageIcon(newimg);
	}
	
	public void paintComponent () {
		Point p = new Point();
		char c;

		for (int i = 0; i < GameWindow.getMap().getRows(); i++)
			for (int j = 0; j < GameWindow.getMap().getCols(); j++) {

				p.setLocation(j, i);
				c = GameWindow.getMap().getChar(p);

				switch (c) {
				case 'X':
					this.add(new JLabel(wall));
					break;
				case 'I':
					this.add(new JLabel(wall));
					break;
				case 'G':
					this.add(new JLabel(ogre));
					break;
				case 'H':
					this.add(new JLabel(hero));
					break;
				case 'k':
					this.add(new JLabel(key));
					break;
				case 'S':
					this.add(new JLabel(door));
					break;
				case 'O':
					this.add(new JLabel(ogre));
					break;
				case '*':
					this.add(new JLabel(club));
					break;
				case '$':
					this.add(new JLabel(club));
					break;
				case 'A':
					this.add(new JLabel(armed_hero));
					break;
				case 'K':
					this.add(new JLabel(hero));
					break;
				case '8':
					this.add(new JLabel(stuned_ogre));
					break;
				case 'g':
					this.add(new JLabel(stuned_ogre));
					break;
				default:
					this.add(new JLabel(black_cell));
					break;
				}

			}
		

	}
	
	public void paintEnd(){
		
		this.add(new JLabel(end));
	}
	
	public void update(){
		removeAll();

		repaint();
		
		paintComponent();
		
		revalidate();
	}

}