




public class API {
    private String Data_Custodian;
    private String Data_Currency_Comments;
    private String Dataset_Description;
    private String Data_Accuracy_Comments;
    private String Attributes;
    private String Coordinate_System;
    private String Relevant_Downloads;

    public API() {
        Data_Custodian = "";
        Data_Currency_Comments = "";
        Dataset_Description = "";
        Data_Accuracy_Comments = "";
        Attributes = "";
        Coordinate_System = "";
        Relevant_Downloads = "";
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
        Relevant_Downloads = Relevant_Downloads + "\n" +  data;
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

    public String getRelevantDownload() {
        if (Relevant_Downloads.equals("")) {
            return "N/A";
        } else {
            return Relevant_Downloads;
        }
    }

    public String toString() {
        return "Data Custodian: " + getDataCustodian() + "\nData Currency Comments: " + getDataCurrencyComments() + "\nDataset Description: " + getDatasetDescription() + "\nData Accuracy Comments: " + getDataAccuracyComments() + "\nAttributes: " + getAttributes() + "\nCoordinate System: " + getCoordinateSystem() + "\nRelevant Downloads: " + getRelevantDownload() + "\n";
    }

}