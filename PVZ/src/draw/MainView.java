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
	private JLayeredPane Menu;
	private JLayeredPane game;
	
	public MainView() {
		// TODO Auto-generated constructor stub
		super("Plants Vs Zombies");
		this.setIconImage(new ImageIcon("plantsVsZombieMaterials/images/interface/SmallLogo.png").getImage());
		this.container = this.getContentPane();	
		
		this.Menu = new MenuView(this);
		this.container.add(Menu);
		this.game = new GameView(this);
		this.container.add(game);
		showMenu();
		
		this.setSize(918, 645);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void showGame() {
		game.setVisible(true);
		Menu.setVisible(false);
	}
	
	public void showMenu() {
		game.setVisible(false);
		Menu.setVisible(true);
	}
	
	public Container getContainer() {
		return container;
	}
	
}
