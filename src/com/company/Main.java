package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static final String courseFile = "courseList.txt";
    public static final String schoolFile = "schoolList.txt";
    public static final String studentFile = "studentList.txt";
    public static void main(String[] args) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = getCourses(new File(courseFile));
        /*
        for(int i = 0; i < courses.size(); i++){
            System.out.println(i + 1 + "|" + courses.get(i).getName());

        }
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Freshman");
            System.out.println("Sophomore");
            System.out.println("Junior");
            System.out.println("Senior");
        }
        */
        School school = getSchool(new File(schoolFile));
        school.addCourse(courses);
        school.initializePrereqs();
        ArrayList<Student> students = getStudents(new File(studentFile), school);
        for(Student s: students){
            System.out.println(s.getName());
            displayCourses(s.getNext());
            System.out.println();
        }

    }

    public static void displayCourses(ArrayList<Course> courses) {
        Collections.sort(courses);
        Subject startSubject = courses.get(0).getSubject();
        String toPrint = "--------" + "\n" +
                startSubject + "\n" +
                "--------" + "\n";
        for(Course c: courses){
            Subject currentSubject = c.getSubject();
            if(currentSubject != startSubject){
                toPrint += "--------" + "\n" +
                        currentSubject + "\n" +
                        "--------" + "\n";
                startSubject = currentSubject;
            }
            toPrint += c.getName() + "\n";
        }
        toPrint = toPrint.replaceAll("_", " ");
        System.out.println(toPrint);
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
            String preReqs = args[9].replaceAll("[\"\\s]", "");
            String preReqTo = args[10].replaceAll("[\"\\s]","");
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
            Student student = new Student(name, gradeYear, school);
            String[] freshmanCourseList = args[2].replaceAll("[\"\\s]","").split(",");
            String[] freshmanGradeList = args[3].replaceAll("[\"\\s]", "").split(",");
            ArrayList<CourseGrade> freshmanCourseGrades = new ArrayList<>();
            for (int i = 0; i < freshmanCourseList.length; i++) {
                Course course = school.getCourses(freshmanCourseList[i]).get(0);
                Grade grade = Grade.getGrade(freshmanGradeList[i]);
                freshmanCourseGrades.add(new CourseGrade(course, grade, student));
            }
            student.setFreshmanCourses(freshmanCourseGrades);

            if(gradeYear.getGradeNumber() >= GradeYear.SOPHOMORE.getGradeNumber()){
                String[] sophomoreCourseList = args[4].replaceAll("[\"\\s]","").split(",");
                String[] sophomoreGradeList = args[5].replaceAll("[\"\\s]", "").split(",");
                ArrayList<CourseGrade> sophomoreCourseGrades = new ArrayList<>();
                for (int i = 0; i < sophomoreCourseList.length; i++) {
                    Course course = school.getCourses(sophomoreCourseList[i]).get(0);
                    Grade grade = Grade.getGrade(sophomoreGradeList[i]);
                    sophomoreCourseGrades.add(new CourseGrade(course, grade, student));
                }
                student.setSophomoreCourses(sophomoreCourseGrades);

            }
            if(gradeYear.getGradeNumber() >= GradeYear.JUNIOR.getGradeNumber()){
                String[] juniorCourseList = args[6].replaceAll("[\"\\s]","").split(",");
                String[] juniorGradeList = args[7].replaceAll("[\"\\s]", "").split(",");
                ArrayList<CourseGrade> juniorCourseGrades = new ArrayList<>();
                for (int i = 0; i < juniorGradeList.length; i++) {
                    Course course = school.getCourses(juniorCourseList[i]).get(0);
                    Grade grade = Grade.getGrade(juniorGradeList[i]);
                    juniorCourseGrades.add(new CourseGrade(course, grade, student));
                }
                student.setJuniorCourses(juniorCourseGrades);
            }
            if(gradeYear.getGradeNumber() >= GradeYear.SENIOR.getGradeNumber()){
                String[] seniorCourseList = args[8].replaceAll("[\"\\s]","").split(",");
                String[] seniorGradeList = args[9].replaceAll("[\"\\s]", "").split(",");
                ArrayList<CourseGrade> seniorCourseGrades = new ArrayList<>();
                for (int i = 0; i < seniorGradeList.length; i++) {
                    Course course = school.getCourses(seniorCourseList[i]).get(0);
                    Grade grade = Grade.getGrade(seniorGradeList[i]);
                    seniorCourseGrades.add(new CourseGrade(course, grade, student));
                }
                student.setSeniorCourses(seniorCourseGrades);
            }
            students.add(student);
        }
        return students;
    }
}
