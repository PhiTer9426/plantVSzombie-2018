 package draw;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import plant.Peashooter;
import plant.Plant;


public class MainView extends JFrame{
	private Container container;
	private MenuView Menu;
	private GameView game;
	private PickCardView pickup;
	private PassLevel pass;
	private int level;
	
	public MainView() {
		// TODO Auto-generated constructor stub
		super("Plants Vs Zombies");
		this.setIconImage(new ImageIcon("plantsVsZombieMaterials/images/interface/SmallLogo.png").getImage());
		this.container = this.getContentPane();	
		
		this.Menu = new MenuView(this);
		this.container.add(Menu);
		this.pickup = new PickCardView(this);
		this.container.add(pickup);
		this.level = 3;
		showMenu();
		
		this.setSize(905, 640);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public void showGame(String[] picked) {
		if (game != null) {
			this.container.remove(game);
			game = null;
		}
		game = new GameView(this, level, picked);
		this.container.add(game);
		Menu.setVisible(false);
		pickup.setVisible(false);
		if (pass != null) {
			this.container.remove(pass);
			pass = null;
		}
	}
	
	public void showPickup() {
		if (game != null) {
			game.setVisible(false);
		}
		Menu.setVisible(false);
		pickup.setVisible(true);
		if (pass != null) {
			this.container.remove(pass);
			pass = null;
		}
	}
	
	public void showMenu() {
		if (game != null) {
			game.setVisible(false);
		}
		Menu.setVisible(true);
		pickup.setVisible(false);
		if (pass != null) {
			this.container.remove(pass);
			pass = null;
		}
	}
	
	public void showPass() {
		Menu.setVisible(false);
		pickup.setVisible(false);
		pass = new PassLevel(level, this);
		this.container.add(pass);
		if (game != null) {
			game.setVisible(false);
		}
	}
	
	public Container getContainer() {
		return container;
	}
	

	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
}
