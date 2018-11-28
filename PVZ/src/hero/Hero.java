package hero;

import java.awt.Image;

import javax.swing.JLabel;

import controller.AudioFilePlayer;

public abstract class Hero {
	
	private String name;
	private int max_health;
	private int current_health;
	private boolean is_alive;
	private boolean is_ready;
	private boolean is_use;
	private	int posX;
	private	int posY;
	private int cd;
	private Image image;
	private final AudioFilePlayer player;
	
	public Hero(int x, int y) {
		this.is_alive = true;
		this.is_ready = true;
		this.posX = x;
		this.posY = y;
		this.player = new AudioFilePlayer ();
	}
	
	
	
	public void playMusic(String path) {
		player.play(path);
	}
		
	public void receiveDamage(int damage) {		
		current_health = current_health - damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMax_health() {
		return this.max_health;
	}
	
	public int getCurrent_health() {
		return this.current_health;
	}
	
	public boolean getIs_alive() {
		return this.is_alive;
	}
	
	public boolean getIs_ready() {
		return this.is_ready;
	}
	
	public boolean getIs_use() {
		return this.is_use;
	}

	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getCd() {
		return this.cd;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMax_health(int max_health) {
		this.max_health = max_health;
	}
	
	public void setCurrent_health(int current_health) {
		this.current_health = current_health;
	}
	
	public void setIs_alive(boolean is_alive) {
		this.is_alive = is_alive;
	}
	
	public void setIs_ready(boolean is_ready) {
		this.is_ready = is_ready;
	}
	
	public void setIs_use(boolean is_use) {
		this.is_use = is_use;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setCd(int cd) {
		this.cd = cd;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

}

