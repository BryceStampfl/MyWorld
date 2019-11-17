import java.util.ArrayList;
import java.util.Random;

public class Nation {
    private String name;
    private Castle castle;
    private ArrayList<WorkerUnit> workers;
    private ArrayList<GameUnit> army;
    private final int INIT_NUM_WORKERS = 10;
    private final int INIT_NUM_ARMY = 10;
    private int id;


    public Nation(String name, int id){
        this.name = name;
        this.id = id;
        this.workers = initWorkers();
        this.army = initArmy();
        castle = new Castle((new Random().nextInt(1500)),
                 (new Random().nextInt(800)), id);
    }

    public String getName(){
        return this.name;
    }

    private ArrayList<WorkerUnit> initWorkers(){
        workers = new ArrayList<WorkerUnit>();
        for (int i = 0; i < INIT_NUM_WORKERS; i++){
            workers.add(new WorkerUnit());
        }
        return workers;
    }

    private ArrayList<GameUnit> initArmy(){
        army = new ArrayList<GameUnit>();
        for(int i = 0; i < INIT_NUM_ARMY; i++){
            army.add(new Soldier());
        }
        return army;
    }

    public Castle getCastle(){
        return this.castle;
    }

    public ArrayList<GameUnit> getArmy(){
        return army;
    }

    public void update(){
        updateArmy();
        updateWorkers();
        updateCastle();
    }
    private void updateArmy(){
        for (GameUnit g : army){
            g.update();
        }
    }
    private void updateWorkers(){

    }
    private void updateCastle(){
        this.castle.update();
    }

}
