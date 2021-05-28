package gb.cloud.client.controller;

import gb.cloud.server.database.DatabaseHandler;
import gb.cloud.server.database.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WebController {

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private Button regButton;

    @FXML
    void initialize(){
        signUpButton.setOnAction(event -> {
            String loginText= login_field.getText().trim();
            String passwordText= password_field.getText().trim();

            if(!loginText.equals("")&& !passwordText.equals("")){
                loginUser(loginText,passwordText);
            }
            else
                System.out.println("Error");
        });


        regButton.setOnAction(event -> {
            regButton.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/regWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root= loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DatabaseHandler dbHandler= new DatabaseHandler();
        User user= new User();
        user.setUsername(loginText);
        user.setPassword(passwordText);
        ResultSet result= dbHandler.getUser(user);

        int counter = 0;

        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if(counter>=1){
            System.out.println("Success");
        }
    }


}