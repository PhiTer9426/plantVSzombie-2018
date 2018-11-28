package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class DuckyTubeZombie extends Zombie {

	private Controller controller;

	
	public  DuckyTubeZombie(Controller controller){
		
		super((int)(Math.random()*5), controller); 
		this.setCurrent_health(10); 
		this.setWalkSpeed(60);
		this.setEatSpeed(500);
	    this.setImage(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Walk1.gif"));
	    this.setImageOfDie(Toolkit.getDefaultToolkit().
				createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif"));
		this.controller = controller;
	}

	@Override
	public void isEat() {
		boolean flag = true;
		for (Plant plant : this.controller.getPlants()) {
			int posX = this.getPosX();
			int posY = this.getPosY();
			if((posX - 150 - 81)/81 == plant.getPosX() && posY == plant.getPosY()) {
					this.setStatus(1);
						this.setImage(Toolkit.getDefaultToolkit().
								createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/ZombieAttack.gif"));
					this.setPlant(plant);
					flag = false;
					break;
			}
		}
		if (flag) {
			this.setStatus(0);
			if(this.getPosX() >=935)
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Walk1.gif"));
			else if(this.getPosX() < 935)
			    this.setImage(Toolkit.getDefaultToolkit().
			    		getImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Walk2.gif"));
		}	
	}
	
	@Override
	public void WalkOfDie() {
		try {
			this.setDiePosX(getPosX());
		    this.setDiePosY(getPosY());
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Die.gif"));
			 while(this.getDiePosX()<(this.getPosX()+12)) {     //比死亡时走多12像素
			    	Thread.sleep(this.getWalkSpeed());
			    	this.setPosX(getPosX() - 1);
		    }			
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
					createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Die.gif"));
			while(this.getDiePosX()<(this.getPosX()+12)) {     //比死亡时走多12像素
		    	Thread.sleep(this.getWalkSpeed());
		    	this.setPosX(getPosX() - 1);
	        }		
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
