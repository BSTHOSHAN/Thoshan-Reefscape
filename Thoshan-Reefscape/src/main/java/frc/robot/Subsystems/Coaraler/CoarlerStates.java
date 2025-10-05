package frc.robot.Subsystems.Coaraler;

import static frc.robot.Subsystems.Coaraler.CoaralerConstants.*;

import org.team7525.subsystem.SubsystemStates;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.Subsystem;


public enum CoarlerStates implements SubsystemStates {
    IDLE(IDLE_WHEELVELOCITY),
    INTAKING(INTAKING_WHEELVELOCITY),
    SCORING(SCORING_WHEELVELOCITY);
    
    private AngularVelocity wheelSpeed;

    CoarlerStates (AngularVelocity wheeSpeed) {
        this.wheelSpeed = wheelSpeed;
    }
    public AngularVelocity getWheelSpeed() {
        return wheelSpeed;
    }
}
