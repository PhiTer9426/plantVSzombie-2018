 package draw;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import plant.Peashooter;
import plant.Plant;


public class MainView extends JFrame{
	private Container container;
	private JLayeredPane Menu;
	private JLayeredPane game;
	private DrawPanel panel;
	private Controller controller;
	
	public MainView(Controller controller) {
		// TODO Auto-generated constructor stub
		super("Plants Vs Zombies");
		this.setIconImage(new ImageIcon("plantsVsZombieMaterials/images/interface/SmallLogo.png").getImage());
		this.container = this.getContentPane();	
		this.controller = controller;
		
		initMenu();		
		initGame();
		showMenu();
		
		this.setSize(918, 645);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void showGame() {
		game.setVisible(true);
		Menu.setVisible(false);
	}
	
	public void showMenu() {
		game.setVisible(false);
		Menu.setVisible(true);
	}
	

	public void initMenu() {
		JLabel backgroud;
		JPanel menu;
		JLabel adventure;

		this.Menu = new JLayeredPane();
		this.Menu.setBounds(0, 0, 900, 600);		
		this.container.add(Menu);
		
		backgroud = new JLabel();
		backgroud.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/surface.jpg"));
		backgroud.setBounds(0, 0, 900, 600);		
			
		menu = new JPanel();
		menu.setBounds(470, 70, 350, 500);
		menu.setLayout(null);
		menu.setOpaque(false);
			
		adventure = new JLabel();
		adventure.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_1.png"));
		adventure.setBounds(0, 0, 331, 146);
			
		menu.add(adventure);		
			
		this.Menu.add(backgroud, new Integer(1));
		this.Menu.add(menu, new Integer(2));
		
		adventure.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				adventure.setBounds(0, 5, 331, 146);
			}				
			public void mouseClicked(MouseEvent e) {
				showGame();
			}				
			public void mouseEntered(MouseEvent e) {
				adventure.setIcon(
						new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_2.png"));
			}
			public void mouseExited(MouseEvent e) {
				adventure.setIcon(
						new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_1.png"));
				adventure.setBounds(0, 0, 331, 146);
			}
		});		
	}

	public void initGame() {
		JLabel backgroud;
		JPanel plantCard;
		JLabel button;
		
		
		this.game = new JLayeredPane();
		this.game.setBounds(0, 0, 900, 600);
		this.container.add(game);
		
		//add backgroud		
		backgroud = new JLabel();
		backgroud.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/background1.jpg"));
		backgroud.setBounds(0, 0, 900, 600);
		this.game.add(backgroud, new Integer(1));	
		
		//add drawPanel in game
		this.panel = new DrawPanel(this.controller);
		panel.setBounds(0, 0, 900, 600);
		this.game.add(this.panel, new Integer(2));
		
		//add menu button
		button = new JLabel();
		button.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
		button.setBounds(787, 0, 113, 41);
		this.game.add(button, new Integer(3));
		
		
		//add listenner
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				button.setBounds(787, 2, 113, 41);
			}				
			public void mouseClicked(MouseEvent e) {
				showMenu();
			}
			public void mouseExited(MouseEvent e) {
				button.setBounds(787, 0, 113, 41);
			}	
		});	
		
		this.game.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					addPlant((e.getX()-150)/81, (e.getY()-90)/92);
				}
			}
		});	
	}
	
	public void addPlant(int x, int y) {
		int[][] a = this.controller.getMap();
		if (0 == a[x][y]) {
			this.controller.getPlants().add(new Peashooter(x, y));		
			a[x][y] = 1;
			this.controller.setMap(a);
		}		
	}
	
}
