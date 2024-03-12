import javax.swing.*;

public class DeleteFilmPanel extends JPanel {
    JLabel listTXT;
    JComboBox listaFilmow;
    JButton usun;

    public DeleteFilmPanel(){
        listTXT = new JLabel("Lista filmów:");
        listaFilmow = new JComboBox<>();
        usun = new JButton("Usuń");
        setLayout(null);

        setBorder(BorderFactory.createTitledBorder("Usuń Film"));


        listTXT.setBounds(80,20,100,20);
        listaFilmow.setBounds(20,50,200,20);
        usun.setBounds(70,270,100,25);


        add(listTXT);
        add(listaFilmow);
        add(usun);

    }

}
