package zombie;
import java.awt.Toolkit;
public class NormalZombie extends Zombie implements Runnable{
	public NormalZombie(){
		super();
		this.setMax_health(270);
		this.setCurrent_health(270);
		this.setMat(Toolkit.getDefaultToolkit().createImage("plantsVsZombieMaterials/images/Zombies/Zombie/0.gif"));
		this.setEatSpeed(100);
		this.setIs_alive(true);
		this.setPosX(50);
		this.setPosY(50);
		this.setWalkSpeed(50);
		}
	public void Walk() {

		
	}

	public void Eat() {
	
		
	}

	public void Die() {
		// TODO �Զ����ɵķ������
		
	}

	public void WalkAfterDie() {
		// TODO �Զ����ɵķ������
		
	}

	public void EatAfterDie() {
		// TODO �Զ����ɵķ������
		
	}

	public void run() {
		// TODO �Զ����ɵķ������
		
	}

}
