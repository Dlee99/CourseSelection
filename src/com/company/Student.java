package com.company;

import java.util.ArrayList;

public class Student {
    private String _name;
    private GradeYear _gradeYear;
    private School _school;
    private ArrayList<Course> _freshmanCourses = new ArrayList<>();
    private ArrayList<Course> _sophomoreCourses = new ArrayList<>();
    private ArrayList<Course> _juniofCourses = new ArrayList<>();
    private ArrayList<Course> _seniorCourses = new ArrayList<>();
    public Student(String name, GradeYear gradeYear, School school){
        _name = name;
        _gradeYear = gradeYear;
        _school = school;
    }
    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public GradeYear getGradeYear() {
        return _gradeYear;
    }

    public void setGradeYear(GradeYear _gradeYear) {
        this._gradeYear = _gradeYear;
    }

    public School getSchool() {
        return _school;
    }

    public void setSchool(School _school) {
        this._school = _school;
    }

    public ArrayList<Course> getFreshmanCourses() {
        return _freshmanCourses;
    }

    public void setFreshmanCourses(ArrayList<Course> _freshmanCourses) {
        this._freshmanCourses = _freshmanCourses;
    }

    public ArrayList<Course> getSophomoreCourses() {
        return _sophomoreCourses;
    }

    public void setSophomoreCourses(ArrayList<Course> _sophomoreCourses) {
        this._sophomoreCourses = _sophomoreCourses;
    }

    public ArrayList<Course> getJuniofCourses() {
        return _juniofCourses;
    }

    public void setJuniofCourses(ArrayList<Course> _juniofCourses) {
        this._juniofCourses = _juniofCourses;
    }

    public ArrayList<Course> getSeniorCourses() {
        return _seniorCourses;
    }

    public void setSeniorCourses(ArrayList<Course> _seniorCourses) {
        this._seniorCourses = _seniorCourses;
    }
}
