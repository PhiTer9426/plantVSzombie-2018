package zombie;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;

public class PoleVaultingZombie extends Zombie  {

	private Controller controller;
	private boolean is_Pole; //true为有杆子
	
	public PoleVaultingZombie(Controller controller){
		super((int)(Math.random() * 5), controller);
		this.setIs_Pole(true);
		this.setCurrent_health(10);
		this.setWalkSpeed(30);
		this.setEatSpeed(500);
		this.setImage(Toolkit.getDefaultToolkit().
				getImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombie.gif"));
	    this.setImageOfDie(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieHead.gif"));
		this.controller = controller;
	}	
	
	
	public void Jump1() {		
		try {
			this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieJump.gif"));
			this.setPosX(this.getPosX());
			//this.playMusic("plantsVsZombieMaterials/audio/polevault.mp3");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void Jump2() {		
		try {
			this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieJump2.gif"));
			this.setPosX(this.getPosX()-150);
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void WalkOfDie() {
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
		    if(this.getIs_Pole()==true)
			    this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieLostHead.gif"));
		    else if(this.getIs_Pole()==false)
				this.setImage(Toolkit.getDefaultToolkit().
				    createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieLostHeadWalk.gif"));
		    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
		    	Thread.sleep(this.getWalkSpeed());
		    	this.setPosX(getPosX() - 1);
	        }			
		    
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieDie.gif"));
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
					createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieLostHeadAttack.gif"));
			
	    	Thread.sleep(this.getEatSpeed() * 6);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieDie.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public void isEat() {
		boolean flag = true;
		if (this.controller.getPlants() != null) {
			for (Plant plant : this.controller.getPlants()) {
				int posX = this.getPosX();
				int posY = this.getPosY();
				if((posX - 150 - 81)/81-1 == plant.getPosX() &&	posY == plant.getPosY() && !plant.getName().equals("Spikeweed")) {
					if(this.getIs_Pole()) {					
						Jump1();
						if(!plant.getName().equals("TallNut")) {
							Jump2();
						}
						
						setWalkSpeed(this.getWalkSpeed()+40);
						this.setIs_Pole(false);
					}
					else {
						this.setStatus(1);
						this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieAttack.gif"));
						this.setPlant(plant);
						flag = false;
					break; 
					}
				}
			}
		}
		if (flag) {
			this.setStatus(0);
			if(this.getIs_Pole()==true)
				this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombie.gif"));
			else if(this.getIs_Pole()==false)
			    this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieWalk.gif"));
		}	
	}

	
	public boolean getIs_Pole() {
		return is_Pole;
	}

	public void setIs_Pole(boolean is_Pole) {
		this.is_Pole = is_Pole;
	}
}
