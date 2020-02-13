package GameUnits;

import Behaviors.CombatBehavior;
import ActionEvents.ActionEvent;
import Utility.GameTimer;
import Utility.Point;
import java.util.ArrayList;

public abstract class CombatGameUnit extends GameUnit {
    private int kills = 0;
    private double att, def, visionRange, attackRange;
    private boolean hasCombatTarget = false;
    private boolean isDead = false;
    private CombatGameUnit combatTarget;
    private CombatBehavior behavior;
    private ArrayList<CombatGameUnit> gameEnemyUnitsInLOS;
    private ActionEvent event;
    private Point castleLocation;
    private GameTimer attackTimer, moveTimer;


    public double getAtt() {
        return att;
    }
    public double getDef() {
        return def;
    }

    public double getAttackRange() {
        return attackRange;
    }
    public double getVisionRange() {
        return visionRange;
    }
    public ArrayList<CombatGameUnit> getEnemyGameUnitsInLOS() {
        return this.gameEnemyUnitsInLOS;
    }
    public boolean hasCombatTarget() {
        return hasCombatTarget;
    }
    public boolean isAttackCDTimerFinished(){
        return attackTimer.isFinished();
    }
    public boolean isMoveCDTimerFinished(){
        return moveTimer.isFinished();
    }

    public CombatGameUnit getCombatTarget() {
        return combatTarget;
    }
    public ActionEvent getEvent() {
        return event;
    }
    public CombatBehavior getCombatBehavior() {
        return behavior;
    }
    public Point getCastleLocation(){
        return castleLocation;
    }
    public boolean getIsDead(){
        return isDead;
    }



    public void setAtt(double att) {
        this.att = att;
    }
    public void setDef(double def) {
        this.def = def;
    }
    public void setVisionRange(double visionRange) {
        this.visionRange = visionRange;
    }
    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }

    public void setEnemyGameUnitsInLOS(ArrayList<CombatGameUnit> gameEnemyUnitsInLOS) {
        this.gameEnemyUnitsInLOS = gameEnemyUnitsInLOS;
    }
    public void setHasCombatTarget(boolean hasCombatTarget) {
        this.hasCombatTarget = hasCombatTarget;
    }
    public void setCombatTarget(CombatGameUnit combatTarget) {
        this.combatTarget = combatTarget;
        setHasCombatTarget(true);
    }
    public void setEventAction(ActionEvent event){
        this.event = event;
    }
    public void setCastleLocation(Point castleLocation){
        this.castleLocation = castleLocation;
    }
    public void setCombatBehavior(CombatBehavior behavior) {
        this.behavior = behavior;
    }
    public void setAttackTimer(double length){
        attackTimer = new GameTimer(length);
    }
    public void setMoveTimer(double length){
        moveTimer = new GameTimer(length);
    }

    public void startAttackTimer(){
        attackTimer.run();
    }
    public void startMoveTimer(){
        moveTimer.run();
    }
    public void setDead(boolean isDead){
        this.isDead = isDead;
    }

    public int getKills(){
        return  kills;
    }
    public void incrementKills(){
        kills += 1;
    }

    public abstract void update(ArrayList<CombatGameUnit> listOfAllUnits);


}

