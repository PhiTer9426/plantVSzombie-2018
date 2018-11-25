package draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;
import plant.*;

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

		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/WXZ.png"), "WXZ", 0, this.controller));

		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/Peashooter_01.gif"), "Peashooter", 1, this.controller));
	
		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/SnowPea_01.gif"), "SnowPea", 2, this.controller));
		
		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/WallNut_01.gif"), "WallNut", 3, this.controller));
		
		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/TallNut_01.gif"), "TallNut", 4, this.controller));
		
		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/PotatoMine_01.gif"), "PotatoMine", 5, this.controller));
		
		plantCard.add(new CardLabel(
				new ImageIcon("plantsVsZombieMaterials/images/Card/Plants/CherryBomb_01.gif"), "CherryBomb", 6, this.controller));
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
					if (e.getX() < 880 && e.getX() > 150 && e.getY() > 90 && e.getY() < 560) {
						addPlant((e.getX()-150)/81, (e.getY()-90)/92, controller.getMouse());
					}
				}
			}
		});	
	}
	
	public void addPlant(int x, int y, String name) {
		for (Plant plant : this.controller.getPlants()) {
			if (plant.getPosX() == x && plant.getPosY() == y) {
				controller.setMouse("");
				break;
			}
		}
		switch (controller.getMouse()) {
		case "WXZ":
			this.controller.getPlants().add(new Wxz(x, y, controller));
			break;
		case "Peashooter":
			this.controller.getPlants().add(new Peashooter(x, y, controller));
			break;
		case "SnowPea":
			this.controller.getPlants().add(new SnowPea(x, y, controller));
			break;
		case "WallNut":
			this.controller.getPlants().add(new WallNut(x, y, controller));
			break;
		case "TallNut":
			this.controller.getPlants().add(new TallNut(x, y, controller));
			break;
		case "PotatoMine":
			this.controller.getPlants().add(new PotatoMine(x, y, controller));
			break;
		case "CherryBomb":
			this.controller.getPlants().add(new CherryBomb(x, y, controller));
			break;
		default:
			break;
		}
		controller.setMouse("");
	}
}
