import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;



/**
 *
 * @author Diego
 */
public class Interfaccia extends JFrame implements ActionListener{
    JPanel p1;
    int corsie;
    Container c;
    JLabel l1, lab;
    JTextField testo1;
    JButton b1;

    public Interfaccia(){
        super("Ippodromo Meucci-Franchi");
        corsie = 0;
        c = this.getContentPane();
        this.setSize(300, 300);
        this.setLocation(280, 180);
        this.setBackground(Color.MAGENTA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        c.add(p1);
        c.setLayout(new FlowLayout(FlowLayout.LEADING));
        l1 = new JLabel(" Inserisci il codice Paguro: ");
        p1.add(l1);
        lab = new JLabel(" Deve essere compreso tra 2 e 10");
        p1.add(lab);
        lab.setVisible(false);
        testo1 = new JTextField(10);
        p1.add(testo1);
        b1 = new JButton("Conferma");
        p1.add(b1);
        b1.addActionListener(this); 
        this.setVisible(true);

    }

    public int controllaint(String buffer){
        int num = 0;
            try{
                num = Integer.parseInt(buffer);

            }catch(Exception e){
                System.out.print("il telefono è sbagliato");
            }
        return num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selezionato = e.getSource();
        if(selezionato == b1){
            p1.setBackground(Color.yellow);
            String t = testo1.getText();
            this.corsie = controllaint(t);
            /*while(this.corsie < 2 || this.corsie > 10){
                lab.setVisible(true);
                String s = testo1.getText();
                this.corsie = controllaint(s);
            }*/

            GaraCavalli gara = new GaraCavalli(this.corsie);
        }
        else
            throw new UnsupportedOperationException("Not supported yet."); 
    }

}
