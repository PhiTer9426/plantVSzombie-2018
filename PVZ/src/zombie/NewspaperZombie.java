package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class NewspaperZombie extends Zombie implements Runnable {
	private Controller controller;
	private boolean is_Newspaper; //true为有报纸
	private int newsPaper_health;
	
	public NewspaperZombie(Controller controller){
		super((int)(Math.random() * 5), controller);
		this.setIs_Newspaper(true);
		this.setCurrent_health(15);
		this.setNewsPaper_health(5);
		this.setWalkSpeed(60);
		this.setEatSpeed(1500);
		this.setImage(Toolkit.getDefaultToolkit().
				getImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/HeadWalk1.gif"));
	    this.setImageOfDie(Toolkit.getDefaultToolkit().
	    		createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/Head.gif"));
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
			if(this.getIs_Newspaper() == true && this.getDeath() == 0) {            //有报纸才需要判定
			    //if (this.getNewsPaper_health() <= 0) {      //报纸生命耗尽
				if(this.getCurrent_health()<=10) {
				    this.setIs_Newspaper(false);
				    LostPaper();
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
					if(getIs_Newspaper() == true)
					    this.setImage(Toolkit.getDefaultToolkit().
					    		createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/HeadAttack1.gif"));
					else if(getIs_Newspaper() == false)
						this.setImage(Toolkit.getDefaultToolkit().
								createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/HeadAttack0.gif"));
					this.setPlant(plant);
					flag = false;
					break;
			}
		}
		if (flag) {
			this.setStatus(0);
			if(this.getIs_Newspaper()==true)
				this.setImage(Toolkit.getDefaultToolkit().
						getImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/HeadWalk1.gif"));
			else if(this.getIs_Newspaper()==false)
			    this.setImage(Toolkit.getDefaultToolkit().
			    		getImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/HeadWalk0.gif"));
		}
		
	}
	@Override
	public void WalkOfDie() {
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 
		    if(this.getIs_Newspaper()==true)
			    this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/LostHeadWalk1.gif"));
		    else if(this.getIs_Newspaper()==false)
				this.setImage(Toolkit.getDefaultToolkit().
				    createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/LostHeadWalk0.gif"));
		    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
		    	Thread.sleep(this.getWalkSpeed());
		    	this.setPosX(getPosX() - 1);
	        }			
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/Die.gif"));
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
					createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/LostHeadAttack0.gif"));
			
	    	Thread.sleep(this.getEatSpeed() * 2);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/Die.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void LostPaper() {	
		try {   
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/NewspaperZombie/LostNewspaper.gif"));
			this.playMusic("plantsVsZombieMaterials/audio/newspaper_rarrgh2.mp3");
			for(int i = 0; i < 10; i++) {
			    Thread.sleep(5);
			    if (this.getCurrent_health() <= 0) {
					this.setIs_alive(false);
			        break;
			    }
			}
			this.setWalkSpeed(this.getWalkSpeed() - 36);
//			this.playMusic("plantsVsZombieMaterials/audio/chomp.mp3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean getIs_Newspaper() {
		return is_Newspaper;
	}


	public void setIs_Newspaper(boolean is_Newspaper) {
		this.is_Newspaper = is_Newspaper;
	}

	public int getNewsPaper_health() {
		return newsPaper_health;
	}

	public void setNewsPaper_health(int newsPaper_health) {
		this.newsPaper_health = newsPaper_health;
	}
}
