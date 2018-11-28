package controller;

<<<<<<< HEAD
import java.util.concurrent.CopyOnWriteArrayList;

import zombie.BucketheadZombie;
import zombie.ConeheadZombie;
import zombie.FlagZombie;
import zombie.NewspaperZombie;
import zombie.NormalZombie;
import zombie.PoleVaultingZombie;
import zombie.Zombie;
=======
import zombie.*;
>>>>>>> 457ec5d7b2378cb1227daa189df9c99b5f4ba1c7

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
				Thread.sleep(2000);

<<<<<<< HEAD
				//this.controller.getZombies().add(new NormalZombie(this.controller));
=======
				this.controller.getZombies().add(new NormalZombie(this.controller));
>>>>>>> 457ec5d7b2378cb1227daa189df9c99b5f4ba1c7
				//this.controller.getZombies().add(new PoleVaultingZombie(this.controller));
				//this.controller.getZombies().add(new NewspaperZombie(this.controller));
				//this.controller.getZombies().add(new BucketheadZombie(this.controller));
			    //this.controller.getZombies().add(new ConeheadZombie(this.controller));
				//this.controller.getZombies().add(new FlagZombie(this.controller));
                this.controller.getZombies().add(new ScreenDoorZombie(this.controller));



			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
