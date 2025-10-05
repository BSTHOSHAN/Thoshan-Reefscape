package frc.robot.Subsystems.Climber;

import edu.wpi.first.units.measure.Angle;

import static frc.robot.Subsystems.Climber.ClimberConstants.*;

import org.team7525.subsystem.SubsystemStates;


public enum ClimberStates implements SubsystemStates{
    UP(UP_POSITION),
    DOWN(DOWN_POSITION);

    private Angle position;
    ClimberStates (Angle position) {
        this.position = position;
    }

    public Angle getPosition() {
        return position;
    }
}
