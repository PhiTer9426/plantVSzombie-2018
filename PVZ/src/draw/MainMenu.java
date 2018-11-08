package draw;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame{
	private Container container;
	private JPanel panel;
	private JLabel backgroud;
	private JButton adventure;
	
	
	public MainMenu() {
		// TODO Auto-generated constructor stub
		super("Plants Vs Zombies");
		this.setIconImage(new ImageIcon("plantsVsZombieMaterials/images/interface/SmallLogo.png").getImage());
//		this.setLayout(null);

		this.container = this.getContentPane();
		this.panel = new JPanel();
		this.backgroud = new JLabel(new ImageIcon("plantsVsZombieMaterials/images/interface/surface.jpg"));
		this.adventure = new JButton(new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_32.png"));
//		this.adventure.setPressedIcon(new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_32.png"));
//		this.adventure.setRolloverIcon(new ImageIcon("plantsVsZombieMaterials/images/interface/SelectorScreenAdventure_32.png"));
		
		this.panel.add(backgroud);
		this.panel.add(adventure);
		this.container.add(panel);
		
	//	adventure.setBounds(500, 100, 331, 292);
		
		this.setSize(900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
