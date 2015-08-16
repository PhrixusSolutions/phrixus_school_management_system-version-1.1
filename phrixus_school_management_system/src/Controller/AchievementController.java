/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Achievement;
import Model.Student;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lahiru Sandeepa
 */
public class AchievementController {
    //Lahiru Sandeepa
        public static ArrayList<Achievement> getAchievementList_ByTeacherID(int teacher_id) throws SQLException, ClassNotFoundException {
        
        ArrayList<Achievement> achievementList=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM achievement where approved_person_id='"+teacher_id+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
       
        while(resultSet.next()){
            Achievement achiement=new Achievement(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
            achievementList.add(achiement);
        }
        return achievementList;
    }

}
