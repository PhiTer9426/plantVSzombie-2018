package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;

public class Squash extends Plant implements Runnable {
	
	private Controller controller;
	private Thread t;
	
	public Squash(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(20);
		this.setPrice(50);
		this.setName("Squash");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/Squash/Squash.gif"));
		this.controller = controller;
		this.start();
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub		
		try {
			while(this.getIs_alive()) {
				Thread.sleep(40);
				for (Zombie zombie : this.controller.getZombies()) {
					if (this.getPosY() == zombie.getPosY() &&
							this.getPosX() * 81 + 81 + 81 +150 > zombie.getPosX()
							&& this.getPosX() * 81 + 81 + 150 < zombie.getPosX()) {
						if (this.getIs_alive()) {
							this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/Squash/SquashR.gif"));
							Thread.sleep(500);
							this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/Squash/SquashAttack.gif"));
							Thread.sleep(1200);
						}
						this.controller.getZombies().remove(zombie);
						zombie.setIs_alive(false);
						this.setIs_alive(false);
					}
				}		
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.controller.getPlants().remove(this);
	}
}
