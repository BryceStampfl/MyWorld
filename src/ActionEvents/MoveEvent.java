package ActionEvents;

import GameUnits.CombatGameUnit;
import Utility.MoveUtility;
import Utility.Point;

public class MoveEvent implements ActionEvent {
    private MoveUtility moveUtility;
    private Point moveToLocation;


    public void processEvent(CombatGameUnit source){
        source.setLocation(moveToLocation);
    }

    public MoveEvent(CombatGameUnit start, CombatGameUnit end){
        moveUtility = new MoveUtility();
         moveToLocation = moveUtility.getPointTowardsTarget(start.getLocation(), end.getLocation(), start.getWalkDistance());
    }
}

