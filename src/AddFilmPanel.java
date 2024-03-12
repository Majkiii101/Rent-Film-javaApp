import javax.swing.*;

public class AddFilmPanel extends JPanel {
    JLabel IdTxt, tytulTXT, autorTXT, gatunekTXT, cenaTXT;
    JTextField Id, tytul, autor, gatunek, cena;
    JButton zapisz, powrot;

    public AddFilmPanel(){
        IdTxt = new JLabel("Id");
        Id = new JTextField();
        tytulTXT = new JLabel("Tytuł");
        tytul = new JTextField();
        autorTXT = new JLabel("Autor");
        autor = new JTextField();
        gatunekTXT = new JLabel("Gatunek");
        gatunek = new JTextField();
        cenaTXT = new JLabel("Cena");
        cena = new JTextField();
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Dodaj film"));

        IdTxt.setBounds(10, 30, 100, 20);
        tytulTXT.setBounds(10, 70, 100, 20);
        autorTXT.setBounds(10, 110, 100, 20);
        gatunekTXT.setBounds(10, 150, 100, 20);
        cenaTXT.setBounds(10,190,100,20);


        Id.setBounds(100, 30, 100, 20);
        tytul.setBounds(100,70,100,20);
        autor.setBounds(100,110,100,20);
        gatunek.setBounds(100,150,100,20);
        cena.setBounds(100,190,100,20);


        zapisz = new JButton("Zapisz");
        powrot = new JButton("Powrót");

        zapisz.setBounds(120,270,100,25);
        powrot.setBounds(10,270,100,25);





        add(IdTxt);
        add(Id);
        add(tytulTXT);
        add(tytul);
        add(autorTXT);
        add(autor);
        add(gatunekTXT);
        add(gatunek);
        add(cenaTXT);
        add(cena);
        add(zapisz);
        add(powrot);

    }
}

