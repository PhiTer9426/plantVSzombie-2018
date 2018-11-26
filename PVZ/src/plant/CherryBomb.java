package plant;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class CherryBomb extends Plant implements Runnable {
	
	private Controller controller;
	private Thread t;
	
	public CherryBomb(int x, int y, Controller controller) {
		
		super(x, y);
		this.setPrice(150);
		this.setName("CherryBomb");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/CherryBomb/CherryBomb.gif"));
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
			Thread.sleep(700);
			this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/CherryBomb/Boom.gif"));
			for (Zombie zombie : this.controller.getZombies()) {
	    		Thread.sleep(40);
    			if ((this.getPosY() == zombie.getPosY() && zombie.getPosX() > this.getPosX() * 81 - 81 +150 && zombie.getPosX() < this.getPosX() * 81 + 81 + 81 + 81 +150)||
    				(this.getPosY() == zombie.getPosY() - 1 && zombie.getPosX() > this.getPosX() * 81 - 81 +150 && zombie.getPosX() < this.getPosX() * 81 + 81 + 81 + 81 +150)||
    				(this.getPosY() == zombie.getPosY() + 1 && zombie.getPosX() > this.getPosX() * 81 - 81 +150 && zombie.getPosX() < this.getPosX() * 81 + 81 + 81 + 81 +150 )) {
    				zombie.setCurrent_health(zombie.getCurrent_health() - 90);
    				zombie.setDeath(1);
    				this.setIs_alive(false);
    			}
    		}
			//Thread.sleep(1700);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.controller.getPlants().remove(this);
	}
	
}

