package com.company;

public class Requirement {
    private Subject _subject;
    private double _credits;

    public Requirement(Subject subject){
        _subject = subject;
        _credits = 0;
    }
    public Requirement(Subject subject, double credits){
        _subject = subject;
        _credits = credits;
    }
    public void setCredits(double credits){
        _credits = credits;
    }
    public double getCredits(){
        return _credits;
    }
    public Subject getSubject(){
        return _subject;
    }

}
