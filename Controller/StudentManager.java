package Controller;

import Model.Student;
import Utils.Acceptable;
import Utils.FileIOHandler;
import Utils.ViewHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author admin
 */
public class StudentManager {
     private String pathFile = "data/StudentList.dat";
     private boolean isSaved = true;

    private HashMap<String,Student> studentList = new HashMap<>();
    public StudentManager() {
        FileIOHandler<Student> studentIOHandler = new FileIOHandler<>();
        List<Student> readList = (List<Student>) studentIOHandler.readFileObject(pathFile);
        for(Student singleStudent : readList){
            studentList.put(singleStudent.getStudentID(), singleStudent);
        }
        
    }
     
    public boolean isSaved(){
        return isSaved;
    }

    public void setSaveStatus(){
        isSaved = true;
    }
  
    public static final String TABLE_HEADER =
      ViewHandler.lineBreak(130) +
      ViewHandler.attributeOfStudentList("Student id","Name","Email","Phone","PeakCode","Fee") +
      ViewHandler.lineBreak(130);
    
      public String getPathFile(){
        return pathFile;
    } 
      
    //add student to hashmap
    public boolean add(Student student){
        if(studentList.containsKey(student.getStudentID()))
                return false;
        
            studentList.put(student.getStudentID(), student);
            this.isSaved = false;
        return true;
    }
    
    //update student(candidate) info
    public void update(Student student){
        if(this.containId(student.getStudentID())){
            studentList.put(student.getStudentID(), student);
            this.isSaved = false;
        }
    }
    
    //check duplicate id by using contains key method of hashmap
    public boolean containId(String id){
        return studentList.containsKey(id);
    }
    
    //search by id
    public Student searchByID(String id){
        return studentList.get(id.toUpperCase());
    }
     
    //search by partial name
    public List<Student> searchByName(String name){
        List<Student> listOfStudentWithName = new ArrayList<>();
        for(Student student: studentList.values()){
            String currentStudentName = student.getName();
            if(Acceptable.isPartialEqual(currentStudentName,name)){
                listOfStudentWithName.add(student);
            }
        }
        
        
        return listOfStudentWithName;
    }
    
    
    
    public void showAll(){
        if(studentList.size()==0){
            ViewHandler.print("No students have registered yet.");
            return;
        }
                
       ViewHandler.showStudentList(studentList.values());
       
    }
  
     // method remove of hashmap return type base on generic of its value
    // means that object type of map.value is Student => remove return Student if remove success, otherwise null
    public boolean delete(String id){
   
        
        boolean isDeleted = this.studentList.remove(id.toUpperCase())!=null;
        if(isDeleted)    
            this.isSaved = false;
      
        return isDeleted;
    }
    
    //create a copy of studentList.values
    public List<Student> getAllStudentList(){
        return new ArrayList (Collections.unmodifiableCollection(studentList.values()));
    }
    
    //Campus code filter
    public List<Student> filterByCampusCode(String campusCode){
        List<Student> returnList = new ArrayList<>();
        
        for(Student student : studentList.values()){
            if(student.getCampusCode().equals(campusCode))
                returnList.add(student);
        }
        
        
        return returnList;
    }
    
}
