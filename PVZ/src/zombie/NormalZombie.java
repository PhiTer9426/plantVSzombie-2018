package zombie;

import java.awt.Toolkit;

import controller.Controller;

public class NormalZombie extends Zombie{

	
	public NormalZombie(int y, Controller controller){
		super(y, controller);
		
		this.setCurrent_health(10);
		this.setWalkSpeed(60);
		this.setEatSpeed(400);
		this.setImage(Toolkit.getDefaultToolkit().
				getImage("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif"));
		this.setImageOfDie(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif"));
	}
	
}
