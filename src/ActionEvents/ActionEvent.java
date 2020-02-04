package ActionEvents;

import GameUnits.CombatGameUnit;

public interface ActionEvent {
    void processEvent(CombatGameUnit source);
}
