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
//		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/TallNut/TallNut.gif"));
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
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
			if((this.getIs_ready() == true) && (this.getIs_use() == true)) {
				for (Zombie zombie : controller.getZombies()) {
					zombie.setCurrent_health(zombie.getCurrent_health()-2);
				}
				this.setIs_ready(false);
				this.setIs_use(false);
			}
		}
		
	}

}
