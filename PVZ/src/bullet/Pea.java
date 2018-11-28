package bullet;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;
import plant.Torchwood;
import zombie.Zombie;

public class Pea extends Bullet implements Runnable{
	public Pea(int posX, int posY, Controller controller) {
		super(posX, posY, controller);
		this.setBulletDamage(1);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PB00.gif").getImage());
	}
	
	@Override
	public void isAttackZombie() {
		for (Zombie zombie : this.getController().getZombies()) {
			if ((this.getPosY()-182)/90 == zombie.getPosY() &&
					zombie.getPosX() - this.getPosX() < 50 &&
					zombie.getPosX() - this.getPosX() > 20) {
				this.bulletEffect(zombie);
				this.setRemove(true);
				break;
			}
		}
		for (Plant plant : this.getController().getPlants()) {
			if ((this.getPosY()-182)/90 == plant.getPosY() &&
					150 + 81 + 81 * plant.getPosX()  - this.getPosX() < 37 &&
					150 + 81 + 81 * plant.getPosX()  - this.getPosX() > 20 &&
					plant.getName().equals("Torchwood") ) {
				this.setRemove(true);
				this.getController().getBullets().add
						(new FirePea(this.getPosX() + 16, this.getPosY(), this.getController()));
				break;
			}
		}
	}
	
}
