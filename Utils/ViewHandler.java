

package Utils;

import Controller.StudentManager;
import Model.Student;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
/**
 *
 * @author admin
 */
public class ViewHandler {
    
    //using local and numberformatter to get vietnam money format
     public static String getVietnamMoneyFormat(double fee){
         Locale vn = new Locale("vi", "vn");
         NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(vn);
         String returnValue = moneyFormatter.format(fee);
         return returnValue.substring(0, returnValue.length()-2);
         
     }
     
     //return row of studentList with a student info or return attribute for its table header
     public static String attributeOfStudentList(String id, String name,String email, String phone, String peakCode,String fee) {
         String returnValue =
                 String.format("| %-13s| %-23s| %-50s| %-13s| %-8s| %-10s|", id,name,email,phone,peakCode,fee);
         return returnValue;
     }
     
     public static String attributeOfStatisticList(String peakCode, String numberOfStudent, String totalCost){
         String returnValue =
                 String.format("| %-10s| %-20s| %-15s|",peakCode,numberOfStudent,totalCost);
         return returnValue;
     }
     
     //return linebreak
     public static String lineBreak(int length){
         StringBuilder returnValue = new StringBuilder();
         returnValue.append("\n");
         for(int i=0;i<length;i++){
             returnValue.append("-");
         }
         returnValue.append("\n");
        
         return returnValue.toString();
     }
     
     //use for print message
      public static void print(String mess){
          System.out.print(mess);
      }
      
      //print error
      public static void printError(String mess){
          System.err.print(mess);
      }
      
      //get String menuHeader from method static String getHeader(Header Type) 
      public static void displayMenu(List<String> menu,String menuHeader){
           ViewHandler.print(menuHeader);
           int count=0;
           String pattern = "| %-"+(MenuContainer.HEADER_WIDTH-4)+"s |";
           for(String option : menu){
               ViewHandler.print(String.format(pattern+"\n",(count++)+"."+option));
           }
           ViewHandler.print(String.format(pattern,""));
           ViewHandler.print(ViewHandler.lineBreak(MenuContainer.HEADER_WIDTH));   
           ViewHandler.print("Note: The system will ask for whether continuing to input information after 3 times failed\n");
      }
      
      //name formatter uppercase first character and lowercase remainning character
      public static String nameFormatter(String rawString){
          if(rawString == null)
              return null;
          
          
          String words[] = rawString.toLowerCase().trim().split("\\s+");
          StringBuilder returnValue = new StringBuilder();
          
          for(String word : words){
              returnValue.append(word.substring(0,1).toUpperCase()).append(word.substring(1)).append(" ");
          }
          
          return returnValue.toString().trim();
      }
      
      //for display a list of student
     public static void showStudentList(Collection<Student> studentList) {
        ViewHandler.print(StudentManager.TABLE_HEADER);
        for (Student student : studentList) {
            String rowOfStudentInfo
                    = ViewHandler.attributeOfStudentList(
                            student.getStudentID(),
                            student.getName(),
                            student.getEmail(),
                            student.getPhoneNumber(),
                            student.getPeakCode(),
                            ViewHandler.getVietnamMoneyFormat(student.getTuitionFee())
                    );

            ViewHandler.print(rowOfStudentInfo);
            ViewHandler.print(ViewHandler.lineBreak(rowOfStudentInfo.length()));
        }
    }
     
     
     public static void fakeClearScreen(){

         for(int i=0;i<50;i++){
             System.out.println();
         }    
     }
}
