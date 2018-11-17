package plant;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Peashooter extends Plant implements Runnable {
	
	private int shootSpeed;
	private boolean is_shoot;
	
	public Peashooter(int x, int y) {
		
		super(x, y);
		this.shootSpeed = 500;
		this.is_shoot = false;
		this.setPrice(100);
		this.setName("PeaShooter");
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/Peashooter/Peashooter.gif").getImage());
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
