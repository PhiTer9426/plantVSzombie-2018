package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;


public class Torchwood extends Plant implements Runnable {
	
	private Controller controller;
	private Thread t;
	
	public Torchwood(int x, int y, Controller controller) {
		
		super(x, y);
		this.setMax_health(6);
		this.setCurrent_health(6);
		this.setPrice(175);
		this.setName("Torchwood");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/Torchwood/Torchwood.gif"));
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
		}		
		this.controller.getPlants().remove(this);
	}
	
}
