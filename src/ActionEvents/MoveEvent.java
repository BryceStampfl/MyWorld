package ActionEvents;

import GameUnits.CombatGameUnit;
import Utility.MoveUtility;

public class MoveEvent implements ActionEvent {
    private CombatGameUnit source, target;


    public void processEvent() {
        MoveUtility moveUtility = new MoveUtility();
        if (source.isMoveCDTimerFinished()) {
            if (target == null) {
                //source.setLocation(moveUtility.getPointTowardsTarget(source.getLocation(), source.getMoveLocation(), source.getWalkDistance()));
                source.setLocation(moveUtility.getImprovedGetPointTowardsTarget(source));

            } else {
                //source.setLocation(moveUtility.getPointTowardsTarget(source.getLocation(), target.getMoveLocation(), source.getWalkDistance()));
                //source.setLocation(moveUtility.getPointTowardsTarget(source, target));
                source.setLocation(moveUtility.getImprovedGetPointTowardsTarget(source,target));
            }
            source.startMoveTimer();
        }
    }

    public MoveEvent(CombatGameUnit source) {
        this.source = source;
    }

    public MoveEvent(CombatGameUnit source, CombatGameUnit target) {
        this.source = source;
        this.target = target;
    }
}



