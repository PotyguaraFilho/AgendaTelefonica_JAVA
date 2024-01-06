import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inicio_APP.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        
        Image favicon = new Image(getClass().getResourceAsStream("agenda.ico"));

        primaryStage.getIcons().add(favicon);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Agenda Telefônica - JAVA");
        primaryStage.setScene(tela);
        primaryStage.show();
    }
}
