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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class MainPageController implements Initializable
{
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

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        showUsernameInPage_O();
        showUsernameInPage_X();
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));
        startGameButton.setOnAction(event -> {
            startGameButton.setDisable(true);
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
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

    public void playerSymbol(Button playerSymbol)
    {
        if (player % 2 == 0)
        {
            playerSymbol.setText("O");
            playerSymbol.setAlignment(Pos.CENTER);
            playerSymbol.setTextFill(Paint.valueOf(("#35dbe4")));
            player = 1;
        }
        else
        {
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
            checkTheEndOfTheGame();
        });
    }

    public void checkTheEndOfTheGame()
    {
        if(theWinnerIsX())
        {showTheWinningText_X();clearButtons();}

        if(theWinnerIsO())
        {showTheWinningText_O();clearButtons();}

        buttons.forEach(button -> {
            if (!theGameEqualised_O() && !theGameEqualised_X()) {
                showText();
            }
        });
    }

    public boolean theWinnerIsX()
    {
        for (int i = 0; i < buttons.size(); i++) {
            if ((button1.getText().equals("X") && button1.getText().equals(button2.getText())
                    && button1.getText().equals(button3.getText()))) {
                point_X();return true;
            } else if (button4.getText().equals("X") && button4.getText().equals(button5.getText())
                    && button4.getText().equals(button6.getText())) {
                point_X();return true;
            } else if (button7.getText().equals("X") && button7.getText().equals(button8.getText())
                    && button7.getText().equals(button9.getText())) {
                point_X();return true;
            } else if (button1.getText().equals("X") && button1.getText().equals(button5.getText())
                    && button1.getText().equals(button9.getText())) {
                point_X();return true;
            } else if (button3.getText().equals("X") && button3.getText().equals(button5.getText())
                    && button3.getText().equals(button7.getText())) {
                point_X();return true;
            } else if (button1.getText().equals("X") && button1.getText().equals(button4.getText())
                    && button1.getText().equals(button7.getText())) {
                point_X();return true;
            } else if (button2.getText().equals("X") && button2.getText().equals(button5.getText())
                    && button2.getText().equals(button8.getText())) {
                point_X();return true;
            } else if (button3.getText().equals("X") && button3.getText().equals(button6.getText())
                    && button3.getText().equals(button9.getText())) {
                point_X();return true;
            }
        }
        return false;
    }

    public boolean theWinnerIsO()
    {
        for (int i = 0; i < buttons.size(); i++) {
            if ((button1.getText().equals("O") && button1.getText().equals(button2.getText())
                    && button1.getText().equals(button3.getText()))) {
                point_O();return true;
            } else if (button4.getText().equals("O") && button4.getText().equals(button5.getText())
                    && button4.getText().equals(button6.getText())) {
                point_O();return true;
            } else if (button7.getText().equals("O") && button7.getText().equals(button8.getText())
                    && button7.getText().equals(button9.getText())) {
                point_O();return true;
            } else if (button1.getText().equals("O") && button1.getText().equals(button5.getText())
                    && button1.getText().equals(button9.getText())) {
                point_O();return true;
            } else if (button3.getText().equals("O") && button3.getText().equals(button5.getText())
                    && button3.getText().equals(button7.getText())) {
                point_O();return true;
            } else if (button1.getText().equals("O") && button1.getText().equals(button4.getText())
                    && button1.getText().equals(button7.getText())) {
                point_O();return true;
            } else if (button2.getText().equals("O") && button2.getText().equals(button5.getText())
                    && button2.getText().equals(button8.getText())) {
                point_O();return true;
            } else if (button3.getText().equals("O") && button3.getText().equals(button6.getText())
                    && button3.getText().equals(button9.getText())) {
                point_O();return true;
            }
        }
        return false;
    }

    public boolean theGameEqualised_O()
    {
        for (int i = 0; i < buttons.size(); i++) {
            if (!(button1.getText().equals("O") && button1.getText().equals(button2.getText()) &&
                    button1.getText().equals(button3.getText())))
            {return true;}
            else if (!(button4.getText().equals("O") && button4.getText().equals(button5.getText()) &&
                    button4.getText().equals(button6.getText())))
            {return true;}
            else if (!(button7.getText().equals("O") && button7.getText().equals(button8.getText()) &&
                    button7.getText().equals(button9.getText())))
            {return true;}
            else if (!(button1.getText().equals("O")  && button1.getText().equals(button5.getText()) &&
                    button1.getText().equals(button9.getText())))
            {return true;}
            else if (!(button3.getText().equals("O") && button3.getText().equals(button5.getText()) &&
                    button3.getText().equals(button7.getText())))
            {return true;}
            else if (!(button1.getText().equals("O")  && button1.getText().equals(button4.getText()) &&
                    button1.getText().equals(button7.getText())))
            {return true;}
            else if (!(button2.getText().equals("O")  && button2.getText().equals(button5.getText()) &&
                    button2.getText().equals(button8.getText())))
            {return true;}
            else if (!(button3.getText().equals("O") && button3.getText().equals(button6.getText()) &&
                    button3.getText().equals(button9.getText())))
            {return true;}
        }
        return false;
    }

    public boolean theGameEqualised_X()
    {
        for (int i = 0; i < buttons.size(); i++) {
            if (!(button1.getText().equals("X") && button1.getText().equals(button2.getText()) &&
                    button1.getText().equals(button3.getText())))
            {return true;}
            else if (!(button4.getText().equals("X") && button4.getText().equals(button5.getText()) &&
                    button4.getText().equals(button6.getText())))
            {return true;}
            else if (!(button7.getText().equals("X") && button1.getText().equals(button5.getText()) &&
                    button1.getText().equals(button9.getText())))
            {return true;}
            else if (!(button3.getText().equals("X")&& button3.getText().equals(button5.getText()) &&
                    button3.getText().equals(button7.getText())))
            {return true;}
            else if (!(button1.getText().equals("X") && button1.getText().equals(button4.getText()) &&
                    button1.getText().equals(button7.getText())))
            {return true;}
            else if (!(button2.getText().equals("X")  && button2.getText().equals(button5.getText()) &&
                    button2.getText().equals(button8.getText())))
            {return true;}
            else if (!(button3.getText().equals("X") && button3.getText().equals(button6.getText()) &&
                    button3.getText().equals(button9.getText())))
            {return true;}
        }
        return false;
    }

    public void showTheWinningText_X()
    {
        winnerLabel.setText("X Is The Winner!");
        winnerLabel.setAlignment(Pos.CENTER);
        winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
        startGameButton.setDisable(false);
    }

    public void showTheWinningText_O()
    {
        winnerLabel.setText("O Is The Winner!");
        winnerLabel.setAlignment(Pos.CENTER);
        winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
        startGameButton.setDisable(false);
    }

    //the text show of the game is equal
    public void showText()
    {
        winnerLabel.setFont(Font.font(25));
        winnerLabel.setText("The Game Equalised!!");
        winnerLabel.setAlignment(Pos.CENTER);
        winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
        startGameButton.setDisable(false);
    }

    public void point_X()
    {
        pointPlayer_X = pointPlayer_X + 1;
        pointLabelX.setText(String.valueOf(pointPlayer_X));
    }

    public void point_O()
    {
        pointPlayer_O = pointPlayer_O + 1;
        pointLabelO.setText(String.valueOf(pointPlayer_O));
    }

    public void clearButtons()
    {
        int counter = 0;
        buttons.forEach(button -> button.setText(""));
        winnerLabel.setText("");
        counter++;
        if(counter > 3)
        {
            winnerLabel.setFont(Font.font(25));
            startGameButton.setDisable(true);
            winnerLabel.setText("The Number Of Round Is Over!");
            winnerLabel.setAlignment(Pos.CENTER);
            winnerLabel.setTextFill(Paint.valueOf(("#078e9a")));
        }

    }
}