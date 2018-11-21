package plant;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;

public class Peashooter extends Plant implements Runnable {
	
	private int shootSpeed;
	private Controller controller;
	private Thread t;
	
	public Peashooter(int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.shootSpeed = 1200;
		this.setPrice(100);
		this.setName("Peashooter");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/Peashooter/Peashooter.gif").getImage());
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
				if (isIs_shoot() == true) {	
					shoot();
				}
				if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
				}
				Thread.sleep(shootSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.controller.getPlants().remove(this);
	}
	
	public void shoot() {
		this.controller.getBullets().
		add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, controller));
	}
}
