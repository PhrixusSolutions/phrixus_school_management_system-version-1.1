/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author hp pc
 */
public class Achievement {
    
    private int approvedTeachersId;
    private int achieverId;
    private int status;
    private String achievement;
    private int society_id;
    private Date date;
   
    //Lahiru Sandeepa
    public Achievement(int achiever_id, int approved_person_id, int society_id, String description, int status) {
            this.achieverId = achiever_id;
            this.approvedTeachersId = approved_person_id;
            this.achievement = description;
            this.status = status;
            this.society_id = society_id;
    }

    public int getSociety_id() {
        return society_id;
    }

    public void setSociety_id(int society_id) {
        this.society_id = society_id;
    }

    /**
     * @return the approvedTeachersId
     */
    //constructor
    public void Achievement(){
    
    }
    
    public int getApprovedTeachersId() {
        return approvedTeachersId;
    }

    /**
     * @param approvedTeachersId the approvedTeachersId to set
     */
    public void setApprovedTeachersId(int approvedTeachersId) {
        this.approvedTeachersId = approvedTeachersId;
    }

    /**
     * @return the achieverId
     */
    public int getAchieverId() {
        return achieverId;
    }

    /**
     * @param achieverId the achieverId to set
     */
    public void setAchieverId(int achieverId) {
        this.achieverId = achieverId;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the achievement
     */
    public String getAchievement() {
        return achievement;
    }

    /**
     * @param achievement the achievement to set
     */
    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
