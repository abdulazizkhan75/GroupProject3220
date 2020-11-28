import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
/*  Usermenu is used to show all the contents of the Categories/Api to the user and to recieve user input. Will call Category, FileRead, and API classes to help in displaying the content*/






public class UserMenu {
        private static String userInput; //stores the input for what the user enters
        private static String userCategory; //stores the input for the category the user selected
        private static String selectedAPI; //stores the input for the corresponding api the user inputted
        
        private static ArrayList<String> catNames = new ArrayList<String>();
        private static ArrayList<JButton> buttonNames = new ArrayList<JButton>();
        private static ArrayList<String> downloadNames = new ArrayList<String>();


        public static void displayCSV(JPanel pane, JLabel info, JTextArea tArea, String file, String fileType, FileDownload dwFile) {
                info.setText("Do you want to see the contents of this file? (This is restricted to .csv only)");

                JButton yesButton = new JButton("Yes");
                JButton noButton = new JButton("No");

                pane.add(yesButton);
                pane.add(noButton);

                yesButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                if (fileType.equals("csv ")) {

                                        // System.out.println(userInNum);
                                                CSVFile csv = new CSVFile("");
                                                 try {
                                                  csv = new CSVFile(dwFile.getDownloadName());
                                                 csv.readCSV(1);
                                                 
                                                 } catch (IOException err) {
                                                         //System.out.println("Ouch, error occured");
                                                         err.printStackTrace();
                                                 }

                                                ArrayList<ArrayList<String>> ybList = csv.getList();
                                                String[] colSizes = csv.getNamesOfColumns();
                                               
                                                //System.out.println(ybList);
                                                //ArrayList<String[]> rowData = csv.getData2DArray();

                                                 String[][] arr2D = new String[ybList.size()][];
                                                 for (int i = 0; i < ybList.size(); i++) {
                                                         ArrayList<String> row = ybList.get(i);
                                                         arr2D[i] = row.toArray(new String[row.size()]);
                                                         
                                                 }

                                               
                                                JTable csvTable = new JTable(arr2D, colSizes);
                                                csvTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                                                JScrollPane scrollPane = new JScrollPane(csvTable);
                                                
                                                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                                                //csvTable.setSize(850, 600);
                                                 scrollPane.setPreferredSize(new Dimension(pane.getWidth(), 500));
                                                 csvTable.setAutoCreateRowSorter(true);
                                                for (int i = 0; i < colSizes.length; i++) {
                                                        csvTable.getColumnModel().getColumn(i).setPreferredWidth((pane.getWidth() / colSizes.length) + 20);
                                                        //scrollpane.getColumnModel().getColumn(i).setWidth(50);
                                                }
                                                pane.remove(tArea);

                                                pane.add(scrollPane);
                                                pane.remove(noButton);
                                                pane.remove(yesButton);
                                                info.setText("Displaying the contents of the csv file");
                                                pane.repaint();
                                                pane.revalidate(); 





                                                //String[] rowDataString = rowData.toArray();
                                                /*String[][] rowDataString = new String[rowData.size()][];
                                                
                                                for (int i = 0; i < rowDataString.length; i++) {
                                                        String[] row = rowData.get(i);
                                                        rowDataString[i] = row;
                                                }
                                                for (int i = 0; i < rowDataString.length; i++) {
                                                        System.out.println(rowDataString[i]);
                                                }
                                                //rowDataString = rowData.toArray(rowDataString);
                                                System.out.println(rowDataString); */
                                                //JTable csvTable = new JTable(rowDataString, colSizes);
                                                //pane.remove(tArea);



                                 } else {
                                         info.setText("uh oh, not a csv file");
                                 }


                        }
                });

                noButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                           System.exit(0);

                        }
                });




        }

        public static void displayAPIdata(JPanel pane, JLabel info) {

                FileRead userFile = new FileRead(userCategory, selectedAPI);
                API selectedAPI = new API();

                try {
                        selectedAPI = userFile.getData();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                String temp = selectedAPI.toString();
                         JTextArea tArea = new JTextArea(temp);
                        Font font = new Font("Arial", 0, 12);
                        tArea.setSize(800, 500);
                        tArea.setFont(font);
                        tArea.setLineWrap(true);
                        tArea.setWrapStyleWord(true);
                        pane.add(tArea);

                        info.setText("Which dataset do you wish to download?");
                        downloadNames = selectedAPI.getRelevantDownload();
                        for (int i = 0; i < downloadNames.size(); i++) {
                                JButton dlButtonName = new JButton(downloadNames.get(i));
                                pane.add(dlButtonName);
                                buttonNames.add(dlButtonName);

                                dlButtonName.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                           
                                                String dlChosen = dlButtonName.getText();
                                                String[] sArray = dlChosen.split("\\(");
                                                String numRemove = "";
                                                numRemove = sArray[0].substring(3);
                                                String[] lastSplitIPromise = numRemove.split("\\.");
                                                emptyList(pane);
                                                FileDownload dwFile = new FileDownload(numRemove); //, lastSplitIPromise[0], lastSplitIPromise[1]);
                                                dwFile.startDownload();
                                
                                                displayCSV(pane, info, tArea, numRemove, lastSplitIPromise[1], dwFile);

                                                
        
        
                                        }
                                });
                        }
                        pane.repaint();
                        pane.revalidate();


              //  JButton 
        }

        public static void displayDataSet(JPanel pane, JLabel info) {
                info.setText("Click the corresponding button that matches the data set you are currently interested in.");

                for (int i = 0; i < catNames.size(); i++) {
                        //final String dsString = catNames.get(i);
                        JButton dsName = new JButton(catNames.get(i));
                        pane.add(dsName);
                        buttonNames.add(dsName);

                        dsName.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                        selectedAPI = dsName.getText();
                                        emptyList(pane);
                                        catNames.clear();

                                        displayAPIdata(pane, info);
                                        //System.out.println(userCategory + " " +  selectedAPI);

                                        


                                }
                        });


                }
        }       

        public static void listInstant() {
                catNames.add("Parks"); 
                catNames.add("Public Service"); 
                catNames.add("Politics");
                catNames.add("Animals");
                catNames.add("City Maintenance");
        }

        //ublic static void
        public static void emptyList(JPanel pane) {
                for (int i = 0; i < buttonNames.size(); i++) {
                        pane.remove(buttonNames.get(i));

                }
                buttonNames.clear();

                pane.repaint();
                pane.revalidate();
        }

        public static void userMenuJPanel(JPanel pane)  {
                //pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
                
                pane.setLayout(new FlowLayout());

                JLabel info = new JLabel("Click the corresponding button that best matches the closest option to your required needs.");
                Font font = new Font("Arial", 0, 20);
                info.setFont(font);
                
                pane.add(info);

                listInstant();

                for (int i = 0; i < catNames.size(); i++) {
                      JButton catButton = new JButton(catNames.get(i));
                      buttonNames.add(catButton);
                      pane.add(catButton);
                      final String fString = catNames.get(i);

                      catButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent  e) {
                               // System.out.println("Button " + fString + " Pressed.");
                                Category swingCat = new Category(fString);
                                userCategory = fString;
                                emptyList(pane);
                                catNames.clear();
                                catNames = swingCat.returnCategory();
                                
                                displayDataSet(pane, info);



                              }
                      });
                }
                

                
        }



        public static void userMenuJFrame() {
                JFrame frame = new JFrame("City of Windsor Data Sets");
                frame.setSize(850, 800);


                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                frame.setVisible(true);
                
                JPanel pane = new JPanel();
                frame.add(pane);
                frame.setResizable(false);
                userMenuJPanel(pane);


        }



        
        public static void userMenu() {
               
                userMenuJFrame();
                while (true) {
                System.out.println("Each option in this has to be either written as below or typed by number. ");
                System.out.println("(1). Parks\n(2). Public Service\n(3). Politics\n(4). Animals\n(5). City Maintenance\n");
                System.out.println("Which category of data are you looking for?(Type 'Exit' or '0' to exit.)");
               
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextLine();
                if (userInput.equalsIgnoreCase("Exit") || userInput.equalsIgnoreCase("0")){
                        System.exit(0);
                }

                if (userInput.equals("1")) {
                        userInput = "Parks";
        
                } else if (userInput.equals("2")) {
                        userInput = "Public Service";
        
                } else if (userInput.equals("3")) {
                        userInput = "Politics";
        
                } else if (userInput.equals("4")) {
                        userInput = "Animals";
        
                } else if (userInput.equals("5")) {
                        userInput = "City Maintenance";
                }

                userCategory = userInput;
                
                Category catSelect = new Category(userCategory); //creates the category to display the data to the user
                
                catSelect.DisplaySelection(); //displays the current category that user inputted. 
                ArrayList<String> tempCat = catSelect.returnCategory();

                userInput = sc.nextLine();
                selectedAPI = userInput;

                if (selectedAPI.equals("1")) {
                        selectedAPI = tempCat.get(0);
                } else if (selectedAPI.equals("2")) {
                        selectedAPI = tempCat.get(1);
                } else if (selectedAPI.equals("3")) {
                        selectedAPI = tempCat.get(2);
                } else if (selectedAPI.equals("0")) {
                        continue;
                }


                FileRead userFile = new FileRead(userCategory, selectedAPI);
                API selectedAPI = new API();
                try {
                selectedAPI = userFile.getData();
                System.out.println(selectedAPI);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                System.out.println("Enter the number corresponding to which File you wish to download, or 0 to cancel.");
                //userInput =  sc.nextLine();
                int userInNum = sc.nextInt();
                if (userInNum == 0) {
                        continue;
                }
                //System.out.println(selectedAPI.getRelevantDownload());
                ArrayList<String> tempArr = selectedAPI.getRelevantDownload();
                String sforDownload = tempArr.get(userInNum - 1);
                String[] sArray = sforDownload.split("\\(");
                //System.out.println(sArray[0]);
                //System.out.println(sArray[0]);
                String numRemove = "";
                if (userInNum < 10) {
                        numRemove = sArray[0].substring(3);
                } else if (userInNum < 100) {
                        numRemove = sArray[0].substring(4);
                }
                //System.out.println(numRemove);
                String[] lastSplitIPromise = numRemove.split("\\.");
                //System.out.println(lastSplitIPromise[0]);
                //System.out.println(lastSplitIPromise[1]);
                FileDownload dwFile = new FileDownload(numRemove); //, lastSplitIPromise[0], lastSplitIPromise[1]);
                dwFile.startDownload();

                System.out.println("Would you like to view the data? (Y=1/N=2) {currently only CSV only}");
                userInNum = sc.nextInt();
                
                if (lastSplitIPromise[1].equals("csv ")) {

                       // System.out.println(userInNum);
                        if (userInNum == 1) {
                                try {
                                    //    System.out.println(dwFile.getDownloadName());
                                CSVFile csv = new CSVFile(dwFile.getDownloadName());
                                csv.readCSV(0);
                                csv.displayCSV();
                                } catch (IOException e) {
                                        //System.out.println("Ouch, error occured");
                                        e.printStackTrace();
                                }
                        } else {
                                continue;
                        }
                }


         }       
        }


        public static void main(String args[]) {
                userMenu();
                
        }
}
