package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;

public class Chomper extends Plant implements Runnable {
	
	private Controller controller;
	private int eatTime;
	private boolean is_ready;
	private Thread t;
	
	public Chomper(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.setPrice(25);
		this.setName("Chomper");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/Chomper/Chomper.gif"));
		this.controller = controller;
		this.eatTime = 10000;
		this.is_ready = true;
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
		    try {			
				Thread.sleep(40);
				
				if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
				}	
				
				if(this.getIs_raedy() == true) {
					for (Zombie zombie : this.controller.getZombies()) {	
				    	if (this.getPosY() == zombie.getPosY() &&
							this.getPosX() * 81 + 81 + 81 + 81 +150 > zombie.getPosX()) {
				    		this.setImage(Toolkit.getDefaultToolkit()
				    				.createImage("plantsVsZombieMaterials/images/Plants/Chomper/ChomperAttack.gif"));
				    		Thread.sleep(500);
				    		zombie.setIs_alive(false);
				    		this.controller.getZombies().remove(zombie);
					    	Thread.sleep(500);
					    	this.setIs_ready(false);
					    	break;
				    	}
				    }			
				}
				if(this.getIs_raedy() == false) {
					this.setImage(Toolkit.getDefaultToolkit()
							.getImage("plantsVsZombieMaterials/images/Plants/Chomper/ChomperDigest.gif"));
					for (int i = 0; i < this.getEatTime()/40; i++) {
						Thread.sleep(40);
						if (this.getCurrent_health() <= 0) {
							this.setIs_alive(false);
							break;
						}	
				    }
					this.setImage(Toolkit.getDefaultToolkit()
							.getImage("plantsVsZombieMaterials/images/Plants/Chomper/Chomper.gif"));
					this.setIs_ready(true);
			    }
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
		this.controller.getPlants().remove(this);
	}
	
	public int getEatTime() {
		return eatTime;
	}
	public void setEatTime(int eatTime) {
		this.eatTime = eatTime;
	}
	
	public boolean getIs_raedy() {
		return is_ready;
	}

	public void setIs_ready(boolean is_ready) {
		this.is_ready = is_ready;
	}
	
}
