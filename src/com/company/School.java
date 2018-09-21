package com.company;

import java.util.ArrayList;

public class School {
    private String _name; //the name of the school
    private String _emailExtension; //the @school.com for the school (ex: pvsd.org)
    private ArrayList<Course> _courseRequirements; //the courses required to be taken at the school
    private ArrayList<Course> _courses; //the courses that the school offers

    /**
     * Creates a school object
     * @param name the name of the school
     */
    public School(String name){
        _name = name;
    }

    /**
     * Adds a course to the courses offered at the school
     * @param course the course to be added
     * @param courses any additional courses to be added
     */
    public void addCourse(Course course, Course ... courses){
        _courses.add(course);
        for (Course c: courses){
            _courses.add(c);
        }
    }
    public boolean removeCourse(Course course){
        return _courses.remove(course);
    }
    /**
     * Adds a requirement to the graduation requirements
     * @param course the course to be added to the requirements
     * @param courses any additional courses to be added
     */
    public void addRequirement(Course course, Course ... courses){
        _courseRequirements.add(course);
        for(Course c: courses){
            _courseRequirements.add(c);
        }
    }

    /**
     * Removes a requirement from the graduation requirements
     * @param course the course to be removed
     * @return True if the course is removed, false if not
     */
    public  boolean removeRequirement(Course course){
        return _courseRequirements.remove(course);
    }
}
