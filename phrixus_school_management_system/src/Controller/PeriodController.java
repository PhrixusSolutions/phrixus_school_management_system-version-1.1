/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Period;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp pc
 */
public class PeriodController {
    //Lahiru Sandeepa
    public static Period getTimeSlot(int period_id) throws SQLException, ClassNotFoundException {
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM timetable where currant_class_id='"+period_id+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        Period period = new Period(resultSet.getInt("number"),resultSet.getTime("starting_time"), resultSet.getString("day"), resultSet.getInt("period_id"), resultSet.getTime("ending_time"));
        return period;
    
    }
    
}
