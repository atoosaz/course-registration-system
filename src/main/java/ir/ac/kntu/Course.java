package ir.ac.kntu;

import java.util.ArrayList;

public class Course {
    private int id;
    private String title;
    private ArrayList<Course> prerequisites = new ArrayList();

    public Course() {
    }

    public Course(int id, String title, ArrayList<Course> prerequisites) {
        this.id = id;
        this.title = title;
        this.prerequisites = prerequisites;
    }

    public boolean checkPrerequisites(Student student) {
        int counter = 0;
        for (int i = 0; i < student.getObtainedCourses().size(); i++) {
            for (int j = 0; j < prerequisites.size(); j++) {
                if (student.getObtainedCourses().get(i).getId() == prerequisites.get(j).id) {
                    counter++;
                }
            }


        }
        if (counter == prerequisites.size()) {
            return true;
        }
        return false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Course> getPrerequisites() {
        return new ArrayList<Course>(prerequisites);
    }

    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = new ArrayList<Course>(prerequisites);
    }
}
