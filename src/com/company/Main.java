package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final String courseFile = "courseList.txt";
    public static final String schoolFile = "schoolList.txt";
    public static void main(String[] args) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = getCourses(new File(courseFile));
        School school = getSchool(new File(schoolFile));
        school.addCourse(courses);
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }
        school.initializePrereqs();

    }
    public static ArrayList<Course> getCourses(File courseFile) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = new ArrayList<>(100);
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
    public static School getSchool(File schoolFile) throws java.io.FileNotFoundException{
        Scanner sc = new Scanner(schoolFile);
        School toReturn;
        String line = sc.nextLine();
        String[] args = line.split("\t");
        String name = args[0];
        toReturn = new School(name);
        double freshCredit = Double.parseDouble(args[1]);
        toReturn.setRequirement(GradeYear.FRESHMAN, Subject.TOTAL, freshCredit);
        double sophCredit = Double.parseDouble(args[2]);
        toReturn.setRequirement(GradeYear.SOPHOMORE, Subject.TOTAL, sophCredit);
        double junCredit = Double.parseDouble(args[3]);
        toReturn.setRequirement(GradeYear.JUNIOR, Subject.TOTAL, junCredit);
        double senCredit = Double.parseDouble(args[4]);
        toReturn.setRequirement(GradeYear.SENIOR, Subject.TOTAL, senCredit);
        double engCredit = Double.parseDouble(args[5]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.ENGLISH, engCredit);
        double socStudiesCredit = Double.parseDouble(args[6]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.SOCIAL_STUDIES, socStudiesCredit);
        double sciCredit = Double.parseDouble(args[7]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.SCIENCE, sciCredit);
        double mathCredit = Double.parseDouble(args[8]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.MATHEMATICS, mathCredit);
        double sciMathCredit = Double.parseDouble(args[9]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.SCIENCE_AND_MATH, sciMathCredit);
        double electCredit = Double.parseDouble(args[10]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.ELECTIVES, electCredit);
        double humanitiesCredit = Double.parseDouble(args[11]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.HUMANITIES, humanitiesCredit);
        double techCredit = Double.parseDouble(args[12]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.TECHNOLOGY, techCredit);
        double healthCredit = Double.parseDouble(args[13]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.HEALTH, healthCredit);
        double physEdCredit = Double.parseDouble(args[14]);
        toReturn.setRequirement(GradeYear.GRADUATION, Subject.PHYSICAL_EDUCATION, physEdCredit);
        return toReturn;
    }
    public static ArrayList<Student> getStudents(File studentFile, School school) throws FileNotFoundException {
        Scanner sc = new Scanner(studentFile);
        ArrayList<Student> students = new ArrayList<>();
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            String[] args = input.split("\t");
            String name = args[0];
            GradeYear gradeYear = GradeYear.valueOf(args[1].toUpperCase());
            int yearsInHighSchool = gradeYear.getGradeNumber() - GradeYear.FRESHMAN.getGradeNumber() + 1;
            int numOfColumns = yearsInHighSchool * 2;
            for (int i = 2; i < numOfColumns + 2; i++) {

            }


        }
        return students;
    }
}
