package draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;
import plant.Peashooter;

public class GameView extends JLayeredPane {
	private JLabel backgroud;
	private JPanel plantCard;
	private JLabel button;
	private DrawPanel panel;
	
	private MainView parent;
	private Controller controller;
	
	
	public GameView(MainView parent) {
		// TODO Auto-generated constructor stub
		this.setBounds(0, 0, 900, 600);
		this.parent = parent;
		parent.getContainer().add(this);
		this.controller = new Controller();
		init();
		addListener();
	}
	
	public void init() {
		//add backgroud
		backgroud = new JLabel();
		backgroud.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/background1.jpg"));
		backgroud.setBounds(0, 0, 900, 600);
		this.add(backgroud, new Integer(1));	

		//add menu button
		button = new JLabel();
		button.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
		button.setBounds(787, 0, 113, 41);
		this.add(button, new Integer(3));
		
		//add drawPanel in game
		this.panel = new DrawPanel(this.controller);
		panel.setBounds(0, 0, 900, 600);
		this.add(this.panel, new Integer(2));
		
		//addCardBar
		this.plantCard = new JPanel();
		this.plantCard.setBounds(0, 0, 110, 600);
		this.plantCard.setOpaque(false);
		this.add(this.plantCard, new Integer(3));
		
		JLabel card1 = new JLabel();
		card1.setIcon(new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/Peashooter.png"));
		card1.setBounds(10, 10, 100, 60);
		plantCard.add(card1);
		
		card1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.setMouse(1);
			}
		});	
	}
	
	
	
	public void addListener() {
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				button.setBounds(787, 2, 113, 41);
			}				
			public void mouseClicked(MouseEvent e) {
				parent.showMenu();
			}
			public void mouseExited(MouseEvent e) {
				button.setBounds(787, 0, 113, 41);
			}	
		});	
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					if (e.getX() < 880 && e.getX() > 150 && e.getY() > 90 && e.getY() < 600
							&& controller.getMouse() == 1) {
						addPlant((e.getX()-150)/81, (e.getY()-90)/92);
						controller.setMouse(0);
					}
				}
			}
		});	
	}
	
	public void addPlant(int x, int y) {
		this.controller.getPlants().add(new Peashooter(x, y));
	}
}
