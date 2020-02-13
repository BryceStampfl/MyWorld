package Utility;

import GameUnits.CombatGameUnit;

public class PositionUtility {

    public double getDeltaX(CombatGameUnit source, CombatGameUnit target) {
        return (getDeltaX(source.getLocation(),target.getLocation()));
    }
    public double getDeltaX(Point start, Point end) {
        if (isGameUnitComingFromRight(start, end)) {
            return start.getX() - end.getX();
        } else {
            return end.getX() - start.getX();
        }
    }

    public double getDeltaY(CombatGameUnit source, CombatGameUnit target) {
        return getDeltaY(source.getLocation(),target.getLocation());
    }
    public double getDeltaY(Point start, Point end) {
        if (isGameUnitComingFromBelow(start, end)) {
            return start.getY() - end.getY();
        } else {
            return end.getY() - start.getY();
        }
    }


    public boolean isGameUnitComingFromRight(CombatGameUnit source, CombatGameUnit target) {
        return isGameUnitComingFromRight(source.getLocation(), target.getLocation());
    }
    public boolean isGameUnitComingFromRight(Point start, Point end) {
        return (start.getX() - end.getX() > 0);
    }


    public boolean isGameUnitComingFromLeft(CombatGameUnit source, CombatGameUnit target) {
        return isGameUnitComingFromLeft(source.getLocation(),target.getLocation());
    }
    public boolean isGameUnitComingFromLeft(Point source, Point target) {
        return (source.getX() - target.getX() < 0);
    }

    public boolean isGameUnitComingFromAbove(CombatGameUnit source, CombatGameUnit target) {
        return isGameUnitComingFromAbove(source.getLocation(),target.getLocation());
    }
    public boolean isGameUnitComingFromAbove(Point source, Point target) {
        return (source.getY() - target.getY() < 0);
    }

    public boolean isGameUnitComingFromBelow(CombatGameUnit source, CombatGameUnit target) {
        return isGameUnitComingFromBelow(source.getLocation(), target.getLocation());
    }
    public boolean isGameUnitComingFromBelow(Point start, Point end) {
        return (start.getY() - end.getY() > 0);
    }

}
