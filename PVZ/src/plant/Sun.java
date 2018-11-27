package plant;

import java.awt.Image;
import java.util.Random;

import javax.swing.JLabel;

public class Sun{
	private int posX;
	private int posY;
	
	private int tposY;	
	
	private boolean existent;
	
	private Image image;
	
	public Sun(int x, int y, int ty){

		this.setExistent(true);
		this.setPosX(x);
		this.setPosY(y);
		this.setTposY(ty);
		
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isExistent() {
		return existent;
	}

	public void setExistent(boolean existent) {
		this.existent = existent;
	}

	public int getTposY() {
		return tposY;
	}

	public void setTposY(int tposY) {
		this.tposY = tposY;
	}
}
