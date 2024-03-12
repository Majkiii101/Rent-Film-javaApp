import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainFrame extends JFrame implements ActionListener {
    StartPanel startPanel;
    AdminLogin adminLogin;
    RegisterPanel registerPanel;

    AdminPanel adminPanel;
    UserPanel userPanel;
    FilmPanel FilmPanel;

    RentFilmPanel rentFilmPanel;
    RentListPanel rentListPanel;
    EditFilmPanel EditFilmPanel;

    DeleteFilmPanel deleteFilm;
    EditFilmPanel editFilmPanel;


    public MainFrame() {

        // Rozmiar i Tytul
        setSize(640, 640);
        setTitle("Wypożyczalnia");
        // Panel Startowy
        startPanel = new StartPanel();
        add(startPanel);
        startPanel.zaloguj.addActionListener(this);
        startPanel.dodajTabele.addActionListener(this);
        startPanel.rejestracja.addActionListener(this);
        // Panel Logowania
        adminLogin = new AdminLogin();
        adminLogin.LogIN.addActionListener(this);
        adminLogin.powrot.addActionListener(this);
        // Panel rejestracji
        registerPanel = new RegisterPanel();
        registerPanel.zarejestruj.addActionListener(this);
        registerPanel.powrot.addActionListener(this);
        // Admin Panel
        adminPanel = new AdminPanel();
        adminPanel.dodajFilm.addActionListener(this);
        adminPanel.edytuj.addActionListener(this);
        adminPanel.wyloguj.addActionListener(this);
        // User Panel
        userPanel = new UserPanel();
        userPanel.wypozycz.addActionListener(this);
        userPanel.biblioteka.addActionListener(this);
        userPanel.wyloguj.addActionListener(this);
        // FilmPanel
        FilmPanel = new FilmPanel();
        FilmPanel.addFilmPanel.powrot.addActionListener(this);
        FilmPanel.addFilmPanel.zapisz.addActionListener(this);
        FilmPanel.deleteFilmPanel.usun.addActionListener(this);
        // RentFilmPanel
        rentFilmPanel = new RentFilmPanel();
        rentFilmPanel.powrot.addActionListener(this);
        rentFilmPanel.wypozycz.addActionListener(this);
        rentFilmPanel.model.addActionListener(this);
        rentFilmPanel.wybierzDate.addActionListener(this);
        rentFilmPanel.listaFilmow.addActionListener(this);


        // FilmListPanel
        EditFilmPanel = new EditFilmPanel();
        editFilmPanel = new EditFilmPanel();
        EditFilmPanel.powrot.addActionListener(this);
        EditFilmPanel.zapisz.addActionListener(this);
        EditFilmPanel.selectFilm.addActionListener(this);
        // RentListPanel
        rentListPanel = new RentListPanel();
        rentListPanel.rentList.addActionListener(this);
        rentListPanel.powrot.addActionListener(this);
        rentListPanel.zwrot.addActionListener(this);
        // DeleteFilm
        deleteFilm = new DeleteFilmPanel();

        // Password Listener


        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // START PANEL
        if (e.getSource() == startPanel.zaloguj) {
            startPanel.setVisible(false);
            adminLogin.setVisible(true);
            //adminowe();
            add(adminLogin);
        }
          else if(e.getSource() == startPanel.rejestracja){
            int randomNum = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
              registerPanel.nrKarty.setText(Integer.toString(randomNum));
              startPanel.setVisible(false);
              registerPanel.setVisible(true);
              add(registerPanel);
        }
          else if(e.getSource() == registerPanel.zarejestruj){
             int randomNum = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
              registerToDB();
              registerPanel.nrKarty.setText(Integer.toString(randomNum));
              registerPanel.haslo.setText(null);
              registerPanel.nrTelefonu.setText(null);
              registerPanel.email.setText(null);
        }
          else if(e.getSource() == registerPanel.powrot){
              registerPanel.setVisible(false);
              startPanel.setVisible(true);
        }
          else if (e.getSource() == startPanel.dodajTabele) {
            Create.createKlient();
            Create.createFilm();
            Create.createWypozyczenia();
            Create.createAdmin();
            JOptionPane.showMessageDialog(null, "Dodano tabele. Korzystaj do woli :)");
        } else if (e.getSource() == adminLogin.LogIN) {
            hasloInv();
            czyPracownik();
            invyCard();
            if(adminLogin.password.getText().equals(adminLogin.invyHaslo.getText())&&Integer.parseInt(adminLogin.czyPracownik.getText()) == 0) {
                adminLogin.password.setText(null);
                adminLogin.setVisible(false);
                userPanel.setVisible(true);
                add(userPanel);
            }
            else if(adminLogin.password.getText().equals(adminLogin.invyHaslo.getText())&&Integer.parseInt(adminLogin.czyPracownik.getText()) == 1) {
                adminLogin.password.setText(null);
                adminLogin.setVisible(false);
                adminPanel.setVisible(true);
                add(adminPanel);
            }
        }
          else if(e.getSource() == adminLogin.powrot){
              adminLogin.setVisible(false);
              startPanel.setVisible(true);
        }
        // ADMIN PANEL
        else if (e.getSource() == adminPanel.wyloguj) {
            adminLogin.login.setText(null);
            adminPanel.setVisible(false);
            startPanel.setVisible(true);
        }
        // FILM PANEL
        else if (e.getSource() == adminPanel.dodajFilm) {
            filmList();
            adminPanel.setVisible(false);
            FilmPanel.setVisible(true);
            add(FilmPanel);
        } else if (e.getSource() == FilmPanel.addFilmPanel.powrot) {
            FilmPanel.deleteFilmPanel.listaFilmow.removeAllItems();
            FilmPanel.setVisible(false);
            adminPanel.setVisible(true);

        } else if (e.getSource() == FilmPanel.addFilmPanel.zapisz) {
            if (FilmPanel.addFilmPanel.Id.getText().length() != 5) {
                JOptionPane.showMessageDialog(null, "ID musi miec 5 znaków");
            } else {
                SaveFilmyToDB();
                // UpdateFilmy();
               FilmPanel.addFilmPanel.Id.setText(null);
               FilmPanel.addFilmPanel.tytul.setText(null);
               FilmPanel.addFilmPanel.autor.setText(null);
               FilmPanel.addFilmPanel.gatunek.setText(null);
               FilmPanel.addFilmPanel.cena.setText(null);
            }
        } else if (e.getSource() == FilmPanel.deleteFilmPanel.usun) {
            UsuwanieFilmuFrDb2();
            FilmPanel.deleteFilmPanel.listaFilmow.removeItem(FilmPanel.deleteFilmPanel.listaFilmow.getSelectedItem());
            JOptionPane.showMessageDialog(null,"Usunięto film");

            // CLIENT PANEL
        }

         /* else if (e.getSource() == clientPanel.registerPanel.powrot) {
            clientPanel.deleteClientPanel.listaKlientow.removeAllItems();
            clientPanel.setVisible(false);
            menuPanel.setVisible(true);
        } else if (e.getSource() == clientPanel.registerPanel.zarejestruj) {
            if (clientPanel.registerPanel.nrKarty.getText().equals("")
                    || clientPanel.registerPanel.haslo.getText().equals("")
                  //  || clientPanel.registerPanel.PESEL.getText().equals("")
                    || clientPanel.registerPanel.nrTelefonu.getText().equals("")
                 //   || clientPanel.registerPanel.NrKarty.getText().equals("")
                    || clientPanel.registerPanel.email.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Wszystkie pola są wymagane.");
          //  } else if (clientPanel.registerPanel.PESEL.getText().length() != 11) {
                JOptionPane.showMessageDialog(this, "Pesel musi mieć 11 cyfr.");
            } else if (clientPanel.registerPanel.nrTelefonu.getText().length() != 9) {
                JOptionPane.showMessageDialog(this, "Numer telefonu musi mieć 9 cyfr.");
          //  } else if (clientPanel.registerPanel.NrKarty.getText().length() != 8) {
                JOptionPane.showMessageDialog(this, "Numer karty musi mieć 8 cyfr.");
            } else {
                registerToDB();
                //   UpdateKlient0();
                clientPanel.registerPanel.nrKarty.setText(null);
                clientPanel.registerPanel.haslo.setText(null);
         //       clientPanel.registerPanel.PESEL.setText(null);
                clientPanel.registerPanel.nrTelefonu.setText(null);
          //      clientPanel.registerPanel.NrKarty.setText(null);
                clientPanel.registerPanel.email.setText(null);
            }
        } else if (e.getSource() == clientPanel.deleteClientPanel.usun) {
            UsuwanieFilmuFrDb1();
            UsuwanieKlientaFrDb();
            clientPanel.deleteClientPanel.listaKlientow.removeItem(clientPanel.deleteClientPanel.listaKlientow.getSelectedItem());
        }

          */
         // USER PANEL
        else if(e.getSource() == userPanel.wyloguj){
            adminLogin.login.setText(null);
            userPanel.setVisible(false);
            startPanel.setVisible(true);
        }

        // RENT FILM
        else if (e.getSource() == userPanel.wypozycz) {
            userPanel.setVisible(false);
            rentFilmPanel.setVisible(true);
            retrieve();
            add(rentFilmPanel);
        } else if (e.getSource() == rentFilmPanel.powrot) {
            rentFilmPanel.listaFilmow.removeAllItems();

            rentFilmPanel.setVisible(false);
            userPanel.setVisible(true);

            // rentFilmPanel.listaFilmow.removeItem(rentFilmPanel.listaFilmow.getSelectedItem());
        }
         else if(e.getSource() == rentFilmPanel.wybierzDate) {
            rentFilmPanel.dataZwrotu.setText(new DatePick(new JFrame()).Set_Picked_Date());
        }

        else if(e.getSource() == rentFilmPanel.listaFilmow){
            if(rentFilmPanel.listaFilmow.getSelectedItem() != null){
                if (rentFilmPanel.model.getSelectedIndex() != 1) {
                    Cost();
                    rentFilmPanel.zlTXT.setText("zł");
                }
                if (rentFilmPanel.model.getSelectedIndex() == 1){
                    rentFilmPanel.cena.setText("10");
                    rentFilmPanel.zlTXT.setText("zł/MM");
                }
           }
           }
        else if (e.getSource() == rentFilmPanel.wypozycz) {
            if (rentFilmPanel.model.getSelectedIndex() != 1) {
                SaveWypozyczeniaToDb();
            }
            if (rentFilmPanel.model.getSelectedIndex() == 1) {
                SaveWypozyczeniaToDb2();
                rentFilmPanel.dataZwrotu.setText(null);
            }
        }

        else if(e.getSource() == rentFilmPanel.model){
            if(rentFilmPanel.model.getSelectedItem() == rentFilmPanel.model.getItemAt(1)){
                rentFilmPanel.wybierzDate.setVisible(true);
                rentFilmPanel.dataZwrotuTXT.setVisible(true);
                rentFilmPanel.dataZwrotu.setVisible(true);
            } else{
                rentFilmPanel.wybierzDate.setVisible(false);
                rentFilmPanel.dataZwrotuTXT.setVisible(false);
                rentFilmPanel.dataZwrotu.setVisible(false);
            }
        }
        // FILM LIST PANEL
        else if(e.getSource() == userPanel.biblioteka){
            getList();
            userPanel.setVisible(false);
            rentListPanel.setVisible(true);
            add(rentListPanel);
        }
        else if(e.getSource() == rentListPanel.powrot){
            rentListPanel.setVisible(false);
            userPanel.setVisible(true);
            rentListPanel.rentList.removeAllItems();
        }
        else if(e.getSource() == rentListPanel.rentList) {
            if(rentListPanel.rentList.getSelectedItem() != null){
                getListAtrb();
            }
        }
        else if(e.getSource() == rentListPanel.zwrot){
            UsuwanieWypozyczeniaFrDb();
            rentListPanel.rentList.removeItem(rentListPanel.rentList.getSelectedItem());
            rentListPanel.id.setText(null);
            rentListPanel.tytul.setText(null);
            rentListPanel.autor.setText(null);
            rentListPanel.gatunek.setText(null);
            getListAtrb();
        }

        // EDIT PANEL
        else if (e.getSource() == adminPanel.edytuj) {
            filmList1();
            selectFilmAtrib();
            adminPanel.setVisible(false);
            EditFilmPanel.setVisible(true);
            add(EditFilmPanel);
        } else if(e.getSource() == EditFilmPanel.selectFilm){
            if(EditFilmPanel.selectFilm.getSelectedItem() != null){
                selectFilmAtrib();
            }
        }
        else if (e.getSource() == EditFilmPanel.powrot) {
            EditFilmPanel.setVisible(false);
            EditFilmPanel.selectFilm.removeAllItems();
            adminPanel.setVisible(true);
        } else if (e.getSource() == EditFilmPanel.zapisz) {
            setFilmAtrib();
            EditFilmPanel.tytul_1.setText(null);
            EditFilmPanel.autor_1.setText(null);
            EditFilmPanel.gatunek_1.setText(null);
            EditFilmPanel.cena_1.setText(null);
        }

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // ZAPISANIE FILMU DO BAZY DANYCH
    public void SaveFilmyToDB() {
        try {
            Service.insertData("INSERT INTO film(Id, Tytul, Autor, Gatunek, Cena)" +
                    "VALUES('" + FilmPanel.addFilmPanel.Id.getText() + "','" + FilmPanel.addFilmPanel.tytul.getText() + "','" + FilmPanel.addFilmPanel.autor.getText() + "','" + FilmPanel.addFilmPanel.gatunek.getText() + "','" + FilmPanel.addFilmPanel.cena.getText() + "')");
            JOptionPane.showMessageDialog(null, "Dodano film");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // REJESTRACJA DO BAZY
    public void registerToDB() {
        try {
            Service.insertData("INSERT INTO uzytkownik(NumerKarty, Haslo, NrTelefonu, Email, CzyPracownik)" +
                    "VALUES('" + registerPanel.nrKarty.getText() + "','" + registerPanel.haslo.getText() + "','" + registerPanel.nrTelefonu.getText() + "','"  + registerPanel.email.getText() + "','" + "0" + "')");
            JOptionPane.showMessageDialog(null, "Zarejestrowano");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // WYSWIETLANIE LISTY FILMOW Z BAZY DANYCH
    public RentFilmPanel retrieve() {
        String sqlFilm = "SELECT Id, Tytul, Autor, Gatunek , Cena FROM film;";
        try {
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlFilm);
            ResultSet rs = ki.executeQuery(sqlFilm);

            while (rs.next()) {
                String Id = rs.getString(1);
                String Tytul = rs.getString(2);
                String Autor = rs.getString(3);
                String Gatunek = rs.getString(4);
                String Cena = rs.getString(5);
                rentFilmPanel.listaFilmow.addItem(Id + "/" + Tytul + "/" + Autor + "/" + Gatunek);
                rentFilmPanel.cena.setText(Cena);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rentFilmPanel;
    }
    public RentFilmPanel Cost(){
        String cost = "SELECT Cena FROM film WHERE Id=" + rentFilmPanel.listaFilmow.getSelectedItem().toString().substring(0,5);
        try{
            Connection con = Service.getConnection();
            Statement ki= con.prepareStatement(cost);
            ResultSet rs = ki.executeQuery(cost);

            while(rs.next()){
                String cena = rs.getString(1);

                rentFilmPanel.cena.setText(cena);
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return rentFilmPanel;
    }

    // DODAWANIE WYPOZYCZENIA
    public void SaveWypozyczeniaToDb() {
        try {
            Service.insertWypozyczenia("INSERT INTO wypozyczenia(Id,NumerKarty,DataWypozyczenia,DataZwrotu)" +
                    "VALUES('" + rentFilmPanel.listaFilmow.getSelectedItem().toString().substring(0, 5) +  "','" + rentFilmPanel.nrKartyInvy.getText() + "','" + rentFilmPanel.dataWypozyczenia.getText() + "','" + "2000-01-01" + "')");
            JOptionPane.showMessageDialog(null, "Zakupiono produkt");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void SaveWypozyczeniaToDb2(){
        try{
            Service.insertWypozyczenia("INSERT INTO wypozyczenia(Id,NumerKarty,DataWypozyczenia,DataZwrotu)" +  "VALUES('" + rentFilmPanel.listaFilmow.getSelectedItem().toString().substring(0, 5) +  "','" + rentFilmPanel.nrKartyInvy.getText() + "','" + rentFilmPanel.dataWypozyczenia.getText() + "','" + rentFilmPanel.dataZwrotu.getText() + "')");
            JOptionPane.showMessageDialog(null, "Dodano wypożyczenie");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // WYSWIETLANIE WYPOZYCZENIA
    public EditFilmPanel retrieveWypozyczenia() {
        String sqlWyp = "SELECT wypozyczenia.Id, film.Tytul, wypozyczenia.NumerKarty,klient.Imie FROM wypozyczenia JOIN film ON wypozyczenia.Id=film.Id JOIN klient ON wypozyczenia.Pesel=klient.Pesel ORDER BY wypozyczenia.id_Wypozyczenia;";
        try {
            Connection con = Service.getConnection();

            Statement Wy = con.prepareStatement(sqlWyp);
            ResultSet Po = Wy.executeQuery(sqlWyp);
            while (Po.next()) {
                String Id = Po.getString(1);
                String Tytul = Po.getString(2);
                String Pesel = Po.getString(3);
                String Imie = Po.getString(4);
                EditFilmPanel.selectFilm.addItem(Id + "/" + Tytul + "/" + Pesel + "/" + Imie);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return EditFilmPanel;
    }

    // USUWANIE WYPOZYCZENIA
    public void UsuwanieWypozyczeniaFrDb() {
        try {
            Service.deleteWypozyczenia("DELETE FROM wypozyczenia WHERE wypozyczenia.Id='"
                    + rentListPanel.rentList.getSelectedItem().toString().substring(0, 5) + "' AND wypozyczenia.NumerKarty = '"
                    + rentListPanel.invyCard.getText() + "'");
            JOptionPane.showMessageDialog(null, "Zwrócono film");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }

    // CZYSZCZENIE COMBOBOXA
    public RentFilmPanel focusGained() {
        rentFilmPanel.model.removeAllItems();

        return rentFilmPanel;
    }

    public void UsuwanieFilmuFrDb1() {
        try {
            Service.deleteFilm("DELETE FROM wypozyczenia WHERE wypozyczenia.Id=" + FilmPanel.deleteFilmPanel.listaFilmow.getSelectedItem().toString().substring(0, 5) + "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    // USUWANIE FILMU
    public DeleteFilmPanel filmList() {
        String sqlFilm = "SELECT Id, Tytul FROM film;";
        try {
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlFilm);
            ResultSet rs = ki.executeQuery(sqlFilm);

            while (rs.next()) {
                String Id = rs.getString(1);

                String Tytul = rs.getString(2);
                FilmPanel.deleteFilmPanel.listaFilmow.addItem(Id + "/" + Tytul);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return deleteFilm;
    }

    public void UsuwanieFilmuFrDb2() {
        try {
            Service.deleteFilm("DELETE FROM film WHERE film.Id=" + FilmPanel.deleteFilmPanel.listaFilmow.getSelectedItem().toString().substring(0, 5) + "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    // EDYTOWANIE FILMU

    public EditFilmPanel filmList1() {
        String sqlFilm = "SELECT Id, Tytul FROM film;";
        try {
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlFilm);
            ResultSet rs = ki.executeQuery(sqlFilm);

            while (rs.next()) {
                String Id = rs.getString(1);

                String Tytul = rs.getString(2);
                EditFilmPanel.selectFilm.addItem(Id + "/" + Tytul);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return EditFilmPanel;
    }

    public EditFilmPanel selectFilmAtrib(){
        String sqlFilmAtrib = "SELECT Tytul, Autor, Gatunek, Cena FROM film WHERE Id=" + EditFilmPanel.selectFilm.getSelectedItem().toString().substring(0,5);
        try{
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlFilmAtrib);
            ResultSet rs = ki.executeQuery(sqlFilmAtrib);

            while (rs.next()){
                String Tytul = rs.getString(1);
                String Autor = rs.getString(2);
                String Gatunek = rs.getString(3);
                String Cena = rs.getString(4);
                EditFilmPanel.tytul.setText(Tytul);
                EditFilmPanel.autor.setText(Autor);
                EditFilmPanel.gatunek.setText(Gatunek);
                EditFilmPanel.cena.setText(Cena);
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return EditFilmPanel;
    }

    public EditFilmPanel setFilmAtrib(){
        try {
            PreparedStatement statement = Service.getConnection().prepareStatement("UPDATE film SET Tytul = ?, Autor = ?, Gatunek = ?, Cena = ? WHERE Id = ?");
            statement.setString(1, EditFilmPanel.tytul_1.getText());
            statement.setString(2, EditFilmPanel.autor_1.getText());
            statement.setString(3, EditFilmPanel.gatunek_1.getText());
            statement.setString(4, EditFilmPanel.cena_1.getText());
            statement.setString(5, EditFilmPanel.selectFilm.getSelectedItem().toString().substring(0, 5));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Zaktualizowano dane");

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return EditFilmPanel;
    }
   // LOGOWANIE

   public AdminLogin hasloInv() {
       String sqlHaslo = "SELECT Haslo FROM uzytkownik WHERE NumerKarty="+ adminLogin.login.getText();
       try {
           Connection con = Service.getConnection();

           Statement ki = con.prepareStatement(sqlHaslo);
           ResultSet rs = ki.executeQuery(sqlHaslo);

           while (rs.next()) {
               String haslo1 = rs.getString(1);
               adminLogin.invyHaslo.setText(haslo1);
           }
       } catch (Exception ex) {
       }
       return adminLogin;
   }

    public AdminLogin czyPracownik() {
        String sqlCzyPracownik = "SELECT CzyPracownik FROM uzytkownik WHERE NumerKarty="+ adminLogin.login.getText();
        try {
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlCzyPracownik);
            ResultSet rs = ki.executeQuery(sqlCzyPracownik);

            while (rs.next()) {
                String sqlCzyPracownik1 = rs.getString(1);
                adminLogin.czyPracownik.setText(sqlCzyPracownik1);
            }
        } catch (Exception ex) {
        }
        return adminLogin;
    }

    public AdminLogin invyCard(){
        String sqlInvyCard = "SELECT NumerKarty FROM uzytkownik WHERE NumerKarty="+ adminLogin.login.getText();
        try {
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlInvyCard);
            ResultSet rs = ki.executeQuery(sqlInvyCard);

            while (rs.next()) {
                String sqlInvy = rs.getString(1);
                rentFilmPanel.nrKartyInvy.setText(sqlInvy);
                rentListPanel.invyCard.setText(sqlInvy);
            }
        } catch (Exception ex){
        } return adminLogin;
    }
    public RentFilmPanel getList(){
        String sqlGetList = "SELECT wypozyczenia.Id, Tytul FROM wypozyczenia, film WHERE wypozyczenia.Id = film.Id AND wypozyczenia.NumerKarty="+ rentListPanel.invyCard.getText();
        try {
            Connection con = Service.getConnection();

            Statement ki = con.prepareStatement(sqlGetList);
            ResultSet rs = ki.executeQuery(sqlGetList);



            while (rs.next()){
                String Id = rs.getString(1);
                String Tytul = rs.getString(2);
                rentListPanel.rentList.addItem(Id + "/" + Tytul);
            }

        } catch (Exception ex){
        } return rentFilmPanel;
    }
    public RentFilmPanel getListAtrb() {
        String sqlGetAtribList = "SELECT wypozyczenia.Id, Tytul, Autor, Gatunek FROM wypozyczenia, film WHERE wypozyczenia.Id=film.Id AND wypozyczenia.Id =" + rentListPanel.rentList.getSelectedItem().toString().substring(0,5);
        try {
            Connection con = Service.getConnection();

            Statement kj = con.prepareStatement(sqlGetAtribList);
            ResultSet rk = kj.executeQuery(sqlGetAtribList);

            while (rk.next()) {
                String Id = rk.getString(1);
                String Tytul = rk.getString(2);
                String Autor = rk.getString(3);
                String Gatunek = rk.getString(4);
                rentListPanel.id.setText(Id);
                rentListPanel.tytul.setText(Tytul);
                rentListPanel.autor.setText(Autor);
                rentListPanel.gatunek.setText(Gatunek);
            }
        } catch (Exception ex) {
        }
        return rentFilmPanel;
    }



}








