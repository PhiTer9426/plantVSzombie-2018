package draw;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PickCardView extends JPanel{
	private String[] picked;
	private JLabel backgroud;
	private JLabel chooseArea;
	private JLabel[] cards;
	
	public PickCardView() {
		// TODO Auto-generated constructor stub
		this.picked = new String[10];
		this.backgroud = new JLabel(new ImageIcon
				("plantsVsZombieMaterials/images/interface/background1.jpg"));
		this.chooseArea = new JLabel(new ImageIcon
				("plantsVsZombieMaterials/images/interface/SeedChooser_Background.png"));
		
		this.add(backgroud);
	}
	
	public void setCard(String name, int index) {
		this.picked[index] = name;
	}
}
