package bullet;

import javax.swing.ImageIcon;

import controller.Controller;
import zombie.Zombie;

public class IcePea extends Bullet{
	public IcePea(int posX, int posY, Controller controller) {
		super(posX, posY, controller);
		this.setBulletDamage(1);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PB-10.gif").getImage());
	}
	@Override
	public void bulletEffect(Zombie zombie) {
		zombie.setCurrent_health(zombie.getCurrent_health()-this.getBulletDamage());
		zombie.setColdTime(150);
	}
}
