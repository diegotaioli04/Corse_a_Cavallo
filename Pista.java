
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



/**
 *
 * @author Diego
 * aasdEGwrharher
 */
public class Pista extends JPanel {
    int corsie;

    /**
     *
     * @param cor {@code int}
     */
    public Pista(int cor){
        this.corsie = cor;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(0, 0, 1000, 945);
        
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
        g.fillRect(0, 900, 1000, 10);

        g.setColor(Color.BLACK);
        g.fillRect(970, 0, 10, 945);
        g.setColor(Color.WHITE);
        g.fillRect(980, 0, 10, 945);
        g.setColor(Color.BLACK);
        g.fillRect(990, 0, 10, 945);
    }
    /** 
     * <p> Il metodo paint crea le linee bianche 
     * che delimitano le corsie
     * @param g {@code Graphics} </p> */
    
}
