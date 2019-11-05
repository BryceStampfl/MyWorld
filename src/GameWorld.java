import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class GameWorld {
private ArrayList<Nation> nations;

public GameWorld(){
    nations = initNations();
    }

    private ArrayList<Nation> initNations(){
        ArrayList<Nation> nations = new ArrayList<Nation>();
        for(int i = 0; i < 3; i++){
            nations.add(new Nation("Nation" + (i+1) ));
        }
        return nations;
    }
    public ArrayList<Drawable> getDrawables(){
        return new ArrayList<Drawable>();
    }
}
