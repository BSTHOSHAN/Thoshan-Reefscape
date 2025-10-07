package frc.robot.Subsystems.Elevator;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Elevator.ElevotorConstants.*;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Distance;

public class ElevatorIONeo implements ElevatorIO{
    TalonFX leftMotor;
    TalonFX rightMotor;
    PIDController elevatorController;
    Distance targetHeight;

    public ElevatorIONeo() {

        leftMotor = new TalonFX(1);
        rightMotor = new TalonFX(0);

        elevatorController = ELEVATOR_CONTROLLER.get();
    }

    @Override
    public void setHieght(Distance targetHeight) {
        var position = leftMotor.getPosition().getValue().in(Degree);
        leftMotor.set(elevatorController.calculate(leftMotor.getPosition().getValueAsDouble() * METERS_PER_ROTATION.in(Meters), targetHeight.in(Meters) * -1));
        rightMotor.set(elevatorController.calculate(rightMotor.getPosition().getValueAsDouble() * METERS_PER_ROTATION.in(Meters), targetHeight.in(Meters)));

    }
    @Override
    public void logData() {
        Logger.recordOutput("Elevator/ Target Height", targetHeight);
        Logger.recordOutput("Elevator/ Left Motor", leftMotor.getPosition().getValueAsDouble());
        Logger.recordOutput("Elevator/ Right Motor", rightMotor.getPosition().getValueAsDouble());
    }
}
