package GameUnits;

import Utility.Point;

import java.util.ArrayList;
import java.util.Random;

public class Nation {
    private final int INIT_NUM_ARMY = 20;

    private int nationID;
    private String name;
    private Castle castle;
    private ArrayList<CombatGameUnit> army;

    public Nation(String name, int nationID) {
        this.name = name;
        this.nationID = nationID;
        castle = new Castle(nationID,
                new Point(new Random().nextInt(1500), new Random().nextInt(800)));
        army = initArmyRandom();
    }

    public Nation(String name, int nationID, Point location) {
        this.name = name;
        this.nationID = nationID;
        castle = new Castle(nationID,location);
        army = initArmyRandom();
    }


    private ArrayList<CombatGameUnit> initArmy() {
        army = new ArrayList<CombatGameUnit>();
        for (int i = 0; i < INIT_NUM_ARMY; i++) {
            army.add(new Knight(nationID, castle.getLocation()));
        }
        return army;
    }

    private ArrayList<CombatGameUnit> initArmyRandom() {
        army = new ArrayList<CombatGameUnit>();
        for (int i = 0; i < INIT_NUM_ARMY; i++) {
            army.add(new Knight(nationID, castle.getLocation(), (new Point((new Random().nextInt(1500)), (new Random().nextInt(1500))))));
        }
        return army;
    }

    public Castle getCastle() {
        return this.castle;
    }

    public ArrayList<CombatGameUnit> getArmy() {
        return army;
    }

    public void update() {
        updateArmy();
        updateCastle();

    }

    private void updateArmy() {

        for (CombatGameUnit g : army) {
            if (!g.hasCombatTarget()) {
                g.updateLocation();
            } else {
                g.updateCombat();
            }
        }

    }

    private void updateCastle() {
        this.castle.update();
    }



}
