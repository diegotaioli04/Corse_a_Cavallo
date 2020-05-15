
package eserciziodeicavalli;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Cavallo implements Runnable {
    private String nome;
    private int num_corsia;
    private Semaforo accesso;

    public Cavallo(int corsia, Semaforo s) {
        this.num_corsia = corsia;
        this.accesso = s;
    }
    public int getCorsia(){
        return num_corsia;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                sleep(100);
            } catch (InterruptedException ex) {}
        }
        System.out.println("Il cavallo della corsia "+this.getCorsia()+" è arrivato");
        if(accesso.acquire(num_corsia)==this.num_corsia){
            System.out.println("Il voncitore è il cavallo numero: "+num_corsia);
        }      
    }
    
}
