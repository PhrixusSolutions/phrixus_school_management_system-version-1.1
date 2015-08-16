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
public class Subject {
    private int sublectId;
    private int grade;
    private String name;

    public Subject(int subjectID, String subject_name, int gradeID) {
            this.sublectId = subjectID;
            this.name = subject_name;
            this.grade= gradeID;
    }


    /**
     * @return the sublectId
     */
    public int getSublectId() {
        return sublectId;
    }

    /**
     * @param sublectId the sublectId to set
     */
    public void setSublectId(int sublectId) {
        this.sublectId = sublectId;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
