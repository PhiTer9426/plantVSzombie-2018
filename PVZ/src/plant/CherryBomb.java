package plant;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class CherryBomb extends Plant implements Runnable {
	
	private Controller controller;
	private Thread t;
	private boolean is_boom;
	
	public CherryBomb(int x, int y, Controller controller) {
		
		super(x, y);
//		this.setCurrent_health(6);
		this.setPrice(150);
		this.setName("CherryBomb");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/CherryBomb/CherryBomb.gif").getImage());
		this.controller = controller;
//		this.is_boom = false;
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
//		while(this.getIs_alive()) {
			try {
//				if(this.getIs_boom() == false) {
					Thread.sleep(320);
//					this.setIs_boom(true);
//				}
//				if(this.getIs_boom() == true){
					this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/CherryBomb/Boom.gif").getImage());
					Thread.sleep(1020);
					this.setIs_alive(false);
//				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
		
		this.controller.getPlants().remove(this);
	}
	
	public boolean getIs_boom() {
		return is_boom;
	}

	public void setIs_boom(boolean is_boom) {
		this.is_boom = is_boom;
	}
	
}

