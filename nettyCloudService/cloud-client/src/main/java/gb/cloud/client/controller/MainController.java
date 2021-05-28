package gb.cloud.client.controller;

import gb.cloud.client.factory.Factory;
import gb.cloud.client.service.NetworkService;
import gb.cloud.domain.Command;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField commandTextField;

    @FXML
    private Button upload_btn;

    @FXML
    private TextArea commandResultTextArea;

    @FXML
    private TextArea commandResultTextArea1;

    @FXML
    private Button download_btn;

    public NetworkService networkService;

    @FXML
    void initialize(){
        download_btn.setOnAction(event -> downloadFile());
        upload_btn.setOnAction(event -> uploadFile());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        networkService = Factory.getNetworkService();

        createCommandResultHandler();
    }

    private void createCommandResultHandler() {
        new Thread(() -> {
            while (true) {
                String resultCommand = networkService.readCommandResult();
                Platform.runLater(() -> commandResultTextArea.appendText(resultCommand + System.lineSeparator()));
            }
        }).start();
    }

    public void sendCommand(ActionEvent actionEvent) {
        String[] textCommand = commandTextField.getText().trim().split("\\s");
        if (textCommand.length > 1) {
            String[] commandArgs = Arrays.copyOfRange(textCommand, 1, textCommand.length);
            networkService.sendCommand(new Command(textCommand[0], commandArgs));
            commandTextField.clear();
        }
    }

    private void downloadFile(){

    }
    private void uploadFile(){

    }
    public void shutdown() {
        networkService.closeConnection();
    }


}
