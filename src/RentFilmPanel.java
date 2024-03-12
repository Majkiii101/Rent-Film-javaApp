import javax.swing.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class RentFilmPanel extends JPanel {
    JLabel listaFilmowTXT, modelTXT, dataWypozyczeniaTXT, dataZwrotuTXT, cenaTXT, zlTXT;
    JTextField dataWypozyczenia, dataZwrotu, cena, nrKartyInvy;
    JComboBox listaFilmow, model;
    JButton powrot, wypozycz, wybierzDate;

    String zakup;
    String pozycz;



    public RentFilmPanel(){
        listaFilmowTXT = new JLabel("Lista filmów");
        listaFilmow = new JComboBox<>();
        modelTXT = new JLabel("Model");
        model = new JComboBox<>();
        cenaTXT = new JLabel("Koszt");
        cena = new JTextField();
        zlTXT = new JLabel("zł");
        dataWypozyczeniaTXT = new JLabel("Data wypożyczenia");
        dataWypozyczenia = new JTextField();
        dataZwrotuTXT = new JLabel("Data zwrotu");
        dataZwrotu = new JTextField();
        nrKartyInvy = new JTextField();

        powrot = new JButton("Powrót");
        wypozycz = new JButton("Wypożycz");
        wybierzDate = new JButton("Wybierz datę");

        zakup = "Zakup";
        pozycz = "Wypożycz";
        model.addItem(zakup);
        model.addItem(pozycz);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        dataWypozyczenia.setText(dtf.format(now));
        dataWypozyczenia.setEditable(false);
        dataZwrotu.setEditable(false);
        cena.setEditable(false);
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Wypożyczalnia"));

        listaFilmowTXT.setBounds(100,50,100,30);
        modelTXT.setBounds(100,90,100,30);
        dataWypozyczeniaTXT.setBounds(100,170,150,30);
        cenaTXT.setBounds(100,130,150,30);
        dataZwrotuTXT.setBounds(100,210,150,30);
        zlTXT.setBounds(450,130, 150, 30);

        listaFilmow.setBounds(235,50,200,20);
        model.setBounds(235,90,200,20);
        dataWypozyczenia.setBounds(235,170,200,20);
        cena.setBounds(235,130,200,20);
        dataZwrotu.setBounds(235,210,200,20);

        powrot.setBounds(180,550,100,30);
        wypozycz.setBounds(320,550,100,30);
        wybierzDate.setBounds(450,210,110,20);
        nrKartyInvy.setBounds(235,400,200,20);

        add(listaFilmowTXT);
        add(modelTXT);
        add(dataWypozyczeniaTXT);
        add(cenaTXT);
        add(dataZwrotuTXT);
        add(zlTXT);

        add(listaFilmow);
        add(model);
        add(dataWypozyczenia);
        add(dataZwrotu);
        add(cena);
        add(nrKartyInvy);


        add(powrot);
        add(wypozycz);
        add(wybierzDate);

        nrKartyInvy.setVisible(false);
        dataZwrotuTXT.setVisible(false);
        dataZwrotu.setVisible(false);
        wybierzDate.setVisible(false);
        setVisible(false);
    }

}
