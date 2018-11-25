package zombie;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;

public class PoleVaultingZombie extends Zombie implements Runnable {

	private Controller controller;
	private Thread t;
	private boolean is_Pole=true;//只改到这行
	
	public PoleVaultingZombie(Controller controller){
		super((int)(Math.random() * 5));
		
		this.setCurrent_health(10);
		this.setWalkSpeed(30);
		this.setEatSpeed(500);
		
				
		
		this.controller = controller;
		this.start();
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.getIs_alive()) {
			boolean flag = true;
			for (Plant plant : this.controller.getPlants()) {
				int posX = this.getPosX();
				int posY = this.getPosY();
				if ((posX - 150 - 81)/81 == plant.getPosX() &&
						posY == plant.getPosY()) {
					this.setStatus(1);
					this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieAttack.gif").getImage());
					this.setPlant(plant);
					flag = false;
					break; 
				}
			}
			if (flag) {
				this.setStatus(0);
				this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif").getImage());
			}	
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
			if (this.getStatus() == 0) {
				Walk();
			}				
			else if (this.getStatus() == 1) {
				Eat();
			}	
		}
		if(this.getDeath()==0) {
		    this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
		    this.setImageOfDie(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif").getImage());
		    if(this.getStatus()==0){
			    this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieLostHead.gif").getImage());
			    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
			    	WalkOfDie();	
		        }
	        }
		    else if(this.getStatus()==1) {
			    this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieLostHeadAttack.gif").getImage());
			    int times=0;
			    while(times<6) {
			    	EatOfDie();
				    times+=1;
			    }
		    }
		    Die_0();
		}
		else if(this.getDeath()==1) {    //炸死
			Die_1();
		}
		
	}
	
	public void Walk() {
		try {
			Thread.sleep(this.getWalkSpeed());
			this.setPosX(getPosX() - 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void WalkOfDie() {
		try {
			Thread.sleep(this.getWalkSpeed());
			this.setPosX(getPosX() - 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void Eat() {	
		try {
			Thread.sleep(this.getEatSpeed());
			this.getPlant().receiveDamage(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void EatOfDie() {	
		try {
			Thread.sleep(this.getEatSpeed());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void Die_0() {		
		try {
		    this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieDie.gif").getImage());
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void Die_1() {		
		try {
		    this.setImage(new ImageIcon("plantsVsZombieMaterials/images/Zombies/Zombie/BoomDie.gif").getImage());
			Thread.sleep(1000);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
