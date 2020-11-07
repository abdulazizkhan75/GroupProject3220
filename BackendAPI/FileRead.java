import java.util.Scanner;
import java.io.FileInputStream;
/*FileRead class is used get the file name from where the data lies, and exactly where in the file to read from.
 Which is then sent to to the API class to be easily stored into an object */


public class FileRead {
    private String FileName;
    private String APIName;
    private API userAPI;
    //overriden constructor to recieve the name of the file and the specific 
    public FileRead(String FileRec, String APIRec) {
        FileName = FileRec;
        APIName = APIRec;

    }

    public API getData() throws Exception {
        
        Scanner fr = new Scanner(new FileInputStream("./" + FileName + ".txt"));
        
        //loops until it reaches the data in the file
        while (fr.hasNextLine()) {
           String i = fr.nextLine();
           if (i.equals(APIName)) {
               break;
           }
        }
        userAPI = new API();
        String currentType = "";
        while (fr.hasNextLine()) {
            String i = fr.nextLine();
            
            if (i.equals("Data Custodian:")) {
                currentType = i;
                userAPI.setDataCustodian(fr.nextLine());

            } else if (i.equals("Data Currency Comments:")) {
                currentType = i;
                userAPI.setDataCurrencyComments(fr.nextLine());

            } else if (i.equals("Dataset Description:")) {
                currentType = i;
                userAPI.setDatasetDescription(fr.nextLine());

            } else if (i.equals("Data Accuracy Comments:")) {
                currentType = i;
                userAPI.setDataAccuracyComments(fr.nextLine());

            } else if (i.equals("Attributes:")) {
                currentType = i;
                userAPI.setAttributes(fr.nextLine());

            } else if (i.equals("Coordinate System:")) {
                currentType = i;
                userAPI.setCoordinateSystem(fr.nextLine());

            } else if (i.equals("Relevant Downloads:")) {
                currentType = i;
                userAPI.setRelevantDownload(fr.nextLine());

            } else if (i.equals("END")) {
                break;
            
            } else {
                if (currentType.equals("Data Custodian:")) {
                    userAPI.setDataCustodian(i);

                } else if (currentType.equals("Data Currency Comments:")) {
                    userAPI.setDataCurrencyComments(i);

                } else if (currentType.equals("Dataset Description:")) {
                    userAPI.setDatasetDescription(i);

                } else if (currentType.equals("Data Accuracy Comments")) {
                    userAPI.setDataAccuracyComments(i);

                }  else if (currentType.equals("Attributes:")) {
                  
                    userAPI.setAttributes(i);

                } else if (currentType.equals("Coordinate System:")) {
                    userAPI.setCoordinateSystem(i);

                } else if (currentType.equals("Relevant Downloads:")) {
                    userAPI.setRelevantDownload(i);

                }
            }
            
        }


        return userAPI;
    }
}