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
		// TODO 自动生成的方法存根
		
	}

	public void WalkAfterDie() {
		// TODO 自动生成的方法存根
		
	}

	public void EatAfterDie() {
		// TODO 自动生成的方法存根
		
	}

	public void run() {
		// TODO 自动生成的方法存根
		
	}

}
