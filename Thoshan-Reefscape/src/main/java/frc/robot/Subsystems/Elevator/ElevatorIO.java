package frc.robot.Subsystems.Elevator;

import edu.wpi.first.units.measure.Distance;

public interface ElevatorIO {
    void setHeight(Distance Height); //camelcase

    void logData();
}
