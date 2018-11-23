package bullet;

import controller.Controller;

public class Watermelon extends ParabolaBullet implements Runnable{
	
	private Thread t;
	private Controller controller;
	
	public Watermelon(int posX, int posY, Controller controller) {
		super(posX, posY);
		this.setBulletDamage(3);
		this.controller = controller;
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
		while (true) {
			try	{
				Thread.sleep(40);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
