package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import controller.Controller;

public class CardLabel extends JLabel{
	public CardLabel(String name, int index,
			Controller controller, GameView game) {
		// TODO Auto-generated constructor stub
		this.setIcon(new ImageIcon(
				"plantsVsZombieMaterials/images/Card/Plants/" + name + "_01.gif"));
		this.setBounds(10, index * 60, 100, 60);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.setMouse(name);
				game.setPreIcon(
						"plantsVsZombieMaterials/images/Plants/" + name + "/" + name + ".gif",
						"plantsVsZombieMaterials/images/Plants/" + name + "/" + name + ".gif");
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});	
	}
}
