package controller;


import java.util.concurrent.CopyOnWriteArrayList;

import bullet.Bullet;
import plant.Plant;
import plant.Sun;
import zombie.Zombie;

public class Controller {
	private CopyOnWriteArrayList<Plant> plants;
	private CopyOnWriteArrayList<Zombie> zombies;
	private CopyOnWriteArrayList<Bullet> bullets;
	private CopyOnWriteArrayList<Sun> sunNumber;
	
	private String mouse;
	private int sun;
	private ZombieProducer zombieProducer;
	private SunProducer sunProducer;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new CopyOnWriteArrayList<Plant>();
		this.zombies = new CopyOnWriteArrayList<Zombie>();
		this.bullets = new CopyOnWriteArrayList<Bullet>();
		this.sunNumber =new CopyOnWriteArrayList<Sun>();
		this.mouse = "";
		this.setSun(50);
		this.zombieProducer = new ZombieProducer(this);

		this.sunProducer=new SunProducer(this);

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
	public CopyOnWriteArrayList<Sun> getSuns(){
		return sunNumber;
	}
	public String getMouse() {
		return mouse;
	}
	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
	public int getSun() {
		return sun;
	}
	public void setSun(int sun) {
		this.sun = sun;
	}
	
	
}