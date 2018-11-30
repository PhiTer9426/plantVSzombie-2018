package controller;


import java.awt.Image;
import java.util.concurrent.CopyOnWriteArrayList;


import bullet.Bullet;
import bullet.LawnCleaner;
import draw.GameView;
import hero.Demon;
import hero.Elf;
import hero.Hero;
import plant.Plant;
import plant.ProduceSun;
import plant.SunMove;
import zombie.Zombie;

public class Controller {
	private CopyOnWriteArrayList<Plant> plants;
	private CopyOnWriteArrayList<Zombie> zombies;
	private CopyOnWriteArrayList<Bullet> bullets;
	private CopyOnWriteArrayList<ProduceSun> sunNumber;
	private CopyOnWriteArrayList<SunMove> movingSun;
	private Hero hero;
	
	private String mouse;
	private int sun;
	
	private ZombieProducer zombieProducer;
	private SunProducer sunProducer;
	
	private Image last;
	private GameView game;
	
	public Controller(GameView game) {
		// TODO Auto-generated constructor stub
		this.plants = new CopyOnWriteArrayList<Plant>();
		this.zombies = new CopyOnWriteArrayList<Zombie>();
		this.bullets = new CopyOnWriteArrayList<Bullet>();
		this.sunNumber =new CopyOnWriteArrayList<ProduceSun>();
		this.movingSun=new CopyOnWriteArrayList<SunMove>();
		this.mouse = "";
		this.setGame(game);
		this.setSun(50);
		for (int i = 0; i < 5; i++) {
			this.bullets.add(new LawnCleaner(150, i * 92 + 90 + 92, this));
		}
		if (game.getLevel() == 3) {
			this.bullets.add(new LawnCleaner(150, 5 * 92 + 90 + 92, this));
		}
		this.setZombieProducer(new ZombieProducer(game.getLevel(), this));	
		
		if (game.getLevel() != 2) {
			this.sunProducer=new SunProducer(this);
		}
		
//		if (game.getLevel() == 2) {
//			this.hero = new Elf(300, 100, this);
//		}
//		if (game.getLevel() == 3) {
//			this.hero = new Demon(300, 100, this);
//		}
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
	public CopyOnWriteArrayList<ProduceSun> getSuns(){
		return sunNumber;
	}
	public Hero getHero() {
		return hero;
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

	public CopyOnWriteArrayList<SunMove> getMovingSun() {
		return movingSun;
	}

	public Image getLast() {
		return last;
	}

	public GameView getGame() {
		return game;
	}

	public void setGame(GameView game) {
		this.game = game;
	}

	public ZombieProducer getZombieProducer() {
		return zombieProducer;
	}

	public void setZombieProducer(ZombieProducer zombieProducer) {
		this.zombieProducer = zombieProducer;
	}

}