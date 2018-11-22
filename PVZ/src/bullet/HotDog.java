package bullet;


import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class HotDog extends LineBullet implements Runnable{
	
	private Thread t;
	private Controller controller;
	
	public HotDog(int posX, int posY, Controller controller) {
		super(posX, posY);
		this.setBulletDamage(1);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WXZ/HotDog.png").getImage());
		this.controller = controller;
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
		while (!isRemove()) {
			try	{
				Thread.sleep(10);
				for (Zombie zombie : this.controller.getZombies()) {
					if ((this.getPosY()-182)/90 == zombie.getPosY() &&
							zombie.getPosX() - this.getPosX() < 50 &&
							zombie.getPosX() - this.getPosX() > 20) {
						zombie.setCurrent_health(zombie.getCurrent_health()-this.getBulletDamage());
						this.setRemove(true);
						break;
					}
				}
				if (this.isBeyondBorder()) {
					this.setRemove(true);
				}
				this.setPosX(getPosX() + 4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		controller.getBullets().remove(this);
	}
	
}
