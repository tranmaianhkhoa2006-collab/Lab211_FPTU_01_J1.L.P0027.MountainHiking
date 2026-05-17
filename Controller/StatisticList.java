package Controller;

import Model.Statistic;
import Model.Student;
import Utils.ViewHandler;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author admin
 */
public class StatisticList {

    private HashMap<String, Statistic> statisticList = new HashMap<>();
    
    private static StatisticList statisticListInstance = new StatisticList();
    
    public static final int TABLE_WIDTH = 52; 
      //Use Singleton pattern for statistic because the object do not need to be 
    //duplicate;
    private StatisticList(){
    }
    
    
    
    public static final String TABLE_HEADER
            = ViewHandler.lineBreak(StatisticList.TABLE_WIDTH)
            + ViewHandler.attributeOfStatisticList("Peak Code", "Number of student", "Total cost")
            + ViewHandler.lineBreak(StatisticList.TABLE_WIDTH);

    public void show() {
               ViewHandler.print(TABLE_HEADER);
         for(Statistic statisInstance :statisticList.values()){
              String row = ViewHandler.
                      attributeOfStatisticList(
                              statisInstance.getPeakCode(), 
                              statisInstance.getNumberOfStudent()+"",
                              ViewHandler.getVietnamMoneyFormat(statisInstance.getTotalCost())
                      )+
                      ViewHandler.lineBreak(StatisticList.TABLE_WIDTH);
              
              ViewHandler.print(row);
         }
    }
    
    

    public static StatisticList getInstance(){
        return statisticListInstance;
    }
    //use big O for O(1) time complexity in searching
    public StatisticList statisticalize(Collection<Student> studentList) {
        this.statisticList.clear();
       
        for (Student student : studentList) {
            String currentPeakCode = student.getPeakCode();

            if (statisticList.containsKey(currentPeakCode)) {
                Statistic currentStatistic = statisticList.get(currentPeakCode);
                double currentStudentFee = student.getTuitionFee();
           
                statisticList.put
                    (currentPeakCode, currentStatistic.increaseStudent(currentStudentFee)  );
            } 
            else {
                statisticList.put
                        (currentPeakCode, (new Statistic(currentPeakCode)).increaseStudent(student.getTuitionFee()) );
            }
            
            
        }
    
        return this;
    }
    
}
