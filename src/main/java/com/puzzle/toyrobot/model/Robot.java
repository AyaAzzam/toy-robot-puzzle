package com.puzzle.toyrobot.model;

public class Robot {

    public static final Integer MAX_POSITION = 4;
    public static final Integer MIN_POSITION = 0;

    private Integer xPosition;

    private Integer yPosition;

    private CardinalDirection cardinalDirection;

    public Robot() { }

    public Robot(Integer xPosition, Integer yPosition, CardinalDirection cardinalDirection) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.cardinalDirection = cardinalDirection;
    }

    public Integer getxPosition() {
        return xPosition;
    }

    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getyPosition() {
        return yPosition;
    }

    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public CardinalDirection getCardinalDirection() {
        return cardinalDirection;
    }

    public void setCardinalDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public boolean isOnTable() {
        return xPosition <= MAX_POSITION && xPosition >= MIN_POSITION
                && yPosition <= MAX_POSITION && yPosition >= MIN_POSITION;
    }

    public boolean isMissing() {
        return xPosition == null && yPosition == null && cardinalDirection == null;
    }

    public String getCurrentStatus() {
        return String.join(",", xPosition.toString(), yPosition.toString(), cardinalDirection.toString());
    }

}
