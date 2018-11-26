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
				Thread.sleep(20000);
				this.controller.getSuns().add(new ProduceSun(this.controller));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
