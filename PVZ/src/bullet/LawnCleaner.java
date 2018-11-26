package bullet;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;



public class LawnCleaner extends Bullet{
	
	private boolean isOn;
	private Controller controller;
	
	public LawnCleaner(int posX, int posY, Controller controller) {
		super(posX, posY, controller);
		this.isOn = false;
		this.controller = controller;
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/interface/LawnCleaner.png").getImage());
	}
	
	public void bulletEffect(Zombie zombie) {
		controller.getZombies().remove(zombie);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (!this.isBeyondBorder()) {
			try	{
				Thread.sleep(40);
				isTrigger();
				this.isAttackZombie();
				if(this.isOn) {
					this.setPosX(getPosX() + 16);
				}	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		getController().getBullets().remove(this);
	}
	
	public void isTrigger() {
		for (Zombie zombie : this.getController().getZombies()) {
			if ((this.getPosY()-182)/90 == zombie.getPosY() &&
					zombie.getPosX() - this.getPosX() < 50 &&
					zombie.getPosX() - this.getPosX() > 20) {
				isOn = true;
				break;
			}
		}
	}
	
}
