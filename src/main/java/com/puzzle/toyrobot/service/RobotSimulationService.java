package com.puzzle.toyrobot.service;

import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.Robot;
import com.puzzle.toyrobot.model.SimulationRound;
import com.puzzle.toyrobot.model.command.Command;
import com.puzzle.toyrobot.model.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RobotSimulationService {

    private final Logger log = LoggerFactory.getLogger(RobotSimulationService.class);

    public Report start(SimulationRound simulationRound) {

        Robot robot = new Robot();

        Report report = new Report();

        for (String commandString : simulationRound.getCommands()) {

            Command command = CommandFactory.getCommand(commandString);

            if (command != null) {

                command.execute(robot, report);

            } else {

                log.debug("Wrong command: " + commandString);
            }
        }

        return report;
    }

}
