package ir.ac.kntu;

import java.util.ArrayList;

public class Professor {

    private String name;
    private String familyName;
    private int id;
    private String password;
    private int maximumCourseUnit;
    private ArrayList<CourseGroup> obtainedCourses;

    public Professor() {
    }

    public Professor(String name, String familyName, int id,
                     String password, int maximumCourseUnit,
                     ArrayList<CourseGroup> obtainedCourses) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
        this.password = password;
        this.maximumCourseUnit = maximumCourseUnit;
        this.obtainedCourses = obtainedCourses;
    }

    public String login(int id,String password) {
        if (this.id == id) {
            if (this.password.equals(password)) {
                return "login was successful!";
            } else {
                return "login was not successful! : password is not correct";
            }
        } else {
            return "login was not successful! : id not found";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaximumCourseUnit() {
        return maximumCourseUnit;
    }

    public void setMaximumCourseUnit(int maximumCourseUnit) {
        this.maximumCourseUnit = maximumCourseUnit;
    }

    public ArrayList<CourseGroup> getObtainedCourses() {
        return new ArrayList<>(obtainedCourses);
    }

    public void setObtainedCourses(ArrayList<CourseGroup> obtainedCourses) {
        this.obtainedCourses = new ArrayList<>(obtainedCourses);
    }
}
