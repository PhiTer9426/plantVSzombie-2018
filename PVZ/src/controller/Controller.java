package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import bullet.Bullet;
import draw.MainView;
import plant.Plant;
import zombie.Zombie;

public class Controller{
	private ArrayList<Plant> plants;
	private ArrayList<Zombie> zombies;
	private ArrayList<Bullet> bullets;
	
	private int[][] map;
	private int mouse;
	
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.plants = new ArrayList<Plant>();
		this.zombies = new ArrayList<Zombie>();
		this.bullets = new ArrayList<Bullet>();
		this.map = new int[9][5];
		this.mouse = 0;
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
