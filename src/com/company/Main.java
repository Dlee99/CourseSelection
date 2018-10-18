package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String courseFile = "courseList.txt";
    public static void main(String[] args) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = getCourses(new File(courseFile));
        School school = new School("Perkiomen Valley");
        school.addCourse(courses);
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }
    }
    public static ArrayList<Course> getCourses(File courseFile) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = new ArrayList<>();
        Scanner sc = new Scanner(courseFile);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] args = line.split("\t");
            String courseName = args[0];
            int courseCode;
            try {
                courseCode = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                courseCode = 0;
            }
            Level courseLevel = Level.valueOf(args[2].replaceAll
                    (" ", "_").toUpperCase());
            boolean isCore = args[3].equals("Y");
            boolean hasGIEP = args[4].equals("Y");
            Subject courseSubject = Subject.valueOf(args[5].replaceAll
                    (" ", "_").toUpperCase());
            double courseCredit;
            try {
                courseCredit = Double.parseDouble(args[6]);
            } catch (NumberFormatException e) {
                courseCredit = 0;
            }
            GradeYear minGrade = GradeYear.valueOf(args[7].toUpperCase());
            GradeYear maxGrade = GradeYear.valueOf(args[8].toUpperCase());
            String preReqs = args[9];
            String preReqTo = args[10];
            Course course = new Course(courseName, courseCode, courseLevel, isCore, hasGIEP,
                    courseSubject, courseCredit, minGrade, maxGrade, preReqs, preReqTo,
                    "");
            courses.add(course);
        }
        return courses;
    }
}
