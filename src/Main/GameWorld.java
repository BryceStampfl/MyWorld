package Main;
import GameUnits.*;
import GameUnits.Nation;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class GameWorld {
    private ArrayList<Nation> nations;
    private final int NUM_NATIONS = 3;

    public GameWorld() {
        nations = initNations();
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
    public ArrayList<GameUnit> getAllUnits() {
        ArrayList<GameUnit> temp = new ArrayList<GameUnit>();

        for (Nation nation : nations) {
            // temp.add(nations.get(i).getCastle());
            temp.addAll(nation.getArmy());
        }
        for (Nation nation : nations) {
            temp.add(nation.getCastle());
        }
        return (temp);
    }

    public ArrayList<ImageView> getDrawables(){
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
        for (Nation n : nations) {
            n.update();
        }
    }
}
