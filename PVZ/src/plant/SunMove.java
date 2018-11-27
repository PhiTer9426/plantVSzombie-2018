package plant;

import javax.swing.ImageIcon;

import controller.Controller;

public class SunMove extends Sun implements Runnable{

	private Controller controller;
	private Thread t;
	
	private int m;
	private int n;
	public SunMove(int x,int y,Controller controller) {
		super();
		this.setPosX(x);
		this.setPosY(y);
		m=600-this.getPosX();
		n=-this.getPosY();
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
		while(this.isExistent())
		{
			this.setImage(new ImageIcon("plantsVsZombieMaterials/images/interface/Sun.gif").getImage());
			if(this.getPosX()-20>=600||this.getTposX()+20<=600)
			{
				moveSun(m,n);
				if(this.getPosY()<=0.0001) {				
					this.setExistent(false);
					break;
				}
			}
			else {
				if(this.getPosY()>0.0001)
					moveY(-10);
				else {
				this.setExistent(false);
				break;
				}
			}
		}
		this.controller.getMovingSun().remove(this);
	}
	
	public void moveSun(int x, int y) {

		if(this.getPosX()!=600) {
		  if(this.getPosX()<570) {
			  
			this.moveX(x/5);
		  }
		  else if(this.getPosX()>630) {
			this.moveX(-10);
		  }
		}
		if(this.getPosY()!=0) {
			this.moveY(y/5);
		}
	}
	
	public void moveY(int x) {
		try {
			Thread.sleep(40);
			this.setPosY(this.getPosY()+x);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void moveX(int x) {
		try {
			Thread.sleep(40);
			this.setPosX(this.getPosX()+x);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
