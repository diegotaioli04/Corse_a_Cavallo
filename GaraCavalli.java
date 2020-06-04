
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author Diego
 */
public class GaraCavalli extends JFrame{
    private Cavallo_in_Corsa [] cav;
    Animazione[] parte;
    Thread[] concorrenti;
    private int num_corsie = 2;
    Pista campo;
    int posizione;
    Graphics graf;
    Image virtual;
    
    public GaraCavalli(int cor){
        this.num_corsie = cor;
        setSize(1000, 945);
        setLocation(10, 40);
        /*do {
            System.out.println("Inserisci il numero: ");
            Scanner input = new Scanner(System.in);
            num_corsie = input.nextInt();
        }while(num_corsie < 2|| num_corsie>10);*/
        cav = new Cavallo_in_Corsa[num_corsie];
        parte = new Animazione[num_corsie];
        concorrenti = new Thread[num_corsie];
        campo = new Pista(num_corsie);
        int start = 15;
        for(int i = 0; i<num_corsie; i++){
            parte[i] = new Animazione(start, i+1);
            cav[i] = new Cavallo_in_Corsa(parte[i], i+1, this);
            concorrenti[i] = new Thread(cav[i]);
            start = start + 100;        
        }
        posizione = 1;
        for(int i = 0; i<num_corsie; i++){
            concorrenti[i].start();
        }
        this.add(campo);
        setVisible(true);
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
        int pos = 0, i = 0;
        for(int j = 0; j < this.getCorsie(); j++){
            i++;
            pos = cav[j].posizione;
            terminati[j] = new JLabel("il numero: "+i+" è arrivato: "+pos);
            terminati[j].setFont(new Font("Arial", Font.ROMAN_BASELINE,18));
            terminati[j].setForeground(Color.GREEN);
            classificato.getContentPane().add(terminati[j]);
        }
        classificato.setVisible(true);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        if(parte != null){
            Graphics2D schermo = (Graphics2D)g;
            virtual = createImage(1000, 845);
            graf = virtual.getGraphics();
            Dimension d = getSize();
            campo.paint(graf);
            for(int i = 0; i<this.num_corsie; i++){
                parte[i].paint(graf);
            }
            schermo.drawImage(virtual, 0, 20, this);
            graf.dispose();
        }
    }
}
