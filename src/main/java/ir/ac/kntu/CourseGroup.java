package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseGroup extends Course {

    private int courseGroupNumber;
    private ArrayList<Student> attendingStudents;
    private int sits;
    private ArrayList<Professor> teachingProfessors;
    private int semesterNumber;
    private HashMap<String, String> Schedule;


    public CourseGroup(int id) {
        super(id, null, null);
    }

    public CourseGroup(String title) {
        super(0, title, null);
    }

    public CourseGroup(int id, String title) {
        super(id, title, null);
    }

    public int getCourseGroupNumber() {
        return courseGroupNumber;
    }

    public void setCourseGroupNumber(int courseGroupNumber) {
        this.courseGroupNumber = courseGroupNumber;
    }

    public ArrayList<Student> getAttendingStudents() {
        return attendingStudents;
    }

    public void setAttendingStudents(ArrayList<Student> attendingStudents) {
        this.attendingStudents = new ArrayList<>(attendingStudents);
    }

    public int getSits() {
        return sits;
    }

    public void setSits(int sits) {
        this.sits = sits;
    }

    public ArrayList<Professor> getTeachingProfessors() {
        return new ArrayList<>(teachingProfessors);
    }

    public void setTeachingProfessors(ArrayList<Professor> teachingProfessors) {
        this.teachingProfessors = teachingProfessors;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public HashMap<String, String> getSchedule() {
        return new HashMap<>(Schedule);
    }

    public void setSchedule(HashMap<String, String> schedule) {
        Schedule = new HashMap<>(schedule);
    }
}
