package Controller;

import Model.Mountain;
import Utils.FileIOHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author admin
 */
public class MountainList {
     private String pathFile = "data/MountainList.csv";
     private HashMap<String,Mountain> mountainList = new HashMap<>();

    public MountainList() {
        List<String> listOfRawString = FileIOHandler.readStringFile(pathFile);
        for(String rawString : listOfRawString){
            Mountain mountain = Mountain.toMountain(rawString);
            mountainList.put(mountain.getPeakCode(),mountain);
        }
    }
     
     public void add(Mountain mountain){
         mountainList.put(mountain.getPeakCode(),mountain);
     } 
     
     
     public boolean isValidPeakCode(String peakCode){
         return mountainList.containsKey(peakCode);
           
     }
     
     public String searchMountain(String peakCode){
         boolean isValidPeakCode = isValidPeakCode(peakCode);
         if(isValidPeakCode)
             return mountainList.get(peakCode).toString();
         
         return null;
     }
     
     public Mountain getMountain(String peakCode){
         return mountainList.get(peakCode);
     }
     
     public Set<Mountain> getListOfMountain(){
         return new TreeSet<>(mountainList.values());
     }
}
