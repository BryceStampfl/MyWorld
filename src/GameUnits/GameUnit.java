package GameUnits;

import Behaviors.CombatBehavior;
import Utility.Point;
import javafx.scene.image.ImageView;

//TODO all logic for stealth or rogue like behavior
public abstract class GameUnit implements Drawable {
    private int hp, att, def;
    private double walkDistance;
    private CombatBehavior behavior;
    private GameUnit target, castleLocation;
    private Point location;
    private ImageView imageView;
    private int nationID;

    public int getAtt(){
        return att;
    }
    public int getHp(){
        return hp;
    }
    public int getDef(){
        return def;
    }
    public int getNationID(){
        return nationID;
    }
    public double getWalkDistance() {
        return walkDistance;
    }
    public GameUnit getTarget(){
        return target;
    }
    public CombatBehavior getBehavior() {
        return behavior;
    }
    public Point getLocation(){
        return location;
    }
    public ImageView getImageView(){
        return imageView;
    }

    public void setAtt(int att) {
        this.att = att;
    }
    public void setHp(int hp) {
        if (hp < 0){
            hp = 0;
        }
        this.hp = hp;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public void setNationID(int nationID){
        this.nationID = nationID;
    }
    public void setWalkDistance(double walkDistance) {
        this.walkDistance = walkDistance;
    }
    public void setTarget(GameUnit target){
        this.target = target;
    }
    public void setBehavior(CombatBehavior behavior) {
        this.behavior = behavior;
    }
    public void setLocation(Point location){
        this.location = location;
        imageView.setX(location.getX());
        imageView.setY(location.getY());
    }
    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }

    public abstract void update();

}
