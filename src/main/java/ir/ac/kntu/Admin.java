package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin {
    private static String username="admin";
    private static String password="admin_pass";
    private ArrayList<Student> configStudent;
    private ArrayList<Professor> configProfessor;
    private ArrayList<CourseGroup> configCourses;
    private boolean loginSuccess;

    public Admin() {

    }

    public Admin(ArrayList<Student> configStudent, ArrayList<Professor> configProfessor,
                 ArrayList<CourseGroup> configCourses) {
        this.configStudent = configStudent;
        this.configProfessor = configProfessor;
        this.configCourses = configCourses;
    }

    public String login(String user, String password) {
        if (username.equals(user)) {
            if (this.password.equals(password)) {
                loginSuccess = true;
                return "login was successful!";

            } else {
                loginSuccess = false;
                return "login was not successful! : password is not correct";
            }
        } else {
            loginSuccess = false;
            return "login was not successful! : id not found";
        }

    }

    public void changeSits() {
        if (loginSuccess) {
            for (int i = 0; i < configStudent.size(); i++) {
                for (int j = 0; j < configStudent.get(i).getObtainedCourses().size(); j++) {
                    configStudent.get(i).getObtainedCourses().get(j).setSits(
                            configStudent.get(i).getObtainedCourses().get(j).getSits() - 1);

                }

            }
        } else {
            System.out.println("Access denied");
        }

    }

    public void checkCoursesStudent() {
        if (loginSuccess) {
            for (int i = 0; i < configStudent.size(); i++) {


                for (int j = 0; j < configStudent.get(i).getObtainedCourses().size(); j++) {

                    if (!configStudent.get(i).getObtainedCourses().get(j).checkPrerequisites(configStudent.get(i))) {
                        System.out.println("[Prerequisite Error] Student:" + configStudent.get(i) + " Course:"
                                + configStudent.get(i).getObtainedCourses().get(j));

                    }


                }

            }
        } else {
            System.out.println("Access denied");
        }

    }

    public void checkTimeConflictStudent() {
        if (loginSuccess) {
            for (int i = 0; i < configStudent.size(); i++) {

                for (int j = 0; j < configStudent.get(i).getObtainedCourses().size(); j++) {

                    for (int h = j + 1; j < configStudent.get(i).getObtainedCourses().size(); h++) {

                        for (Map.Entry m : configStudent.get(i).getObtainedCourses().get(j).getSchedule().entrySet()) {
                            for (Map.Entry n : configStudent.get(i).getObtainedCourses().get(h).getSchedule().entrySet()) {

                                if (m.getValue().equals(n.getValue()) && m.getKey().equals(n.getValue())) {
                                    System.out.println("[Conflict Error] Student:" + configStudent.get(i) + " Courses:"
                                            + configStudent.get(i).getObtainedCourses().get(j) + " and " +
                                            configStudent.get(i).getObtainedCourses().get(h));
                                }

                            }


                        }


                    }
                }
            }
        } else {
            System.out.println("Access denied");
        }

    }

    public void checkMaxSits() {
        if (loginSuccess) {
            for (int i = 0; i < configCourses.size(); i++) {
                if (configCourses.get(i).getSits() < 0) {
                    System.out.println("[Courselimit Error] course:" + configCourses.get(i) + " Exceeded Number of Students:" +
                            (configCourses.get(i).getSits() * -1));
                }
            }
        } else {
            System.out.println("Access denied");
        }

    }

    public void checkDuplication() {
        if (loginSuccess) {
            for (int i = 0; i < configStudent.size(); i++) {
                for (int j = 0; j < configStudent.get(i).getObtainedCourses().size(); j++) {
                    for (int k = j + 1; j < configStudent.get(k).getObtainedCourses().size(); k++) {

                        if (configStudent.get(k).getObtainedCourses().get(j).getId() ==
                                configStudent.get(k).getObtainedCourses().get(k).getId()) {
                            System.out.println("[CourseDuplication Error] " +
                                    " Student" + configStudent.get(i) +
                                    "course:" + configStudent.get(i).getObtainedCourses().get(j).getTitle());
                        }
                    }
                }
            }
        } else {
            System.out.println("Access denied");
        }

    }

    public void checkTimeConflictProfessor() {
        if (loginSuccess) {
            for (int i = 0; i < configProfessor.size(); i++) {

                for (int j = 0; j < configProfessor.get(i).getObtainedCourses().size(); j++) {

                    for (int h = j + 1; j < configProfessor.get(i).getObtainedCourses().size(); h++) {

                        for (Map.Entry m : configProfessor.get(i).getObtainedCourses().get(j).getSchedule().entrySet()) {
                            for (Map.Entry n : configProfessor.get(i).getObtainedCourses().get(h).getSchedule().
                                    entrySet()) {

                                if (m.getValue().equals(n.getValue()) && m.getKey().equals(n.getValue())) {
                                    System.out.println("[Conflict Error] Professor:" + configProfessor.get(i) + " Courses:"
                                            + configProfessor.get(i).getObtainedCourses().get(j) + " and " +
                                            configProfessor.get(i).getObtainedCourses().get(h));
                                }

                            }


                        }


                    }
                }
            }
        } else {
            System.out.println("Access denied");
        }

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {
        if (loginSuccess) {
            this.username = username;
        } else {
            System.out.println("Access denied");
        }
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
        if (loginSuccess) {
            this.password = password;
        } else {
            System.out.println("Access denied");
        }
    }

    public ArrayList<Student> getConfigStudent() {
        return new ArrayList<>(configStudent);
    }

    public void setConfigStudent(ArrayList<Student> configStudent) {
        if (loginSuccess) {
            this.configStudent = new ArrayList<>(configStudent);
        } else {
            System.out.println("Access denied");
        }
    }

    public ArrayList<Professor> getConfigProfessor() {
        return new ArrayList<>(configProfessor);
    }

    public void setConfigProfessor(ArrayList<Professor> configProfessor) {
        if (loginSuccess) {
            this.configProfessor = new ArrayList<>(configProfessor);
        } else {
            System.out.println("Access denied");
        }
    }

    public ArrayList<CourseGroup> getConfigCourses() {
        return new ArrayList<>(configCourses);
    }

    public void setConfigCourses(ArrayList<CourseGroup> configCourses) {
        if (loginSuccess) {
            this.configCourses = new ArrayList<>(configCourses);
        } else {
            System.out.println("Access denied");
        }
    }
}
