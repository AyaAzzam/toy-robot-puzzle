package com.puzzle.toyrobot.model;

public class Robot {

    public static final Integer MAX_POSITION = 4;
    public static final Integer MIN_POSITION = 0;

    private Integer xPosition;

    private Integer yPosition;

    private CardinalDirection cardinalDirection;

    public Robot() {
    }

    public Robot(Integer xPosition, Integer yPosition, CardinalDirection cardinalDirection) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.cardinalDirection = cardinalDirection;
    }

    public Integer getXPosition() {
        return xPosition;
    }

    public void setXPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getYPosition() {
        return yPosition;
    }

    public void setYPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public CardinalDirection getCardinalDirection() {
        return cardinalDirection;
    }

    public void setCardinalDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public boolean isOnTable() {
        return xPosition != null && yPosition != null && cardinalDirection != null;
    }

    public String getCurrentStatus() {
        return String.join(",", xPosition.toString(), yPosition.toString(), cardinalDirection.toString());
    }


    public void increaseYPosition() {
        yPosition++;
    }

    public void decreaseYPosition() {
        yPosition--;
    }

    public void increaseXPosition() {
        xPosition++;
    }

    public void decreaseXPosition() {
        yPosition++;
    }
}
