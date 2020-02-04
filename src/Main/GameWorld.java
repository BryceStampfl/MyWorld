package Main;

import GameUnits.*;
import GameUnits.Nation;
import Utility.CollisionUtility;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GameWorld {
    private ArrayList<Nation> nations;
    private CollisionUtility collisionUtility;
    private final int NUM_NATIONS = 3;

    public GameWorld() {
        nations = initNations();
        collisionUtility = new CollisionUtility();
    }

    private ArrayList<Nation> initRandomNations() {
        ArrayList<Nation> nations = new ArrayList<Nation>();
        for (int i = 0; i < NUM_NATIONS; i++) {
            nations.add(new Nation(("Nation" + (i)), i));
        }
        return nations;
    }

    private ArrayList<Nation> initNations() {
        ArrayList<Nation> nations = new ArrayList<Nation>();
        for (int i = 0; i < NUM_NATIONS; i++) {
            nations.add(new Nation(("Nation" + (i)), i));
        }
        return nations;
    }

    // For now only the militaristic game units will be drawable.
    //TODO add other units besides castles to the game screen
    public ArrayList<CombatGameUnit> getAllUnits() {
        ArrayList<CombatGameUnit> temp = new ArrayList<CombatGameUnit>();

        for (Nation nation : nations) {
            temp.addAll(nation.getArmy());
        }
        return (temp);
    }

    public ArrayList<ImageView> getDrawables() {
        ArrayList<ImageView> temp = new ArrayList<ImageView>();
        for (Nation nation : nations) {
            for (GameUnit g : nation.getArmy()) {
                temp.add(g.getImageView());
            }
        }
        for (Nation nation : nations) {
            temp.add(nation.getCastle().getImageView());
        }
        return temp;
    }

    public void update() {
        // checkForCollisions();
        for (Nation n : nations) {
            n.update(getAllUnits());
        }
    }
}