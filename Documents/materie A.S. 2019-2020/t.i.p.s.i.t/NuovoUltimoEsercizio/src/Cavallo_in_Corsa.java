
import static java.lang.Thread.sleep;



/**
 *
 * @author Diego
 */
public class Cavallo_in_Corsa implements Runnable {
    int corsia;
    Animazione mov;
    GaraCavalli race;
    int posizione, speed, cont;
    
    public Cavallo_in_Corsa(Animazione a, int c, GaraCavalli g){
        posizione = 0;
        this.mov = a;
        this.corsia = c;
        race = g;
        speed = 2;
        cont = 0;  
    }
    
     public void run() {
        int img = 79;
        int pista = 960;
        int a = 0;
        while((mov.getAvanzamento() + img) < pista){
            if((cont % 10) == 0){
                speed = (int)(Math.random()*4+1);
            }
            mov.setAvanzamento(mov.getAvanzamento()+speed);
            cont++;
        try {sleep(75);}
        catch (InterruptedException ex) {}
        race.repaint();
        }
        posizione = race.getPosizione();
        race.Arrivals(); 
        System.out.println("Il cavallo della corsia "+this.corsia+" è arrivato");
    }
}
