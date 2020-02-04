package Utility;

import ActionEvents.ActionEvent;
import ActionEvents.CombatEvent;
import ActionEvents.MoveEvent;
import GameUnits.CombatGameUnit;

import java.util.LinkedList;
import java.util.Queue;

public class EventGenerator {
    private Queue<ActionEvent> event;
    private CollisionUtility collisionUtility;
    private boolean lastTurnAttacked, lastTurnDefended;
    private boolean beingAttacked;

    /*
        TODO: need to add a MoveEvent for if source sees target but isn't in melee range yet
     */
    public Queue<ActionEvent> GenerateEvents(CombatGameUnit g) {
        event = new LinkedList<ActionEvent>();

        if (g.hasCombatTarget()) {
            if (collisionUtility.checkCombatCollision(g, g.getCombatTarget())) {
                event.add(new CombatEvent(g, g.getCombatTarget()));
            }
        } else if (!g.getEnemyGameUnitsInLOS().isEmpty()) {
            g.setCombatTarget(g.getEnemyGameUnitsInLOS().get(0));
            g.setHasCombatTarget(true);
            event.add(new CombatEvent(g, g.getCombatTarget()));
        } else {
            event.add(new MoveEvent(g, g.getCombatTarget()));
        }
        return event;
    }

    public EventGenerator() {
        collisionUtility = new CollisionUtility();
    }

}
