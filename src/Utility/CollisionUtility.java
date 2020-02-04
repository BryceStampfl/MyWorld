package Utility;

import GameUnits.CombatGameUnit;

import java.util.ArrayList;

public class CollisionUtility {
    private double deltaX, deltaY;

    public boolean checkCombatCollision(CombatGameUnit one, CombatGameUnit two) {
        Point a = one.getLocation();
        Point b = two.getLocation();
        double walkDistance = 100;
        deltaX = Abs(a.getX() - b.getX());
        deltaY = Abs(a.getY() - b.getY());

        if (Abs(deltaX) < walkDistance && Abs(deltaY) < walkDistance) {
            return true;
        }
        return false;
    }

    public ArrayList<CombatGameUnit> updateUnitsInLOS(CombatGameUnit source, ArrayList<CombatGameUnit> listOfAllUnits) {
        CollisionUtility collisionUtility = new CollisionUtility();
        ArrayList<CombatGameUnit> unitsInLOS = new ArrayList<>();
        for (CombatGameUnit cgu : listOfAllUnits) {
            if (!source.equals(cgu)) {
                if (collisionUtility.hasVisionOf(source, cgu)) {
                    unitsInLOS.add(cgu);
                }
            }
        }
        return unitsInLOS;
    }

    public boolean hasVisionOf(CombatGameUnit source, CombatGameUnit target) {
        deltaX = getDeltaX(source.getLocation(), target.getLocation());
        deltaY = getDeltaX(source.getLocation(), target.getLocation());
        return deltaX <= source.getVisionRange() && deltaY <= source.getVisionRange();
    }

    public double getDeltaX(Point start, Point end) {
        if (isGameUnitComingFromRight(start, end)) {
            return end.getX() - start.getX();
        } else {
            return Abs(end.getX() - start.getX());
        }
    }

    public double getDeltaY(Point start, Point end) {
        if (isGameUnitComingFromBelow(start, end)) {
            return end.getY() - start.getY();
        } else {
            return Abs(end.getY() - start.getY());
        }
    }

    private boolean isGameUnitComingFromBelow(Point start, Point end) {
        return (end.getY() - start.getY() > 0);
    }

    private boolean isGameUnitComingFromRight(Point start, Point end) {
        return (end.getX() - start.getX() > 0);
    }

    public boolean checkCollision(Point a, Point b, double walkDistance) {
        double deltaX = Abs(a.getX() - b.getX());
        double deltaY = Abs(a.getY() - b.getY());

        return Abs(deltaX) < walkDistance && Abs(deltaY) < walkDistance;
    }

    private double Abs(double num) {
        if (num < 0) {
            num *= -1;
        }
        return num;
    }
}
