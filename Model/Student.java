package Model;

import Utils.Acceptable;
import Utils.ViewHandler;
import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Student implements Serializable{
      private String studentID;
      private String name;
      private String phoneNumber;
      private String email;
      private String campusCode;
      private String peakCode;
      private double tuitionFee;
      public static final double DEFAULT_FEE = 6000000;
      
      
      public Student(String studentID,String name,String phoneNumber,String email,String peakCode,boolean isViettelOrVina){
          this.studentID = studentID.toUpperCase();
          this.name = name;
          this.phoneNumber = phoneNumber;
          this.email = email;
          this.campusCode = studentID.substring(0, 2);
          this.peakCode = peakCode;
          if(isViettelOrVina)
                this.tuitionFee = Student.DEFAULT_FEE*(1-36/100);
          else 
                this.tuitionFee = Student.DEFAULT_FEE;
      }
      
  

    public String getStudentID() {
        return studentID;
    }

    public Student setStudentID(String studentID) {
        this.studentID = studentID;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Student setPhoneNumber(String phoneNumber) {
        
        this.phoneNumber = phoneNumber;
        if(Acceptable.isValid(phoneNumber, Acceptable.VIETTEL_VALID)||Acceptable.isValid(phoneNumber, Acceptable.VNPT_VALID))
                this.tuitionFee = Student.DEFAULT_FEE*(1-36/100);
          else 
                this.tuitionFee = Student.DEFAULT_FEE;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCampusCode() {
        return campusCode;
    }

    public String getPeakCode() {
        return peakCode;
    }

    public Student setPeakCode(String peakCode) {
        this.peakCode = peakCode;
        return this;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }
    
    @Override
    public String toString(){
        return "Student ID: " + this.studentID+"\n"+
                   "Name      : "+ this.name+"\n"+
                   "Phone     : "+ this.phoneNumber +"\n"+
                   "Mountain  : "+ this.peakCode+"\n"+
                   "Fee       : "+ ViewHandler.getVietnamMoneyFormat(tuitionFee)+"\n";
                
                        
    }
    
   

}
