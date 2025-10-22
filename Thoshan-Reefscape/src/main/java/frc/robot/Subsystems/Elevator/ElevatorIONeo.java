package frc.robot.Subsystems.Elevator;

import static edu.wpi.first.units.Units.Meters;
import static frc.robot.Subsystems.Elevator.ElevotorConstants.*;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Distance;

public class ElevatorIONeo implements ElevatorIO{
    TalonFX leftMotor;
    TalonFX rightMotor;
    PIDController elevatorController;
    Distance targetHeight;

    public ElevatorIONeo() {

        leftMotor = new TalonFX(12);
        rightMotor = new TalonFX(13);

        elevatorController = ELEVATOR_CONTROLLER.get();
    }

    @Override
    public void setHeight(Distance targetHeight) {
        leftMotor.set(elevatorController.calculate(leftMotor.getPosition().getValueAsDouble() * METERS_PER_ROTATION.in(Meters), targetHeight.in(Meters)));
        rightMotor.set(leftMotor.get());

    }
    @Override
    public void logData() { 
        Logger.recordOutput("Elevator/ Target Height", targetHeight);
        Logger.recordOutput("Elevator/ Left Motor", leftMotor.getPosition().getValueAsDouble());
        Logger.recordOutput("Elevator/ Right Motor", rightMotor.getPosition().getValueAsDouble());
    }
}
