package frc.robot.Subsystems.Coraler;

import edu.wpi.first.units.measure.AngularVelocity;

public interface CoralerIO {

    void setWheelSpeed(AngularVelocity wheelSpeed); 
    
    void logData();
}
