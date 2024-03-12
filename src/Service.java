import java.sql.Connection;
import java.sql.DriverManager;

public class Service {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

    }

    public static Connection getConnection(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseurl = "jdbc:mysql://localhost:3306/wypozyczalnia";
            String username = "root";
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl, username, password);
            return conn;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static void insertData(String sql) throws Exception {
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void insertWypozyczenia(String sql) throws Exception {
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void deleteWypozyczenia(String sql) throws Exception {
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void createKlient(String sql) throws Exception {
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void createFilm(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void createWypozycz(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void deleteKlient(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void deleteFilm(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }

    public static void setFilmAtrib(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }
    public static void cost(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }

    public static void admin(String sql) throws Exception{
        getConnection().createStatement().executeUpdate(sql);
    }




}