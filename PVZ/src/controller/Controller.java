package controller;



import java.util.concurrent.CopyOnWriteArrayList;

import bullet.Bullet;
import plant.Plant;
import zombie.Zombie;

public class Controller implements Runnable{
	private CopyOnWriteArrayList<Plant> plants;
	private CopyOnWriteArrayList<Zombie> zombies;
	private CopyOnWriteArrayList<Bullet> bullets;
	
	private String mouse;
	private int sun;
	private ZombieProducer zombieProducer;
	
	private Thread t;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new CopyOnWriteArrayList<Plant>();
		this.zombies = new CopyOnWriteArrayList<Zombie>();
		this.bullets = new CopyOnWriteArrayList<Bullet>();
		this.mouse = "";
		this.sun = 50;
		this.zombieProducer = new ZombieProducer(this);
		this.start();
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start();
		}
	}
	public void run() {
		while (true) {			
			this.runPersonelLogic();
		}
	}
	
	public void runPersonelLogic() {
		try	{
			Thread.sleep(100);
			//判断植物是否需要射击
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
			//判断子弹是否打中僵尸
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
			//判断僵尸是否要吃植物
			for (Zombie zombie : zombies) {
				boolean flag = true;
				for (Plant plant : plants) {
					int posX = zombie.getPosX();
					int posY = zombie.getPosY();
					if ((posX - 150 - 81)/81 == plant.getPosX() &&
							posY == plant.getPosY()) {
						zombie.setStatus(1);
						zombie.setPlant(plant);
						flag = false;
						break;
					}
				}
				if (flag) {
					zombie.setStatus(0);
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
	public String getMouse() {
		return mouse;
	}
	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
	
}