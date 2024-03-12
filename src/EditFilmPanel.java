import javax.swing.*;

public class EditFilmPanel extends JPanel {
    JLabel selectFilmTXT, tytulTXT, autorTXT, gatunekTXT, cenaTXT;
    JTextField tytul, autor, gatunek, cena, tytul_1, autor_1, gatunek_1, cena_1;
    JComboBox selectFilm;
    JButton powrot, zapisz;


    public EditFilmPanel(){
        selectFilmTXT = new JLabel("Wybierz film:");
        selectFilm = new JComboBox<>();
        tytulTXT = new JLabel("tytuł:");
        tytul = new JTextField();
        tytul_1 = new JTextField();
        autorTXT = new JLabel("Autor:");
        autor = new JTextField();
        autor_1 = new JTextField();
        gatunekTXT = new JLabel("Gatunek:");
        gatunek = new JTextField();
        gatunek_1 = new JTextField();
        cenaTXT = new JLabel("Cena:");
        cena = new JTextField();
        cena_1 = new JTextField();
        powrot = new JButton("Powrót");
        zapisz = new JButton("Zapisz");
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Edycja filmów"));

        selectFilmTXT.setBounds(150,50,100,30);
        selectFilm.setBounds(250,50,100,20);
        tytulTXT.setBounds(150, 100, 100,20);
        tytul.setBounds(250, 100, 100,20);
        tytul_1.setBounds(360, 100, 100,20);
        autorTXT.setBounds(150, 150, 100,20);
        autor.setBounds(250, 150, 100,20);
        autor_1.setBounds(360, 150, 100,20);
        gatunekTXT.setBounds(150, 200, 100,20);
        gatunek.setBounds(250, 200, 100,20);
        gatunek_1.setBounds(360, 200, 100,20);
        cenaTXT.setBounds(150, 250, 100, 20);
        cena.setBounds(250, 250, 100,20);
        cena_1.setBounds(360, 250, 100,20);
        powrot.setBounds(200,300,100,25);
        zapisz.setBounds(350,300,100,25);

        tytul.setEditable(false);
        autor.setEditable(false);
        gatunek.setEditable(false);
        cena.setEditable(false);

        add(selectFilmTXT);
        add(selectFilm);
        add(tytulTXT);
        add(tytul);
        add(tytul_1);
        add(autorTXT);
        add(autor);
        add(autor_1);
        add(gatunekTXT);
        add(gatunek);
        add(gatunek_1);
        add(cenaTXT);
        add(cena);
        add(cena_1);

        add(powrot);
        add(zapisz);

        setVisible(false);
    }
}

