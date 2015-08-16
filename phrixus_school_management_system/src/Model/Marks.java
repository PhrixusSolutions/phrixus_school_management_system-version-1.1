
package Model;

import java.sql.Date;

/**
 *
 * @author Lahiru Sandeepa
 * This class for handling student term test marks with database structute. 
 */
public class Marks {
    private int student_id;
    private String student_name;
    private int subject_id;
    private int enrollment_id;
    private int marks;
    private int term;
    private Date year;

    public Marks(int student_id, int enrollment_id, int subject_id, Date year, String student_name) {
            this.student_id = student_id;
            this.subject_id = subject_id;
            this.year = year;
            this.enrollment_id = enrollment_id;
            this.student_name = student_name;
    
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
    
    public void setenrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public int getenrollment_id() {
        return enrollment_id;
    }
}
