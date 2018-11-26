package draw;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

import plant.Peashooter;
import plant.Plant;
import plant.Sun;
import plant.Wxz;

import plant.*;


public class GameView extends JLayeredPane {
	private JLabel backgroud;
	private JPanel plantCard;
	private JLabel button;
	private DrawPanel panel;
	private JLabel prePlant;
	private JLabel prePlantShadow;
	
	private MainView parent;
	private Controller controller;
	
	private JLabel sunText;
	private JTextField sun;
	
	public GameView(MainView parent) {
		// TODO Auto-generated constructor stub
		this.setBounds(0, 0, 900, 600);
		this.parent = parent;
		parent.getContainer().add(this);
		this.controller = new Controller();
		this.backgroud = new JLabel();
		this.button = new JLabel();
		this.panel = new DrawPanel(this.controller);
		this.plantCard = new JPanel();
		this.prePlant = new JLabel();
		this.prePlantShadow = new JLabel();
		init();
		addListener();
	}
	
	public void init() {
		//add backgroud
		backgroud.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/background1.jpg"));
		backgroud.setBounds(0, 0, 900, 600);
		this.add(backgroud, new Integer(1));	

		//add menu button
		button.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
		button.setBounds(787, 0, 113, 41);
		this.add(button, new Integer(3));
		
		//add drawPanel in game
		panel.setBounds(0, 0, 900, 600);
		this.add(this.panel, new Integer(2));
		
		//addCardBar
		this.plantCard.setBounds(0, 0, 110, 600);
		this.plantCard.setOpaque(false);
		this.plantCard.setLayout(null);;
		this.add(this.plantCard, new Integer(3));
		
		
		this.add(prePlant, new Integer(4));
		this.add(prePlantShadow, new Integer(3));	


		//addText
		this.sunText=new JLabel();
		this.sunText.setIcon(new ImageIcon("plantsVsZombieMaterials/images/interface/SunBack.png"));
		this.sunText.setBounds(600,0,113,41);
		//this.sunText .setEditable(false);
		this .add(this.sunText ,new Integer(3));
		
		sun = new JTextField();
		sun.setBounds(640,0,113,41);
		sun.setOpaque(false);
		sun.setBorder(null);
		sun.setEditable(false);
		sun.setText("50");
		this.add(this. sun,new Integer(4));
		

		plantCard.add(new CardLabel("WXZ", 0, this.controller, this));
	
		plantCard.add(new CardLabel("Peashooter", 1, this.controller, this));

		plantCard.add(new CardLabel("SnowPea", 2, this.controller, this));
		
		plantCard.add(new CardLabel("WallNut", 3, this.controller, this));
		
		plantCard.add(new CardLabel("Torchwood", 4, this.controller, this));
		
		plantCard.add(new CardLabel("PotatoMine", 5, this.controller, this));
		
		plantCard.add(new CardLabel("Jalapeno", 6, this.controller, this));
		
		plantCard.add(new CardLabel("Chomper", 7, this.controller, this));
		
		plantCard.add(new CardLabel("Spikeweed", 8, this.controller, this));
		
		plantCard.add(new CardLabel("Threepeater", 9, this.controller, this));
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
					for(Sun sun : controller.getSuns()) {
						if(e.getX() < sun.getPosX() + 80   &&
								e.getX() > sun.getPosX() - 80  &&
								e.getY() < sun.getPosY() + 100 &&
								e.getY() > sun.getPosY() - 100)
						{
							addSunNumber();
							destroy(sun);
							break;
						}
					}
						
					
					if (e.getX() < 880 && e.getX() > 150 && e.getY() > 90 && e.getY() < 560) {
						addPlant((e.getX()-150)/81, (e.getY()-90)/92, controller.getMouse());
					}
				}
			}
		});	
		
		this.addMouseMotionListener(new MouseAdapter() {			
			public void mouseMoved(MouseEvent e) {
				if (!controller.getMouse().equals("")) {
					prePlant.setVisible(true);
					prePlant.setBounds(
							e.getX() - prePlant.getIcon().getIconWidth() +40, 
							e.getY() - prePlant.getIcon().getIconHeight() +45,
							prePlant.getIcon().getIconWidth(), 
							prePlant.getIcon().getIconHeight());
					if (e.getX() < 880 && e.getX() > 150 && e.getY() > 90 && e.getY() < 560) {
						prePlantShadow.setBounds(
								150 + 81 + ((e.getX()-150)/81)*81 - prePlantShadow.getIcon().getIconWidth(), 
								90 + 92 + ((e.getY()-90)/92)*92 - prePlantShadow.getIcon().getIconHeight(), 
								prePlantShadow.getIcon().getIconWidth(), 
								prePlantShadow.getIcon().getIconHeight());
						prePlantShadow.setVisible(true);
					}
				}
				else {
					prePlant.setVisible(false);
					prePlantShadow.setVisible(false);
				}
			}
		});	
	}
	
	public void addPlant(int x, int y, String name) {
		for (Plant plant : this.controller.getPlants()) {
			if (plant.getPosX() == x && plant.getPosY() == y) {      //���ô��Ƿ���ֲ��
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
		case "Repeater":
			this.controller.getPlants().add(new Repeater(x, y, controller));
			break;
		case "SnowPea":
			this.controller.getPlants().add(new SnowPea(x, y, controller));
			break;
		case "WallNut":
			this.controller.getPlants().add(new WallNut(x, y, controller));
			break;
		case "Torchwood":
			this.controller.getPlants().add(new Torchwood(x, y, controller));
			break;
		case "PotatoMine":
			this.controller.getPlants().add(new PotatoMine(x, y, controller));
			break;
		case "Jalapeno":
			this.controller.getPlants().add(new Jalapeno(x, y, controller));
			break;
		case "Chomper":
			this.controller.getPlants().add(new Chomper(x, y, controller));
			break;
		case "Spikeweed":
			this.controller.getPlants().add(new Spikeweed(x, y, controller));
			break;
		case "Threepeater":
			this.controller.getPlants().add(new Threepeater(x, y, controller));
			break;
		case "Squash":
			this.controller.getPlants().add(new Squash(x, y, controller));
			break;
		case "CherryBomb":
			this.controller.getPlants().add(new CherryBomb(x, y, controller));
			break;
		case "TallNut":
			this.controller.getPlants().add(new TallNut(x, y, controller));
			break;
		default:
			break;
		}
		controller.setMouse("");
	}

	
	public void addSunNumber() {
		controller.setSun(controller.getSun() + 50);
		String s =String.valueOf(controller.getSun());
		sun.setText(s);
	}
	
	public void destroy(Sun sun) {
		this.controller.getSuns().remove(sun);
	}
	public void setPreIcon(String preName, String PreShadow) {
		prePlant.setIcon(new ImageIcon(preName));
		prePlantShadow.setIcon(new ImageIcon(PreShadow));
	}
}
