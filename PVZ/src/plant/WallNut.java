package plant;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;

public class WallNut extends Plant implements Runnable {
	
	private int shootSpeed;
	private Controller controller;
	private Thread t;
	
	public WallNut(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.shootSpeed = 1200;
		this.setPrice(100);
		this.setName("WXZ");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WallNut/WallNut.gif").getImage());
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
		while(this.getIs_alive()) {
			
			if (this.getCurrent_health() <= (this.getMax_health())*2/3) {
				this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WallNut/Wallnut_cracked1.gif").getImage());
			}
			else if (this.getCurrent_health() <= (this.getMax_health())/3) {
				this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WallNut/Wallnut_cracked2.gif").getImage());
			}
			else if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
		}
		this.controller.getPlants().remove(this);
	}
	
}
