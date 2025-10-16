package frc.robot.Subsystems.Coraler;

import static frc.robot.Subsystems.Coraler.CoralerConstants.*;

import org.team7525.subsystem.SubsystemStates;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.Subsystem;


public enum CoralerStates implements SubsystemStates {
    IDLE(IDLE_WHEELVELOCITY),
    INTAKING(INTAKING_WHEELVELOCITY),
    SCORING(SCORING_WHEELVELOCITY);
    
    private AngularVelocity wheelSpeed;

    CoralerStates (AngularVelocity wheelSpeed) {
        this.wheelSpeed = wheelSpeed;
    }
    public AngularVelocity getWheelSpeed() {
        return wheelSpeed;
    }
}
