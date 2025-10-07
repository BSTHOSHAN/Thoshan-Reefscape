package frc.robot.Subsystems.PassThrough;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.PassThrough.PassThroughConstants.*;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.AngularVelocityUnit;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class PassThroughIONeo implements PassThroughIO{
    SparkMax climberMotor;
    PIDController climbController;
    AngularVelocity targetSpeed;

    public PassThroughIONeo() {
        climberMotor = new SparkMax( POSITION_MOTOR_ID, MotorType.kBrushless);

        climbController = WHEEL_SPEED_CONTROLLER.get();
    }

    @Override
    public void setWheelSpeed(AngularVelocity WheelSpeed) {
        targetSpeed = WheelSpeed;
        climberMotor.set(climbController.calculate(climberMotor.getAbsoluteEncoder().getVelocity() / 60, targetSpeed.in(RotationsPerSecond)));
    }

    @Override
    public void logData() {
        Logger.recordOutput("Climber/Wheel Speed", climberMotor.getAbsoluteEncoder().getVelocity());
        Logger.recordOutput("Climber/Target Position", targetSpeed);
    }
    


}
