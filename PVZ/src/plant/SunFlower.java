package plant;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;

public class SunFlower extends Plant implements Runnable{
	
	private int creatSpeed;
	private Controller controller;
	private Thread t;
	
	public SunFlower (int x, int y, Controller controller) {
		
		super(x, y);
		this.setCurrent_health(6);
		this.creatSpeed = 24000;
		this.setPrice(50);
		this.setName("SunFlower");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/SunFlower/SunFlower1.gif").getImage());
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
					creat();
				}
				if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
				}
				Thread.sleep(creatSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.controller.getPlants().remove(this);
	}
	
	public void creat() {
		this.controller.getBullets().
		add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, controller));
	}

}
