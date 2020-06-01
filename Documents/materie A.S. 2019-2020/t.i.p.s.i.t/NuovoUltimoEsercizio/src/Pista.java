
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



/**
 *
 * @author Diego
 */
public class Pista extends JPanel {
    int corsie;
    public Pista(int cor){
        this.corsie = cor;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(0, 0, 1000, 845);
        
        g.setColor(Color.white);

        g.fillRect(0, 0, 1000, 10);
        g.fillRect(0, 100, 1000, 10);
        g.fillRect(0, 200, 1000, 10);
        g.fillRect(0, 300, 1000, 10);
        g.fillRect(0, 400, 1000, 10);
        g.fillRect(0, 500, 1000, 10);
        g.fillRect(0, 600, 1000, 10);
        g.fillRect(0, 700, 1000, 10);
        g.fillRect(0, 800, 1000, 10);
        
        g.fillRect(960, 0, 5, 845);
        g.fillRect(970, 0, 5, 845);
        g.fillRect(980, 0, 5, 845);
    }
}
