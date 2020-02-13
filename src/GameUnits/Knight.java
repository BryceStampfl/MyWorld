package GameUnits;

import GUI.ImageManager;
import Utility.*;

import java.util.ArrayList;
import java.util.Random;

/*
Knight class for my game. Intended to be the basic melee units
 */
public class Knight extends CombatGameUnit {
    private final double visionRange = 200;
    private final double attackRange = 20;
    private final double size = 50;
    private final double walkDistance = 0.5;
    private final int attackCoolDownInSeconds = 2000;
    private final int moveCoolDownInSeconds = 10;

    private final int baseAttack = 5;
    private final int baseHealth = 10;
    private final int baseDefense = 2;

    private EventGenerator eventGenerator;

    public void update(ArrayList<CombatGameUnit> listOfAllUnits) {
        setEnemyGameUnitsInLOS(new CollisionUtility().updateEnemyUnitsInLOS(this, listOfAllUnits));
        new EventGenerator().GenerateEvent(this).processEvent();
        //setEventAction(eventGenerator.GenerateEvent(this));
        // getEvent().processEvent();
    }


    public Knight(int nationID, Point castleLocation) {
        setImageView(ImageManager.getInstance().getImage(nationID, getClass().getSimpleName()));
        setAttackTimer(attackCoolDownInSeconds);
        setMoveTimer(moveCoolDownInSeconds);
        setCastleLocation(castleLocation);
        setLocation(castleLocation);
        setNationID(nationID);
        setCombatAttributes();
    }

    public Knight(int nationID, Point castleLocation, Point spawn) {
        this(nationID, castleLocation);
        setMoveLocation(castleLocation);
        setLocation(spawn);
    }

    void setCombatAttributes() {
        setAtt(new Random().nextInt(baseAttack) + baseAttack);
        setHp(new Random().nextInt(baseHealth) + baseHealth);
        setDef(new Random().nextInt(baseHealth) + baseDefense);
        setVisionRange(visionRange);
        setWalkDistance(walkDistance);
        setAttackRange(attackRange);
        setSize(size);
        setHasCombatTarget(false);
        eventGenerator = new EventGenerator();
    }

}
