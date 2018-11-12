package draw;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainMenu extends JFrame{
	private Container container;
	private JLayeredPane pane;
	private JLabel backgroud;
	private JPanel menu;
	private JLabel adventure;
	
	
	public MainMenu() {
		// TODO Auto-generated constructor stub
		super("Plants Vs Zombies");
		this.setIconImage(new ImageIcon("plantsVsZombieMaterials/images/interface/SmallLogo.png").getImage());
		init();
		addListen();
	}
	
	private void init() {
		this.container = this.getContentPane();
		this.pane = new JLayeredPane();
		pane.setLayout(null);

		this.backgroud = new JLabel();
		this.backgroud.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/surface.jpg"));
		this.backgroud.setBounds(0, 0, 900, 600);		
		
		this.menu = new JPanel();
		this.menu.setBounds(470, 70, 350, 500);
		menu.setLayout(null);
		menu.setOpaque(false);
		
		this.adventure = new JLabel();
		this.adventure.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_1.png"));
		this.adventure.setBounds(0, 0, 331, 146);
		
		menu.add(adventure);		
		
		this.pane.add(backgroud, new Integer(1));
		this.pane.add(menu, new Integer(2));
		
		this.container.add(pane);
		
		this.setSize(900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addListen() {
		this.adventure.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				adventure.setBounds(0, 5, 331, 146);
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
}
