package com.company;

import java.util.ArrayList;

public class Student {
    private String _name;
    private GradeYear _gradeYear;

    public Student(String name, GradeYear gradeYear){
        _name = name;
        _gradeYear = gradeYear;
    }
    public void setGrade(GradeYear gradeYear){
        _gradeYear = gradeYear;
    }
    public GradeYear getGrade(){
         return _gradeYear;
    }
}
