package com.puzzle.toyrobot.model.command;

import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(ReportCommand.class);

    @Override
    public void execute(Robot robot, Report report) {
        if (!robot.isOnTable()) {
            log.debug("Missing Robot");
            report.addOutput("ROBOT MISSING");
        } else {
            report.addOutput(robot.getCurrentStatus());
        }
    }
}
