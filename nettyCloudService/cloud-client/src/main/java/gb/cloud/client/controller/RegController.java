package gb.cloud.client.controller;

import gb.cloud.server.database.DatabaseHandler;
import gb.cloud.server.database.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegController {

        @FXML
        private TextField regName;

        @FXML
        private PasswordField password_field;

        @FXML
        private Button regMe;


        @FXML
        void initialize(){

            regMe.setOnAction(event -> {
            regNewUser();
            });

        }

   private void regNewUser() {
       DatabaseHandler dbHandler = new DatabaseHandler();
       String username= regName.getText();
       String password= password_field.getText();

       User user= new User(username,password);

       dbHandler.regUser(user);

    }
}
