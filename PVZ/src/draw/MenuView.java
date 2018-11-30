package draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MenuView extends JLayeredPane {
	private MainView parent;
	private JLabel backgroud;
	private JPanel menu;
	private JLabel adventure;
	
	public MenuView(MainView parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.setBounds(0, 0, 900, 600);	
		init();
		addListener();
	}
	
	public void init() {
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
			
		this.add(backgroud, new Integer(1));
		this.add(menu, new Integer(2));
	}

	public void addListener() {
		adventure.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				adventure.setBounds(0, 5, 331, 146);
			}				
			public void mouseClicked(MouseEvent e) {
				parent.showPickup();
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
