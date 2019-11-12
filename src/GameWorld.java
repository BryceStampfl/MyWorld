
import java.util.ArrayList;

public class GameWorld {
private ArrayList<Nation> nations;
private final int NUM_NATIONS = 4;

public GameWorld(){
    nations = initNations();
    }

    private ArrayList<Nation> initNations(){
        ArrayList<Nation> nations = new ArrayList<Nation>();
        for(int i = 0; i < NUM_NATIONS; i++){
            nations.add(new Nation(("Nation" + (i+1)), i ));
        }
        return nations;
    }

    // For now only the militaristic game units will be drawable.
    // To get the drawable objects we go through each nation and get all the units.
    //TODO add other units besides castles to the game screen
    public ArrayList<? extends Drawable> getDrawables() {
        ArrayList<GameUnit> temp = new ArrayList<GameUnit>();
        for(int i = 0; i < nations.size();i++){
            temp.add(nations.get(i).getCastle());
        }
        return (temp);

    }
}
