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
public class TimeTable {
    private int class_id;
    private int subject_id;
    private int teacher_id;
    private Date year;
    private int period_id;

    public TimeTable(int class_id, int subject_id, int teacher_id, int period_id, java.sql.Date year) {
        this.class_id = class_id;
        this.teacher_id = teacher_id;
        this.period_id = period_id;
        this.subject_id = subject_id;
        this.year = year;
    }
    public void setYear(Date year) {
        this.year = year;
    }

    public Date getYear() {
        return year;
    }
    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }


    public int getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
    }
}
