package bullet;

import java.awt.Image;

import controller.Controller;
import zombie.Zombie;

public abstract class Bullet implements Runnable{
	private	int posX;
	private	int posY;
	private	int bulletDamage;
	private boolean isRemove;
	private Image image;
	private Thread t;
	private Controller controller;
	
	
	
	public Bullet(int posX, int posY, Controller controller) {
		// TODO 自动生成的构造函数存根
		this.posX = posX;
		this.posY = posY;
		this.setRemove(false);
		this.setController(controller);
		this.start();
		
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start();
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (!this.isRemove()) {
			try	{
				Thread.sleep(40);
				this.isAttackZombie();
				if (this.isBeyondBorder()) {
					this.setRemove(true);
				}
				this.setPosX(getPosX() + 16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getController().getBullets().remove(this);
	}
	
	public void isAttackZombie() {
		for (Zombie zombie : this.getController().getZombies()) {
			if ((this.getPosY()-182)/90 == zombie.getPosY() &&
					zombie.getPosX() - this.getPosX() < 50 &&
					zombie.getPosX() - this.getPosX() > 20) {
				this.bulletEffect(zombie);
				this.setRemove(true);
				break;
			}
		}
	}
	
	public void bulletEffect(Zombie zombie) {
		zombie.setCurrent_health(zombie.getCurrent_health()-this.getBulletDamage());
	}
	public boolean isBeyondBorder() {
		if(getPosX() > 1000 || getPosX() < 0 ) {
			return true;
		}
		return false;
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

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public boolean isRemove() {
		return isRemove;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

}
