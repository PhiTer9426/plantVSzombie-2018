package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.Pea;
import controller.Controller;

public class Peashooter extends PlantShooter {
	public Peashooter(int x, int y, Controller controller) {		
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1200);
		this.setPrice(100);
		this.setName("Peashooter");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/Peashooter/Peashooter.gif"));
	}
	public void shoot() {
		this.getController().getBullets().
		add(new Pea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
	}
}
