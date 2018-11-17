//package draw;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JLayeredPane;
//
//
//import plant.Peashooter;
//
//public class GameView extends JLayeredPane{
//	private JLabel backgroud;
//	private JLayeredPane toolbar;
//	private JLabel button;
//	
//	private MainView parent;
//	
//	public GameView(MainView parent) {
//		// TODO Auto-generated constructor stub
//		this.setBounds(0, 0, 900, 600);
//		this.parent = parent;
//		parent.getContainer().add(this);
//	}
//	
//	public void init() {
//		backgroud = new JLabel();
//		backgroud.setIcon(
//				new ImageIcon("plantsVsZombieMaterials/images/interface/background1.jpg"));
//		backgroud.setBounds(0, 0, 900, 600);
//		this.add(backgroud, new Integer(1));	
//		
//		button = new JLabel();
//		button.setIcon(
//				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
//		button.setBounds(787, 0, 113, 41);
//		this.add(button, new Integer(2));
//	}
//	
//	
//	
//	button.addMouseListener(new MouseAdapter() {
//		public void mousePressed(MouseEvent e) {
//			button.setBounds(787, 2, 113, 41);
//		}				
//		public void mouseClicked(MouseEvent e) {
//			parent.showMenu();
//		}
//		public void mouseExited(MouseEvent e) {
//			button.setBounds(787, 0, 113, 41);
//		}	
//	});	
//	
//	this.addMouseListener(new MouseAdapter() {
//		public void mouseClicked(MouseEvent e) {
//			addPlant((e.getX()-155)/80, (e.getY()-95)/90);
//		}
//	});	
//	
//	public void addPlant(int x, int y) {
//		parent.controller.getPlants().add(new Peashooter(x, y));
//	}
//}
