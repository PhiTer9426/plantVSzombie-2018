package bullet;

import java.awt.Image;

public abstract class Bullet {
	private	int posX;
	private	int posY;
	private	int bulletDamage;
	private Image image;
	
	//public abstract void bulletPath();
	//public abstract boolean isAttackZombie();
	
	public Bullet(int posX, int posY) {
		// TODO 自动生成的构造函数存根
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getBulletDamage() {
		return this.bulletDamage;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
		
	public void setBulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
}
