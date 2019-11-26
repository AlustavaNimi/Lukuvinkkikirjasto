
import IO.KonsoliIO;
import UI.GraafinenKayttoliittyma;
import UI.Kayttoliittyma;
import UI.TekstiKayttoliittyma;
import database.KirjaDao;
import database.Tietokanta;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;

public class Sovellus extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("test");
    }

    public static void main(String[] args) {
        boolean graafinen = false;
        //cubbli-linuxilla anna komentorivillä komento
        //export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/
        if (graafinen) {
            Tietokanta lukuvinkit = new KirjaDao("jdbc:sqlite:kirjat.db");
            GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(lukuvinkit);
            kayttoliittyma.run();
        } else {
            Tietokanta lukuvinkit = new KirjaDao("jdbc:sqlite:kirjat.db");
            Kayttoliittyma kayttoliittyma = new TekstiKayttoliittyma(new KonsoliIO(), lukuvinkit);
            kayttoliittyma.run();
        }
    }
}
