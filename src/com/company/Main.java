package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String courseFile = "courseList.txt";
    public static void main(String[] args) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = getCourses(new File(courseFile));
    }
    public static ArrayList<Course> getCourses(File courseFile) throws java.io.FileNotFoundException{
        ArrayList<Course> courses = new ArrayList<>();
        Scanner sc = new Scanner(courseFile);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] args = line.split("\t");
            String courseName = args[0];
            int courseCode;
            try{
                courseCode = Integer.parseInt(args[1]);
            }
            catch(InputMismatchException e){
                courseCode = 0;
            }
            Level courseLevel = Level.valueOf(args[2].replaceAll
                    (" ", "_"));
        }
        return courses;
    }
}
