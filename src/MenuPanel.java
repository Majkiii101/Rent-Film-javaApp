import javax.swing.*;

public class MenuPanel extends JPanel{

    JButton wypozycz, dodajFilm, lista, dodajKlienta;
    public MenuPanel(){
        // MenuPanel

        dodajFilm = new JButton("Filmy");
        dodajKlienta = new JButton("Klienci");
        wypozycz = new JButton("Wypożycz");
        lista = new JButton("Zwrot");
        setLayout(null);

        dodajFilm.setBounds(260,125, 130,30);
        dodajKlienta.setBounds(260,225,130,30);
        wypozycz.setBounds(260,325, 130, 30);
        lista.setBounds(260,425, 130,30);



        add(dodajFilm);
        add(dodajKlienta);
        add(wypozycz);
        add(lista);


        setVisible(false);

    }

}
