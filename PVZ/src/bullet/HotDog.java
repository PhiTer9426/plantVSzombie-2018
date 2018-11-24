package bullet;


import javax.swing.ImageIcon;

import controller.Controller;

public class HotDog extends Bullet {
	public HotDog(int posX, int posY, Controller controller) {
		super(posX, posY, controller);
		this.setBulletDamage(1);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/WXZ/HotDog.png").getImage());
	}
}
