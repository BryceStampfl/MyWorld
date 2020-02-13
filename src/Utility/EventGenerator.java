package Utility;

import ActionEvents.ActionEvent;
import ActionEvents.CombatEvent;
import ActionEvents.MoveEvent;
import ActionEvents.WaitEvent;
import GameUnits.CombatGameUnit;

import java.util.Queue;

public class EventGenerator {
    private CollisionUtility collisionUtility;
    private boolean lastTurnAttacked, lastTurnDefended;

    /*
        TODO: need to add a MoveEvent for if source sees target but isn't in melee range yet
     */
    public ActionEvent GenerateEvent(CombatGameUnit g) {

        if (g.getEnemyGameUnitsInLOS().isEmpty()) {
            //  System.out.println(" Moving to Castle");

            return new MoveEvent(g);
        }
        // If the unit doesn't have a target but there's target in its LOS
        //  if (!g.hasCombatTarget()){
        g.setCombatTarget(g.getEnemyGameUnitsInLOS().get(0));
        g.getCombatTarget().setCombatTarget(g);


        if (collisionUtility.isInAttackRange(g, g.getCombatTarget())) {
            if (!g.isAttackCDTimerFinished()) {
            }

            if (g.isAttackCDTimerFinished()) {
                return new CombatEvent(g, g.getCombatTarget());
            } else {
                return new WaitEvent();
            }
        } else {
           /* System.out.println(" " + g.getLocation().getX() + ", " + g.getLocation().getY() +
                    " Moving closer to target " + g.getCombatTarget().getLocation().getX() + ", "
            + g.getCombatTarget().getLocation().getY() + "with visionRange = " + g.getVisionRange());
*/
            return new MoveEvent(g, g.getCombatTarget());
        }
    }

    public EventGenerator() {
        collisionUtility = new CollisionUtility();
    }

}
