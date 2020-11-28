

import java.io.*;
import java.util.Scanner;

import org.w3c.dom.css.CSSPrimitiveValue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFile {
    private String fileName;
    private int numOfColumns;
    private String[] namesOfColumns;
    private ArrayList<ArrayList<String>> csvColumns = new ArrayList<ArrayList<String>>();
    private ArrayList<String[]> data2DArray = new ArrayList<String[]>();
    

    public CSVFile(String file) {
        fileName = file;
        numOfColumns = 0;
        
    }
    public String[] getNamesOfColumns() {
        return namesOfColumns;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }


    public ArrayList<String[]> getData2DArray() {
        return data2DArray;
    }



    public ArrayList<ArrayList<String>> getList() {
        return csvColumns;
    }


    public void aListInstantiation() {
        for (int i = 0; i < numOfColumns; i++) {
            ArrayList<String> tempList = new ArrayList<String>();
            csvColumns.add(tempList);
        }
        //System.out.println("list created");
    }
 =


    public void readCSV(int mode) throws IOException{
        Scanner fr = new Scanner(new FileInputStream(fileName));

        String rowLength = fr.nextLine();
        String[] columns = rowLength.split(",");
        namesOfColumns = columns;
        numOfColumns = columns.length;

        


        while (fr.hasNextLine()) {
            String r = fr.nextLine();
            String[] c = r.split(",");
            if (mode == 0) {
                this.aListInstantiation();
                for (int i = 0; i < columns.length; i++) {
                    csvColumns.get(i).add(c[i]);
                }

            } else if (mode == 1) {
                
                 ArrayList<String> temp = new ArrayList<String>();

                    for (int j = 0; j < c.length; j++) {
                        temp.add(c[j]);

                    }
                csvColumns.add(temp);
            }
        }
       

     }

    public void displayCSV() {
        String tempString = "";
        for (int i = 0; i < numOfColumns; i++) {
            tempString = tempString + namesOfColumns[i] + "\t";
        }
        System.out.println(tempString);
        for (int i = 0; i < tempString.length() + 15; i++) {
            System.out.print("=");
        }
        System.out.println();

        for (int i = 0; i < csvColumns.get(0).size(); i++) {
            for (int j = 0; j < namesOfColumns.length; j++) {
                System.out.print(csvColumns.get(j).get(i) + "\t");
            }
            System.out.println();
        }

    }
}
