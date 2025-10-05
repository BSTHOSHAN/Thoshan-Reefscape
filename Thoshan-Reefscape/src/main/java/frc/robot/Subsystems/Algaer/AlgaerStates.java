package frc.robot.Subsystems.Algaer;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

import static frc.robot.Subsystems.Algaer.AlgaerConstants.*;

import org.team7525.subsystem.SubsystemStates;


public enum AlgaerStates implements SubsystemStates{
    IDLE(IDLE_WHEELSPEED, IDLE_POSITION),
    INTAKING(INTAKING_WHEELSPEED, INTAKING_POSITION),
    SHOOTING(SHOOTING_WHEELSPEED, SHOOTING_POSITION);

    AngularVelocity wheelSpeed;
    Angle position;

    AlgaerStates(AngularVelocity wheelSpeed, Angle position) {
        this.wheelSpeed = wheelSpeed;
        this.position = position;
    }

    public AngularVelocity getWheelSpeed() {
        return wheelSpeed;
    }
    public Angle getPosition() {
        return position;
    }
}
