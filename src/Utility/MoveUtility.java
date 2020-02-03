package Utility;

import GameUnits.GameUnit;

public class MoveUtility {
    /*
    Project:Combat:#6 Movement
    Allows a unit to get the next point to move to, towards a target.
     */
    public Point getPointTowardsTarget(Point start, Point end, double distance){
        Point movePoint = new Point();
        // If value is positive then start point is left and the end point is to the right
        double deltaX = end.getX() - start.getX();
        // If value is positive then start point is up and end point is down
        double deltaY = end.getY() - start.getY();


        //Check if the start x point is already in bounds of the end x point
        if(Abs(deltaX) <= (distance / 2)) {
            if (deltaX > 0){
                movePoint.setX(end.getX());
            }else{
                movePoint.setX(end.getX());
            }
        }
        //Check if the start y point is already in bounds of the end x point
        if (Abs(deltaY) <= (distance / 2)){
            if (deltaY > 0){
                movePoint.setY(end.getY());
            }else {
                movePoint.setY(end.getY());
            }
        }
        // If the end object is farther than we need to be.
        if (Abs(deltaX) > distance/2) {
            if (deltaX > 0) {
                movePoint.setX(start.getX() + (distance / 2));
            } else {
                movePoint.setX(start.getX() - (distance / 2));
            }
        }
        if (Abs(deltaY) > distance/2){
            if (deltaY > 0){
                movePoint.setY(start.getY() + (distance / 2));
            }else{
                movePoint.setY(start.getY() - (distance / 2));
            }
        }
        return movePoint;
    }

    private double Abs(double num){
        if (num < 0){
            num *= -1;
        }
        return num;
    }

    public MoveUtility(){
    }

}
