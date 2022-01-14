package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsPageController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Button recordsButton;

    @FXML
    private TextField roundField;

    @FXML
    private Button doneButton;

    @FXML
    private Label errorLabel;

    static int round = 3;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        doneButton.setOnAction(event -> {
            changeTheGameRound();
        });
        exitButton.setOnAction(event -> exitPage());
    }

    private void exitPage()
    {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

    private boolean changeTheGameRound()
    {
        try {
            String roundString = roundField.getText();
            round = Integer.parseUnsignedInt(roundString);
            if(round <= 0)
            {
                errorLabel.setFont(Font.font(15));
                errorLabel.setText("The number entered is incorrect!");
                errorLabel.setAlignment(Pos.CENTER);
                errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
                return false;
            }
            errorLabel.setFont(Font.font(15));
            errorLabel.setText("The game round was changed successfully");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf("#006600"));
            return true;
        } catch (NumberFormatException e) {
            errorLabel.setText("Please fill in the fields !!");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
    }
}
