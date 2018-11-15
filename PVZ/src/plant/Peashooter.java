package plant;

import java.awt.Toolkit;

public class Peashooter extends Plant implements Runnable {
	
	private int shootSpeed;
	private boolean is_shoot;
	
	public Peashooter() {
		
		super();
		this.shootSpeed = 5;
		this.is_shoot = false;
		this.setPosX(1);
		this.setPosY(1);
		this.setPrice(100);
		this.setName("PeaShooter");
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Plants/Peashooter/Peashooter.gif"));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.getIs_alive()) {
			
			if (is_shoot == true) {	
				shoot();
			}
			
			try {
				Thread.sleep(shootSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shoot() {
		
	}
	

}
