package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;


public class Wxz extends PlantShooter {
	public Wxz(int x, int y, Controller controller) {
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1200);
		this.setPrice(100);
		this.setName("WXZ");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/WXZ/WXZ.gif"));
	}
	public void shoot() {
		this.getController().getBullets().
		add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
	}
}
