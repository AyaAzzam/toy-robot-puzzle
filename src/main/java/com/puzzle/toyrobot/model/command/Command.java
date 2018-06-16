package com.puzzle.toyrobot.model.command;


import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.Robot;

public abstract class Command {

    public abstract void execute(Robot robot, Report report);
}
