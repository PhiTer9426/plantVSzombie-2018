package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PassLevel extends JLayeredPane{
	
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
					"plantsVsZombieMaterials/images/interface/Hearo_Elf.jpg"));
			break;
		case 2:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/Hearo_Demon.jpg"));
			break;
		case 3:
			backgroud.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/Passall.jpg"));
			break;
		default:
			break;
		}
		backgroud.setBounds(0, 0, 900, 600);
		this.add(backgroud, new Integer(1));
		
		
		if (level == 3) {
			this.button.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/finish.png"));
		}
		else {
			this.button.setIcon(new ImageIcon(
					"plantsVsZombieMaterials/images/interface/next.png"));
		}
		
		this.button.setBounds(400, 500, 102, 38);
		this.add(button, new Integer(2));
		
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if (level == 3) {
					parent.showMenu();
				}
				else {
					parent.showPickup();
					parent.setLevel(level+1);
				}
			}
		});	
	}
}
