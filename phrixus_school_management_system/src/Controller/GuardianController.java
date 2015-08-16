/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Guardian;
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
public class GuardianController {
    public static Guardian searchGuardianById(int guardianId) throws SQLException, ClassNotFoundException{
        Guardian guardian=null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="SELECT * FROM guardian WHERE guardian_id='"+guardianId+"'";
        ResultSet resultSet=DB_Handler.getData(connection, sql);
        while(resultSet.next()){
            guardian=new Guardian(resultSet.getString("nic"), resultSet.getInt("guardian_id"), resultSet.getString("name"), resultSet.getInt("mobile"), resultSet.getString("occupation"), resultSet.getString("officeAddress"), resultSet.getInt("officeTelephone"));
            
        }
        return guardian;
    }
    
    public static void SaveGuardian(Guardian guardian) throws SQLException, ClassNotFoundException{
        //Guardian guardian=null;
        Connection connection=DB_Connection.getDBConnection().getConnection();
        String sql="INSERT INTO phrixus_db.guardian (guardian_id, name, nic, mobile, occupation, officeAddress, officeTelephone) VALUES ('"+guardian.getGuardianId()+"','"+guardian.getName()+"', '"+guardian.getNic()+"', '"+guardian.getMobileNo()+"', '"+guardian.getOccupation()+"', '"+guardian.getOfficeAddress()+"', '"+guardian.getOfficeTelephoneNo()+"')";
        DB_Handler.setData(connection, sql);
        
        
    }
    
    }
