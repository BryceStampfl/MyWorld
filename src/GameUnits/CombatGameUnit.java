package GameUnits;

import Behaviors.CombatBehavior;

public abstract class CombatGameUnit extends GameUnit {
    private double att, def;
    private boolean checkedCollision = false;
    private boolean hasCombatTarget = false;
    private CombatGameUnit combatTarget;
    private CombatBehavior behavior;




    public double getAtt() {
        return att;
    }

    public double getDef() {
        return def;
    }

    /*public boolean isInCombat() {
        return inCombat;
    }

    public boolean isCombatFinished() {
        return combatFinished;
    }
*/
    public boolean hasCombatTarget(){
        return hasCombatTarget;
    }

    public boolean isCheckedCollision(){
        return checkedCollision;
    }

    public CombatGameUnit getCombatTarget() {
        return combatTarget;
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

    public void setHasCombatTarget(boolean hasCombatTarget){
        this.hasCombatTarget = hasCombatTarget;
    }

    public void setCheckedCollision(boolean checkedCollision){
        this.checkedCollision = checkedCollision;
    }

    public void setCombatTarget(CombatGameUnit combatTarget) {
        this.combatTarget = combatTarget;
        setHasCombatTarget(true);
    }

    public void setBehavior(CombatBehavior behavior) {
        this.behavior = behavior;
    }

    public abstract void updateLocation();
    public abstract void updateCombat();
}
