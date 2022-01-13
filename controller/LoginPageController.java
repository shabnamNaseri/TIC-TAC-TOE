package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable
{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button exitBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private Label registerLabel;

    @FXML
    private Label errorLbl;

    static Stage registerStage = null;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        exitBtn.setOnAction(event -> {
            exitPage();
        });

        registerBtn.setOnAction(event -> {
            try {
                openRegisterPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        loginButton.setOnAction(event -> {
            try {
                openPlayerNamePage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void exitPage()
    {
        Stage stage = (Stage)exitBtn.getScene().getWindow();
        stage.close();
    }

    private void openRegisterPage() throws IOException
    {
        if (registerStage == null) {
            AnchorPane root = FXMLLoader.load(getClass().getResource("../view/RegisterPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Register Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }
    }

    private void openPlayerNamePage() throws IOException
    {
        if(checkLogin()) {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource
                    ("../view/PlayersNamePage.fxml")));
            Stage registerStage = new Stage();
            registerStage.setTitle("Player Name Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }
    }

    public  boolean checkFields()
    {
        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty())
        {
            errorLbl.setText("Please fill in all fields !!");
            errorLbl.setAlignment(Pos.CENTER);
            errorLbl.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true;
    }

    public boolean checkLogin()
    {
        ArrayList<User> users = User.getUserArrayList();
        if (checkFields()) {
            for (User each : users) {
                if (usernameField.getText().equals(each.getUsername())
                        && passwordField.getText().equals(each.getPassword()))
                {
                    errorLbl.setText("");
                    return true;
                }
            }
        }
        else
        {
            errorLbl.setText("Please fill in all fields !!");
            errorLbl.setAlignment(Pos.CENTER);
            errorLbl.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        errorLbl.setText("Username or password is incorrect!");
        errorLbl.setAlignment(Pos.CENTER);
        errorLbl.setTextFill(Paint.valueOf(("#FF0000")));
        return false;
    }

}