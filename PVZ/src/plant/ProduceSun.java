package plant;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;

public class ProduceSun extends Sun implements Runnable{
	
	private Controller controller;
	private Thread t;
	private float time;
	public ProduceSun(Controller controller) {
		super();
		
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
//			this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/interface/Sun.gif"));
			this.setImage(new ImageIcon("plantsVsZombieMaterials/images/interface/Sun.gif").getImage());
			if(this.getPosY()<this.getTposY() ) {
				moveY(1);
			}
			else if(this.getPosX()>this.getTposX()){
				moveY(-1);
			}
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
}
