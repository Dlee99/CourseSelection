package com.company;

public enum GradeYear {
    FRESHMAN(9, "Freshman"), SOPHOMORE(10, "Sophomore"), JUNIOR(11, "Junior"), SENIOR(12, "Senior"), GRADUATION(0, "Graduation");
    private int _gradeNumber;
    private String _name;
    GradeYear(int gradeNumber, String name){
        _gradeNumber = gradeNumber;
        _name = name;
    }
}
