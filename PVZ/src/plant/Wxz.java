package plant;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;

public class Wxz extends Plant implements Runnable {
	
	private int shootSpeed;
	private boolean is_shoot;
	private Controller controller;
	private Thread t;
	
	public Wxz(int x, int y, Controller controller) {
		
		super(x, y);
		this.shootSpeed = 1000;
		this.is_shoot = true;
		this.setPrice(100);
		this.setName("PeaShooter");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WXZ/WXZ.gif").getImage());
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
			
			if (is_shoot == true) {	
				shoot();
			}
			
			try {
				Thread.sleep(shootSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shoot() {
		this.controller.getBullets().add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, controller));
	}
}
