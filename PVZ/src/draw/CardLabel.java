package draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.Controller;

public class CardLabel extends JLabel{
	private String name;
	private Controller controller;
	public CardLabel(ImageIcon icon, String name, int index, Controller controller) {
		// TODO Auto-generated constructor stub
		this.setIcon(icon);
		this.setBounds(10, 10 + index * 60, 100, 60);
		this.controller = controller;
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.setMouse(name);
			}
		});	
	}
}
