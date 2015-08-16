/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;

/**
 *
 * @author hp pc
 */
public class Period {
    
    private Time start;
    private Time end;
    private String day;
    private int periodId;
    private int subjectId;

    public Period(int number, Time starting_time, String day, int period_id, Time ending_time) {
        this.start = starting_time;
        this.end = ending_time;
        this.day = day;
        this.periodId= period_id;
        this.subjectId = number;
    }

    /**
     * @return the start
     */
    public void Period(){
    
    
    }
    public Time getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Time start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Time getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Time end) {
        this.end = end;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the periodId
     */
    public int getPeriodId() {
        return periodId;
    }

    /**
     * @param periodId the periodId to set
     */
    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    /**
     * @return the subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    
}
