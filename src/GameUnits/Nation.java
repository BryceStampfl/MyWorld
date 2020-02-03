package GameUnits;

import Utility.Point;

import java.util.ArrayList;
import java.util.Random;

public class Nation {
    private final int INIT_NUM_WORKERS = 10;
    private final int INIT_NUM_ARMY = 100;

    private String name;
    private Castle castle;
    private ArrayList<WorkerUnit> workers;
    private ArrayList<GameUnit> army;
    private int nationID;

    public Nation(String name, int nationID){
        this.name = name;
        this.nationID = nationID;
        castle = new Castle(nationID,
                new Point(new Random().nextInt(1500),new Random().nextInt(800)));
        workers = initWorkers();
        army = initArmyRandom();

    }

    public Nation(String name, int nationID, Point location){
        this.name = name;
        this.nationID = nationID;
        castle = new Castle(nationID,
                new Point(new Random().nextInt(1500),new Random().nextInt(800)));
        workers = initWorkers();
        army = initArmyRandom();

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
            army.add(new Knight(nationID, castle.getLocation()));
        }
        return army;
    }

    private ArrayList<GameUnit> initArmyRandom(){
        army = new ArrayList<GameUnit>();
        for(int i = 0; i < INIT_NUM_ARMY; i++){
            army.add(new Knight(nationID, castle.getLocation(),(new Point((new Random().nextInt(10000)), (new Random().nextInt(10000))))));
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
