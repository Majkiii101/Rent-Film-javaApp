import javax.swing.*;

public class StartPanel extends JPanel{
    JLabel zdjecie;
    JLabel loginText, passwordText;
    JTextField login;
    //  JPasswordField password;
    JButton zaloguj, rejestracja, dodajTabele;

    public StartPanel() {
        // Zdjecie
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Filmyy.jpg"));
        zdjecie = new JLabel(imageIcon);

        // Przycisk
        dodajTabele = new JButton("Dodaj potrzebne tabele");
        zaloguj = new JButton("Logowanie");
        rejestracja = new JButton("Rejestracja");


        // add(loginText);
        //  add(login);
        // add(passwordText);
        // add(password);
        add(dodajTabele);
        add(zaloguj);
        add(rejestracja);
        add(zdjecie);
        setOpaque(false);

    }
}
