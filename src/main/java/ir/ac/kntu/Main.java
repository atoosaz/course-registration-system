package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  data initial config
        Admin admin = new Admin();
        CourseGroup configCourse1 = new CourseGroup(10001, "mathematics1");
        configCourse1.setSits(2);
        HashMap<String, String> schedule = new HashMap<>();
        schedule.put("saturday", "13");
        configCourse1.setSchedule(schedule);
        CourseGroup configCourse2 = new CourseGroup(10002, "electronics1");
        configCourse2.setSits(1);
        schedule.put("saturday", "14");
        configCourse2.setSchedule(schedule);
        CourseGroup configCourse3 = new CourseGroup(10003, "electronics2");
        HashMap<String, String> schedule2 = new HashMap<>();
        schedule.put("monday", "14");
        configCourse3.setSchedule(schedule2);
        configCourse3.setSits(1);
        ArrayList<CourseGroup> configCourse = new ArrayList<>();
        configCourse.add(configCourse1);
        configCourse.add(configCourse2);
        configCourse.add(configCourse3);
        ArrayList<CourseGroup> student1Courses = new ArrayList<>();
        student1Courses.add(configCourse1);
        student1Courses.add(configCourse2);
        Student student1 = new Student();
        student1.setId(962518322);
        student1.setPassword("asdfg");
        student1.setObtainedCourses(student1Courses);
        ArrayList<Student> configStudents = new ArrayList<>();
        configStudents.add(student1);
        admin.setConfigStudent(configStudents);
        ArrayList<Professor> configProfessors = new ArrayList<>();

        //
        System.out.println("Enter Admin username and password:");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String pass = scanner.nextLine();
        System.out.println(admin.login(user, pass));
        boolean adminSection = false;
        while (admin.login(user, pass).equals("login was successful!") && adminSection) {
            System.out.println("select an option:");
            System.out.println("*add student[1]");
            System.out.println("*add professor[2]");
            System.out.println("*add course[3]");
            System.out.println("*nothing[4]");
            int input_section = Integer.parseInt(scanner.nextLine());
            if (input_section == 1) {//student
                System.out.println("enter name:");
                String name = scanner.nextLine();
                System.out.println("enter familyname:");
                String familyname = scanner.nextLine();
                System.out.println("enter id:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("enter password:");
                pass = scanner.nextLine();
                System.out.println("enter number of courses:");
                CourseGroup courseToAdd;
                int numberOfCourses = Integer.parseInt(scanner.nextLine());
                ArrayList<CourseGroup> studentnCourses = new ArrayList<>();
                for (int i = 0; i < numberOfCourses; i++) {
                    System.out.println("enter course id:");
                    id = Integer.parseInt(scanner.nextLine());
                    for (int j = 0; j < admin.getConfigCourses().size(); j++) {
                        if (id == admin.getConfigCourses().get(j).getId()) {
                            courseToAdd = admin.getConfigCourses().get(j);
                            studentnCourses.add(courseToAdd);
                        }
                    }
                }

                configStudents.add(new Student(name, familyname, id, pass, studentnCourses));
                admin.setConfigStudent(configStudents);
            } else if (input_section == 2) {//professor
                System.out.println("enter name:");
                String name = scanner.nextLine();
                System.out.println("enter familyname:");
                String familyname = scanner.nextLine();
                System.out.println("enter id:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("enter password:");
                pass = scanner.nextLine();
                System.out.println("enter number of courses:");
                ArrayList<CourseGroup> professornCourses = new ArrayList<>();
                CourseGroup courseToAdd;
                int numberOfCourses = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < numberOfCourses; i++) {
                    System.out.println("enter course id:");
                    id = Integer.parseInt(scanner.nextLine());
                    for (int j = 0; j < admin.getConfigCourses().size(); j++) {
                        if (id == admin.getConfigCourses().get(j).getId()) {
                            courseToAdd = admin.getConfigCourses().get(j);
                            professornCourses.add(courseToAdd);
                        }
                    }
                }

                configStudents.add(new Student(name, familyname, id, pass, professornCourses));
                admin.setConfigStudent(configStudents);
            } else if (input_section == 3) {//Course
                System.out.println("enter course id or title : ");
                System.out.println("*id[1]");
                System.out.println("*title[2]");
                System.out.println("*id and title[3]");
                int input = Integer.parseInt(scanner.nextLine());
                if (input == 1) {
                    System.out.println("enter course id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    configCourse.add(new CourseGroup(id));
                    admin.setConfigCourses(configCourse);
                } else if (input == 2) {
                    System.out.println("enter course title : ");
                    String title = scanner.nextLine();
                    configCourse.add(new CourseGroup(title));
                    admin.setConfigCourses(configCourse);
                } else if (input == 3) {
                    System.out.println("enter course id : ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("enter course title : ");
                    String title = scanner.nextLine();
                    configCourse.add(new CourseGroup(id, title));
                    admin.setConfigCourses(configCourse);
                }

            } else if(input_section==4){
                //do nothing
            }
            admin.changeSits();
            admin.checkCoursesStudent();
            admin.checkDuplication();
            admin.checkTimeConflictStudent();
            admin.checkMaxSits();
            System.out.println("do you want to conrinue as admin?");
            String checkAdmin = scanner.nextLine();
            if (!checkAdmin.equals("yes")) {
                adminSection = false;
            }

        }
        System.out.println("login as Student or Professor:");
        System.out.println("*Student[1]");
        System.out.println("*Professor[2]");
        int StudentOrProfessor = Integer.parseInt(scanner.nextLine());
        if (StudentOrProfessor == 1) {
            //login as student
            System.out.println("Enter Student id and password:");
            int id = Integer.parseInt(scanner.nextLine());
            pass = scanner.nextLine();
            for (int i = 0; i < configStudents.size(); i++) {
                if (configStudents.get(i).getId() == id) {
                    System.out.println(configStudents.get(i).login(id, pass));
                    if (configStudents.get(i).login(id, pass).equals("login was successful!")) {
                        System.out.println("your courses are:");
                        for (int j = 0; j < configStudents.get(i).getObtainedCourses().size(); j++) {
                            System.out.println(configStudents.get(i).getObtainedCourses().get(j).getTitle());
                        }

                    }
                }
            }
        }
        if (StudentOrProfessor == 2) {
            //login as student
            System.out.println("Enter Student id and password:");
            int id = Integer.parseInt(scanner.nextLine());
            pass = scanner.nextLine();
            for (int i = 0; i < configProfessors.size(); i++) {
                if (configProfessors.get(i).getId() == id) {
                    System.out.println(configProfessors.get(i).login(id, pass));
                    if (configProfessors.get(i).login(id, pass).equals("login was successful!")) {
                        System.out.println("your courses are:");
                        for (int j = 0; j < configProfessors.get(i).getObtainedCourses().size(); j++) {
                            System.out.println(configProfessors.get(i).getObtainedCourses().get(j).getTitle());
                        }

                    }
                }
            }
        }


    }
}