/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Lahiru Sandeepa
 */
public class Enrollment {
    private int student_id;
    private int subject_id;
    private int enrallment_id;
    private Date year;

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
    
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getEnrallment_id() {
        return enrallment_id;
    }

    public void setEnrallment_id(int enrallment_id) {
        this.enrallment_id = enrallment_id;
    }
    
}
