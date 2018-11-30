package hero;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;
import zombie.Zombie;

public class Demon extends Hero{
	
    public Demon(int x, int y, Controller controller) {
		
		super(x, y);
		this.setName("Demon");
		this.setPrice(300);
		this.setIcon(new ImageIcon(
				"plantsVsZombieMaterials/images/Heroes/Demon/Demon.gif"));
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (controller.getSun() > 200) {
					for (Zombie zombie : controller.getZombies()) {
						zombie.setDeath(1);
						zombie.setCurrent_health(zombie.getCurrent_health() - 90);
					}
					controller.getGame().addSunNumber(-200);
				}	    		
			}
		});		
    }
}
		    	