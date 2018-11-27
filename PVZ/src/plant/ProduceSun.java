package plant;

import javax.swing.ImageIcon;

public class ProduceSun extends Sun implements Runnable{
	
	private Thread t;
	public ProduceSun(int x, int y, int ty) {
		super(x, y, ty);
		this.setImage(new ImageIcon
				("plantsVsZombieMaterials/images/interface/Sun.gif").getImage());
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
			try {
				Thread.sleep(40);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void moveY(int x) {
		this.setPosY(this.getPosY() + x);
	}
}
