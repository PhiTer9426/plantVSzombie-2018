package plant;

import javax.swing.ImageIcon;

import bullet.HotDog;
import bullet.IcePea;
import controller.Controller;

public class SnowPea extends PlantShooter {
	public SnowPea(int x, int y, Controller controller) {		
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1200);
		this.setPrice(100);
		this.setName("Peashooter");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/SnowPea/SnowPea.gif").getImage());
	}
	public void shoot() {
		this.getController().getBullets().
		add(new IcePea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
	}
}
