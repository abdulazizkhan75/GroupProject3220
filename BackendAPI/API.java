import java.util.ArrayList;

public class API {
    private String Data_Custodian;
    private String Data_Currency_Comments;
    private String Dataset_Description;
    private String Data_Accuracy_Comments;
    private String Attributes;
    private String Coordinate_System;
    private ArrayList<String> Relevant_Downloads = new ArrayList<String>();
    private int numOfDownloads = 0;
    public API() {
        Data_Custodian = "";
        Data_Currency_Comments = "";
        Dataset_Description = "";
        Data_Accuracy_Comments = "";
        Attributes = "";
        Coordinate_System = "";
    }

    public int getNumOfDownloads() {
        return numOfDownloads;
    }

    public void setDataCustodian(String data) {
        Data_Custodian = Data_Custodian + "\n" + data;
        
    }
    
    public void setDataCurrencyComments(String data) {
        Data_Currency_Comments = Data_Currency_Comments + "\n" +  data;
    }

    public void setDatasetDescription(String data) {
        Dataset_Description = Dataset_Description + "\n" +  data;
    }

    public void setDataAccuracyComments(String data) {
        Data_Accuracy_Comments = Data_Accuracy_Comments + "\n" +  data;
    }

    public void setAttributes(String data) {
        Attributes = Attributes + "\n" +  data;
    }

    public void setCoordinateSystem(String data) {
        Coordinate_System = Coordinate_System + "\n" +  data;
    }

    public void setRelevantDownload(String data) {
        Relevant_Downloads.add((Relevant_Downloads.size() + 1) + "." +  data);
        //Relevant_Downloads = Relevant_Downloads + "\n(" + (numOfDownloads + 1) + "). " +  data;
        //numOfDownloads = numOfDownloads + 1;
    }

    public String getDataCustodian() {
        if (Data_Custodian.equals("")) {
            return "N/A";
        } else {
            return Data_Custodian;
        }
    }

    public String getDataCurrencyComments() {
        if (Data_Currency_Comments.equals("")) {
            return "N/A";
        } else {
            return Data_Currency_Comments;
        }
    }

    public String getDatasetDescription() {
        if (Dataset_Description.equals("")) {
            return "N/A";
        } else {
            return Dataset_Description;
        }
    }

    public String getDataAccuracyComments() {
        if (Data_Accuracy_Comments.equals("")) {
            return "N/A";
        } else {
            return Data_Accuracy_Comments;
        }
    }

    public String getAttributes() {
        if (Attributes.equals("")) {
            return "N/A";
        } else {
            return Attributes;
        }
    }

    public String getCoordinateSystem() {
        if (Coordinate_System.equals("")) {
            return "N/A";
        } else {
            return Coordinate_System;
        }
    } 

    public ArrayList<String> getRelevantDownload() {
        if (Relevant_Downloads.isEmpty()) {
            Relevant_Downloads.add("N/A");
        } 
        
        return Relevant_Downloads;
        
    }

    public String printAList() {
        String listTemp = "\n";
        for (int i = 0; i < Relevant_Downloads.size(); i++) {
            listTemp = listTemp + "" + Relevant_Downloads.get(i) + "\n";
        }
        return listTemp;
    }

    public String toString() {
        return "Data Custodian: " + getDataCustodian() + "\n\nData Currency Comments: " + getDataCurrencyComments() + "\n\nDataset Description: " + getDatasetDescription() + "\n\nData Accuracy Comments: " + getDataAccuracyComments() + "\n\nAttributes: " + getAttributes() + "\n\nCoordinate System: " + getCoordinateSystem() + "\n\nRelevant Downloads: " + printAList() + "\n\n";
    }

}
