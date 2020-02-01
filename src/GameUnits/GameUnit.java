package GameUnits;

import Behaviors.DamageBehavior;

//TODO all logic for stealth or rogue like behavior
public abstract class GameUnit implements Drawable {
    private int hp, att, def, moveSpeed,xPos, yPos;
    private DamageBehavior behavior;


    public int nationID;
    public int getAtt(){
        return att;
    }
    public int getHp(){
        return hp;
    }
    public int getDef(){
        return def;
    }
    public int getMoveSpeed() {
        return moveSpeed;
    }
    public int getXPos(){
        return this.xPos;
    }
    public int getYPos(){
        return this.yPos;
    }
    public DamageBehavior getBehavior() {
        return behavior;
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
    public void setXPos(int x){
        this.xPos = x;
    }
    public void setYPos(int y){
        this.yPos = y;
    }
    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
    public void setBehavior(DamageBehavior behavior) {
        this.behavior = behavior;
    }


    public int getNationID(){
        return nationID;
    }

    public abstract void update();

}
