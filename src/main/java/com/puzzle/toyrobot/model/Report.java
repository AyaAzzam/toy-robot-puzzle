package com.puzzle.toyrobot.model;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<String> output = new ArrayList<>();

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public void addOutput(String outupt) {
        this.output.add(outupt);
    }

}
