package easy.infra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi on 25/2/16.
 */

/**
 * This class is used to get data from the remote database
 * @author Abhilash.S
 * @version 1.0
 */
public class GetData {
    String tableName;

    /**
     * This constructs and initializes the name of the database table
     * @param junctionName the name of the junction under operation
     */
    public GetData(String junctionName){
        CreateDBObject tempObject = new CreateDBObject();
        this.tableName = tempObject.getTableNameFromJunctionName(junctionName);
        //System.out.println(tableName);
    }

    List<CreateDBObject> objects = new ArrayList<CreateDBObject>();

    /**
     * This method returns all the records that match the query as DB objects
     * @return list of DB objects that matched the query
     */
    public List<CreateDBObject> fetchData() {


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnectionConfiguration.getConnection();
            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select * from "+tableName);
                //preparedStatement.setString(1,tableName);


                while (resultSet.next()){
                    CreateDBObject object = new CreateDBObject();
                    //object.setJunctionName(resultSet.getString("year"));
                    object.setYear(resultSet.getString("year"));
                    object.setMonth(resultSet.getString("month"));
                    object.setDate(resultSet.getString("date"));
                    object.setHour(resultSet.getString("hour"));
                    object.setMinute(resultSet.getString("minute"));
                    object.setSecond(resultSet.getString("second"));
                    object.setMillisecond(resultSet.getString("millisecond"));
                    object.setpRed(resultSet.getFloat("pRed"));
                    object.setpYellow(resultSet.getFloat("pYellow"));
                    object.setpGreen(resultSet.getFloat("pGreen"));

                    objects.add(object);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return objects;
    }
}