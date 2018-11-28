package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import bullet.Pea;
import controller.Controller;
import zombie.Zombie;

public class Threepeater extends PlantShooter {
	public Threepeater(int x, int y, Controller controller) {		
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1100);
		this.setPrice(325);
		this.setName("Threepeater");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/Threepeater/Threepeater.gif"));
	}
	
	public void shoot() {		
		this.getController().getBullets().
				add(new Pea(getPosX() * 81 + 150 + 81, (getPosY() + 1) * 92 + 90 + 92, this.getController()));
		this.getController().getBullets().
				add(new Pea(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
		this.getController().getBullets().
				add(new Pea(getPosX() * 81 + 150 + 81, (getPosY() - 1) * 92 + 90 + 92, this.getController()));			
	}
	
	public void IsZombieIn() {
		boolean flag = true;
		for (Zombie zombie : getController().getZombies()) {
			if ((this.getPosY() == zombie.getPosY() 				||
					this.getPosY() == zombie.getPosY() + 1		||
					this.getPosY() == zombie.getPosY() - 1)		&&
					this.getPosX() * 81 + 81 +150 < zombie.getPosX()) {
				this.setIs_shoot(true);
				flag = false;
				break;
			}
		}
		if (flag) {
			this.setIs_shoot(false);
		}		
	}
}
