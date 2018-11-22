package plant;

import javax.swing.ImageIcon;

import bullet.HotDog;
import controller.Controller;
import zombie.Zombie;

<<<<<<< HEAD
public class Wxz extends Plant implements Runnable {
	
	private int shootSpeed;
	private Controller controller;
	private Thread t;
	
	public Wxz(int x, int y, Controller controller) {
		
		super(x, y);
		this.shootSpeed = 1000;
=======
public class Wxz extends PlantShooter {
	public Wxz(int x, int y, Controller controller) {
		super(x, y, controller);
		this.setCurrent_health(6);
		this.setShootSpeed(1200);
>>>>>>> origin
		this.setPrice(100);
		this.setName("WXZ");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WXZ/WXZ.gif").getImage());
<<<<<<< HEAD
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
			
			if (isIs_shoot() == true) {	
				shoot();
			}
			
			try {
				Thread.sleep(shootSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
=======
>>>>>>> origin
	}
	public void shoot() {
		this.getController().getBullets().
		add(new HotDog(getPosX() * 81 + 150 + 81, getPosY() * 92 + 90 + 92, this.getController()));
	}
}
