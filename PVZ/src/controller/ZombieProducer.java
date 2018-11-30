package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import zombie.*;

public class ZombieProducer implements Runnable{
	private Thread t;
	private Controller controller;
	private boolean lastWave;
	private boolean islastWaved;
	private int level;
	public ZombieProducer(int level, Controller controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.level = level;	
		this.setLastWave(false);
		this.islastWaved = false;	
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
		switch (this.level) {
		case 1:
			level1();
			break;
		case 2:
			level2();
			break;
		case 3:
			level3();
			break;
		default:
			break;
		}	
		System.out.println(this.level);
	}	
	
	public void level1() {
		try	{
			Thread.sleep(5000);
			this.controller.getZombies().add(new NormalZombie(2, this.controller));
			Thread.sleep(2000);
			this.controller.getZombies().add(new NormalZombie(3, this.controller));
			Thread.sleep(5000);
			this.setLastWave(true);
			Thread.sleep(1000);
			this.setLastWave(false);
			Thread.sleep(3000);
			this.controller.getZombies().add(new FlagZombie(4, this.controller));
			for(int i=0;i<2;i++) {
				this.controller.getZombies().add(new NewspaperZombie(0, this.controller));
				this.controller.getZombies().add(new NormalZombie(2, this.controller));
				this.controller.getZombies().add(new BucketheadZombie(4, this.controller));
				this.controller.getZombies().add(new ConeheadZombie(1, this.controller));
				this.controller.getZombies().add(new PoleVaultingZombie(3, this.controller));
			}
			while (controller.getZombies().size() != 0) {
				Thread.sleep(2000);
			}
			
			this.islastWaved = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void level2() {
		try	{
			Thread.sleep(2000);
			this.controller.getZombies().add(new NormalZombie(1, this.controller));
			Thread.sleep(5000);
			this.controller.getZombies().add(new ConeheadZombie(2, this.controller));
			Thread.sleep(5000);
			this.controller.getZombies().add(new BucketheadZombie(0, this.controller));Thread.sleep(2000);
			this.controller.getZombies().add(new NewspaperZombie(4, this.controller));
			Thread.sleep(2000);
			this.setLastWave(true);
			Thread.sleep(1000);
			this.setLastWave(false);
			Thread.sleep(3000);
			this.controller.getZombies().add(new FlagZombie(3, this.controller));
			for(int i=0;i<2;i++) {
				this.controller.getZombies().add(new NewspaperZombie(2, this.controller));
				this.controller.getZombies().add(new NormalZombie(3, this.controller));
				this.controller.getZombies().add(new ScreenDoorZombie(3, this.controller));
				this.controller.getZombies().add(new FootballZombie(1, this.controller));
				this.controller.getZombies().add(new PoleVaultingZombie(4, this.controller));
			}
			while (controller.getZombies().size() != 0) {
				Thread.sleep(2000);
			}
			
			this.islastWaved = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void level3() {
		try	{
			Thread.sleep(2000);
			this.controller.getZombies().add(new NormalZombie(1, this.controller));
			Thread.sleep(5000);
			this.controller.getZombies().add(new DuckyTubeZombie(3, this.controller));
			Thread.sleep(8000);
			this.controller.getZombies().add(new Zomboni(1, this.controller));		
			Thread.sleep(2000);
			this.controller.getZombies().add(new NewspaperZombie(5, this.controller));
			Thread.sleep(2000);
			this.setLastWave(true);
			Thread.sleep(1000);
			this.setLastWave(false);
			Thread.sleep(3000);
			this.controller.getZombies().add(new FlagZombie(0, this.controller));
			for(int i=0;i<2;i++) {
				this.controller.getZombies().add(new DuckyTubeConeheadZombie(3, this.controller));
				this.controller.getZombies().add(new NormalZombie(5, this.controller));
				this.controller.getZombies().add(new DuckyTubeBucketheadZombie(2, this.controller));
				this.controller.getZombies().add(new ConeheadZombie(0, this.controller));
				this.controller.getZombies().add(new Zomboni(5, this.controller));
			}
			while (controller.getZombies().size() != 0) {
				Thread.sleep(2000);
			}
			
			this.islastWaved = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isLastWave() {
		return lastWave;
	}
	
	public boolean isIslastWaved() {
		return islastWaved;
	}

	public void setLastWave(boolean lastWave) {
		this.lastWave = lastWave;
	}	
}
