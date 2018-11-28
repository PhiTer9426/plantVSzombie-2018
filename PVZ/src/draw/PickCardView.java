package draw;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PickCardView extends JLayeredPane{
	private String[] picked;
	private ArrayList<PickCardLabel> cards;
	
	private JLabel backgroud;
	private JLabel chooseArea;
	
	private JPanel tip;
	private MainView parent;
	
	public PickCardView(MainView parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.setBounds(0, 0, 900, 600);		
		this.picked = new String[10];
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
	}
	
	public void addCard() {
		this.cards.add(new PickCardLabel("Peashooter", 0, this));
		this.cards.add(new PickCardLabel("WXZ", 1, this));
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
		this.cards.add(new PickCardLabel("Torchwood", 13, this));
		this.cards.add(new PickCardLabel("Jalapeno", 14, this));
		
		for (PickCardLabel pickCardLabel : cards) {
			this.add(pickCardLabel, new Integer(3));
		}
	}
	
	public void setCard(String name) {
		boolean flag = true;
		for (int i = 0; i < picked.length; i++) {
			if (picked[i] == null) {
				picked[i] = name;
				flag = false;
				break;
			}
		}
		if (flag) {
			this.tip.setVisible(true);
		}
	}
	
	public void removeCard(String name) {
		for (int i = 0; i < picked.length; i++) {
			if (picked[i].equals(name)) {
				picked[i] = null;
				break;
			}
		}
	}
}
