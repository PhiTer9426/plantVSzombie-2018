package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class FootballZombie extends Zombie {

	private Controller controller;
	private boolean is_Orn;     //true为有头盔
	private int Orn_health;
	
	public FootballZombie(int y, Controller controller){
		super(y, controller);
		this.setIs_Orn(true);
		this.setCurrent_health(60);
		this.setOrn_health(50);
		this.setWalkSpeed(30);
		this.setEatSpeed(500);
		this.setImage(Toolkit.getDefaultToolkit().
				getImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/FootballZombie.gif"));
	    this.setImageOfDie(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif"));
		this.controller = controller;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while(this.getIs_alive()) {
			isEat();			
			if (this.getStatus() == 0) {
				Walk();
			}
			else if (this.getStatus() == 1) {
				Eat();
			}
			if(this.getIs_Orn() == true) {            
			    //if (this.getNewsPaper_health() <= 0) {      
				if(this.getCurrent_health()<=10) {
				    this.setIs_Orn(false);
			    }
			}
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
		}
		if(this.getDeath()==0) {
			if(this.getStatus() == 0){
			    WalkOfDie();
	        }
		    else if(this.getStatus() == 1) {
			    EatOfDie();
		    }
		}
		else if(this.getDeath()==1) {    //炸死
			DieBoom();
		}
		
	}
	
	@Override
	public void Eat() {	
		try {   
			for(int i = 0; i < 10; i++) {
			Thread.sleep(this.getEatSpeed() / 10);
			    if (this.getColdTime() > 0) {
				    Thread.sleep(this.getEatSpeed() / 10);
				    setColdTime(getColdTime() - 1);
			    }
			    if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
			        break;
			    }
			}
//			this.playMusic("plantsVsZombieMaterials/audio/chomp.mp3");
			this.getPlant().receiveDamage(2);           //两倍伤害
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public void isEat() {
		boolean flag = true;
		for (Plant plant : this.controller.getPlants()) {
			int posX = this.getPosX();
			int posY = this.getPosY();
			if((posX - 150 - 81)/81 == plant.getPosX() && posY == plant.getPosY()
					&& plant.getName() != "Spikeweed") {
					this.setStatus(1);
					if(getIs_Orn() == true)
					    this.setImage(Toolkit.getDefaultToolkit().
					    		createImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/FootballZombieAttack.gif"));
					else if(getIs_Orn() == false)
						this.setImage(Toolkit.getDefaultToolkit().
								createImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/FootballZombieOrnLostAttack.gif"));
					this.setPlant(plant);
					flag = false;
					break;
			}
		}
		if (flag) {
			this.setStatus(0);
			if(this.getIs_Orn()==true)
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/FootballZombie.gif"));
			else if(this.getIs_Orn()==false)
			    this.setImage(Toolkit.getDefaultToolkit().
			    		getImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/FootballZombieOrnLost.gif"));
		}
		
	}
	@Override
	public void WalkOfDie() {
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
			this.setImage(Toolkit.getDefaultToolkit().
				    createImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/LostHead.gif"));
		    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
		    	Thread.sleep(this.getWalkSpeed());
		    	this.setPosX(getPosX() - 1);
	        }			
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/Die.gif"));
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
					createImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/LostHeadAttack.gif"));
			
	    	Thread.sleep(this.getEatSpeed() * 2);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/FootballZombie/Die.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public boolean getIs_Orn() {
		return is_Orn;
	}

	public void setIs_Orn(boolean is_Orn) {
		this.is_Orn = is_Orn;
	}

	public int getOrn_health() {
		return Orn_health;
	}

	public void setOrn_health(int orn_health) {
		Orn_health = orn_health;
	}
	
}
