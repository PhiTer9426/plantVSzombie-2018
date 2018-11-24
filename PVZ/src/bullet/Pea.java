package bullet;




import javax.swing.ImageIcon;

import controller.Controller;

public class Pea extends Bullet implements Runnable{
	public Pea(int posX, int posY, Controller controller) {
		super(posX, posY, controller);
		this.setBulletDamage(1);
		this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Plants/PB00.gif").getImage());
	}
	
}
