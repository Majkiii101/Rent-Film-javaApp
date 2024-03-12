import javax.swing.*;

public class AdminLogin extends JPanel {
    JTextField login, invyHaslo, czyPracownik;
    JPasswordField password;
    JLabel loginTXT, passwordTXT;
    JButton LogIN, powrot;

    public AdminLogin(){
        loginTXT = new JLabel("Login:");
        login = new JTextField(10);
        passwordTXT = new JLabel("Hasło:");
        password = new JPasswordField(10);
        LogIN = new JButton("Zaloguj");
        powrot = new JButton("Powrót");
        invyHaslo = new JTextField("invy",10);
        czyPracownik = new JTextField("czy", 10);



        invyHaslo.setVisible(false);
        czyPracownik.setVisible(false);

        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Logowanie"));

        loginTXT.setBounds(200,200,100,20);
        passwordTXT.setBounds(200,250,100,20);

        login.setBounds(250,200,100,20);
        password.setBounds(250,250,100,20);

        powrot.setBounds(180,300,100,25);
        LogIN.setBounds(300, 300,100,25);




        add(loginTXT);
        add(login);
        add(passwordTXT);
        add(password);
        add(LogIN);
        add(powrot);
        add(invyHaslo);
        add(czyPracownik);
        setVisible(false);


    }
}
