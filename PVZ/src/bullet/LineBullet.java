package bullet;

public abstract class LineBullet extends Bullet {
	public LineBullet(int posX, int posY) {
		// TODO 自动生成的构造函数存根
		super(posX, posY);
	}
	
	
	public boolean isBeyondBorder() {
		if(getPosX() > 1000 || getPosX() < 0 ) {
			return true;
		}
		return false;
	}
}
