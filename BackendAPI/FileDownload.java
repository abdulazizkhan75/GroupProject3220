import java.nio.*;
import java.net.URL;
import java.io.FileOutputStream;
import java.nio.channels.*;




public class FileDownload {

    private String downloadName;
    //private String fileFormat;
    //private String nameAlone;

    public FileDownload(String name) { //, String fName, String fType) {
        
        downloadName = name;
        //nameAlone = fName;
        //fileFormat = fType;
    }

    public String getDownloadName() {
        return downloadName;
    }

    public void checkFileString() {
        System.out.println(downloadName);
        downloadName = downloadName.stripTrailing();
        if (downloadName.equals("ParksMaintenance_YTD.csv")) {
            downloadName = "1f301b1e-f40a-43df-9386-787d3947400d.csv";
        } else if (downloadName.equals("ParksLighting_YTD.csv")) {
            downloadName = "619c7c78-80c6-458e-b384-b8675c3eafe6.csv";
        }
    }
    public void startDownload() {
        
        //SOME FILES ON THE WEBSITE ARE NOT THE SAME FOR SOMEREASON IE PARKS MAINTENANCE SERVICE, HAVE TO MANUALLY ENTER
        //DONT BE ALARMED IF NOT DOWNLOADED IMMEDIATELY, SHOULD BE AROUND 10-20 SECONDS FOR IT TO HAVE A FILE SIZE GREATER THAN 0
        try{
        //credit to dfa on stackoverflow https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
        
        checkFileString();
        URL downloadURL = new URL("https://opendata.citywindsor.ca/Uploads/" + downloadName);
        ReadableByteChannel rbc = Channels.newChannel(downloadURL.openStream());
        FileOutputStream fOut = new FileOutputStream(downloadName);
        fOut.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);




        System.out.println("Download complete");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}