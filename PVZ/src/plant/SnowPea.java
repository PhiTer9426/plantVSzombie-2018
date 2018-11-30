package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import bullet.IcePea;
import controller.Controller;

public class SnowPea extends PlantShooter {
	public SnowPea(int x, int y, Controller controller) {		
		super(x, y, controller);
		this.setMax_health(6);
		this.setCurrent_health(6);
		this.setShootSpeed(1200);
		this.setPrice(175);
		this.setName("Snowpea");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/SnowPea/SnowPea.gif"));
	}
	public void shoot() {
		this.getController().getBullets().
		add(new IcePea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
	}
}
