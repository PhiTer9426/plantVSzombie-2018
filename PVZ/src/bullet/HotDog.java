package bullet;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class HotDog extends LineBullet implements Runnable{
	
	private Thread t;
	private CopyOnWriteArrayList<Bullet> bullets;
	
	public HotDog(int posX, int posY, Controller controller) {
		super(posX, posY);
		this.setBulletDamage(1);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WXZ/HotDog.png").getImage());
		this.bullets = controller.getBullets();
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
		while (true) {
			try	{
				Thread.sleep(40);
				if (this.isRemove()) {
					this.bullets.remove(this);
				}
				else {
					this.setPosX(getPosX() + 4);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
