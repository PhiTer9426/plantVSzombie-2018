package controller;

import java.util.ArrayList;

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
	
	private Thread t;
	private MainView frame;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new ArrayList<Plant>();
		this.zombies = new ArrayList<Zombie>();
		this.bullets = new ArrayList<Bullet>();
		this.map = new int[9][5];
		
		this.frame = new MainView(this);
		
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
				Thread.sleep(40);
				frame.repaint();
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

	
	public static void main(String[] args) {
		Controller controller = new Controller();
	}
}
