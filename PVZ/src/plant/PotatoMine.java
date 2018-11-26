package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;

public class PotatoMine extends Plant implements Runnable {
	
	private Controller controller;
	private int readyTime;
	private Thread t;
	
	public PotatoMine(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.setPrice(25);
		this.setName("PotatoMine");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/PotatoMine/PotatoMineNotReady.gif"));
		this.controller = controller;
		this.readyTime = 250;
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
			for (int i = 0; i < this.getReadyTime(); i++) {
				Thread.sleep(40);
				if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
					break;
				}	
			}
			this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PotatoMine/PotatoMine.gif").getImage());
			while(this.getIs_alive()) {
				Thread.sleep(40);
				for (Zombie zombie : this.controller.getZombies()) {
					if (this.getPosY() == zombie.getPosY() &&
							this.getPosX() * 81 + 81 + 81 +150 > zombie.getPosX()) {
						zombie.setCurrent_health(zombie.getCurrent_health() - 90);
						this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PotatoMine/PotatoMine_mashed.gif").getImage());
						this.setIs_alive(false);
					}
				}
				Thread.sleep(400);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.controller.getPlants().remove(this);
	}
	
	public int getReadyTime() {
		return readyTime;
	}
	public void setReadyTime(int readyTime) {
		this.readyTime = readyTime;
	}
}
