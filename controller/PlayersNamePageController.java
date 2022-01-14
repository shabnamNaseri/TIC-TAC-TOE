package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayersNamePageController implements Initializable
{
    @FXML
    private TextField usernamePlayer_X;

    @FXML
    private TextField usernamePlayer_O;

    @FXML
    private Button enterGameButton;

    @FXML
    private Label errorLabel;

    static String username_X;

    static String username_O;

    @Override
    public void initialize(URL location,ResourceBundle resources)
    {

        enterGameButton.setOnAction(event -> {
            try {
                openMainPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void openMainPage() throws IOException
    {
        if(checkUsername_O() && checkUsername_X()){
            AnchorPane root = FXMLLoader.load(getClass().getResource("../view/mainPage.fxml"));
            Stage mainStage = new Stage();
            mainStage.setTitle("Main Page");
            mainStage.setScene(new Scene(root));
            mainStage.show();
            LoginPageController.playersNameStage.close();
        }
    }

    private boolean checkFields()
    {
        if (usernamePlayer_O.getText().isEmpty() || usernamePlayer_X.getText().isEmpty())
        {
            errorLabel.setText("Please fill in all fields !!");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true;
    }

    private boolean checkUsername_X()
    {
        ArrayList<User> users = User.getUserArrayList();
        if (checkFields()) {
            for (User each : users) {
                if (usernamePlayer_X.getText().equals(each.getUsername()) && !usernamePlayer_X.getText()
                        .equals(usernamePlayer_O.getText()))
                {
                    username_X = each.getUsername();
                    errorLabel.setText("");
                    return true;
                }
            }
        }
        else
        {
            errorLabel.setText("Please fill in all fields !!");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        errorLabel.setText("Usernames is incorrect!");
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
        return false;
    }

    private boolean checkUsername_O()
    {
        ArrayList<User> users = User.getUserArrayList();
        if (checkFields()) {
            for (User each : users) {
                if (usernamePlayer_O.getText().equals(each.getUsername()) && (!usernamePlayer_X.getText()
                        .equals(usernamePlayer_O.getText())))
                {
                    username_O = each.getUsername();
                    errorLabel.setText("");
                    return true;
                }
            }
        }
        else
        {
            errorLabel.setText("Please fill in all fields !!");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        errorLabel.setText("Usernames is incorrect!");
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
        return false;
    }
}
