
import UI.GraafinenKayttoliittyma;
import UI.Kayttoliittyma;
import database.FakeTietokanta;
import database.LukuvinkkiDao;
import database.Tietokanta;
import java.util.Scanner;
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
import javax.swing.SwingUtilities;

public class Sovellus {
//
//    @Override
//    public void start(Stage primaryStage) {
//        System.out.println("test");
//    }

    public static void main(String[] args) {

        Tietokanta lukuvinkit = new LukuvinkkiDao("jdbc:sqlite:db.db");
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(lukuvinkit);
        kayttoliittyma.run();

    }
}
