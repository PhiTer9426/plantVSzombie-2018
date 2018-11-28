package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import controller.Controller;

public class CardLabel extends JLabel implements Runnable{
	private long firstTime;
	private long nextTime;
	
	private long cd;
	private boolean isBegin;
	
	private String name;
	private Thread t;
	private Controller controller;
	
	public CardLabel(String name, int index,
			Controller controller, GameView game , long cd) {
		// TODO Auto-generated constructor stub
		this.setIcon(new ImageIcon(
				"plantsVsZombieMaterials/images/Card/Plants/" + name + "_01.gif"));
		this.setBounds(10, 10 + index * 60, 100, 60);
		
		this.isBegin=true;
		this.name=name;
		this.cd=cd;
		this.controller=controller;
		
		firstTime=System.currentTimeMillis();
		
		this.start();
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
								
				if(isBegin) {
				controller.setMouse(name);
				game.setPreIcon(
						"plantsVsZombieMaterials/images/Plants/" + name + "/" + name + ".gif",
						"plantsVsZombieMaterials/images/Plants/" + name + "/" + name + ".gif");
				isBegin=false;
				
				firstTime = nextTime;				
				}
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});	
	}

	public void start() {
		if(t==null) {
			t=new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while(true) {
			nextTime=System.currentTimeMillis();
			if(isBegin) {
				this.setIcon(new ImageIcon(
						"plantsVsZombieMaterials/images/Card/Plants/" + name + "_01.gif"));
			}
			else {
				setIcon(new ImageIcon(
						"plantsVsZombieMaterials/images/Card/Plants/" + name + "_03.gif"));
				//System.out.println(nextTime-firstTime);
			}
			if(nextTime-firstTime>=cd) {
				isBegin=true;
			}
		}
	}

}
