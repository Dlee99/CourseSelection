package com.company;

import java.util.ArrayList;

public class School {
    private String _name; //the name of the school
    private String _emailExtension; //the @school.com for the school (ex: pvsd.org)
    private ArrayList<Course> _courseRequirements; //the courses required to be taken at the school
    private ArrayList<Course> _courses; //the courses that the school offers
    private Requirement[] _subjectRequirements = new Requirement[Subject.values().length];

    /**
     * Creates a school object
     * @param name the name of the school
     */
    public School(String name){
        _name = name;
        for (int i = 0; i < _subjectRequirements.length; i++) {
            _subjectRequirements[i] = new Requirement(Subject.values()[i]);
        }
    }

    /**
     * Sets the credits value in the Requirement object that has the inputted subject in
     * _subjectRequirements to the inputted credits
     * @param subject the subject to set a credit requirement for
     * @param credits the amount of credits to be required
     */
    public void setSubjectRequirement(Subject subject, double credits){
        for (int i = 0; i < _subjectRequirements.length; i++) {
            Requirement r = _subjectRequirements[i];
            Subject s = r.getSubject();
            if(subject == s){
                _subjectRequirements[i].setCredits(credits);
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
