package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class FlagZombie extends Zombie {

	private Controller controller;
	public FlagZombie(Controller controller){
		super((int)(Math.random() * 5), controller);
		
		this.setCurrent_health(10);
		this.setWalkSpeed(50);
		this.setEatSpeed(500);
	    this.setImageOfDie(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif"));
		this.setImage(Toolkit.getDefaultToolkit().
				createImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/FlagZombie.gif"));
		this.controller = controller;
	}
	
	@Override
	public void isEat() {
		boolean flag = true;
		for (Plant plant : this.controller.getPlants()) {
			int posX = this.getPosX();
			int posY = this.getPosY();
			if ((posX - 150 - 81)/81 == plant.getPosX() &&
					posY == plant.getPosY() && plant.getName() != "Spikeweed") {
				this.setStatus(1);
				this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/FlagZombieAttack.gif"));
				this.setPlant(plant);
				flag = false;
				break; 
			}
		}
		if (flag) {
			this.setStatus(0);
			this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/FlagZombie.gif"));
		}	
	}
	
	@Override
	public void WalkOfDie() {
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/FlagZombieLostHead.gif"));
			
		    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
		    	Thread.sleep(this.getWalkSpeed());
		    	this.setPosX(getPosX() - 1);
	        }			
		    
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/ZombieDie.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void EatOfDie() {	
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/FlagZombieLostHeadAttack.gif"));
			
	    	Thread.sleep(this.getEatSpeed() * 6);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/FlagZombie/ZombieDie.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
