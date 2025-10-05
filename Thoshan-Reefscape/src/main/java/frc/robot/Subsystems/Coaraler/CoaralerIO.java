package frc.robot.Subsystems.Coaraler;

import edu.wpi.first.units.measure.AngularVelocity;

public interface CoaralerIO {

    void setWheelSpeed(AngularVelocity wheelSpeed); 
    
    void logData();
}
