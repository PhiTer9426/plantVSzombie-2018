package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class ConeheadZombie extends Zombie {

	private Controller controller;
	private boolean is_Cone;     //true为有帽子
	private int Cone_health;
	
	public ConeheadZombie(Controller controller){
		super((int)(Math.random() * 5), controller);
		this.setIs_Cone(true);
		this.setCurrent_health(30); //待修改
		this.setCone_health(20);
		this.setWalkSpeed(60);
		this.setEatSpeed(500);
	    this.setImage(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/ConeheadZombie/ConeheadZombie.gif"));
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
			if(this.getIs_Cone() == true) {            //有铁桶才需要判定
			    //if (this.getNewsPaper_health() <= 0) {      //报纸生命耗尽
				if(this.getCurrent_health()<=10) {
				    this.setIs_Cone(false);
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
	public void isEat() {
		boolean flag = true;
		for (Plant plant : this.controller.getPlants()) {
			int posX = this.getPosX();
			int posY = this.getPosY();
			if((posX - 150 - 81)/81 == plant.getPosX() && posY == plant.getPosY()
							&& plant.getName() != "Spikeweed") {
					this.setStatus(1);
					if(getIs_Cone() == true)
					    this.setImage(Toolkit.getDefaultToolkit().
					    		createImage("plantsVsZombieMaterials/images/Zombies/ConeheadZombie/ConeheadZombieAttack.gif"));
					else if(getIs_Cone() == false)
						this.setImage(Toolkit.getDefaultToolkit().
								createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieAttack.gif"));
					this.setPlant(plant);
					flag = false;
			}
		}
		if (flag) {
			this.setStatus(0);
			if(this.getIs_Cone()==true)
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/ConeheadZombie/ConeheadZombie.gif"));
			else if(this.getIs_Cone()==false)
			    this.setImage(Toolkit.getDefaultToolkit().
			    		getImage("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif"));
		}
		
	}

	public int getCone_health() {
		return Cone_health;
	}

	public void setCone_health(int cone_health) {
		Cone_health = cone_health;
	}

	public boolean getIs_Cone() {
		return is_Cone;
	}

	public void setIs_Cone(boolean is_Cone) {
		this.is_Cone = is_Cone;
	}
}
