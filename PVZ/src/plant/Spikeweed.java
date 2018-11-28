package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;

public class Spikeweed extends Plant implements Runnable {
	
	private Controller controller;
	private Thread t;
	
	public Spikeweed(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.setPrice(25);
		this.setName("Spikeweed");

		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/Spikeweed/Spikeweed.gif"));

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
				for (Zombie zombie : this.controller.getZombies()) {
		    	    if (this.getPosY() == zombie.getPosY() &&
		    			    this.getPosX() * 81 + 81 + 81 +150 > zombie.getPosX()
		    			    && this.getPosX() * 81 + 81 + 150 < zombie.getPosX()) {
		    		    zombie.setCurrent_health(zombie.getCurrent_health() - 1);
	                }
	    	    }
				Thread.sleep(1500);
			}		

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
