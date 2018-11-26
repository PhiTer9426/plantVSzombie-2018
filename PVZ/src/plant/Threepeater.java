package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import bullet.Pea;
import controller.Controller;

public class Threepeater extends PlantShooter {
	public Threepeater(int x, int y, Controller controller) {		
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1100);
		this.setPrice(325);
		this.setName("Threepeater");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/Threepeater/Threepeater.gif"));
	}
	public void shoot() {
		
		if(this.getPosY() == 0) {
			this.getController().getBullets().
			add(new Pea(getPosX() * 81 + 150 + 81, (getPosY() + 1) * 92 + 90 + 92, this.getController()));
			this.getController().getBullets().
			add(new Pea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));	
		}
		else if(this.getPosY() == 4) {
			this.getController().getBullets().
			add(new Pea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
			this.getController().getBullets().
			add(new Pea(getPosX() * 81 + 150 + 81, (getPosY() - 1) * 92 + 90 + 92, this.getController()));
		}
		else {
			this.getController().getBullets().
		    add(new Pea(getPosX() * 81 + 150 + 81, (getPosY() + 1) * 92 + 90 + 92, this.getController()));
		    this.getController().getBullets().
		    add(new Pea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
		    this.getController().getBullets().
		    add(new Pea(getPosX() * 81 + 150 + 81, (getPosY() - 1) * 92 + 90 + 92, this.getController()));	
		}
		
	}
}
