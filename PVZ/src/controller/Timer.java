package controller;

import draw.MainView;

public class Timer  implements Runnable{
	private Thread t;
	private MainView frame;
	
	public Timer() {
		// TODO Auto-generated constructor stub
		this.frame = new MainView();		
		this.start();
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try	{
				Thread.sleep(40);
				frame.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
	}

}
