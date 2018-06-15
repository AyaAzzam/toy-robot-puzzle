package com.puzzle.toyrobot.model;

import java.util.ArrayList;
import java.util.List;

public class SimulationRound {

    private List<String> commands = new ArrayList<>();

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}
