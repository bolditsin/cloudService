package gb.cloud.server.service.file;

public class RequestMsg extends AbstractMsg {

    private String filename;
    private String newFileName;



    public RequestMsg(String filename) {
        this.filename = filename;

    }

    public RequestMsg(String cmd, String filename, String newFileName, String login) {
        this.filename = filename;
        this.newFileName = newFileName;
    }

    public String getFilename() {
        return filename;
    }


    public String getNewFileName() {
        return newFileName;
    }

}