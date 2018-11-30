package draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PickCardView extends JLayeredPane{
	private String[] picked;
	private ArrayList<PickCardLabel> cards;
	private int num;
	
	private JLabel backgroud;
	private JLabel chooseArea;
	private JLabel button;
	private JLabel buttonStart;
	
	private JPanel tip;
	private MainView parent;
	
	public PickCardView(MainView parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.setBounds(0, 0, 900, 600);		
		this.picked = new String[10];
		this.num = 0;
		this.cards = new ArrayList<PickCardLabel>();
		
		initView();
		addCard();
		
	}
	
	public void initView() {
		this.backgroud = new JLabel(new ImageIcon
				("plantsVsZombieMaterials/images/interface/background1.jpg"));
		this.backgroud.setBounds(0, 0, 900, 600);
		this.add(backgroud , new Integer(1));
		
		this.chooseArea = new JLabel(new ImageIcon
				("plantsVsZombieMaterials/images/interface/SeedChooser_Background.png"));
		this.chooseArea.setBounds(0, 0, 465, 554);
		this.add(chooseArea, new Integer(2));
		
		//add menu button
		this.button = new JLabel();
		button.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Button.png"));
		button.setBounds(787, 0, 113, 41);
		this.add(button, new Integer(3));
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				button.setBounds(787, 2, 113, 41);
			}				
			public void mouseClicked(MouseEvent e) {
				parent.showMenu();
			}
			public void mouseExited(MouseEvent e) {
				button.setBounds(787, 0, 113, 41);
			}	
		});	
		
		//add start button
		this.buttonStart = new JLabel();
		buttonStart.setIcon(
				new ImageIcon("plantsVsZombieMaterials/images/interface/Start1.png"));
		buttonStart.setBounds(150, 555, 155, 39);
		this.add(buttonStart, new Integer(3));
		buttonStart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (num == 10) {
					buttonStart.setIcon(
							new ImageIcon("plantsVsZombieMaterials/images/interface/Start3.png"));
				}
			}				
			public void mouseClicked(MouseEvent e) {
				parent.showGame(picked);
			}
			public void mouseExited(MouseEvent e) {
				if (num == 10) {
					buttonStart.setIcon(
					new ImageIcon("plantsVsZombieMaterials/images/interface/Start2.png"));
				}
				else {
					buttonStart.setIcon(
					new ImageIcon("plantsVsZombieMaterials/images/interface/Start1.png"));
				}
			}	
		});	
	}
	
	public void addCard() {
		this.cards.add(new PickCardLabel("Peashooter", 0, this));
		this.cards.add(new PickCardLabel("Jalapeno", 1, this));
		this.cards.add(new PickCardLabel("CherryBomb", 2, this));
		this.cards.add(new PickCardLabel("Chomper", 3, this));
		this.cards.add(new PickCardLabel("PotatoMine", 4, this));
		this.cards.add(new PickCardLabel("Repeater", 5, this));
		this.cards.add(new PickCardLabel("SnowPea", 6, this));
		this.cards.add(new PickCardLabel("Spikeweed", 7, this));
		this.cards.add(new PickCardLabel("Squash", 8, this));
		this.cards.add(new PickCardLabel("SunFlower", 9, this));
		this.cards.add(new PickCardLabel("TallNut", 10, this));
		this.cards.add(new PickCardLabel("Threepeater", 11, this));
		this.cards.add(new PickCardLabel("WallNut", 12, this));
		this.cards.add(new PickCardLabel("LilyPad", 13, this));
		this.cards.add(new PickCardLabel("Torchwood", 14, this));
		this.cards.add(new PickCardLabel("WXZ", 15, this));
		
		for (PickCardLabel pickCardLabel : cards) {
			this.add(pickCardLabel, new Integer(3));
		}
	}
	
	public void setCard(String name) {
		for (int i = 0; i < picked.length; i++) {
			if (picked[i] == null) {
				picked[i] = name;
				num++;
				break;
			}
		}
		if (num == 10) {
			buttonStart.setIcon(
					new ImageIcon("plantsVsZombieMaterials/images/interface/Start2.png"));
		}
	}
	
	public void removeCard(String name) {
		for (int i = 0; i < picked.length; i++) {
			if (picked[i].equals(name)) {
				picked[i] = null;
				num--;
				break;
			}
		}
	}
	
	public int getNum() {
		return num;
	}
}
