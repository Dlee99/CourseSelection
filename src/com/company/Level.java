package com.company;

public enum Level {
    ACADEMIC(1), COLLEGE_PREP(1), HONORS(1.125), ADVANCED_PLACEMENT(1.25);
    double _creditWeight;
    Level(double creditWeight){
        _creditWeight = creditWeight;
    }
}
