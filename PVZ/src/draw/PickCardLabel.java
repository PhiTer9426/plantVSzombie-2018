package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.Controller;

public class PickCardLabel extends JLabel{
	public PickCardLabel(String name, int index,
			Controller controller, PickCardView View) {
		// TODO Auto-generated constructor stub
		this.setIcon(new ImageIcon(
				"plantsVsZombieMaterials/images/Card/Plants/" + name + "_01.gif"));
		//this.setBounds(10, 10 + index * 60, 100, 60);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				View.setCard(name, index);
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});	
	}
}
