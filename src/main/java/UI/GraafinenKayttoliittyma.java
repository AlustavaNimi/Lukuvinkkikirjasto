
package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GraafinenKayttoliittyma {
    private Stage primaryStage;

    public GraafinenKayttoliittyma(Stage primaryStage) {
        this.primaryStage = primaryStage;
        luoIkkuna();
    }

    private void luoIkkuna() {
        Button btn = new Button();
        btn.setText("Paina minua");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Höhöö");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 600, 750);
        
        primaryStage.setTitle("Lukuvinkkisovellus");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
