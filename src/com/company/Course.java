package com.company;

import java.util.ArrayList;

public class Course {

    private String _name; //name of the course
    private String _description; //description of the course
    private ArrayList<Course> _prerequisiteCourses = new ArrayList(); //the classes needed to be taken before this one
    private static ArrayList<Course> _requirements = new ArrayList(); //the classes required to graduate
    private double _credits; //the amount of credits the course is worth
    private Subject _subject;

    /**
     * Creates a course object
     * @param name the name of the course
     * @param description the description of the course
     */
    public Course(String name, String description, double credits){
        _name = name;
        _description = description;
        _credits = credits;
    }

    /**
     * Sets the name of the course
     * @param name - new name of the course
     */
    public void setName(String name){
        _name = name;
    }

    /**
     * @return the name of the course
     */
    public String getName(){
        return _name;
    }

    /**
     * Sets the description of the course
     * @param description - new description of the course
     */
    public void setDescription(String description){
        _description = description;
    }

    /**
     * @return the description of the course
     */
    public String getDescription(){
        return _description;
    }
    /**
     * Sets the subject of the course
     * @param subject - the new subject classification
     */
    public void setSubject(Subject subject){
        _subject = subject;
    }
    public Subject getSubject(){
        return _subject;
    }
    /**
     * Adds a prerequisite to the course created
     * @param course the course to be added to the prerequisites
     * @param courses any additional courses to be added
     */
    public void addPrerequisite(Course course, Course ... courses){
        _prerequisiteCourses.add(course);
        for(Course c: courses){
            _prerequisiteCourses.add(c);
        }
    }

    /**
     * Removes a prerequisite course from the list
     * @param course the course to be removed
     * @return True if the course is removed, false if not
     */
    public boolean removePrerequisite(Course course){
        return _prerequisiteCourses.remove(course);
    }

    /**
     * Validates whether or not the list of courses meets the prerequisites for a course
     * @param studentCourses the courses that were taken to check for the prerequisites
     * @return True if the list has the necessary prerequisites, false if not
     */
    public boolean validatePrereqs(ArrayList<Course> studentCourses){
        return studentCourses.containsAll(_prerequisiteCourses);
    }


}
