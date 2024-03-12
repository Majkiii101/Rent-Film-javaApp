import javax.swing.*;

public class AdminPanel extends JPanel {
    JButton dodajFilm, edytuj, wyloguj;
    public AdminPanel(){
        dodajFilm = new JButton("Filmy");
        edytuj = new JButton("Edytuj");
        wyloguj = new JButton("Wyloguj");
        setLayout(null);

        dodajFilm.setBounds(260,125, 130,30);
        edytuj.setBounds(260,225, 130,30);
        wyloguj.setBounds(260,325,130,30);

        add(dodajFilm);
        add(edytuj);
        add(wyloguj);
        setVisible(false);
    }
}
