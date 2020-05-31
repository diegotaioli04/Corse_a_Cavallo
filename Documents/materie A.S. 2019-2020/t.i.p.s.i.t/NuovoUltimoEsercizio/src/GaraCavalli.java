
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author Diego
 */
public class GaraCavalli {
    private Cavallo_in_Corsa [] cav;
    Thread[] concorrenti;
    private int num_corsie = 2;
    int posizione;
    
    public GaraCavalli(int cor){
        this.num_corsie = cor;
        /*do {
            System.out.println("Inserisci il numero: ");
            Scanner input = new Scanner(System.in);
            num_corsie = input.nextInt();
        }while(num_corsie < 2|| num_corsie>10);*/
        cav = new Cavallo_in_Corsa[num_corsie];
        concorrenti = new Thread[num_corsie];
        
        for(int i = 0; i<num_corsie; i++){
            cav[i] = new Cavallo_in_Corsa(i+1, this);
            concorrenti[i] = new Thread(cav[i]);
        }
        posizione = 1;
        for(int i = 0; i<num_corsie; i++){
            concorrenti[i].start();
        }
        
    }
    
    public int getCorsie(){
        return this.num_corsie;
    }
            
    public synchronized int getPosizione(){
        return posizione++;
    }
    
    public synchronized void Arrivals(){
        boolean arrivi = true;
        
        for (int i = 0; i < this.getCorsie(); i++){
            if(cav[i].posizione == 0){
                arrivi = false;
            }
        }
        
        if(arrivi == true){
            stampaClassifica();
        }
    }
    
    public void stampaClassifica(){
        JLabel[] terminati;
        terminati = new JLabel[getCorsie()];
        JFrame classificato = new JFrame("Classifica");
        classificato.setSize(500, 500);
        classificato.setLocation(280, 180);
        classificato.setBackground(Color.BLUE);
        classificato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        classificato.getContentPane().setLayout(new GridLayout(getCorsie(),1));
        int pos = 0;
        for(int j = 1; j < this.getCorsie(); j++){
            pos = cav[j].posizione;
            terminati[j] = new JLabel("il numero: "+j+" è arrivato: "+pos);
            terminati[j].setFont(new Font("TImes New Roman", Font.ITALIC,20));
            terminati[j].setForeground(Color.blue);
            classificato.getContentPane().add(terminati[j]);
        }
        classificato.setVisible(true);
    }
}
