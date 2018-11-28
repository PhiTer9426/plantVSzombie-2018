package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.Controller;

public class PickCardLabel extends JLabel{
	
	private boolean isChoosed;
	
	public PickCardLabel(String name, int index, PickCardView View) {
		// TODO Auto-generated constructor stub
		this.isChoosed = false;
		this.setIcon(new ImageIcon(
				"plantsVsZombieMaterials/images/Card/Plants/" + name + "_03.gif"));
		this.setBounds(13 + (index % 4) * 113,
				50 + (index / 4) * 60,
				100, 60);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {				
				if (isChoosed) {
					View.removeCard(name);
					setIcon(new ImageIcon("plantsVsZombieMaterials/images/Card/"
							+ "Plants/" + name + "_03.gif"));
				}
				else {
					View.setCard(name);
					setIcon(new ImageIcon("plantsVsZombieMaterials/images/Card/"
							+ "Plants/" + name + "_01.gif"));
				}
				isChoosed = !isChoosed;
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});	
	}
}
