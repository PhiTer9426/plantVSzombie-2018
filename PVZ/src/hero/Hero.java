package hero;

import java.awt.Image;

import javax.swing.JLabel;

import controller.AudioFilePlayer;

public abstract class Hero extends JLabel{
	
	private String name;
	private	int posX;
	private	int posY;
	private int price;
	private Image image;
	private final AudioFilePlayer player;
	
	public Hero(int x, int y) {
		this.posX = x;
		this.posY = y;
		this.player = new AudioFilePlayer ();
		this.setBounds(x,y,200,200);
	}
	
	
	
	public void playMusic(String path) {
		player.play(path);
	}
	
	public String getName() {
		return this.name;
	}

	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getPrice() {
		return this.price;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

}

