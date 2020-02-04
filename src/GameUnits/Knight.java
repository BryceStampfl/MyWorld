package GameUnits;

import GUI.ImageManager;
import Utility.*;
import jdk.jfr.Event;

import java.util.ArrayList;
import java.util.Random;

/*
Knight class for my game. Intended to be the basic melee units
 */
public class Knight extends CombatGameUnit {
    private final int attack = 2;
    private final int health = 10;
    private Point castleLocation;
    private CollisionUtility collisionUtility;
    private EventGenerator eventGenerator;

    public void update(ArrayList<CombatGameUnit> listOfAllUnits) {
        setEnemyGameUnitsInLOS(collisionUtility.updateEnemyUnitsInLOS(this, listOfAllUnits));
        System.out.println("Printing units in LOS for i" + this + listOfAllUnits.toString());
        eventGenerator.GenerateEvents(this);

        //Add ckean up
    }



    public Knight(int nationID, Point castleLocation) {
        setImageView(ImageManager.getInstance().getImage(nationID, getClass().getSimpleName()));
        this.castleLocation = castleLocation;
        setLocation(castleLocation);
        setNationID(nationID);
        setWalkDistance(1);
        setCombatAttributes();

    }

    public Knight(int nationID, Point castleLocation, Point spawn) {
        this(nationID, castleLocation);
        setLocation(spawn);
    }

    void setCombatAttributes() {
        setAtt(new Random().nextInt(10));
        setHp(new Random().nextInt(100));
        setVisionRange(50);
        collisionUtility = new CollisionUtility();
        eventGenerator = new EventGenerator();
    }

    private void attack() {
        getCombatTarget().setHp(getCombatTarget().getHp() - getAtt());
        setHp(getHp() - getCombatTarget().getAtt());
        if (getHp() <= 0) {
            // getCombatTarget().setHasCombatTarget(false);
        }
        if (getCombatTarget().getHp() <= 0) {
            // setHasCombatTarget(false);
        }
    }

    public void updateLocation() {
        if (!hasCombatTarget()) {
            MoveUtility util = new MoveUtility();
            Point newLoc = util.getPointTowardsTarget(getLocation(), castleLocation, getWalkDistance());
            setLocation(newLoc);
        }
    }

}
