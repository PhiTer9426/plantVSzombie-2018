package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import zombie.NormalZombie;
import zombie.Zombie;

public class ZombieProducer implements Runnable{
	private Thread t;
	private CopyOnWriteArrayList<Zombie> zombies;
	
	public ZombieProducer(Controller controller) {
		// TODO Auto-generated constructor stub
		this.zombies = controller.getZombies();		
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
				Thread.sleep(5000);
				zombies.add(new NormalZombie(this.zombies));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
