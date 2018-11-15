package zombie;

import java.awt.Image;

public abstract class Zombie {
      private Image Mat;
      private int max_health;
      private int current_health;
      private float eatSpeed;
      private float walkSpeed;
      private int posX;
      private int posY;
      private Boolean is_alive;
      public abstract void Walk();
      public abstract void Eat();
      public abstract void Die();
      public abstract void WalkAfterDie();
      public abstract void EatAfterDie();

	public int getMax_health() {
		return max_health;
	}
	public void setMax_health(int max_health) {
		this.max_health = max_health;
	}
	public int getCurrent_health() {
		return current_health;
	}
	public void setCurrent_health(int current_health) {
		this.current_health = current_health;
	}
	public float getEatSpeed() {
		return eatSpeed;
	}
	public void setEatSpeed(float eatSpeed) {
		this.eatSpeed = eatSpeed;
	}
	public float getWalkSpeed() {
		return walkSpeed;
	}
	public void setWalkSpeed(float walkSpeed) {
		this.walkSpeed = walkSpeed;
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
	public Boolean getIs_alive() {
		return is_alive;
	}
	public void setIs_alive(Boolean is_alive) {
		this.is_alive = is_alive;
	}

	public Image getMat() {
		return Mat;
	}

	public void setMat(Image mat) {
		Mat = mat;
	}

}
