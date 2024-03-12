import javax.swing.*;

public class Create {
    public static void createKlient(){
        try{
            Service.createKlient("CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`uzytkownik` (`NumerKarty` VARCHAR(6) NOT NULL , `Haslo` TEXT NOT NULL , `NrTelefonu` VARCHAR(9) NOT NULL , `Email` VARCHAR(50) NOT NULL , `CzyPracownik` Tinyint(50) NOT NULL , PRIMARY KEY (`NumerKarty`)) ENGINE = InnoDB;");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static void createFilm(){
        try {
            Service.createFilm("CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`film` (`Id` VARCHAR(5) NOT NULL , `Tytul` TEXT NOT NULL , `Autor` TEXT NOT NULL , `Gatunek` TEXT NOT NULL , `Cena` VARCHAR(10) NOT NULL , PRIMARY KEY (`Id`)) ENGINE = InnoDB;");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    public static void createWypozyczenia(){
        try{
            Service.createWypozycz("CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`wypozyczenia` (`IdWypozyczenia` INT(11) NOT NULL AUTO_INCREMENT , `Id` VARCHAR(5) NOT NULL , `NumerKarty` VARCHAR(6) NOT NULL , `DataWypozyczenia` DATE NOT NULL , `DataZwrotu` DATE NOT NULL , PRIMARY KEY (`IdWypozyczenia`),\n" +
                    "FOREIGN KEY(Id) REFERENCES film(Id),\n" +
                    "FOREIGN KEY(NumerKarty) REFERENCES uzytkownik(NumerKarty)) ENGINE = InnoDB;");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }

    public static void createAdmin(){
        try{
            Service.admin("INSERT INTO `uzytkownik` (`NumerKarty`, `Haslo`, `NrTelefonu`, `Email`, `CzyPracownik`) VALUES ('000000', 'admin', '123456789', 'admin@gmail.com', '1');");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}

