package Run;

import Controller.Controller;
import Model.HeaderType;
import Utils.Inputter;
import Utils.MenuContainer;
import Utils.ViewHandler;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
       Controller service = new Controller();
       int choice = -1;
       ViewHandler.fakeClearScreen();
       do{
           ViewHandler.displayMenu(MenuContainer.getInstance().createMainMenu().getMenu(),MenuContainer.getHeader(HeaderType.MAIN_MENU_HEADER));
           choice = Inputter.inputChoice("Input your choice: ",0,MenuContainer.getInstance().getNumberOfOptions()-1);
           service.processOption(choice);
           ViewHandler.fakeClearScreen();
           if(choice==0)
               ViewHandler.print("See you again!\n");
       }
       while(choice !=0);
        
    }
}
