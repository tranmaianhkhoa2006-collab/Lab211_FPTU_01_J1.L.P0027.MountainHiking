package Utils;

import Model.HeaderType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class MenuContainer {
     private static MenuContainer menuContainerInstance = new MenuContainer();
    
     private ArrayList<String> menuOption = new ArrayList<>();
     
     //menu width
     public final static int HEADER_WIDTH = 74;
     
     //menu pattern
     public final static String PATTERN_OF_MENU = "| %-"+(MenuContainer.HEADER_WIDTH-4)+"s |";
     
     
     private MenuContainer(){
     }
     
     //using singleton for avoiding trash menu in the program , menu do not need to
     //create multiple object
     public static MenuContainer getInstance(){
         return menuContainerInstance;
     }
     
     public static String getHeader(HeaderType headerType){
         String header = 
             ViewHandler.lineBreak(MenuContainer.HEADER_WIDTH) +
             String.format(MenuContainer.PATTERN_OF_MENU,headerType.getTitle())+
             ViewHandler.lineBreak(MenuContainer.HEADER_WIDTH);
         return header;
     }
     
     public MenuContainer createMainMenu(){
           menuOption.clear();
           menuOption.add("Exit the Program");
           menuOption.add("New Registration");
           menuOption.add("Update Registration Information");
           menuOption.add("Display Registered List");
           menuOption.add("Delete Registration Information");
           menuOption.add("Search Participants by Name");
           menuOption.add("Filter Data by Campus");
           menuOption.add("Statistics of Registration Numbers by Location");
           menuOption.add("View List of mountain info");
           menuOption.add("Save Data to File");
           return menuContainerInstance;
     }
     
     public MenuContainer createUpdateStudentMenu(){
         menuOption.clear();
         menuOption.add("Return to menu");
         menuOption.add("Update student name");
         menuOption.add("Update peak code for student");
         menuOption.add("Update phone number");
         menuOption.add("Update email");
         menuOption.add("Change student id");
         return menuContainerInstance;
     }
     
     public MenuContainer createYesNoMenu(){
          menuOption.clear();
          menuOption.add("Yes");
          menuOption.add("No");
          return menuContainerInstance;
     }
     
     public int getNumberOfOptions(){
         return menuOption.size();
     }
     
     public List<String> getMenu(){
         return Collections.unmodifiableList(menuOption);
     }
     
     
}
