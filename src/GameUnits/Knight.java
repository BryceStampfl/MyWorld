package GameUnits;

import GUI.ImageManager;
import Utility.*;

/*
Knight class for my game. Intended to be the basic melee units
 */
public class Knight extends GameUnit {
    private Point castleLocation;

    public void update() {
        MoveUtility util = new MoveUtility();
        Point newLoc = util.getPointTowardsTarget(getLocation(), castleLocation, getMoveSpeed());
        setLocation(newLoc);
    }

    public Knight(int nationID, Point castleLocation) {
        setImageView(ImageManager.getInstance().getImage(nationID, getClass().getSimpleName())); ;
        this.castleLocation = castleLocation;
        setLocation(castleLocation);
        setNationID(nationID);
        setMoveSpeed(5);
    }

    public Knight(int nationID, Point castleLocation, Point spawn) {
        setImageView(ImageManager.getInstance().getImage(nationID, getClass().getSimpleName())); ;
        this.castleLocation = castleLocation;
        setLocation(spawn);
        setNationID(nationID);
        setMoveSpeed(1);
    }

}
