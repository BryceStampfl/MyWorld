import java.util.ArrayList;

public class Nation {
    private String name;
    private ArrayList<WorkerUnit> workers;
    private ArrayList<GameUnit> Army;



    public Nation(String name){
        this.name = name;

    }

    public String getName(){
        return this.name;
    }

    private ArrayList<WorkerUnit> initWorkers(){
        

        return workers;
    }

}
