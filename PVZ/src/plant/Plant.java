package plant;

import java.awt.Image;

import javax.swing.JLabel;

public abstract class Plant{
	
	private String name;
	private int max_health;
	private int current_health;
	private boolean is_alive;
	private boolean is_shoot;
	private int cd;
	private int price;
	private	int posX;
	private	int posY;
	private Image image;
	public Plant(int x, int y) {
		this.is_alive = true;
		this.price = 0;
		this.cd = 0;
		this.posX = x;
		this.posY = y;
		this.is_shoot = false;
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
	
	public int getPrice() {
		return this.price;
	}
	
	public boolean getIs_alive() {
		return this.is_alive;
	}
	
	public int getCd() {
		return this.cd;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
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
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setIs_alive(boolean is_alive) {
		this.is_alive = is_alive;
	}
	
	public void setCd(int cd) {
		this.cd = cd;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isIs_shoot() {
		return is_shoot;
	}

	public void setIs_shoot(boolean is_shoot) {
		this.is_shoot = is_shoot;
	}
}
