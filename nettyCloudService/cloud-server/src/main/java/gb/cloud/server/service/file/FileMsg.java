package gb.cloud.server.service.file;

public class FileMsg extends AbstractMsg {

    private String filename;
    private byte[] data;
    private int partNumber;
    private int partsCount;


    public FileMsg(String filename, int partNumber, int partsCount, byte[] data) {
        this.filename = filename;
        this.partNumber = partNumber;
        this.partsCount = partsCount;
        this.data = data;

    }

    public String getFilename() {
        return filename;
    }

    public byte[] getData() {
        return data;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }
}