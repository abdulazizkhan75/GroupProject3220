import java.util.*;



//Category class to determine the  data sets to be shown to the user, this data is stored in an arraylist for easy insert and filtering of data 
public class Category {
        private ArrayList<String> selection; //stores the list of available apis to be shown to the user
     //   private ArrayList<String> firstFilter = new ArrayList<String>();
      public Category() { //defualt constructor
            selection = new ArrayList<String>();
            selection.add("Default String Name");
      }
      //public constructor to initialize the Arraylist for the available data sets
      public Category(String Filter) {
            selection = new ArrayList<String>();


            if (Filter.equalsIgnoreCase("Parks")) {
                selection.add("Parks"); 
                selection.add("Parks Maintenance Service Requests"); 
                selection.add("Parks Lighting Service Requests");

            } else if (Filter.equalsIgnoreCase("Public Service")) {
                selection.add("Police Stations");
                selection.add("Hospitals"); 
                selection.add("Fire Stations");

            } else if (Filter.equalsIgnoreCase("Politics")) {
                selection.add("Voting Locations"); 
                selection.add("Voting Subdivisions"); 
                selection.add("Election Results - 2020");

            } else if (Filter.equalsIgnoreCase("Animals")) {
                selection.add("Dead Animal Removal Service Requests");
                selection.add("Dog Complaint - Bylaw Service Requests");
                selection.add("Keeping of Animals Service Requests");

            } else if (Filter.equalsIgnoreCase("City Maintenance")) {
                selection.add("Alley Maintenance Service Requests");
                selection.add("Sewer Maintenance Service Requests");
                selection.add("Street Sweeping Service Requests");

            }
        

      }
      //displays the available data sets of the specific Category object
      public void DisplaySelection() {
          System.out.println("Which data set would you like to see? (0 to exit)");
          for (int i = 0; i < selection.size(); i++) {
              System.out.println("(" + (i+1) + "). " + selection.get(i));
          }
          
      }


      public ArrayList<String> returnCategory() {
            return selection;

      }

       
}
