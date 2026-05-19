package Utils;

/**
 *
 * @author admin
 */
public interface Acceptable {
       public final String   STUDENT_ID  = "^[CDHQcdhqSs][Ee]\\d{6}$"    ;
       
       public final String   NAME_VALID  = "^[A-Z a-z]{2,20}$"    ;
       
       public final String   DOUBLE_VALID = "^([-])?\\d+([.,]\\d+)?"  ;
       
       public final String   CAMPUS_CODE_VALID="^[CDHQcdhqsS][Ee]$";
       
       public final String   INTEGER_VALID="^\\d+$"   ;
       
       public final String   PHONE_VALID="^0[35789]\\d{8}$"      ;
       
       public final String   VIETTEL_VALID="^0[357][2-9]\\d{7}$"  ;
       
       public final String   VNPT_VALID ="^0[89][123458]\\d{7}$"      ;
       
       public final String   EMAIL_VALID ="^[a-zA-Z0-9]+@fpt.[a-zA-Z0-9.-]+(.[a-zA-Z]{2,4})?$" ;
     
       public static boolean isValid(String data, String pattern){   
            return data.matches(pattern);
       }
       
       public static boolean isDigitInRange(int digit,int min,int max){
           return digit>=min && digit<=max;
       }
       
       public static boolean isPartialEqual(String firstString,String secondString){
           if(firstString == secondString)
               return firstString.equals(secondString);
           
           String minLengthString ;
           String maxLengthString;
           if(firstString.length()<secondString.length()){
               minLengthString= firstString;
               maxLengthString= secondString;
           }
           else {
               minLengthString = secondString;
               maxLengthString = firstString;
           }
           
           int minLength = minLengthString.length();
           boolean isEqual = false;
           for(int i=0;i<=maxLengthString.length()-minLength;i++){
              isEqual = minLengthString.equalsIgnoreCase(maxLengthString.substring(i, i+minLength));
              if(isEqual){
                  break;
              }
              
           }
           
           return isEqual;
       }
       
       
}
