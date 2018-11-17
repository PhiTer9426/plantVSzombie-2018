package draw;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.Controller;
import plant.Plant;

public class DrawPanel extends JPanel{
	private Controller controller;

	public DrawPanel(Controller controller) {
		this.controller = controller;
		this.setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (controller.getPlants() != null) {
			for (Plant plant : controller.getPlants()) {
				g.drawImage(
						plant.getImage(), 
						150 + 81 + 81 * plant.getPosX() - plant.getImage().getWidth(null),
						90 + 92 + 92 * plant.getPosY() - plant.getImage().getHeight(null), null);
			}
		}
	}
}
