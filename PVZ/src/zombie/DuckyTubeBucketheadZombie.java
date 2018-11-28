package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class DuckyTubeBucketheadZombie extends Zombie {

	private Controller controller;
	private boolean is_Bucket;     //true为有帽子
	private int Bucket_health;
	
	public  DuckyTubeBucketheadZombie(Controller controller){
		
		super((int)(Math.random()*5), controller);  //只在三四行出现
		this.setIs_Bucket(true);
		this.setCurrent_health(40); 
		this.setBucket_health(30);
		this.setWalkSpeed(60);
		this.setEatSpeed(500);
		 this.setImage(Toolkit.getDefaultToolkit().
		    		createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie3/Walk1.gif"));
		    this.setImageOfDie(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead.gif"));
		this.controller = controller;
	}
	
	@Override
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
			if(this.getIs_Bucket() == true) {            
			    //if (this.getNewsPaper_health() <= 0) {      
				if(this.getCurrent_health()<=10) {
				    this.setIs_Bucket(false);
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
					if(getIs_Bucket() == true)
					    this.setImage(Toolkit.getDefaultToolkit().
					    		createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie3/Attack.gif"));
					else if(getIs_Bucket() == false)
						this.setImage(Toolkit.getDefaultToolkit().
								createImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Attack.gif"));
					this.setPlant(plant);
					flag = false;
					break;
			}
		}
		if (flag) {
			this.setStatus(0);
			if(this.getIs_Bucket() == true && this.getPosX() >= 935)
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie3/Walk1.gif"));
			if(this.getIs_Bucket() == true && this.getPosX() < 935)
			    this.setImage(Toolkit.getDefaultToolkit().
			    		getImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie3/Walk2.gif"));
			if(this.getIs_Bucket() == false && this.getPosX() >= 935)
				this.setImage(Toolkit.getDefaultToolkit().
			    		getImage("plantsVsZombieMaterials/images/Zombies/DuckyTubeZombie1/Walk1.gif"));
			if(this.getIs_Bucket() == false && this.getPosX() < 935)
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

	public boolean getIs_Bucket() {
		return is_Bucket;
	}

	public void setIs_Bucket(boolean is_Bucket) {
		this.is_Bucket = is_Bucket;
	}

	public int getBucket_health() {
		return Bucket_health;
	}

	public void setBucket_health(int bucket_health) {
		Bucket_health = bucket_health;
	}

}
