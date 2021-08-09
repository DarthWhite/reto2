import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage statisticalSystem) throws Exception{
        try {
            //Cargar la vista en esta linea de codigo llamo al archivo FXML 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GradingSystemController.fxml"));
            //Cargo la ventana de la vista
            Pane microVentana=(Pane) loader.load();

            //Cargar la Scene(La Scena es lo que va dentro del pane)
            Scene scene=new Scene(microVentana);
            //Mostrando la Scene
            statisticalSystem.setScene(scene);
            statisticalSystem.show();


        } catch (Exception e) {
            //Excepcion
            System.out.println("Error inexperado"+e.getMessage());
        }        

    }

    public static void main(String[] args) {
        launch();
    }
}
