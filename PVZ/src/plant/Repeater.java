package plant;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;

public class Repeater extends PlantShooter {
	public Repeater(int x, int y, Controller controller) {		
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1200);
		this.setPrice(100);
		this.setName("Repeater");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/Repeater/Repeater.gif").getImage());
	}
	public void shoot() {
		this.getController().getBullets().
		add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getController().getBullets().
		add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
	}
}
