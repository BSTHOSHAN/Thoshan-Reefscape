package frc.robot.Subsystems.Elavator;

import org.team7525.subsystem.SubsystemStates;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Distance;

import static frc.robot.Subsystems.Elavator.ElavotorConstants.*;

public enum ElavotorStates implements SubsystemStates{
    IDLE(IDLE_HEIGHT),
    L1(L1_HEIGHT),
    L2(L2_HEIGHT),
    L3(L3_HEIGHT),
    ALGAE_HIGH(ALGAE_HIGH_HEIGHT),
    L4(L4_HEIGHT),
    CLIMBING(CLIMBING_HEIGHT),
    ALGAE_LOW(ALGAE_LOW_HEIGHT);

    private Distance position;

    private ElavotorStates(Distance position) {
        this.position = position;
    }

    public Distance getPosition() {
        return position;
    }
}
