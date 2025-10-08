package frc.robot.Subsystems.PassThrough;

import edu.wpi.first.units.measure.AngularVelocity;

import static frc.robot.Subsystems.PassThrough.PassThroughConstants.*;

import org.team7525.subsystem.SubsystemStates;


public enum PassThroughStates implements SubsystemStates{
    IDLE(IDLE_WHEEL_SPEED),
    INTAKING(INTAKING_WHEEL_SPEED);

    private AngularVelocity WheelSpeed;
    PassThroughStates (AngularVelocity WheelSpeed) {
        this.WheelSpeed = WheelSpeed;
    }

    public AngularVelocity getWheelSpeed() {
        return WheelSpeed;
    }
}
