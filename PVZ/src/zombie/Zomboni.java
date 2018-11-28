package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class Zomboni extends Zombie {

	private Controller controller;
	
	public Zomboni(Controller controller){
		super((int)(Math.random() * 5), controller);
		this.setCurrent_health(60);
		this.setWalkSpeed(50);
		this.setEatSpeed(400);
		this.setImage(Toolkit.getDefaultToolkit().
				getImage("plantsVsZombieMaterials/images/Zombies/Zomboni/2.gif"));
		this.controller = controller;
		this.setDeath(-1);
		
	}
	
	
	
	public void run() {
		// TODO Auto-generated method stub
		while(this.getIs_alive()) {
			isEat();			
			Walk();
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
		}
		if(this.getDeath()==-1) {
			if(this.getStatus()==0){
			    WalkOfDie();
	        }
		    else if(this.getStatus()==1) {
			    EatOfDie();
		    }
		}
		else if(this.getDeath()==1) {    //炸死
			DieBoom();
		}
		
	}
	public void isEat() {
		
		for (Plant plant : this.controller.getPlants()) {
			int posX = this.getPosX();
			int posY = this.getPosY();
			if ((posX - 150 -40)/81 == plant.getPosX() &&
					posY == plant.getPosY() && plant.getName() != "Spikeweed") {
				plant.setIs_alive(false);
				this.controller.getPlants().remove(plant);
			}
			if ((posX - 150 - 81)/81 == plant.getPosX() &&
					posY == plant.getPosY() && plant.getName().equals ("Spikeweed")) {
				System.out.println("0");
				this.setCurrent_health(0);
				this.setStatus(1);
				break;
			}
		}
			if(this.getCurrent_health() >= 40) 
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/Zomboni/1.gif"));
			else if(this.getCurrent_health() < 40 &&
					this.getCurrent_health() >= 20)
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/Zomboni/2.gif"));
			else if(this.getCurrent_health() < 20) 
			    this.setImage(Toolkit.getDefaultToolkit().
					    getImage("plantsVsZombieMaterials/images/Zombies/Zomboni/3.gif"));
	}
	
	@Override
	public void WalkOfDie() {          //被打死
		try {
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zomboni/5.gif"));
			Thread.sleep(900);
			
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void EatOfDie() {	       //踩地刺
		try {	    
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zomboni/4.gif"));
	    	Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zomboni/5.gif"));
			Thread.sleep(900);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void DieBoom() {		
		try {
		    this.setImage(Toolkit.getDefaultToolkit().
		    		createImage("plantsVsZombieMaterials/images/Zombies/Zomboni/BoomDie.gif"));
			Thread.sleep(2500);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
	

