package zombie;

import java.awt.Toolkit;

import controller.Controller;
import plant.Plant;

public class ScreenDoorZombie extends Zombie {
		private Controller controller;
		private boolean is_Door; //true为有门
		private int Door_health;
		
		public ScreenDoorZombie(int y, Controller controller){
			super(y, controller);
			this.setIs_Door(true);
			this.setCurrent_health(50);
			this.setDoor_health(40);
			this.setWalkSpeed(60);
			this.setEatSpeed(500);
			this.setImage(Toolkit.getDefaultToolkit().
					createImage("plantsVsZombieMaterials/images/Zombies/ScreenDoorZombie/ScreenDoorZombie.gif"));
		    this.setImageOfDie(Toolkit.getDefaultToolkit().
		    		createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieHead"));
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
				if(this.getIs_Door() == true) {            //有门才需要判定
				    //if (this.getNewsPaper_health() <= 0) {      //门生命耗尽
					if(this.getCurrent_health()<=10) {
					    this.setIs_Door(false);
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
				if ((posX - 150 - 81)/81 == plant.getPosX() &&
						posY == plant.getPosY() && plant.getName() != "Spikeweed")  {
						this.setStatus(1);
						if(getIs_Door() == true)
						    this.setImage(Toolkit.getDefaultToolkit().
						    		createImage("plantsVsZombieMaterials/images/Zombies/ScreenDoorZombie/ScreenDoorZombieAttack.gif"));
						else if(getIs_Door() == false)
							this.setImage(Toolkit.getDefaultToolkit().
									createImage("plantsVsZombieMaterials/images/Zombies/Zombie/ZombieAttack.gif"));
						this.setPlant(plant);
						flag = false;
						break;
				}
			}
			if (flag) {
				this.setStatus(0);
				if(this.getIs_Door()==true)
					this.setImage(Toolkit.getDefaultToolkit().
							getImage("plantsVsZombieMaterials/images/Zombies/ScreenDoorZombie/ScreenDoorZombie.gif"));
				else if(this.getIs_Door()==false)
				    this.setImage(Toolkit.getDefaultToolkit().
				    		getImage("plantsVsZombieMaterials/images/Zombies/Zombie/Zombie.gif"));
			}
			
		}
		public boolean getIs_Door() {
			return is_Door;
		}

		public void setIs_Door(boolean is_Door) {
			this.is_Door = is_Door;
		}

		public int getDoor_health() {
			return Door_health;
		}

		public void setDoor_health(int door_health) {
			Door_health = door_health;
		}
}
