package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;

public class TallNut extends Plant implements Runnable {
	private Controller controller;
	private Thread t;
	
	public TallNut(int x, int y, Controller controller) {
		
		super(x, y);
		this.setMax_health(90);
		this.setCurrent_health(90);
		this.setPrice(125);
		this.setName("TallNut");
		this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Plants/TallNut/TallNut.gif"));
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
			else if (this.getCurrent_health() <= 30) {
				this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/TallNut/TallnutCracked2.gif").getImage());
			}
			 else if (this.getCurrent_health() <= 60) {
				 this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/TallNut/TallnutCracked1.gif").getImage());
			}
		}
		this.controller.getPlants().remove(this);
	}
}
