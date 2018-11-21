package zombie;

import java.awt.Image;

public abstract class Zombie {
	private Image image;
      
	private int max_health;
	private int current_health;
	private Boolean is_alive;
	private int status;				//0：走路，1：吃
      
	private int eatSpeed;
	private int walkSpeed;
	
	private int posX;
	private int posY;
	
	public Zombie(int y) {
		// TODO Auto-generated constructor stub
		this.is_alive = true;
		this.status = 0;
		this.posX = 1000;//pixel
		this.posY = y;//grid
	}
	
	public abstract void Walk();
	public abstract void Eat();
	public abstract void Die();

	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMax_health() {
		return max_health;
	}
	public void setMax_health(int max_health) {
		this.max_health = max_health;
	}
	public int getCurrent_health() {
		return current_health;
	}
	public void setCurrent_health(int current_health) {
		this.current_health = current_health;
	}
	public int getEatSpeed() {
		return eatSpeed;
	}
	public void setEatSpeed(int eatSpeed) {
		this.eatSpeed = eatSpeed;
	}
	public int getWalkSpeed() {
		return walkSpeed;
	}
	public void setWalkSpeed(int walkSpeed) {
		this.walkSpeed = walkSpeed;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Boolean getIs_alive() {
		return is_alive;
	}
	public void setIs_alive(Boolean is_alive) {
		this.is_alive = is_alive;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image mat) {
		image = mat;
	}
}
