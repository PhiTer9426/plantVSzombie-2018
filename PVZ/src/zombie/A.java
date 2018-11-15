package zombie;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class A {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.add(new ImagePanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
      }
    });
  }
}
class ImagePanel extends JPanel {

  Image image;

  public ImagePanel() {
    image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\MACHENIKE\\Desktop\\PlantVsZombie\\PVZ\\plantsVsZombieMaterials\\images\\Zombies\\Zombie\\Zombie.gif");
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
      g.drawImage(image, 0, 0, this);
    }
  }
 }

