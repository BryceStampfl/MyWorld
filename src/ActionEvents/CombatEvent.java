package ActionEvents;

import GameUnits.CombatGameUnit;

public class CombatEvent implements ActionEvent {
        private CombatGameUnit source;
        private CombatGameUnit target;

    public void processEvent(){
        if (source.isAttackCDTimerFinished()) {
            attack();
            source.startAttackTimer();
        }
    }

    public CombatEvent(CombatGameUnit source, CombatGameUnit target){
        this.source = source;
        this.target = target;
    }

    private void attack(){
        double attack = source.getAtt();
        double defense = target.getDef();
        double damage = attack - defense;


        if (target.getHp() - damage <= 0){
            targetKilled();
        }else {
            target.setHp(target.getHp() - damage);
        }
    }

    private void targetKilled(){
        source.setHasCombatTarget(false);
        source.incrementKills();
        target.setDead(true);


        source.getImageView().setFitHeight(source.getSize() * (source.getKills() +1));
        source.getImageView().setFitWidth(source.getSize() * (source.getKills() +1));
        source.setHp(10);
    }
}
