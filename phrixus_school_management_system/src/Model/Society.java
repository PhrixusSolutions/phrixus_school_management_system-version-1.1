/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hp pc
 */
public class Society {
    
    private String name;
    private int id;
    private int teacherInchargeId;

    //Lahiru Sandeepa
    public Society(int society_Id, String name) {
        this.name = name;
        this.id = society_Id;
    
    }

    /**
     * @return the name
     */
    //constructor
    public void Society(){
    
    }
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the teacherInchargeId
     */
    public int getTeacherInchargeId() {
        return teacherInchargeId;
    }

    /**
     * @param teacherInchargeId the teacherInchargeId to set
     */
    public void setTeacherInchargeId(int teacherInchargeId) {
        this.teacherInchargeId = teacherInchargeId;
    }
    
}
