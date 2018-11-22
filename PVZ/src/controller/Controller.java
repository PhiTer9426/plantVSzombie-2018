package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import bullet.Bullet;
import draw.MainView;
import plant.Plant;
import zombie.Zombie;

public class Controller implements Runnable{
	private ArrayList<Plant> plants;
	private ArrayList<Zombie> zombies;
	private ArrayList<Bullet> bullets;
	
	private int[][] map;
	private int mouse;
	private Thread t;
	
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new ArrayList<Plant>();
		this.zombies = new ArrayList<Zombie>();
		this.bullets = new ArrayList<Bullet>();
		this.map = new int[9][5];
		this.mouse = 0;
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
		while (true) {
			try	{
				Thread.sleep(200);
				for (Plant plant  : plants) {
					boolean flag = true;
					for (Zombie zombie : zombies) {
						if (plant.getPosY() == zombie.getPosY()) {
							plant.setIs_shoot(true);
							flag = false;
							break;
						}
					}
					if (flag) {
						plant.setIs_shoot(false);
					}					
				}
							
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	public ArrayList<Plant> getPlants() {
		return plants;
	}
	public ArrayList<Zombie> getZombies() {
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
