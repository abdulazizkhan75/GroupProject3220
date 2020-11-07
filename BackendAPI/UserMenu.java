import java.util.Scanner;
import java.io.*;
/*  Usermenu is used to show all the contents of the Categories/Api to the user and to recieve user input. Will call Category, FileRead, and API classes to help in displaying the content*/


public class UserMenu {
        private static String userInput; //stores the input for what the user enters
        private static String userCategory; //stores the input for the category the user selected
        private static String selectedAPI; //stores the input for the corresponding api the user inputted

       
        public static void userMenu() {
                while (true) {
                System.out.println("Each option in this has to be either written as below");
                System.out.println("(1). Parks\n(2). Public Service\n(3). Politics\n(4). Animals\n(5). City Maintenance\n");
                System.out.println("Which category of data are you looking for?(Type 'Exit' to exit.)");
               
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextLine();
                if (userInput.equalsIgnoreCase("Exit")){
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
                userInput = sc.nextLine();
                selectedAPI = userInput;

                FileRead userFile = new FileRead(userCategory, selectedAPI);
                try {
                API selectedAPI = userFile.getData();
                System.out.println(selectedAPI);
                } catch (Exception e) {
                        e.printStackTrace();
                }

         }       
        }


        public static void main(String args[]) {
                userMenu();
        }
}