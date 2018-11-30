package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PassLevel extends JPanel{
	
	private JLabel backgroud;
	private JLabel button;
	private MainView parent;
	
	private int level;
	
	public PassLevel(int level, MainView parent) {
		// TODO Auto-generated constructor stub
		this.level = level;
		this.button = new JLabel();
		this.backgroud = new JLabel();
		this.parent = parent;
		init();
		
	}
	
	public void init() {
		switch (level) {
		case 1:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/Hearo_Demon.jpg"));
			break;
		case 2:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/Hearo_Elf.jpg"));
			break;
		case 3:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/background3.jpg"));
			break;
		default:
			break;
		}
		backgroud.setBounds(0, 0, 900, 600);
		this.add(backgroud);
		
		this.button.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/background3.jpg"));
		this.button.setBounds(300, 200, 100, 50);
		this.add(button);
		
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}				
			public void mouseClicked(MouseEvent e) {
				parent.showPickup();
				parent.setLevel(level+1);
			}
		});	
	}
}
