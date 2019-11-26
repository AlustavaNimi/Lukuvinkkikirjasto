
import IO.KonsoliIO;
import UI.GraafinenKayttoliittyma;
import UI.Kayttoliittyma;
import UI.TekstiKayttoliittyma;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Sovellus extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        new GraafinenKayttoliittyma(primaryStage);
    }

    public static void main(String[] args) {
        boolean graafinen = true;
        //cubbli-linuxilla anna komentorivillä komento
        //export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/
        if(graafinen) {
            launch(args);
        } else {
            Kayttoliittyma kayttoliittyma = new TekstiKayttoliittyma(new KonsoliIO());
            kayttoliittyma.run();
        }
    }
}
