package GameUnits;

import Behaviors.CombatBehavior;
import ActionEvents.ActionEvent;

import java.util.ArrayList;
import java.util.Queue;

public abstract class CombatGameUnit extends GameUnit {
    private double att, def, visionRange;
    private boolean checkedCollision = false;
    private boolean hasCombatTarget = false;
    private CombatGameUnit combatTarget;
    private CombatBehavior behavior;
    private ArrayList<CombatGameUnit> gameEnemyUnitsInLOS;
    private Queue<ActionEvent> eventsToSelf;
    private Queue<ActionEvent> eventsToOther;


    public double getAtt() {
        return att;
    }

    public double getDef() {
        return def;
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

    public boolean isCheckedCollision() {
        return checkedCollision;
    }

    public CombatGameUnit getCombatTarget() {
        return combatTarget;
    }

    public Queue<ActionEvent> getEventsToSelf() {
        return eventsToSelf;
    }

    public CombatBehavior getBehavior() {
        return behavior;
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

    public void setEnemyGameUnitsInLOS(ArrayList<CombatGameUnit> gameEnemyUnitsInLOS) {
        this.gameEnemyUnitsInLOS = gameEnemyUnitsInLOS;
    }

    public void setHasCombatTarget(boolean hasCombatTarget) {
        this.hasCombatTarget = hasCombatTarget;
    }

    public void setCheckedCollision(boolean checkedCollision) {
        this.checkedCollision = checkedCollision;
    }

    public void setCombatTarget(CombatGameUnit combatTarget) {
        this.combatTarget = combatTarget;
        setHasCombatTarget(true);
    }

    public void setBehavior(CombatBehavior behavior) {
        this.behavior = behavior;
    }

    public abstract void update(ArrayList<CombatGameUnit> listOfAllUnits);


}

