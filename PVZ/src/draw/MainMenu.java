package draw;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainMenu extends JFrame{
	private Container container;
	private JLayeredPane pane;
	
	private JLayeredPane Menu;
	private JLayeredPane game;
	
	public MainMenu() {
		// TODO Auto-generated constructor stub
		super("Plants Vs Zombies");
		this.setIconImage(new ImageIcon("plantsVsZombieMaterials/images/interface/SmallLogo.png").getImage());

		this.container = this.getContentPane();
		this.pane = new JLayeredPane();
		pane.setLayout(null);
		
		
		initMenu();
		
		initGame();
		
		this.container.add(pane);
		
		this.setSize(900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void showGame() {
		this.pane.setLayer(Menu, new Integer(1));
		this.pane.setLayer(game, new Integer(2));
	}
	
	public void showMenu() {
		this.pane.setLayer(Menu, new Integer(2));
		this.pane.setLayer(game, new Integer(1));
	}
	

	public void initMenu() {
		JLabel backgroud;
		JPanel menu;
		JLabel adventure;

		this.Menu = new JLayeredPane();
		this.Menu.setBounds(0, 0, 900, 600);		
		this.pane.add(Menu, new Integer(2));
		
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
		JPanel toolbar;
		JLabel button;
		
		this.game = new JLayeredPane();
		this.game.setBounds(0, 0, 900, 600);
		this.pane.add(game, new Integer(1));
		
		backgroud = new JLabel();
		backgroud.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/background1.jpg"));
		backgroud.setBounds(0, 0, 900, 600);
		this.game.add(backgroud, new Integer(1));	
		
		button = new JLabel();
		button.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
		button.setBounds(787, 0, 113, 41);
		this.game.add(button, new Integer(2));
		
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
	}
	
}
