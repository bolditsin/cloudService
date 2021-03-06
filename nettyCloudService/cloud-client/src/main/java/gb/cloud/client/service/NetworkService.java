package gb.cloud.client.service;


import gb.cloud.domain.Command;

public interface NetworkService {

    void sendCommand(Command command);

    String readCommandResult();

    void closeConnection();

}
