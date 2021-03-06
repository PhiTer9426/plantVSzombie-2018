package draw;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bullet.Bullet;
import controller.Controller;
import plant.Plant;
import plant.ProduceSun;
import plant.SunMove;
import zombie.Zombie;

public class DrawPanel extends JPanel{
	private Controller controller;
	Image plant;
	private boolean game;
	private GameView gm;
	
	public DrawPanel(Controller controller,GameView game) {
		this.controller = controller;
		this.setOpaque(false);
		this.game =true;
		gm=game;
		}

	public boolean getGame() {
		return game;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(game) {

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
				if((zombie.getIs_alive() == false) && (zombie.getDeath() == 0)) {
					if(zombie.getStatus() == 0) {
				        g.drawImage(
						    zombie.getImageOfDie(), 
						    zombie.getDiePosX() - zombie.getImageOfDie().getWidth(null) + 81,
						    90 + 92 + 92 * zombie.getDiePosY() - zombie.getImageOfDie().getHeight(null), null);
					}
					else if(zombie.getStatus() == 1) {
						g.drawImage(
							    zombie.getImageOfDie(), 

							    zombie.getDiePosX() - zombie.getImageOfDie().getWidth(null) + 81,

							    90 + 92 + 92 * zombie.getDiePosY() - zombie.getImageOfDie().getHeight(null), null);
					}
				}
				if(zombie.getPosX()<=50 && zombie.getIs_alive()) {
					game=false;
				}
			}
		}

		if(controller.getSuns()!=null) {
			for(ProduceSun sun : controller.getSuns()) {
				g.drawImage(sun.getImage(), sun.getPosX(),
						sun.getPosY(), null);
			}
		}

		if(controller.getMovingSun()!=null) {
			for(SunMove sun : controller.getMovingSun()) {
				g.drawImage(sun.getImage(), sun.getPosX(),
					sun.getPosY(), null);
			}
		}
//		
//		if (controller.getHero() != null) {
//			g.drawImage(controller.getHero().getImage(),
//						controller.getHero().getPosX(),
//						controller.getHero().getPosY(), null);
//		}
//		
		
		if(controller.getZombieProducer().isLastWave()) {
			gm.getEnd().setVisible(true);
		}
		else {
			gm.getEnd().setVisible(false);
		}
		
		if (controller.getZombieProducer().isIslastWaved()) {
			this.gm.getParent().showPass();
		}
	} 
	else {		
		g.drawImage(new ImageIcon("plantsVsZombieMaterials/images/interface/ZombiesWon.png").getImage(),
				420,200,200,200,null);
	}
	}
}
