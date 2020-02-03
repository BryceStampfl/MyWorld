package Utility;

import GameUnits.GameUnit;

public class MoveUtility {
    private double deltaX, deltaY;

    /*
    Project:Combat:#6 Movement
    Allows a unit to get the next point to move to, towards a target.
     */


    private double Abs(double num) {
        if (num < 0) {
            num *= -1;
        }
        return num;
    }

    public MoveUtility() {
    }

    public Point getPointTowardsTarget(Point start, Point end, double walkDistance) {
        Point movePoint = new Point();
        // If value is positive then start point is left and the end point is to the right
        double deltaX = end.getX() - start.getX();
        // If value is positive then start point is up and end point is down
        double deltaY = end.getY() - start.getY();

        if (isGameUnitAtTarget(start, end, walkDistance)) {
            return new Point(end.getX(), end.getY());
        } else if (isGameUnitAtTargetXAxis(start, end, walkDistance)) {
            if (isGameUnitComingFromBelow(start, end)) {
                return new Point(end.getX(), start.getY() + walkDistance);
            } else {
                return new Point(end.getX(), start.getY() - walkDistance);
            }
        } else if (isGameUnitAtTargetYAxis(start, end, walkDistance)) {
            if (isGameUnitComingFromRight(start,end)) {
                return new Point(start.getX() + walkDistance, end.getY());
            } else {
                return new Point(start.getX() - walkDistance, end.getY());
            }
        } else {
            double x = start.getX();
            double y = start.getY();
            if (isGameUnitComingFromRight(start,end)) {
                x += walkDistance;
            } else {
                x -= walkDistance;
            }
            if (isGameUnitComingFromBelow(start, end)) {
                y += walkDistance;
            } else {
                y -= walkDistance;
            }
            return new Point(x, y);
        }
    }

    public Point getPatrolPointAroundTarget(Point start, Point end, double walkDistance) {
        if (isGameUnitAtTarget(start, end, walkDistance)) {
            return new Point(end.getX(), end.getY());
        }

        if (isGameUnitAtTargetXAxis(start, end, walkDistance)) {
        }


        return new Point();
    }

    private boolean isGameUnitComingFromLeft(Point start, Point end) {
        return (end.getX() - start.getX()   < 0);
    }

    private boolean isGameUnitComingFromRight(Point start, Point end) {
        return (end.getX() - start.getX() > 0);
    }

    private boolean isGameUnitComingFromAbove(Point start, Point end) {
            return (end.getY() - start.getY() < 0);
    }

    private boolean isGameUnitComingFromBelow(Point start, Point end) {
            return (end.getY() - start.getY() > 0);
    }

    private boolean isGameUnitAtTarget(Point start, Point end, double walkDistance) {
        double deltaX = Abs(end.getX() - start.getX());
        double deltaY = Abs(end.getY() - start.getY());

        if (Abs(deltaX) < walkDistance && Abs(deltaY) < walkDistance) {
            return true;
        }
        return false;
    }

    private boolean isGameUnitAtTargetXAxis(Point start, Point end, double walkDistance) {
        deltaX = Abs(end.getX() - start.getX());
        return deltaX < walkDistance;
    }

    private boolean isGameUnitAtTargetYAxis(Point start, Point end, double walkDistance) {
        deltaY = Abs(end.getY() - start.getY());
        return deltaY < walkDistance;
    }


}
