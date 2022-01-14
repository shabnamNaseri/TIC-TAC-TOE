package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class MainPageController implements Initializable {
    @FXML
    private Label usernameLabelX;

    @FXML
    private Label pointLabelX;

    @FXML
    private Button exitButton;

    @FXML
    private Button startGameButton;

    @FXML
    private Button settingsGameButton;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Label winnerLabel;

    @FXML
    private Label usernameLabelO;

    @FXML
    private Label pointLabelO;

    static ArrayList<Button> buttons;

    private int player = 0;
    private double pointPlayer_X = 0;
    private double pointPlayer_O = 0;
    private int counter = 0;
    private int number = 0;
    private int roundNumber = 3;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        showUsernameInPage_O();
        showUsernameInPage_X();
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7,
                button8, button9));
        startGameButton.setOnAction(event -> {
            startGameButton.setDisable(true);
            winnerLabel.setText("");
            number++;
            setRound();
            if (number > roundNumber) {
                number = 0;
                buttons.forEach(button -> button.setDisable(true));
                winnerSelection();
            }
            buttons.forEach(button -> {
                setActionButton(button);
            });
        });
        startGameButton.setDisable(false);
        exitButton.setOnAction(event -> exitPage());
        settingsGameButton.setOnAction(event -> {
            try {
                openSettingsPge();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void openSettingsPge() throws IOException
    {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/settingPage.fxml"));
        Stage settingStage = new Stage();
        settingStage.setTitle("Setting Page");
        settingStage.setScene(new Scene(root));
        settingStage.show();
    }

    private void exitPage()
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void playerSymbol(Button playerSymbol)
    {
        if (player % 2 == 0) {
            playerSymbol.setText("O");
            playerSymbol.setAlignment(Pos.CENTER);
            playerSymbol.setTextFill(Paint.valueOf(("#35dbe4")));
            player = 1;
        } else {
            playerSymbol.setText("X");
            playerSymbol.setAlignment(Pos.CENTER);
            playerSymbol.setTextFill(Paint.valueOf(("#0f5cc6")));
            player = 0;
        }
    }

    public void showUsernameInPage_X()
    {
        pointLabelX.getText();
        usernameLabelX.setText(PlayersNamePageController.username_X);
    }

    public void showUsernameInPage_O()
    {
        pointLabelO.getText();
        usernameLabelO.setText(PlayersNamePageController.username_O);
    }

    public void setActionButton(Button buttonAction)
    {
        buttonAction.setOnMouseClicked(mouseEvent -> {
            playerSymbol(buttonAction);
            counter++;
            checkTheEndOfTheGame();
        });
    }

    public void checkTheEndOfTheGame()
    {
        if (theWinnerIsX()) {
            winnerLabel.setText("X Is The Winner!");
            point_X(1);
            winnerLabel.setAlignment(Pos.CENTER);
            winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
            startGameButton.setDisable(false);
            clearButtons();
        }

        if (theWinnerIsO()) {
            winnerLabel.setText("O Is The Winner!");
            point_O(1);
            winnerLabel.setAlignment(Pos.CENTER);
            winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
            startGameButton.setDisable(false);
            clearButtons();
        }

        if (counter == 9 && theGameEqualised()) {
            point_X(0.5);
            point_O(0.5);
            showText();
            clearButtons();
        }
    }

    public boolean theWinnerIsX()
    {
        for (int i = 0; i < buttons.size(); i++) {
            if ((button1.getText().equals("X") && button1.getText().equals(button2.getText())
                    && button1.getText().equals(button3.getText()))) {
                return true;
            } else if (button4.getText().equals("X") && button4.getText().equals(button5.getText())
                    && button4.getText().equals(button6.getText())) {
                return true;//point_X(1);counter++;return true;
            } else if (button7.getText().equals("X") && button7.getText().equals(button8.getText())
                    && button7.getText().equals(button9.getText())) {
                return true;
            } else if (button1.getText().equals("X") && button1.getText().equals(button5.getText())
                    && button1.getText().equals(button9.getText())) {
                return true;
            } else if (button3.getText().equals("X") && button3.getText().equals(button5.getText())
                    && button3.getText().equals(button7.getText())) {
                return true;
            } else if (button1.getText().equals("X") && button1.getText().equals(button4.getText())
                    && button1.getText().equals(button7.getText())) {
                return true;
            } else if (button2.getText().equals("X") && button2.getText().equals(button5.getText())
                    && button2.getText().equals(button8.getText())) {
                return true;
            } else if (button3.getText().equals("X") && button3.getText().equals(button6.getText())
                    && button3.getText().equals(button9.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean theWinnerIsO()
    {
        for (int i = 0; i < buttons.size(); i++) {
            if ((button1.getText().equals("O") && button1.getText().equals(button2.getText())
                    && button1.getText().equals(button3.getText()))) {
                return true;
            } else if (button4.getText().equals("O") && button4.getText().equals(button5.getText())
                    && button4.getText().equals(button6.getText())) {
                return true;
            } else if (button7.getText().equals("O") && button7.getText().equals(button8.getText())
                    && button7.getText().equals(button9.getText())) {
                return true;
            } else if (button1.getText().equals("O") && button1.getText().equals(button5.getText())
                    && button1.getText().equals(button9.getText())) {
                return true;
            } else if (button3.getText().equals("O") && button3.getText().equals(button5.getText())
                    && button3.getText().equals(button7.getText())) {
                return true;
            } else if (button1.getText().equals("O") && button1.getText().equals(button4.getText())
                    && button1.getText().equals(button7.getText())) {
                return true;
            } else if (button2.getText().equals("O") && button2.getText().equals(button5.getText())
                    && button2.getText().equals(button8.getText())) {
                return true;
            } else if (button3.getText().equals("O") && button3.getText().equals(button6.getText())
                    && button3.getText().equals(button9.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean theGameEqualised()
    {
        if (!theWinnerIsX() && !theWinnerIsO()) {
            return true;
        }
        return false;
    }

    //the text show of the game is equal
    public void showText()
    {
        startGameButton.setDisable(false);
        winnerLabel.setFont(Font.font(25));
        winnerLabel.setText("The Game Equalised!!");
        winnerLabel.setAlignment(Pos.CENTER);
        winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
    }

    public void point_X(double number)
    {
        pointPlayer_X = pointPlayer_X + number;
        pointLabelX.setText(String.valueOf(pointPlayer_X));
        ArrayList<User> users = User.getUserArrayList();
        for (User each : users) {
            if (PlayersNamePageController.username_X.equals(each.getUsername()))
            {each.point = pointPlayer_X;}
        }
    }

    public void point_O(double number)
    {
        pointPlayer_O = pointPlayer_O + number;
        pointLabelO.setText(String.valueOf(pointPlayer_O));
        ArrayList<User> users = User.getUserArrayList();
        for (User each : users) {
            if (PlayersNamePageController.username_O.equals(each.getUsername()))
            {each.point = pointPlayer_O;}
        }
    }

    public void clearButtons()
    {
        counter = 0;
        buttons.forEach(button -> button.setText(""));
    }

    private void winnerSelection()
    {
       if(pointPlayer_X > pointPlayer_O)
       {
           winnerLabel.setFont(Font.font(25));
           winnerLabel.setText("The winner is player X!");
           winnerLabel.setAlignment(Pos.CENTER);
           winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
       }
       else if(pointPlayer_X < pointPlayer_O)
       {
            winnerLabel.setFont(Font.font(25));
           winnerLabel.setText("The winner is player O!");
            winnerLabel.setAlignment(Pos.CENTER);
            winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
       }
       else {
           winnerLabel.setFont(Font.font(25));
           winnerLabel.setText("Points are equal!");
           winnerLabel.setAlignment(Pos.CENTER);
           winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
       }
    }

    private void setRound()
    {roundNumber = SettingsPageController.round;}
}