package Utility;

import GameUnits.CombatGameUnit;

import java.util.ArrayList;
import java.util.Random;

public class CollisionUtility {
    private double deltaX, deltaY;
    private PositionUtility pos;

    public CollisionUtility(){
        pos = new PositionUtility();
    }


    public ArrayList<CombatGameUnit> updateEnemyUnitsInLOS(CombatGameUnit source, ArrayList<CombatGameUnit> listOfAllUnits) {
        CollisionUtility collisionUtility = new CollisionUtility();
        ArrayList<CombatGameUnit> enemyUnitsInLOS = new ArrayList<>();
        for (CombatGameUnit cgu : listOfAllUnits) {
            if (!source.equals(cgu) && source.getNationID() != cgu.getNationID()) {
                if (collisionUtility.hasVisionOf(source, cgu)) {
                    enemyUnitsInLOS.add(cgu);
                }
            }
        }
        if (enemyUnitsInLOS.size() > 1) {
            return sortArrayListBubble(source, enemyUnitsInLOS);
        }
        return enemyUnitsInLOS;

    }

    public boolean hasVisionOf(CombatGameUnit source, CombatGameUnit target) {
        deltaX = pos.getDeltaX(source.getLocation(), target.getLocation());
        deltaY = pos.getDeltaY(source.getLocation(), target.getLocation());
        return (deltaX <= source.getVisionRange() && deltaY <= source.getVisionRange());
    }


    public boolean isInAttackRange(CombatGameUnit source, CombatGameUnit target) {
        deltaX = pos.getDeltaX(source.getLocation(), target.getLocation());
        deltaY = pos.getDeltaY(source.getLocation(), target.getLocation());
        return deltaX <= source.getAttackRange() && deltaY <= source.getAttackRange();
    }

    public ArrayList<CombatGameUnit> sortArrayList(CombatGameUnit source, ArrayList<CombatGameUnit> listOfAllUnits) {

        if (listOfAllUnits.size() < 2) {
            return listOfAllUnits;
        }
        int pivotIndex = (new Random().nextInt(listOfAllUnits.size() - 1));
        CombatGameUnit pivot = listOfAllUnits.get(pivotIndex);
        double pivotVal = pos.getDeltaX(source.getLocation(), pivot.getLocation()) + pos.getDeltaY(source.getLocation(), pivot.getLocation());

        ArrayList<CombatGameUnit> lessThan = new ArrayList<>();
        ArrayList<CombatGameUnit> greaterThan = new ArrayList<>();

        for (CombatGameUnit unit : listOfAllUnits) {
            if (!unit.equals(pivot)) {
                double unitVal = pos.getDeltaX(source.getLocation(), unit.getLocation()) + pos.getDeltaY(source.getLocation(), unit.getLocation());
                System.out.println("Pivot val = " + pivotVal + "   Unit val = " + unitVal);
                if (unitVal < pivotVal) {
                    lessThan.add(unit);
                } else {
                    greaterThan.add(unit);
                }
            }
        }
        ArrayList<CombatGameUnit> finalList = new ArrayList<>(sortArrayList(source, lessThan));
        finalList.add(pivot);
        finalList.addAll(sortArrayList(source, greaterThan));
        for (CombatGameUnit g : finalList) {
            System.out.print(" " + pos.getDeltaX(source.getLocation(), g.getLocation()) + pos.getDeltaY(source.getLocation(), g.getLocation()));
        }
        System.out.println();
        return finalList;

    }

    public ArrayList<CombatGameUnit> sortArrayListBubble(CombatGameUnit source, ArrayList<CombatGameUnit> listOfAllUnits) {
        boolean sorted = false;
        while (sorted == false) {
            sorted = true;

            for (int i = 0; i < listOfAllUnits.size() - 1; i++) {
                double indexNum = pos.getDeltaX(source.getLocation(), listOfAllUnits.get(i).getLocation()) + pos.getDeltaY(source.getLocation(), listOfAllUnits.get(i).getLocation());
                double nextIndexNum = pos.getDeltaX(source.getLocation(), listOfAllUnits.get(i + 1).getLocation()) + pos.getDeltaY(source.getLocation(), listOfAllUnits.get(i + 1).getLocation());

                if (indexNum > nextIndexNum) {
                    CombatGameUnit temp = listOfAllUnits.get(i);
                    listOfAllUnits.set(i, listOfAllUnits.get(i + 1));
                    listOfAllUnits.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return listOfAllUnits;
    }

}
