package zombie;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

public class NormalZombie extends Zombie implements Runnable{

	private CopyOnWriteArrayList<Zombie> zombies;
	private Thread t;
	
	public NormalZombie(CopyOnWriteArrayList<Zombie> zombies){
		super((int)(Math.random() * 5));
		
		this.setCurrent_health(10);
		this.setWalkSpeed(40);
		this.setEatSpeed(500);
		
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif").getImage());
		this.setEatImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieAttack.gif").getImage());		
		
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
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
			if (this.getStatus() == 0) {
				Walk();
			}				
			else if (this.getStatus() == 1) {
				Eat();
			}	
		}
		this.zombies.remove(this);
	}
	
	public void Walk() {
		try {
			Thread.sleep(this.getWalkSpeed());
			this.setPosX(getPosX() - 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void Eat() {	
		try {
			Thread.sleep(this.getEatSpeed());
			this.getPlant().receiveDamage(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void Die() {		
		this.zombies.remove(this);
	}
}
