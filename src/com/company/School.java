package com.company;

import java.util.ArrayList;

public class School {
    private String _name; //the name of the school
    private String _emailExtension; //the @school.com for the school (ex: pvsd.org)
    private ArrayList<Course> _courses; //the courses that the school offers
    private Requirement[] _graduationRequirements = new Requirement[Subject.values().length];

    /**
     * Creates a school object
     * @param name the name of the school
     */
    public School(String name){
        _name = name;
        Subject[] subjects = Subject.values();
        for (int i = 0; i < _graduationRequirements.length; i++) {

        }
    }

    /**
     * Sets the credits value in the Requirement object that has the inputted subject in
     * _subjectRequirements to the inputted credits
     * @param subject the subject to set a credit requirement for
     * @param credits the amount of credits to be required
     */
    public void setGraduationRequirement(Subject subject, double credits){
        for (int i = 0; i < _graduationRequirements.length; i++) {
            Requirement r = _graduationRequirements[i];
            Subject s = r.getSubject();
            if(subject == s){
                _graduationRequirements[i].setCredits(credits);
                return;
            }
        }
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

    /**
     * Removes a course from the courses offered at the school
     * @param course the course to be removed
     * @return True if the course is removed, false if not
     */
    public boolean removeCourse(Course course){
        return _courses.remove(course);
    }

}
