package ir.ac.kntu;

import java.util.ArrayList;

public class Student {

    private String name;
    private String familyName;
    private int id;
    private String password;
    static private int maximumCourseUnit=20;
    private ArrayList<CourseGroup> obtainedCourses;
    private boolean loginSuccess;

    public Student() {
    }

    public Student(String name, String familyName, int id,
                   String password, ArrayList<CourseGroup> obtainedCourses) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
        this.password = password;
        this.obtainedCourses = obtainedCourses;
    }

    public String login(int id, String password) {
        if (this.id == id) {
            System.out.println(this.password);
            System.out.println(password);
            if (this.password.equals(password)) {
                loginSuccess=true;
                return "login was successful!";
            } else {
                loginSuccess=false;
                return "login was not successful! : password is not correct";
            }
        } else {
            loginSuccess=false;
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
        if (loginSuccess) {
            return password;
        }else{
            System.out.println("Access denied");
            return ("Access denied");
        }
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
