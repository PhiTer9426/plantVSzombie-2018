package controller;



import java.util.concurrent.CopyOnWriteArrayList;

import bullet.Bullet;
import plant.Plant;
import zombie.Zombie;

public class Controller implements Runnable{
	private CopyOnWriteArrayList<Plant> plants;
	private CopyOnWriteArrayList<Zombie> zombies;
	private CopyOnWriteArrayList<Bullet> bullets;
	
	private int[][] map;
	private int mouse;
	
	private ZombieProducer zombieProducer;
	
	private Thread t;	
	private boolean suspend = false;	 
	private String control = ""; // 只是需要一个对象而已，这个对象没有实际意义
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new CopyOnWriteArrayList<Plant>();
		this.zombies = new CopyOnWriteArrayList<Zombie>();
		this.bullets = new CopyOnWriteArrayList<Bullet>();
		this.map = new int[9][5];
		this.mouse = 0;
		this.zombieProducer = new ZombieProducer(this);
		this.start();
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start();
		}
	}
	
 
	public void setSuspend(boolean suspend) {
		if (!suspend) {
			synchronized (control) {
				control.notifyAll();
			}
		}
		this.suspend = suspend;
	}
 
	public boolean isSuspend() {
		return this.suspend;
	}
 
	public void run() {
		while (true) {
			synchronized (control) {
				if (suspend) {
					try {
						control.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			this.runPersonelLogic();
		}
	}
	
	public void runPersonelLogic() {
		try	{
			Thread.sleep(100);
			for (Plant plant  : plants) {
				boolean flag = true;
				for (Zombie zombie : zombies) {
					if (plant.getPosY() == zombie.getPosY() &&
							plant.getPosX() * 81 + 81 +150 < zombie.getPosX()) {
						plant.setIs_shoot(true);
						flag = false;
						break;
					}
				}
				if (flag) {
					plant.setIs_shoot(false);
				}					
			}
			for (Bullet bullet: bullets) {
				for (Zombie zombie : zombies) {
					if ((bullet.getPosY()-182)/90 == zombie.getPosY() &&
							zombie.getPosX() - bullet.getPosX() < 50 &&
							zombie.getPosX() - bullet.getPosX() > 20) {
						zombie.setCurrent_health(zombie.getCurrent_health()-bullet.getBulletDamage());
						bullet.setRemove(true);
						break;
					}
				}
				if (bullet.isBeyondBorder()) {
					bullet.setRemove(true);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public CopyOnWriteArrayList<Bullet> getBullets() {
		return bullets;
	}
	public CopyOnWriteArrayList<Plant> getPlants() {
		return plants;
	}
	public CopyOnWriteArrayList<Zombie> getZombies() {
		return zombies;
	}
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	public int getMouse() {
		return mouse;
	}
	public void setMouse(int mouse) {
		this.mouse = mouse;
	}
	
}