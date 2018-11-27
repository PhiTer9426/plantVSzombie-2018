package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;

public class ProduceSun extends Sun implements Runnable{
	
	private Controller controller;
	private Thread t;
	public ProduceSun(Controller controller) {
		super();
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/interface/Sun.gif").getImage());
		this.controller=controller;
		this.start();
	}

	public void start() {
		if(t==null)
		{
			t=new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while(this.isExistent()) {
			if(this.getPosY() < this.getTposY() ) {
				moveY(1);
			}
		}
	}
	
	public void moveY(int x) {
		try {
			Thread.sleep(40);
			this.setPosY(this.getPosY() + x);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}

