package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import zombie.NewspaperZombie;
import zombie.NormalZombie;
import zombie.PoleVaultingZombie;
import zombie.Zombie;

public class ZombieProducer implements Runnable{
	private Thread t;
	private Controller controller;
	
	public ZombieProducer(Controller controller) {
		// TODO Auto-generated constructor stub
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
		while (true) {
			try	{
				Thread.sleep(5000);

				//this.controller.getZombies().add(new NormalZombie(this.controller));
				this.controller.getZombies().add(new PoleVaultingZombie(this.controller));
				//this.controller.getZombies().add(new NewspaperZombie(this.controller));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
