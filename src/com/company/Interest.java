package com.company;

import java.util.ArrayList;

public enum Interest {
    LOGIC, CREATIVITY, PROBLEM_SOVLING;

    private ArrayList<String> _keywords = new ArrayList();

    public void addKeyword(String keyword){
        _keywords.add(keyword);
    }
    public ArrayList<String> getKeywords(){
        return _keywords;
    }

}
