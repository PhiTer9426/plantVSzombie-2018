package zombie;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;

public class PoleVaultingZombie extends Zombie implements Runnable {

	private Controller controller;
	private Thread t;
	private boolean is_Pole; //true为有杆子
	
	public PoleVaultingZombie(Controller controller){
		super((int)(Math.random() * 5));
		this.setIs_Pole(true);
		this.setCurrent_health(100);
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
				if((posX - 150 - 81)/81-1 == plant.getPosX() &&
						posY == plant.getPosY()&&this.getIs_Pole()==true) {
					Jump1();
					Jump2();
					setWalkSpeed(this.getWalkSpeed()+40);
					this.setIs_Pole(false);
				}
				else if (posX - 150 - plant.getImage().getWidth(null) <= plant.getPosX()*81+150 &&
						posX - 150 - plant.getImage().getWidth(null) > plant.getPosX()*81+150-81&&
						posY == plant.getPosY()&&this.getIs_Pole()==false) {
					this.setStatus(1);
					this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieAttack.gif"));
					this.setPlant(plant);
					flag = false;
					break; 
				}
			}
			if (flag) {
				this.setStatus(0);
				if(this.getIs_Pole()==true)
					this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombie.gif"));
				else if(this.getIs_Pole()==false)
				    this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieWalk.gif"));
			}	
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
			switch (this.getStatus()) {
			case 0:
				Walk();
				break;
			case 1:
				Eat();
				break;
			default:
				break;
			}
		}
		if(this.getDeath()==0) {
		    this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
		    this.setImageOfDie(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif"));
		    
		    if(this.getStatus()==0){
			    this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieLostHead.gif"));
			    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
			    	WalkOfDie();	
		        }
	        }
		    else if(this.getStatus()==1) {
			    this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieLostHeadAttack.gif"));
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
	
	public void Jump1() {		
		try {
			this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieJump.gif"));
			this.setPosX(this.getPosX());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void Jump2() {		
		try {
			this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/PoleVaultingZombie/PoleVaultingZombieJump2.gif"));
			this.setPosX(this.getPosX()-140);
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public boolean getIs_Pole() {
		return is_Pole;
	}

	public void setIs_Pole(boolean is_Pole) {
		this.is_Pole = is_Pole;
	}
}
