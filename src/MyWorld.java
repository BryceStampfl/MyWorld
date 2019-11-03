import java.util.ArrayList;


public class MyWorld {

private ArrayList<Nation> nations;


public MyWorld(){
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
