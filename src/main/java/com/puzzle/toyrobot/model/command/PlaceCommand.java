package com.puzzle.toyrobot.model.command;

import com.puzzle.toyrobot.model.CardinalDirection;
import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.Robot;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaceCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(PlaceCommand.class);

    private String commandString;

    PlaceCommand(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public void execute(Robot robot, Report report) {
        String placementArgs = StringUtils.substringAfter(commandString, CommandType.PLACE.name());
        String[] args = StringUtils.split(placementArgs, ",");

        Integer initialX = Integer.parseInt(args[0].trim());
        Integer initialY = Integer.parseInt(args[1].trim());

        if (initialX <= Robot.MAX_POSITION && initialX >= Robot.MIN_POSITION
                && initialY <= Robot.MAX_POSITION && initialY >= Robot.MIN_POSITION) {
            robot.setXPosition(initialX);
            robot.setYPosition(initialY);
            robot.setCardinalDirection(CardinalDirection.valueOf(args[2].trim()));
            log.debug("Robot is placed at " + robot.getCurrentStatus());
        } else {
            log.debug("Place command ignored");
        }
    }
}
