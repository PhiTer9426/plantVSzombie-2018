package draw;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bullet.Bullet;
import controller.Controller;
import plant.Plant;
import zombie.Zombie;

public class DrawPanel extends JPanel{
	private Controller controller;
	Image plant;

	public DrawPanel(Controller controller) {
		this.controller = controller;
		this.setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (controller.getBullets().size() != 0) {
			for (Bullet bullet : controller.getBullets()) {
				g.drawImage(
						bullet.getImage(), 
						bullet.getPosX() - bullet.getImage().getWidth(null) + 10,
						bullet.getPosY() - bullet.getImage().getHeight(null) - 40, null);
			}
		}
		if (controller.getPlants().size() != 0) {
			for (Plant plant : controller.getPlants()) {
				g.drawImage(
						plant.getImage(), 
						150 + 81 + 81 * plant.getPosX() - plant.getImage().getWidth(null),
						90 + 92 + 92 * plant.getPosY() - plant.getImage().getHeight(null), null);
			}
		}
		if (controller.getZombies().size() != 0) {
			for (Zombie zombie : controller.getZombies()) {
					g.drawImage(
						zombie.getImage(), 
						zombie.getPosX() - zombie.getImage().getWidth(null),
						90 + 92 + 92 * zombie.getPosY() - zombie.getImage().getHeight(null), null);
					if((zombie.getIs_alive()==false)&&(zombie.getDeath()==0)) {
						if(zombie.getStatus()==0) {
					        g.drawImage(
							    zombie.getImageOfDie(), 
							    zombie.getDiePosX() - zombie.getImageOfDie().getWidth(null)+81,
							    90 + 92 + 92 * zombie.getDiePosY() - zombie.getImageOfDie().getHeight(null), null);
						}//只有第一只僵尸头会跳
						
						/*else if(zombie.getStatus()==1) {
							g.drawImage(
								    zombie.getImageOfDie(), 
								    zombie.getDiePosX() - zombie.getImageOfDie().getWidth(null)-500,
								    90 + 92 + 92 * zombie.getDiePosY() - zombie.getImageOfDie().getHeight(null), null);
						}*/
						//如果加上这一段，会卡，无法理解
					}
			}
		}
//		switch (controller.getMouse()) {
//		case "WXZ":
//			this.plant = new ImageIcon("plantsVsZombieMaterials/images/Plants/WXZ/WXZ.gif").getImage();
//			g.drawImage(plant, 100, 100, null);
//			break;
//		case "Peashooter":
//			this.plant = new ImageIcon("plantsVsZombieMaterials/images/Plants/Peashooter/Peashooter.gif").getImage();
//			g.drawImage(plant, 100, 100, null);
//			break;
//		case "SnowPea":
//			this.plant = new ImageIcon("plantsVsZombieMaterials/images/Plants/SnowPea/SnowPea.gif").getImage();
//			g.drawImage(plant, 100, 100, null);
//			break;
//		case "WallNut":
//			this.plant = new ImageIcon("plantsVsZombieMaterials/images/Plants/WallNut/WallNut.gif").getImage();
//			g.drawImage(plant, 100, 100, null);
//			break;
//		case "TallNut":
//			this.plant = new ImageIcon("plantsVsZombieMaterials/images/Plants/TallNut/TallNut.gif").getImage();
//			g.drawImage(plant, 100, 100, null);
//			break;
//		default:
//			break;
//		}
	}
}
