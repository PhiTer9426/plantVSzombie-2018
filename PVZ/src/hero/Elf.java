package hero;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import controller.Controller;
import plant.Plant;

public class Elf extends Hero {
	
    public Elf(int x, int y, Controller controller) {
		
		super(x, y);
		this.setName("Elf");
		this.setPrice(100);
		this.setIcon(new ImageIcon
				("plantsVsZombieMaterials/images/Heroes/Elf/Elf.gif"));
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (Plant plant : controller.getPlants()) {
					plant.setCurrent_health(plant.getMax_health());
					System.out.println(plant.getCurrent_health());
				}
			}
		});		
	}
}
		
		
