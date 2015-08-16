/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Achievement;
import Model.Society;
import db.DB_Connection;
import db.DB_Handler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp pc
 */
public class SocietyController {

    //Lahiru Sandeepa
    public static ArrayList<Society> getAChievement_StudentList(ArrayList<Achievement> AchievementList) throws SQLException, ClassNotFoundException {
        
        ArrayList<Society> societyList=new ArrayList<>();
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM society";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        /*
        In This methord we have to get Society Name List to Achivement approval.
        to do that, we get Achivement list and get society id from each achivement and cheak that society id with all society list
        we import from DataBase. 
        then If it matches society we get only that societies to return....
        
        */
        while(resultSet.next()){
            Society society = new Society(resultSet.getInt(2),resultSet.getString(3));
            int count = 0;
            while(AchievementList.isEmpty()){
                int society_id = AchievementList.get(count).getSociety_id();
                if(society_id == society.getId()){
                    societyList.add(society);
                }
                count++;
            }
        }
        return societyList;

    
    }
    
}
