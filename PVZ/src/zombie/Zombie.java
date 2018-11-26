package zombie;

import java.awt.Image;
import java.awt.Toolkit;

import controller.AudioFilePlayer;
import controller.Controller;
import plant.Plant;

public abstract class Zombie implements Runnable{
	private Image image;
	private Image imageOfDie;
      
	private int current_health;
	private boolean is_alive;
	private int status;	 
	private int death;			
	private int coldTime;
	
      
	private int eatSpeed;
	private int walkSpeed;
	
	private int posX;
	private int posY;
	private int diePosX=getPosX();  
	private int diePosY=getPosY(); 
	
	private Plant plant;
	private final AudioFilePlayer player;
	private Controller controller;

	private Thread t;
	
	public Zombie(int y, Controller controller) {
		// TODO Auto-generated constructor stub
		this.is_alive = true;
		this.status = 0;
		this.setColdTime(0);
		this.posX = 1000;//pixel
		this.posY = y;//grid
		this.death=0;
		this.player = new AudioFilePlayer ();
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
			isEat();			
			if (this.getStatus() == 0) {
				Walk();
			}
			else if (this.getStatus() == 1) {
				Eat();
			}
			if (this.getCurrent_health() <= 0) {
				this.setIs_alive(false);
			}
		}
		if(this.getDeath()==0) {
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
		boolean flag = true;
		for (Plant plant : this.controller.getPlants()) {
			int posX = this.getPosX();
			int posY = this.getPosY();
			if ((posX - 150 - 81)/81 == plant.getPosX() &&
					posY == plant.getPosY()) {
				this.setStatus(1);
				this.setImage(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieAttack.gif"));
				this.setPlant(plant);
				flag = false;
				break; 
			}
		}
		if (flag) {
			this.setStatus(0);
			this.setImage(Toolkit.getDefaultToolkit().getImage("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif"));
		}	
	}
	
	public void Eat() {	
		try {
			Thread.sleep(this.getEatSpeed());
			if (this.getColdTime() > 0) {
				Thread.sleep(this.getEatSpeed());
				setColdTime(getColdTime() - 10);
			}
			this.playMusic("plantsVsZombieMaterials/audio/chomp.mp3");
			this.getPlant().receiveDamage(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void Walk() {
		try {
			Thread.sleep(this.getWalkSpeed());
			if (this.getColdTime() > 0) {
				Thread.sleep(this.getWalkSpeed());
				setColdTime(getColdTime() - 1);
			}
			this.setPosX(getPosX() - 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void WalkOfDie() {
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY());
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieLostHead.gif"));
			
		    while(this.getDiePosX()<(this.getPosX()+41)) {     //比死亡时走多41像素
		    	Thread.sleep(this.getWalkSpeed());
		    	this.setPosX(getPosX() - 1);
	        }			
		    
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieDie.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void EatOfDie() {	
		try {
			this.setDiePosX(getPosX());  
		    this.setDiePosY(getPosY()); 		    
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieLostHeadAttack.gif"));
			
	    	Thread.sleep(this.getEatSpeed() * 6);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieDie.gif"));
			Thread.sleep(1800);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void DieBoom() {		
		try {
		    this.setImage(Toolkit.getDefaultToolkit().
		    		createImage("plantsVsZombieMaterials/images/Zombies/Zombie/BoomDie.gif"));
			Thread.sleep(2500);
			this.controller.getZombies().remove(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void playMusic(String path) {
		player.play(path);
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCurrent_health() {
		return current_health;
	}
	public void setCurrent_health(int current_health) {
		this.current_health = current_health;
	}
	public int getEatSpeed() {
		return eatSpeed;
	}
	public void setEatSpeed(int eatSpeed) {
		this.eatSpeed = eatSpeed;
	}
	public int getWalkSpeed() {
		return walkSpeed;
	}
	public void setWalkSpeed(int walkSpeed) {
		this.walkSpeed = walkSpeed;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Boolean getIs_alive() {
		return is_alive;
	}
	public void setIs_alive(Boolean is_alive) {
		this.is_alive = is_alive;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image mat) {
		image = mat;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Image getImageOfDie() {
		return imageOfDie;
	}

	public void setImageOfDie(Image imageOfDie) {
		this.imageOfDie = imageOfDie;
	}

	public int getDiePosY() {
		return diePosY;
	}

	public void setDiePosY(int diePosY) {
		this.diePosY = diePosY;
	}

	public int getDiePosX() {
		return diePosX;
	}

	public void setDiePosX(int diePosX) {
		this.diePosX = diePosX;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public int getColdTime() {
		return coldTime;
	}

	public void setColdTime(int coldTime) {
		this.coldTime = coldTime;
	}

}
