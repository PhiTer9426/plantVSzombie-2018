package controller;


import java.util.concurrent.CopyOnWriteArrayList;

import bullet.Bullet;
import plant.Plant;
import zombie.Zombie;

public class Controller {
	private CopyOnWriteArrayList<Plant> plants;
	private CopyOnWriteArrayList<Zombie> zombies;
	private CopyOnWriteArrayList<Bullet> bullets;
	
	private String mouse;
	private int sun;
	private ZombieProducer zombieProducer;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new CopyOnWriteArrayList<Plant>();
		this.zombies = new CopyOnWriteArrayList<Zombie>();
		this.bullets = new CopyOnWriteArrayList<Bullet>();
		this.mouse = "";
		this.sun = 50;
		this.zombieProducer = new ZombieProducer(this);
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