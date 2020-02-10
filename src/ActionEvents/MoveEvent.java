package ActionEvents;

import GameUnits.CombatGameUnit;
import Utility.MoveUtility;
import Utility.Point;

public class MoveEvent implements ActionEvent {
    private MoveUtility moveUtility;
    private Point moveToLocation;


    public void processEvent(CombatGameUnit source){
        moveUtility = new MoveUtility();
        //source.setLocation(moveToLocation);
        //Right now the move location is the castle
        source.setLocation(moveUtility.getPointTowardsTarget(source.getLocation(),source.getMoveLocation(),source.getWalkDistance()));
    }

    public MoveEvent(CombatGameUnit start, CombatGameUnit end){
        moveUtility = new MoveUtility();
         moveToLocation = moveUtility.getPointTowardsTarget(start.getLocation(), end.getLocation(), start.getWalkDistance());
    }
    public MoveEvent(CombatGameUnit start){
        moveUtility = new MoveUtility();
        moveToLocation = moveUtility.getPointTowardsTarget(start.getLocation(), start.getMoveLocation(), start.getWalkDistance());
    }
}

