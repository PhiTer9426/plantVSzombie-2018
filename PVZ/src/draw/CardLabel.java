package draw;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import controller.Controller;

public class CardLabel extends JLabel implements Runnable{
	private int cd;
	private int leftCd;
	
	private String name;
	private Thread t;
	private Controller controller;
	
	public CardLabel(String name, int index,
			Controller controller, GameView game , int cd) {
		// TODO Auto-generated constructor stub
		this.setIcon(new ImageIcon(
				"plantsVsZombieMaterials/images/Card/Plants/" + name + "_01.gif"));

		this.setBounds(10, 10 + index * 60, 100, 60);
		
		this.name = name;
		this.cd = cd;
		this.leftCd = 0;
		this.controller = controller;
		
		
		this.start();
		
		this.setBounds(10, index * 60, 100, 60);

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {								
				if(leftCd <= 0) {
					controller.setMouse(name);
					game.setPreIcon(
							"plantsVsZombieMaterials/images/Plants/" + name + "/" + name + ".gif",
							"plantsVsZombieMaterials/images/Plants/" + name + "/" + name + ".gif");
					leftCd = cd;
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
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(leftCd <= 0) {
				this.setIcon(new ImageIcon(
						"plantsVsZombieMaterials/images/Card/Plants/" + name + "_01.gif"));
			}
			else {
				this.setIcon(new ImageIcon(
						"plantsVsZombieMaterials/images/Card/Plants/" + name + "_03.gif"));
				leftCd--;
			}
		}
	}

}
