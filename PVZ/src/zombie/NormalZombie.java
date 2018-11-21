package zombie;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

public class NormalZombie extends Zombie implements Runnable{

	private CopyOnWriteArrayList<Zombie> zombies;
	private Thread t;
	
	public NormalZombie(CopyOnWriteArrayList<Zombie> zombies){
		super((int)(Math.random() * 5));
		
		this.setMax_health(10);
		this.setCurrent_health(10);
		this.setWalkSpeed(1);
		
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif").getImage());		
		
		this.zombies = zombies;
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
		while(this.getIs_alive()) {
			try {
				Thread.sleep(40);
				if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
				}
				switch (this.getStatus()) {
				case 0:
					Walk();
					break;
				case 1:
					Eat();
					break;
				default:
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.zombies.remove(this);
	}
	
	public void Walk() {
		this.setPosX(getPosX() - this.getWalkSpeed());		
	}

	public void Eat() {	
		
	}

	public void Die() {		
		this.zombies.remove(this);
	}
}
