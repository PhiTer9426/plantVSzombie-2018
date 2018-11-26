package plant;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class Jalapeno extends Plant implements Runnable {
	
	private Controller controller;
	private Thread t;
	
	public Jalapeno(int x, int y, Controller controller) {
		
		super(x, y);
		this.setPrice(150);
		this.setName("Jalapeno");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/Jalapeno/Jalapeno.gif"));
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
			this.setPosX(8);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Plants/Jalapeno/JalapenoAttack.gif"));
			for (Zombie zombie : this.controller.getZombies()) {
    			if (this.getPosY() == zombie.getPosY()) {
    				zombie.setDeath(1);
    				zombie.setCurrent_health(zombie.getCurrent_health() - 90);
    				this.setIs_alive(false);
    			}
    		}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		this.controller.getPlants().remove(this);
	}
	
}