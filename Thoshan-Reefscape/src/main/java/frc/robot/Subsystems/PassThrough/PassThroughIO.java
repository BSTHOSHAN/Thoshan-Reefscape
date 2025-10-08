package frc.robot.Subsystems.PassThrough;

import edu.wpi.first.units.measure.AngularVelocity;

public interface PassThroughIO {
    public void setWheelSpeed(AngularVelocity wheelSpeed);

    public void logData();
}
