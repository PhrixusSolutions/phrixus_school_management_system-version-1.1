
package Controller;

import Model.Marks;
import Model.TermTestResult;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lahiru Sandeepa
 */
public class TermTestController {
    public static void setStudent_UpdateMarks(ArrayList<Marks> studentResult)throws SQLException, ClassNotFoundException{
        
        Connection connection=DB_Connection.getDBConnection().getConnection();

        for (Marks studentmark : studentResult){
           String sql= "UPDATE term_test SET enrollment_id = '"+studentmark.getenrollment_id()+"', marks = '"+studentmark.getMarks()+"',Term = '"+studentmark.getTerm()+"'";
           int status = DB_Handler.setData(connection, sql);
           if(status == -1){
               // database not updated.
           }
        }
        
      
    }
}
