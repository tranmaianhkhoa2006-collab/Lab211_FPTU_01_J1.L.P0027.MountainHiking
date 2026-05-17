package Model;

/**
 *
 * @author admin
 */
public enum MenuHeaderType {
     MAIN_MENU_HEADER("Main menu"),
     YES_NO_MENU_HEADER("Choose yes or no"),
     UPDATE_STUDENT_MENU_HEADER("Update student menu");
     
     private String title;
     private MenuHeaderType(String title){
         this.title = title;
     }
     
     public String getTitle(){
         return this.title;
     }
}
