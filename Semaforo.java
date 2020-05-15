
package eserciziodeicavalli;

import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class Semaforo implements Serializable{
    private int num;
    
    public Semaforo(int valore){
        this.num = valore;
    }
    public synchronized int acquire(int corsia){
        int vincit = 0;
        if(num == 1){
           vincit = corsia;
           num = 0;
        }
        return vincit;
    }
}
