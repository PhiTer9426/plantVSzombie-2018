package draw;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import hero.Demon;
import hero.Elf;
import hero.Hero;
import plant.*;


public class GameView extends JLayeredPane {
	private JLabel backgroud;
	private JPanel plantCard;
	private JLabel button;
	private Hero hero;
	private JLabel shovelBack;
	private DrawPanel panel;
	private JLabel prePlant;
	private JLabel prePlantShadow;
	private JLabel end;
	
	private MainView parent;
	private Controller controller;
		
	private JLabel sunText;
	private JTextField sun;
	private String[] picked;
	private int level;
	
	public GameView(MainView parent, int level, String[] picked) {
		// TODO Auto-generated constructor stub
		this.level = level;
		this.setBounds(0, 0, 900, 600);
		this.parent = parent;
		this.controller = new Controller(this);
		this.backgroud = new JLabel();
		this.button = new JLabel();
		this.shovelBack =new JLabel();
		this.panel = new DrawPanel(this.controller,this);
		this.plantCard = new JPanel();
		this.prePlant = new JLabel();
		this.prePlantShadow = new JLabel();
		this.picked = picked;
		init(level);
		addListener();
	}
	
	public void init(int level) {
		//add background
		switch (level) {
		case 1:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/background1.jpg"));
			break;
		case 2:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/background2.jpg"));
			this.hero = new Elf(150, 0, this.controller);
			this.add(hero, new Integer(5));
			break;
		case 3:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/background3.jpg"));
			this.hero = new Demon(150, 0, this.controller);
			this.add(hero, new Integer(5));
			break;
		default:
			break;
		}
		backgroud.setBounds(0, 0, 900, 600);
		this.add(backgroud, new Integer(1));	

		//add menu button
		button.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
		button.setBounds(787, 0, 113, 41);
		this.add(button, new Integer(3));
		
		//add chanzi		
		shovelBack.setIcon(new ImageIcon("plantsVsZombieMaterials/images/interface/Shovel.png"));
		shovelBack.setBounds(348, 6, 100, 49);
		this.add(shovelBack, new Integer(3));
		
		//add drawPanel
		panel.setBounds(0, 0, 900, 600);
		this.add(this.panel, new Integer(2));
		
		//addCardBar
		this.plantCard.setBounds(0, 0, 110, 600);
		this.plantCard.setOpaque(false);
		this.plantCard.setLayout(null);;
		this.add(this.plantCard, new Integer(3));
		
		if (level == 2) {
			
		}
		if (level == 3) {
			
		}
		
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
		
		//add end
		this.setEnd(new JLabel());
		this.getEnd().setIcon(new ImageIcon("plantsVsZombieMaterials/images/interface/FinalWave.gif"));
		this.getEnd().setBounds(400, 100, 600, 400);
		this.end.setVisible(false);
		this.add(getEnd(), new Integer(5));
		
		for (int i = 0; i < picked.length; i++) {			
			switch (picked[i]) {
			case "WXZ":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 0));
				break;
			case "Peashooter":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 100));
				break;
			case "Repeater":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 200));
				break;
			case "SnowPea":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 175));
				break;
			case "WallNut":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 50));
				break;
			case "Torchwood":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 175));
				break;
			case "PotatoMine":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 25));
				break;
			case "Jalapeno":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 125));
				break;
			case "Chomper":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 150));
				break;
			case "Spikeweed":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 100));
				break;
			case "Threepeater":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 325));
				break;
			case "Squash":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 50));
				break;
			case "CherryBomb":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 150));
				break;
			case "TallNut":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 125));
				break;
			case "SunFlower":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 50));
				break;
			case "LilyPad":
				plantCard.add(new CardLabel(picked[i], i, this.controller, this, 200, 25));
				break;
			default:
				break;
			}
		}
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
		shovelBack.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setPreIcon(
						"plantsVsZombieMaterials/images/interface/SlantShovel.png",
						"plantsVsZombieMaterials/images/interface/SlantShovel.png");
				controller.setMouse("Shovel");
			}
		});
		
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					for(ProduceSun sun : controller.getSuns()) {
						if(e.getX() < sun.getPosX() + 80   &&
								e.getX() > sun.getPosX() - 80  &&
								e.getY() < sun.getPosY() + 100 &&
								e.getY() > sun.getPosY() - 100)
						{
							controller.getMovingSun().add(new SunMove(sun.getPosX(),sun.getPosY(),controller));
							addSunNumber(25);
							destroy(sun);
							break;
						}
					}
					if (e.getX() < 880 && e.getX() > 150 && e.getY() > 90 && e.getY() < 560) {
						addPlant((e.getX()-150)/81, (e.getY()-90)/92, controller.getMouse());
					}
				}
				else {
					controller.setMouse("");
					prePlant.setVisible(false);
					prePlantShadow.setVisible(false);
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
			if (plant.getPosX() == x && plant.getPosY() == y) {
				if(controller.getMouse().equals("Shovel")) {
					controller.getPlants().remove(plant);
					plant.setIs_alive(false);
					controller.setMouse("");
				}
				break;
			}
		}
		
		for (Plant plant : this.controller.getPlants()) {
			if(plant.getPosX() == x && plant.getPosY() == y && !plant.getName().equals("LilyPad")) {
				controller.setMouse("");
				break;
			}
		}
		
		if (level != 3 && name.equals("LilyPad")) {
			controller.setMouse("");
		}
		
		if (level == 3) {
			if(y != 2 && y != 3 && name.equals("LilyPad")) {
				controller.setMouse("");
			}
			
			else if(y == 2 || y == 3) {
				boolean flag1 = true;//有植物
				boolean flag2 = true;//有非睡莲
				for (Plant plant : this.controller.getPlants()) {
					//有植物
					if(plant.getPosX() == x && plant.getPosY() == y) {
						flag1 = false;
						break;
					}
					//有非睡莲
					if(plant.getPosX() == x && plant.getPosY() == y && !plant.getName().equals("LilyPad")) {
						controller.setMouse("");
						flag2 = false;
						break;
					}
				}
				//无植物
				if (flag1 && !name.equals("LilyPad")) {
					controller.setMouse("");
				}
				//无非睡莲
				if (!flag1 && flag2 && name.equals("LilyPad")) {
					controller.setMouse("");
				}
			}
		}

		
		switch (controller.getMouse()) {
		case "WXZ":
			this.controller.getPlants().add(new Wxz(x, y, controller));
			break;
		case "Peashooter":
			this.controller.getPlants().add(new Peashooter(x, y, controller));
			addSunNumber(-100);
			break;
		case "Repeater":
			this.controller.getPlants().add(new Repeater(x, y, controller));
			addSunNumber(-200);
			break;
		case "SnowPea":
			this.controller.getPlants().add(new SnowPea(x, y, controller));
			addSunNumber(-175);
			break;
		case "WallNut":
			this.controller.getPlants().add(new WallNut(x, y, controller));
			addSunNumber(-50);
			break;
		case "Torchwood":
			this.controller.getPlants().add(new Torchwood(x, y, controller));
			addSunNumber(-175);
			break;
		case "PotatoMine":
			this.controller.getPlants().add(new PotatoMine(x, y, controller));
			addSunNumber(-25);
			break;
		case "Jalapeno":
			this.controller.getPlants().add(new Jalapeno(x, y, controller));
			addSunNumber(-125);
			break;
		case "Chomper":
			this.controller.getPlants().add(new Chomper(x, y, controller));
			addSunNumber(-150);
			break;
		case "Spikeweed":
			this.controller.getPlants().add(new Spikeweed(x, y, controller));
			addSunNumber(-100);
			break;
		case "Threepeater":
			this.controller.getPlants().add(new Threepeater(x, y, controller));
			addSunNumber(-325);
			break;
		case "Squash":
			this.controller.getPlants().add(new Squash(x, y, controller));
			addSunNumber(-50);
			break;
		case "CherryBomb":
			this.controller.getPlants().add(new CherryBomb(x, y, controller));
			addSunNumber(-150);
			break;
		case "TallNut":
			this.controller.getPlants().add(new TallNut(x, y, controller));
			addSunNumber(-125);
			break;
		case "SunFlower":
			this.controller.getPlants().add(new SunFlower(x, y, controller));
			addSunNumber(-50);
			break;
		case "LilyPad":
			this.controller.getPlants().add(new LilyPad(x, y, controller));
			addSunNumber(-25);
			break;
		default:
			break;
		}
		controller.setMouse("");
		prePlant.setVisible(false);
		prePlantShadow.setVisible(false);
	}

	public void addSunNumber(int x) {
		controller.setSun(controller.getSun() + x);
		String s =String.valueOf(controller.getSun());
		sun.setText(s);
	}
	
	public void destroy(ProduceSun sun) {
		this.controller.getSuns().remove(sun);
	}
	
	public void setPreIcon(String preName, String PreShadow) {
		prePlant.setIcon(new ImageIcon(preName));
		prePlantShadow.setIcon(new ImageIcon(PreShadow));
	}

	public JLabel getEnd() {
		return end;
	}

	public void setEnd(JLabel end) {
		this.end = end;
	}
	
	public DrawPanel getPanel() {
		return panel;
	}
	
	public int getLevel() {
		return level;
	}
	
	public MainView getParent() {
		return parent;
	}
}
