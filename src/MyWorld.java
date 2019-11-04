import java.util.ArrayList;
import java.util.Random;


public class MyWorld {
Random r;
private ArrayList<Nation> nations;


public MyWorld(){
        r = new Random(500);
        nations = initNations();
    }

    private ArrayList<Nation> initNations(){
        ArrayList<Nation> nations = new ArrayList<Nation>();
        for(int i = 0; i < 3; i++){
            nations.add(new Nation("Nation" + (i+1) ));
        }
        return nations;
    }




}
