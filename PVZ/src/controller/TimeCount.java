package controller;

public class TimeCount implements Runnable{
	private Controller controller;
	private Thread t;
	private long time;
	private long time2;
	
	public TimeCount(Controller controller) {
		setTime2(System.currentTimeMillis());
		this.controller=controller;
		this.start();
	}
	
	public void start() {
		if(t==null) {
			t=new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while(true) {
			setTime(System.currentTimeMillis());
			//System.out.println(time2-time);
		}
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getTime2() {
		return time2;
	}

	public void setTime2(long time2) {
		this.time2 = time2;
	}
}
