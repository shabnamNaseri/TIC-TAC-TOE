import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("view/LoginPage.fxml"));
        //   loader.load();
        primaryStage.setTitle("TIC-TAC-TOE");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
