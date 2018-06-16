package com.puzzle.toyrobot.model.command;

import com.puzzle.toyrobot.model.CardinalDirection;
import com.puzzle.toyrobot.model.Report;
import com.puzzle.toyrobot.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RightCommand extends Command {
    private final Logger log = LoggerFactory.getLogger(RightCommand.class);

    @Override
    public void execute(Robot robot, Report report) {
        if (!robot.isOnTable()) {
            log.debug("Right command ignored");
        } else {
            switch (robot.getCardinalDirection()) {
                case NORTH:
                    robot.setCardinalDirection(CardinalDirection.EAST);
                    break;
                case SOUTH:
                    robot.setCardinalDirection(CardinalDirection.WEST);
                    break;
                case EAST:
                    robot.setCardinalDirection(CardinalDirection.SOUTH);
                    break;
                case WEST:
                    robot.setCardinalDirection(CardinalDirection.NORTH);
                    break;
            }
            log.debug("The robot is rotating 90 degree to " + robot.getCardinalDirection());

        }
    }
}
