package bullet;

import java.awt.Image;

public abstract class Bullet {
	private	int posX;
	private	int posY;
	private	int bulletDamage;
	private Image image;
	
	public abstract void bulletPath();
	public abstract boolean isAttackZombie();
	public boolean isBeyondBorder(int xFront , int xBehind) {
		if(posX > xFront || posX < xBehind ) {
			return true;
		}
		return false;
	}
	
	public int getposX() {
		return this.posX;
	}
	
	public int getposY() {
		return this.posY;
	}
	
	public int getbulletDamage() {
		return this.bulletDamage;
	}
	
	public Image getimage() {
		return this.image;
	}
	
	public void setposX(int x) {
		this.posX = x;
	}
	
	public void setposY(int y) {
		this.posY = y;
	}
		
	public void setbulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage;
	}
	
	public void setimage(Image image) {
		this.image = image;
	}
}
