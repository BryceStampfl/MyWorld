package GameUnits;

import java.util.ArrayList;
import java.util.Random;

public class Nation {
    private String name;
    private Castle castle;
    private ArrayList<WorkerUnit> workers;
    private ArrayList<GameUnit> army;
    private final int INIT_NUM_WORKERS = 10;
    private final int INIT_NUM_ARMY = 2;
    private int id;

    public Nation(String name, int id){
        this.name = name;
        this.id = id;
        castle = new Castle((new Random().nextInt(1500)),
                (new Random().nextInt(800)), id);
        this.workers = initWorkers();
        this.army = initArmy(id);

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

    private ArrayList<GameUnit> initArmy(int id){
        army = new ArrayList<GameUnit>();
        for(int i = 0; i < INIT_NUM_ARMY; i++){
            army.add(new Soldier(id,castle.getXPos()+i*50, castle.getYPos()));
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
