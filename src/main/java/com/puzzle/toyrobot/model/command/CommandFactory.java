package com.puzzle.toyrobot.model.command;

public class CommandFactory {

    private static final String PLACE_COMMAND_REGEX = "^(PLACE)\\s\\d+,\\d+,(NORTH|WEST|EAST|SOUTH)$";

    public static Command getCommand(String commandString) {

        if (commandString.matches(PLACE_COMMAND_REGEX)) {
            return new PlaceCommand(commandString);

        } else if (commandString.equals(CommandType.LEFT.name())) {
            return new LeftCommand();

        } else if (commandString.equals(CommandType.RIGHT.name())) {
            return new RightCommand();

        } else if (commandString.equals(CommandType.REPORT.name())) {
            return new ReportCommand();

        } else if (commandString.equals(CommandType.MOVE.name())) {
            return new MoveCommand();

        }
        return null;
    }
}
