package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegisterPageController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label errorLBL;

    @FXML
    private Button registerBTN;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        errorLBL.setText("");

        cancelBtn.setOnAction(event -> closePage());

        registerBTN.setOnAction(event -> {
            try {
                createUser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void closePage()
    {
        Stage stage = (Stage)cancelBtn.getScene().getWindow();
        stage.close();
        LoginPageController.registerStage = null;
    }

    public boolean checkFields()
    {
        if (name.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty() ||
                confirmPassword.getText().isEmpty())
        {
            errorLBL.setText("Please fill in all fields !!");
            errorLBL.setAlignment(Pos.CENTER);
            errorLBL.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true;
    }

    public boolean checkPassword()
    {
        if (!password.getText().equals(confirmPassword.getText())){
            errorLBL.setText("Passwords do not match !!");
            errorLBL.setAlignment(Pos.CENTER);
            errorLBL.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true;
    }

    public boolean checkUsername()
    {
        ArrayList<User> users = User.getUserArrayList();
        for (User each : users)
            if(each.getUsername().equals(username.getText()))
            {
                errorLBL.setFont(Font.font(14));
                errorLBL.setText("The username entered is repetitive!!");
                errorLBL.setAlignment(Pos.CENTER);
                errorLBL.setTextFill(Paint.valueOf(("#FF0000")));
                return false;
            }
        errorLBL.setText("");
        return true;
    }

    private boolean checkUsernameAndPassword()
    {
        if(checkUsername()) {
            if (checkPassword()) {
                return true;
            }
        }
        return  false;
    }

    public void createUser()
    {
        if (checkFields()) {
            if (checkUsernameAndPassword()) {
                User user = new User(name.getText(), username.getText(), password.getText());
                user.getUserArrayList().add(user);
                errorLBL.setText("User successfully created ");
                errorLBL.setAlignment(Pos.CENTER);
                errorLBL.setTextFill(Paint.valueOf(("#006600")));
            }
        }
    }
}
