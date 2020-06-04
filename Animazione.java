

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Diego
 */
public class Animazione extends JPanel{
    int ascisse;
    int ordinate;
    Image img; 
    
    /**
     *
     * @param xx {@code int}
     * @param yy {@code int}
     */
    public Animazione(int xx, int yy){
        ascisse = 0;
        this.ordinate = yy;
        this.setSize(80, 81);
        Toolkit tk = Toolkit.getDefaultToolkit();
        switch(xx){
            case 1: {img = tk.getImage("knight.jpg");}
            case 2: {img = tk.getImage("knight.jpg");}
            case 3: {img = tk.getImage("knight.jpg");}
            case 4: {img = tk.getImage("knight.jpg");}
            case 5: {img = tk.getImage("knight.jpg");}
            case 6: {img = tk.getImage("knight.jpg");}
        }
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 1);
        try{
            mt.waitForID(1);
        }catch(InterruptedException e){};
    }
    public int getAvanzamento(){
        return ascisse;
        /** 
         * @return 
         */
    }
    public void setAvanzamento(int x){
        this.ascisse = x;
    }
    public void paint(Graphics g){
        g.drawImage(img, ascisse, ordinate, null);
    }
}
