package Utility;
/*
Super basic point class;
 */
public class Point {
    private double x;
    private double y;

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x){
            this.x = x;
    }

    public void setY(double y){
            this.y = y;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(){
        x = 0;
        y = 0;
    }

    public boolean equals(Point b){
        return this.x == b.getX() && this.y == b.getY();
    }

}
