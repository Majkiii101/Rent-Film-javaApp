import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class RegisterPanel extends JPanel {
    JLabel nrKartyTXT, hasloTXT, nrTelefonuTXT, emailTXT;
    JTextField nrKarty, nrTelefonu, email;
    JPasswordField haslo;
    JButton zarejestruj, powrot;



    public RegisterPanel() {
        nrKartyTXT = new JLabel("Numer karty:");
        nrKarty = new JTextField();
        hasloTXT = new JLabel("Hasło:");
        haslo = new JPasswordField();
        nrTelefonuTXT = new JLabel("Nr. Telefonu:");
        nrTelefonu = new JTextField();
        emailTXT = new JLabel("Adres E-Mail:");
        email = new JTextField();

        zarejestruj = new JButton("Zarejestruj");
        powrot = new JButton("Powrót");
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Rejestracja konta"));


        nrKartyTXT.setBounds(200, 100, 100, 20);
        hasloTXT.setBounds(200, 140, 100, 20);
        nrTelefonuTXT.setBounds(200, 180, 100, 20);
        emailTXT.setBounds(200,220,100,20);

        nrKarty.setBounds(350, 100, 100, 20);
        haslo.setBounds(350, 140, 100, 20);
        nrTelefonu.setBounds(350, 180, 100, 20);
        email.setBounds(350,220,100,20);

        zarejestruj.setBounds(340, 260, 100, 25);
        powrot.setBounds(210, 260, 100, 25);

        nrKarty.setEditable(false);


        add(nrKartyTXT);
        add(hasloTXT);
        add(nrTelefonuTXT);
        add(emailTXT);

        add(nrKarty);
        add(haslo);
        add(nrTelefonu);
        add(email);

        add(zarejestruj);
        add(powrot);
        setVisible(false);

    }
}

