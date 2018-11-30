package plant;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;

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
		this.setMax_health(6);
		this.setCurrent_health(6);
		this.creatSpeed = 100;
		this.setPrice(50);
		this.setName("SunFlower");
		this.setImage(Toolkit.getDefaultToolkit().
				getImage("plantsVsZombieMaterials/images/Plants/SunFlower/SunFlower1.gif"));
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
				creat();
				for (int i = 0; i < creatSpeed; i++) {
					Thread.sleep(40);
					if (this.getCurrent_health() <= 0) {
						this.setIs_alive(false);
						break;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.controller.getPlants().remove(this);
	}
	
	public void creat() {
		controller.getSuns().add(new ProduceSun(
				180 + 81 * this.getPosX(),
				100 + 92 * this.getPosY(),
				120 + 92 * this.getPosY()));
	}

}
