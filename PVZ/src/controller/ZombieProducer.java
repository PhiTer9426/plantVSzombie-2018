package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import zombie.*;

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
				this.controller.getZombies().add(new NormalZombie(this.controller));
				Thread.sleep(2000);
				this.controller.getZombies().add(new PoleVaultingZombie(this.controller));
				Thread.sleep(2000);
				this.controller.getZombies().add(new NewspaperZombie(this.controller));
				Thread.sleep(2000);
				this.controller.getZombies().add(new BucketheadZombie(this.controller));
				Thread.sleep(2000);
				this.controller.getZombies().add(new ConeheadZombie(this.controller));
				Thread.sleep(2000);
				this.controller.getZombies().add(new FlagZombie(this.controller));
//				Thread.sleep(2000);
//				this.controller.getZombies().add(new ScreenDoorZombie(this.controller));
//				Thread.sleep(2000);
//				this.controller.getZombies().add(new FootballZombie(this.controller));
//				Thread.sleep(2000);
//				this.controller.getZombies().add(new DuckyTubeZombie(this.controller));
//				Thread.sleep(2000);
//				this.controller.getZombies().add(new DuckyTubeConeheadZombie(this.controller));
//				Thread.sleep(2000);
//				this.controller.getZombies().add(new DuckyTubeBucketheadZombie(this.controller));
//				Thread.sleep(2000);
//				this.controller.getZombies().add(new Zomboni(this.controller));
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
