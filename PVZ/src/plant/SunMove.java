package plant;

import javax.swing.ImageIcon;

import controller.Controller;

public class SunMove extends Sun implements Runnable{

	private Controller controller;
	private Thread t;
	
	private int m;
	private int n;
	public SunMove(int x,int y,Controller controller) {
		super(x, y, 0);
		this.setPosX(x);
		this.setPosY(y);
		this.m = (650 - this.getPosX()) / 20;
		this.n = this.getPosY() / 20;
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
		for (int i = 0; i < 20; i++) {
			this.setPosX(this.getPosX() + m);
			this.setPosY(this.getPosY() - n);
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.controller.getMovingSun().remove(this);
	}
}
