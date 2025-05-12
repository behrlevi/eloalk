import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Henger extends JFrame {
    private JTextField rTextField;
    private JTextField mTextField;
    private JLabel vLabel;
    private JLabel aLabel;
    private JButton szamolButton;

    public Henger() {
        // Ablak beállítása
        setTitle("Henger");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Null layout a pontos pozicionáláshoz

        // Címkék létrehozása
        JLabel rLabel = new JLabel("R:");
        rLabel.setBounds(20, 30, 20, 20);
        add(rLabel);

        JLabel mLabel = new JLabel("M:");
        mLabel.setBounds(140, 30, 20, 20);
        add(mLabel);

        // Beviteli mezők
        rTextField = new JTextField();
        rTextField.setBounds(40, 30, 80, 25);
        add(rTextField);

        mTextField = new JTextField();
        mTextField.setBounds(160, 30, 80, 25);
        add(mTextField);

        // Eredmény címkék
        vLabel = new JLabel("V=0.00cm3");
        vLabel.setBounds(260, 30, 100, 25);
        add(vLabel);

        aLabel = new JLabel("A=0.00cm2");
        aLabel.setBounds(370, 30, 100, 25);
        add(aLabel);

        // Számol gomb
        szamolButton = new JButton("Számol");
        szamolButton.setBounds(40, 80, 80, 25);
        szamolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szamitas();
            }
        });
        add(szamolButton);
    }

    private void szamitas() {

        // Adatok beolvasása
        double r = Double.parseDouble(rTextField.getText());
        double m = Double.parseDouble(mTextField.getText());

        // Számítások
        double v = Math.PI * r * r * m; // Térfogat
        double a = 2 * Math.PI * r * (r + m); // Felszín

        // Formázás két tizedes jegyre
        DecimalFormat df = new DecimalFormat("0.00");
            
        // Eredmények megjelenítése
        vLabel.setText("V=" + df.format(v) + "cm3");
        aLabel.setText("A=" + df.format(a) + "cm2");
    }

    public static void main(String[] args) {
        // GUI futtatása
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Henger().setVisible(true);
            }
        });
    }
}