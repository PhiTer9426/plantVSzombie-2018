package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;

public class PotatoMine extends Plant implements Runnable {
	
	private Controller controller;
	private int readyTime;
	private boolean is_ready;
	private Thread t;
	
	public PotatoMine(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.setPrice(25);
		this.setName("PotatoMine");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/PotatoMine/PotatoMineNotReady.gif"));
		this.controller = controller;
		this.readyTime = 500;
		this.is_ready = false;
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
				for (int i = 0; i <= this.getReadyTime()/40; i++) {
					Thread.sleep(40);
					if (this.getCurrent_health() <= 0) {
						this.setIs_alive(false);
						break;
					}	
				}
				if (this.getIs_alive() == true) {
					this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PotatoMine/PotatoMine.gif").getImage());
				    this.setIs_ready(true);
			    	if(this.getIs_ready() == true ) {
				    	for (Zombie zombie : this.controller.getZombies()) {
				    		Thread.sleep(40);
			    			if (this.getPosY() == zombie.getPosY() &&
			    					this.getPosX() * 81 + 81 + 81 +150 > zombie.getPosX()) {
			    				zombie.setCurrent_health(zombie.getCurrent_health() - 90);
			    				this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PotatoMine/PotatoMine_mashed.gif").getImage());
			    				this.setIs_alive(false);
			    			}
			    		}
			    	}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.controller.getPlants().remove(this);
	}
	
	public int getReadyTime() {
		return readyTime;
	}
	public void setReadyTime(int readyTime) {
		this.readyTime = readyTime;
	}
	
	public boolean getIs_ready() {
		return is_ready;
	}

	public void setIs_ready(boolean is_ready) {
		this.is_ready = is_ready;
	}

}
