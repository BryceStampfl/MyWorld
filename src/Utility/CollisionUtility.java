package Utility;

import GameUnits.CombatGameUnit;

public class CollisionUtility {

    public boolean checkCombatCollision(CombatGameUnit one, CombatGameUnit two) {
        Point a = one.getLocation();
        Point b = two.getLocation();
        double walkDistance = 100;
        double deltaX = Abs(a.getX() - b.getX());
        double deltaY = Abs(a.getY() - b.getY());

        if (Abs(deltaX) < walkDistance && Abs(deltaY) < walkDistance) {
            return true;
        }
        return false;
    }

    public boolean checkCollision(Point a, Point b, double walkDistance ) {
        double deltaX = Abs(a.getX() - b.getX());
        double deltaY = Abs(a.getY() - b.getY());

        if (Abs(deltaX) < walkDistance && Abs(deltaY) < walkDistance) {
            return true;
        }
        return false;
    }

    private double Abs(double num) {
        if (num < 0) {
            num *= -1;
        }
        return num;
    }
}
