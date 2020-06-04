import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
    JPanel p1, p2, p3;
    int corsie;
    Container c;
    JLabel lab, l1;
    JButton b1;
    Image img;
    JComboBox<String> box;

    public Interfaccia(){
        super("Ippodromo Meucci-Franchi");
        corsie = 0;
        c = this.getContentPane();
        this.setSize(400, 400);
        this.setLocation(280, 180);
        this.setBackground(Color.MAGENTA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.MAGENTA);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.setLayout(new FlowLayout(FlowLayout.LEADING));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("knight.jpg");
        
        String[] lista = {"2", "3", "4", "5", "6","7", "8", "9", "10"};
        lab = new JLabel("Benvenuto alle Corse dei Cavalli");
        l1 = new JLabel(" Seleziona il numero di corsie: ");
        p1.add(lab);
        p2.add(l1);
        box = new JComboBox(lista); 
        p2.add(box);
        b1 = new JButton("Conferma");
        p3.add(b1);
        b1.addActionListener(this); 
        this.setVisible(true);

    }

    public int controllaint(String buffer){
        int num = 0;
            try{
                num = Integer.parseInt(buffer);
            }catch(Exception e){
                System.out.print("il numero è sbagliato");
            }
        return num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object selezionato = e.getSource();
        if(selezionato == b1){
            p1.setBackground(Color.yellow);
                String s = (String) box.getSelectedItem();
                this.corsie = controllaint(s);
            GaraCavalli gara = new GaraCavalli(this.corsie);
        }
    }

}
