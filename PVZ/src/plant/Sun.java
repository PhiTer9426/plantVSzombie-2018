package plant;

import java.awt.Image;
import java.util.Random;

import javax.swing.JLabel;

public class Sun{
	private int posX;
	private int posY;
	
	private int tposX;
	private int tposY;
	
	
	private boolean existent;
	
	private Image image;
	
	public Sun(){

		Random r =new Random();
		int random = r.nextInt(500)+200;
		int randomx = r.nextInt(500)+200;
		int randomy = r.nextInt(500)+100;
		this.setExistent(true);
		this.setPosX(random);
		this.setPosY(0);
		this.setTposX(randomx);
		this.setTposY(randomy);
		
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

	public int getTposX() {
		return tposX;
	}

	public void setTposX(int tposX) {
		this.tposX = tposX;
	}

	public int getTposY() {
		return tposY;
	}

	public void setTposY(int tposY) {
		this.tposY = tposY;
	}
}
