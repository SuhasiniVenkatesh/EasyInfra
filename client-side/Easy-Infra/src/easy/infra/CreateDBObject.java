package easy.infra;
/**
 * Created by abhi on 22/2/16.
 */

/**
 * This class creates an object which represents all the necessary information about a given snapshot
 * @author Abhilash.S
 * @version 1.0
 */
/* implement junction class */
public class CreateDBObject {

    String junctionName;
    String year;
    String month;
    String date;
    String hour;
    String minute;
    String second;
    String millisecond = "00";
    String tableName;
    Float pRed,pYellow,pGreen;

    /**
     * This method returns the name of the table in database which represents the junction of the snapshot
     * @return the name of the table as a string
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * This method is used to set the value of table name based on junction name
     * @param junctionName the name of junction as a string
     */
    public void setTableName(String junctionName) {
        if(junctionName.equals("axatech"))
            tableName = "axatech";
        if(junctionName.equals("hosur-road"))
            tableName = "hosur_road";
        if(junctionName.equals("hosur-road-2"))
            tableName = "hosur_road_2";
        if(junctionName.equals("ring-road"))
            tableName = "ring_road";
        if(junctionName.equals("silkboard"))
            tableName = "silkboard";
    }

    /**
     * A zero parameter constructor for the Database object
     */
    public CreateDBObject(){

    }

    /**
     * This constructs and initializes a DBObject with given junctionName, year, month, date, hour, minute, second, millisecond, pRed, pYellow, pGreen
     * @param junctionName the name of the junction as a string
     * @param year the year of the snapshot as a string
     * @param month the month of the snapshot as a string
     * @param date the date of the snapshot as a string
     * @param hour the hour of the snapshot as a string
     * @param minute the minute of the snapshot as a string
     * @param second the second of the snapshot as a string
     * @param millisecond the millisecond of the snapshot as a string
     * @param pRed the red value in percent as a float
     * @param pYellow the yellow value in percent as a float
     * @param pGreen the green value in percent as a float
     */
    public CreateDBObject(String junctionName, String year, String month, String date, String hour, String minute, String second, String millisecond, Float pRed, Float pYellow, Float pGreen) {
        this.junctionName = junctionName;
        this.year = year;
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
        this.pRed = pRed;
        this.pYellow = pYellow;
        this.pGreen = pGreen;
        setTableName(junctionName);
    }

    /**
     * This constructs and initializes a DBObject with given junctionName, year, month, date, hour, minute, second, pRed, pYellow, pGreen
     * @param junctionName the name of the junction as a string
     * @param year the year of the snapshot as a string
     * @param month the month of the snapshot as a string
     * @param date the date of the snapshot as a string
     * @param hour the hour of the snapshot as a string
     * @param minute the minute of the snapshot as a string
     * @param second the second of the snapshot as a string
     * @param pRed the red value in percent as a float
     * @param pYellow the yellow value in percent as a float
     * @param pGreen the green value in percent as a float
     */
    public CreateDBObject(String junctionName, String year, String month, String date, String hour, String minute, String second, Float pRed, Float pYellow, Float pGreen) {
        this.junctionName = junctionName;
        this.year = year;
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.pRed = pRed;
        this.pYellow = pYellow;
        this.pGreen = pGreen;
        setTableName(junctionName);
        setMillisecond("00");

    }

//    /**
//     * This method is used to set the value of the junction name based on table name
//     * @param tableName the name of the table as a string
//     */
//    public void setJunctionNameFromTableName(String tableName){
//        if(tableName.equals("axatech"))
//            junctionName = "axatech";
//        if(tableName.equals("hosur_road"))
//            junctionName = "hosur-road";
//        if(tableName.equals("hosur_road_2"))
//            junctionName = "hosur-road-2";
//        if(tableName.equals("ring_road"))
//            junctionName = "ring-road";
//        if(tableName.equals("silkboard"))
//            junctionName = "silkboard";
//
//    }

    public String getTableNameFromJunctionName(String junctionName){
        if(junctionName.equals("axatech"))
            tableName =  "axatech";
        if(junctionName.equals("hosur-road"))
            tableName =  "hosur_road";
        if(junctionName.equals("hosur-road-2"))
            tableName =  "hosur_road_2";
        if(junctionName.equals("ring-road"))
            tableName =  "ring_road";
        if (junctionName.equals("silkboard"))
            tableName =  "silkboard";

        return tableName;
    }

    /**
     * This method is used to get the name of the junction of a snapshot
     * @return the junction name as a string
     */
    public String getJunctionName() {
        return junctionName;
    }

    /**
     * This method is used to set the value of name of the junction
     * @param junctionName the name of the junction as a string
     */
    public void setJunctionName(String junctionName) {
        this.junctionName = junctionName;
        setTableName(junctionName);

    }

    /**
     * this method returns the year of the snapshot
     * @return the year as a string
     */
    public String getYear() {
        return year;
    }

    /**
     * This method is used to set the value of year of the snapshot
     * @param year the year as a string
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * this method returns the month of the snapshot
     * @return the month as a string
     */
    public String getMonth() {
        return month;
    }

    /**
     * This method is used to set the value of month of the snapshot
     * @param month the month as a string
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * this method returns the date/day in a month of the snapshot
     * @return the date as a string
     */
    public String getDate() {
        return date;
    }

    /**
     * This method is used to set the value of date of the snapshot
     * @param date the date as a string
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * this method returns the hour in a day of the snapshot
     * @return the hour as a string
     */
    public String getHour() {
        return hour;
    }

    /**
     * This method is used to set the value of hour in a day of the snapshot
     * @param hour the hour as a string
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * this method returns the minute in an hour of the snapshot
     * @return the minute as a string
     */
    public String getMinute() {
        return minute;
    }

    /**
     * This method is used to set the value of minute in an hour of the snapshot
     * @param minute the minute as a string
     */
    public void setMinute(String minute) {
        this.minute = minute;
    }

    /**
     * this method returns the second in a minute of the snapshot
     * @return the second as a string
     */
    public String getSecond() {
        return second;
    }

    /**
     * This method is used to set the value of second in a minute of the snapshot
     * @param second the second as a string
     */
    public void setSecond(String second) {
        this.second = second;
    }

    /**
     * this method returns the Millisecond in a minute of the snapshot
     * @return the millisecond as a string
     */
    public String getMillisecond() {
        return millisecond;
    }

    /**
     * This method is used to set the value of millisecond in a second of the snapshot
     * @param millisecond the millisecond as a string
     */
    public void setMillisecond(String millisecond) {
        this.millisecond = millisecond;
    }

    /**
     * this method returns the amount of red value in percent of the snapshot
     * @return the red value in percent as a float
     */
    public Float getpRed() {
        return pRed;
    }

    /**
     * This method is used to set the percent value of red color in the snapshot
     * @param pRed the red value in percent as a float
     */
    public void setpRed(Float pRed) {
        this.pRed = pRed;
    }

    /**
     * this method returns the amount of yellow value in percent of the snapshot
     * @return the yellow value in percent as a float
     */
    public Float getpYellow() {
        return pYellow;
    }

    /**
     * This method is used to set the percent value of yellow color in the snapshot
     * @param pYellow the yellow value in percent as a float
     */
    public void setpYellow(Float pYellow) {
        this.pYellow = pYellow;
    }

    /**
     * this method returns the amount of green value in percent of the snapshot
     * @return the green value in percent as a float
     */
    public Float getpGreen() {
        return pGreen;
    }

    /**
     * This method is used to set the percent value of green color in the snapshot
     * @param pGreen the green value in percent as a float
     */
    public void setpGreen(Float pGreen) {
        this.pGreen = pGreen;
    }
}
