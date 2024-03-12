import javax.swing.*;

public class RentListPanel extends JPanel {
    JLabel rentListTXT, idTXT, tytulTXT, autorTXT, gatunekTXT;
    JComboBox rentList;
    JTextField id, tytul, autor, gatunek, invyCard;
    JButton powrot, zwrot;


    public RentListPanel(){
        rentListTXT = new JLabel("Lista filmów:");
        rentList = new JComboBox<>();
        idTXT = new JLabel("Id:");
        id = new JTextField();
        tytulTXT = new JLabel("Tytul:");
        tytul = new JTextField();
        autorTXT = new JLabel("Autor:");
        autor = new JTextField();
        gatunekTXT = new JLabel("Gatunek:");
        gatunek = new JTextField();
        invyCard = new JTextField();

        powrot = new JButton("Powrót");
        zwrot = new JButton("Zwróć");

        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Moja biblioteka"));

        rentListTXT.setBounds(100,50,100,30);
        idTXT.setBounds(100,90,100,30);
        tytulTXT.setBounds(100,130,150,30);
        autorTXT.setBounds(100,170,150,30);
        gatunekTXT.setBounds(100, 210, 100, 20);

        rentList.setBounds(235,50,200,20);
        id.setBounds(235,90,200,20);
        tytul.setBounds(235,170,200,20);
        autor.setBounds(235,130,200,20);
        gatunek.setBounds(235,210,200,20);
        invyCard.setBounds(100,500,100,20);

        powrot.setBounds(180,550,100,30);
        zwrot.setBounds(320,550,100,30);

        add(rentListTXT);
        add(idTXT);
        add(tytulTXT);
        add(autorTXT);
        add(gatunekTXT);

        add(rentList);
        add(id);
        add(autor);
        add(tytul);
        add(autor);
        add(gatunek);
        add(invyCard);

        add(zwrot);
        add(powrot);

        invyCard.setVisible(false);
        id.setEditable(false);
        tytul.setEditable(false);
        autor.setEditable(false);
        gatunek.setEditable(false);
        setVisible(false);
    }
}
