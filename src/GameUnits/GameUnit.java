
package GameUnits;

import Utility.Point;
import javafx.scene.image.ImageView;

//TODO all logic for stealth or rogue like behavior
public abstract class GameUnit implements Drawable {
    private int nationID;
    private double hp, walkDistance;
    private boolean alive = true;
    private Point location, moveLocation;
    private ImageView imageView;


    public int getNationID() {
        return nationID;
    }

    public double getHp() {
        return hp;
    }

    public double getWalkDistance() {
        return walkDistance;
    }

    public boolean isAlive(){
        return alive;
    }

    public Point getLocation() {
        return location;
    }

    public Point getMoveLocation() {
        return moveLocation;
    }

    public ImageView getImageView() {
        return imageView;
    }



    public void setNationID(int nationID) {
        this.nationID = nationID;
    }

    public void setHp(double hp) {
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
        this.hp = hp;
    }

    public void setWalkDistance(double walkDistance) {
        this.walkDistance = walkDistance;
    }

    public void setLocation(Point location) {
        this.location = location;
        imageView.setX(location.getX());
        imageView.setY(location.getY());
    }

    public void setMoveLocation(Point moveLocation) {
        this.moveLocation = moveLocation;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }




}
