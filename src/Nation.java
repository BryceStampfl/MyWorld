import java.util.ArrayList;

public class Nation {
    private String name;
    private ArrayList<workerUnit> workers;
    private ArrayList<GameUnit> Army;



    public Nation(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
