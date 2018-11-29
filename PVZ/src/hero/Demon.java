package hero;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;
import zombie.Zombie;

public class Demon extends Hero implements Runnable {
	
	private Controller controller;
	private Thread t;
	
    public Demon(int x, int y, Controller controller) {
		
		super(x, y);
		this.setMax_health(30);
		this.setCurrent_health(30);
		this.setName("Demon");
		this.setPrice(300);
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Hearoes/Demon/Demon.gif"));
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
			try {
				Thread.sleep(40);
		    	if (this.getCurrent_health() <= 0) {
				    this.setIs_alive(false);
		    	}
		    	if((this.getIs_ready() == true) && (this.getIs_use() == true)) {
		    		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Hearoes/Demon/DemonAttack.gif"));
		    		for (Zombie zombie : controller.getZombies()) {
		    			zombie.setDeath(1);
	    				zombie.setCurrent_health(zombie.getCurrent_health() - 90);
	    				this.setIs_alive(false);
			    	}
				this.setIs_ready(false);
				this.setIs_use(false);	
				Thread.sleep(2000);
			    }				
		
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
