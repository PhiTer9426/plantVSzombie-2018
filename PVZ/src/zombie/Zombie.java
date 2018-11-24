package zombie;

import java.awt.Image;

import com.sun.org.apache.xpath.internal.operations.Bool;

import controller.AudioFilePlayer;
import plant.Plant;

public abstract class Zombie {
	private Image image;
	private Image imageOfDie;
      
	private int current_health;
	private boolean is_alive;
	private int status;				//0：走路，1：吃
	private int coldTime;
	
      
	private int eatSpeed;
	private int walkSpeed;
	
	private int posX;
	private int posY;
	private int diePosX=getPosX();  //死亡时横坐标
	private int diePosY=getPosY();  //死亡时纵坐标
	private int death;             //0:正常死，1：炸死
	
	private Plant plant;
	private final AudioFilePlayer player;
	
	
	public Zombie(int y) {
		// TODO Auto-generated constructor stub
		this.is_alive = true;
		this.status = 0;
		this.setColdTime(0);
		this.posX = 1000;//pixel
		this.posY = y;//grid
<<<<<<< HEAD
		this.death=0;
=======
		this.player = new AudioFilePlayer ();
		
	}
	
	public void playMusic(String path) {
		player.play(path);
>>>>>>> d47776c6d2f5c800b3d0b63d9fe4d5714e9fd569
	}
	
	public abstract void Walk();
	public abstract void Eat();
	public abstract void Die_0();
	public abstract void Die_1();

	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

<<<<<<< HEAD
	public Image getImageOfDie() {
		return imageOfDie;
	}

	public void setImageOfDie(Image imageOfDie) {
		this.imageOfDie = imageOfDie;
	}

	public int getDiePosY() {
		return diePosY;
	}

	public void setDiePosY(int diePosY) {
		this.diePosY = diePosY;
	}

	public int getDiePosX() {
		return diePosX;
	}

	public void setDiePosX(int diePosX) {
		this.diePosX = diePosX;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	
=======
	public int getColdTime() {
		return coldTime;
	}

	public void setColdTime(int coldTime) {
		this.coldTime = coldTime;
	}

>>>>>>> d47776c6d2f5c800b3d0b63d9fe4d5714e9fd569
}
