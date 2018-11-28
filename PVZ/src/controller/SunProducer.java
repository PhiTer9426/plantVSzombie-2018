package controller;

import plant.ProduceSun;

import java.util.concurrent.CopyOnWriteArrayList;

public class SunProducer implements Runnable{
	private Controller controller;
	private Thread t;
	public SunProducer(Controller controller) {
		super();
		
		this.controller =controller;
		this.start();
	}

	public void start() {
		if(t==null)
		{
			t =new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while(true)
		{
			try {
				this.controller.getSuns().add(new ProduceSun(
						(int)(Math.random() * 500) + 200,
						0,
						(int)(Math.random() * 400) + 100));
				Thread.sleep(8000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
