import javax.swing.*;

public class UserPanel extends JPanel {

    JButton wypozycz, biblioteka, wyloguj;
    public UserPanel(){
        wypozycz = new JButton("Wypożycz");
        biblioteka = new JButton("Moja biblioteka");
        wyloguj = new JButton("Wyloguj");
        setLayout(null);

        wypozycz.setBounds(260,125, 130, 30);
        biblioteka.setBounds(260,225, 130, 30);
        wyloguj.setBounds(260,325, 130, 30);


        add(wypozycz);
        add(biblioteka);
        add(wyloguj);

        setVisible(false);
    }
}
