package plant;

import controller.Controller;
import zombie.Zombie;

public abstract class PlantShooter extends Plant implements Runnable{
	private int shootSpeed;
	private Controller controller;
	private Thread t;
	
	public PlantShooter(int x, int y, Controller controller) {
		// TODO Auto-generated constructor stub
		super(x, y);
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
				IsZombieIn();
				if (isIs_shoot() == true) {	
					shoot();
				}
				if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
				}
				Thread.sleep(getShootSpeed());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.controller.getPlants().remove(this);
	}
	public abstract void shoot();
	
	public void IsZombieIn() {
		boolean flag = true;
		for (Zombie zombie : this.controller.getZombies()) {
			if (this.getPosY() == zombie.getPosY() &&
					this.getPosX() * 81 + 81 +150 < zombie.getPosX()) {
				this.setIs_shoot(true);
				flag = false;
				break;
			}
		}
		if (flag) {
			this.setIs_shoot(false);
		}		
	}
	
	public int getShootSpeed() {
		return shootSpeed;
	}
	public void setShootSpeed(int shootSpeed) {
		this.shootSpeed = shootSpeed;
	}
	public Controller getController() {
		return controller;
	}
}
