package com.company;

import java.util.ArrayList;

public class Student {
    private String _name;
    private int _gradeNumber;

    public Student(String name, int grade){
        _name = name;
        _gradeNumber = grade;
    }
     public void setGrade(int grade){
        _gradeNumber = grade;
    }
    public int getGrade(){
         return _gradeNumber;
    }
}
