package frc.robot.Subsystems.Climber;

import edu.wpi.first.units.measure.Angle;

public interface ClimberIO {
    public void setPosition(Angle position);

    public void logData();
}
