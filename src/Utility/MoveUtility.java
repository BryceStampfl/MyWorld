package Utility;

import GameUnits.CombatGameUnit;

public class MoveUtility {
    private double deltaX, deltaY;
    private PositionUtility pos;
    /*
    Project:Combat:#6 Movement
    Allows a unit to get the next point to move to, towards a target.
     */

    public MoveUtility() {
        pos = new PositionUtility();
    }

    public Point getImprovedGetPointTowardsTarget(CombatGameUnit source, CombatGameUnit target) {
        pos = new PositionUtility();
        deltaX = pos.getDeltaX(source, target);
        deltaY = pos.getDeltaY(source, target);
        double walkDistance = source.getWalkDistance();
        double slope;
        double distY = 0;
        double distX = 0;
        double remainder = 0;


        if (deltaX + deltaY <= walkDistance) {
            return new Point(target.getLocation().getX(), target.getLocation().getY());
        } else if (deltaX <= walkDistance || deltaY <= walkDistance) {
            if (deltaX <= walkDistance) {
                remainder = 0;
                if (pos.isGameUnitComingFromBelow(source, target)) {
                    remainder = -1 * (walkDistance - deltaX);
                } else {
                    remainder = (walkDistance - deltaX);
                }
                distY += remainder;
            }
            if (deltaY <= walkDistance) {
                remainder = 0;
                if (pos.isGameUnitComingFromRight(source, target)) {
                    remainder = -1 * (walkDistance - deltaY);
                } else {
                    remainder = (walkDistance - deltaY);
                }
                distX += remainder;
            }
        } else if (deltaX > walkDistance && deltaY > walkDistance) {
            //X distance is farther
            if (deltaX > deltaY) {
                slope = deltaY / deltaX;
                if (walkDistance * slope > walkDistance / 2) {
                    distX = walkDistance * slope;
                    distY = walkDistance - distX;
                } else {
                    distY = walkDistance * slope;
                    distX = walkDistance - distY;
                }
                // deltaY > deltaX
            } else {
                slope = deltaX / deltaY;
                if (walkDistance * slope > walkDistance / 2) {
                    distY = walkDistance * slope;
                    distX = walkDistance - distY;
                } else {
                    distX = walkDistance * slope;
                    distY = walkDistance - distX;
                }
            }

            if (pos.isGameUnitComingFromBelow(source, target)) {
                distY *= -1;
            }
            if (pos.isGameUnitComingFromRight(source, target)) {
                distX *= -1;
            }
        }
        return new Point(source.getLocation().getX() + distX, source.getLocation().getY() + distY);
    }

    public Point getImprovedGetPointTowardsTarget(CombatGameUnit source) {
        Point target = source.getMoveLocation();
        deltaX = pos.getDeltaX(source.getLocation(), source.getMoveLocation());
        deltaY = pos.getDeltaY(source.getLocation(), source.getMoveLocation());
        double walkDistance = source.getWalkDistance();
        // If farther than walkDistance away

        if (deltaX + deltaY <= walkDistance) {
            return new Point(target.getX(), target.getY());
        } else if (deltaX <= walkDistance || deltaY <= walkDistance) {

            double remainder;
            double distY = 0;
            double distX = 0;
            if (deltaX <= walkDistance) {
                remainder = 0;
                if (pos.isGameUnitComingFromBelow(source.getLocation(), target)) {
                    remainder = -1 * (walkDistance - deltaX);
                } else {
                    remainder = (walkDistance - deltaX);
                }
                distY += remainder;
            }
            if (deltaY <= walkDistance) {
                remainder = 0;
                if (pos.isGameUnitComingFromRight(source.getLocation(), target)) {
                    remainder = -1 * (walkDistance - deltaY);
                } else {
                    remainder = (walkDistance - deltaY);
                }
                distX += remainder;
            }
            return new Point(source.getLocation().getX() + distX, source.getLocation().getY() + distY);

        } else if (deltaX > walkDistance && deltaY > walkDistance) {
            double slope, distX, distY;
            double remainder = 0;
            //X distance is farther
            if (deltaX > deltaY) {
                slope = deltaY / deltaX;
                if (walkDistance * slope > walkDistance / 2) {
                    distX = walkDistance * slope;
                    distY = walkDistance - distX;
                } else {
                    distY = walkDistance * slope;
                    distX = walkDistance - distY;
                }
                // deltaY > deltaX
            } else {
                slope = deltaX / deltaY;
                if (walkDistance * slope > walkDistance / 2) {
                    distY = walkDistance * slope;
                    distX = walkDistance - distY;
                } else {
                    distX = walkDistance * slope;
                    distY = walkDistance - distX;
                }
            }

            if (pos.isGameUnitComingFromBelow(source.getLocation(), target)) {
                distY *= -1;
            }
            if (pos.isGameUnitComingFromRight(source.getLocation(), target)) {
                distX *= -1;
            }


            return new Point(source.getLocation().getX() + distX, source.getLocation().getY() + distY);
        }
        System.out.println("Error shouldn't get here in getImprovedGetPointTowardsTarget in MoveUtility");
        return new Point(0, 0);
    }


}
