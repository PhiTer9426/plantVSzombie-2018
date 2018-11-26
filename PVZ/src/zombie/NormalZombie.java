package zombie;

import java.awt.Toolkit;

import controller.Controller;

public class NormalZombie extends Zombie{

	
	public NormalZombie(Controller controller){
		super((int)(Math.random() * 5), controller);
		
		this.setCurrent_health(10);
		this.setWalkSpeed(40);
		this.setEatSpeed(400);
		this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif"));
	}

}
