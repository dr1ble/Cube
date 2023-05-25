import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private Cube _cube;

    private static int _WIDTH = 450;
    private static int _HEIGHT = 300;

    public Screen(Cube cube){
        _cube = cube;

        //this.setDoubleBuffered(true); //для JPanel
        this.setTitle("CUBE");
        this.setSize(_WIDTH, _HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        super.paint(g2d);

        g2d.translate(_WIDTH/2, _HEIGHT/2);

        _cube.draw(g2d);
    }
}
