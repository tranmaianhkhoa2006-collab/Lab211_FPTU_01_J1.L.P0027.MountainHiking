package Model;


/**
 *
 * @author admin
 */
public class Mountain implements Comparable<Mountain>{
    private String peakCode;
    private String mountainName;
    private String province;
    private String description;

    public Mountain(String peakCode, String mountainName, String province, String description) {
        this.peakCode = peakCode;
        this.mountainName = mountainName;
        this.province = province;
        this.description = description;
    }

    public String getPeakCode() {
        return peakCode;
    }

    public void setPeakCode(String peakCode) {
        this.peakCode = peakCode;
    }

    public String getMountainName() {
        return mountainName;
    }

    public void setMountainName(String mountainName) {
        this.mountainName = mountainName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static Mountain toMountain(String saveString){
        String attributeOfMountain[] = saveString.split(",");
        String peakCode = attributeOfMountain[0].trim();
        if(peakCode.length()==1){
            peakCode = "MT0"+peakCode;
        }
        else
            peakCode = "MT"+peakCode;
        
        String mountainName = attributeOfMountain[1].trim();
        String province = attributeOfMountain[2].trim();
        String description;
        if(attributeOfMountain.length==4)
            description= attributeOfMountain[3].trim();
        else
            description="";
        return new Mountain(peakCode, mountainName, province, description);
    }
    
    @Override
    public String toString(){
        return "Peak Code    : "+peakCode+"\n"+
                   "Name         : "+mountainName+"\n"+
                   "Province     : "+province+"\n"+
                   "Description  : "+description;
    }
    
    @Override
    public int compareTo(Mountain mountain){
        return this.peakCode.compareTo(mountain.peakCode);
    }
}
