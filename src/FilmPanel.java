import javax.swing.*;
import java.awt.*;

public class FilmPanel extends JPanel {
    AddFilmPanel addFilmPanel;
    DeleteFilmPanel deleteFilmPanel;

    public FilmPanel(){
        addFilmPanel = new AddFilmPanel();
        deleteFilmPanel = new DeleteFilmPanel();


        addFilmPanel.setPreferredSize(new Dimension(240,320));
        deleteFilmPanel.setPreferredSize(new Dimension(240, 320));

        add(addFilmPanel);
        add(deleteFilmPanel);

        setVisible(false);
    }
}