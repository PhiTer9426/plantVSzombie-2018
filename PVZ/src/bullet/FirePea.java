package bullet;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class FirePea extends Bullet{
	public FirePea(int posX, int posY, Controller controller) {
		super(posX, posY, controller);
		this.setBulletDamage(2);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PB10.gif").getImage());
	}
	
	public void bulletEffect(Zombie zombie) {
		zombie.setCurrent_health(zombie.getCurrent_health()-this.getBulletDamage());
	}
	
	public void isAttackZombie(Controller controller) {
		for (Zombie zombie : this.getController().getZombies()) {
			if ((this.getPosY()-182)/90 == zombie.getPosY() &&
					zombie.getPosX() - this.getPosX() < 50 &&
					zombie.getPosX() - this.getPosX() > 20) {
				this.bulletEffect(zombie);
				this.setBulletDamage(1);
			}
			this.setRemove(true);
		}
	}
}
