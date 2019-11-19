
import java.util.ArrayList;

public class GameWorld {
    private ArrayList<Nation> nations;
    private final int NUM_NATIONS = 3;

    public GameWorld() {
        nations = initNations();
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
    public ArrayList<? extends Drawable> getDrawables() {
        ArrayList<GameUnit> temp = new ArrayList<GameUnit>();

        for (int i = 0; i < nations.size(); i++) {
            // temp.add(nations.get(i).getCastle());
            for (GameUnit g : nations.get(i).getArmy()) {
                temp.add(g);
            }
        }
        for (int i = 0; i < nations.size(); i++) {
            temp.add(nations.get(i).getCastle());
        }
        return (temp);
    }

    public void update() {
        for (Nation n : nations) {
            n.update();
        }
    }
}
