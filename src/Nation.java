import java.util.ArrayList;
import java.util.Random;

public class Nation {
    private String name;
    private ArrayList<WorkerUnit> workers;
    private ArrayList<GameUnit> army;
    private final int initialWorkerNumber = 10;
    private final int initialArmyNumber = 10;


    public Nation(String name){
        this.name = name;
        this.workers = initWorkers();
        this.army = initArmy();
    }

    public String getName(){
        return this.name;
    }

    private ArrayList<WorkerUnit> initWorkers(){
        workers = new ArrayList<WorkerUnit>();
        for (int i = 0; i < initialWorkerNumber; i++){
            workers.add(new WorkerUnit());
        }
        return workers;
    }

    private ArrayList<GameUnit> initArmy(){
        army = new ArrayList<GameUnit>();
        for(int i = 0; i < initialArmyNumber; i++){
            army.add(new Solider());
        }
        return army;
    }

}
