
package eserciziodeicavalli;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class EsercizioDeiCavalli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaforo select = new Semaforo(1);
        Cavallo cav;
        int traguardo = 1, vincitore = 0;
        Thread[] corridori = new Thread[10];
        for(int i = 0; i< 10; i++){
            cav = new Cavallo(i+1, select);
            corridori[i] = new Thread(cav);
        }
        for(int i = 0; i < 10; i++){
            corridori[i].start();
        }
        for(int i = 0; i < 10; i++){
            while(corridori[i].isAlive()){
                try {
                    corridori[i].join();
                } catch (InterruptedException ex) {}
            }
        }
        
        
    }
    
}
