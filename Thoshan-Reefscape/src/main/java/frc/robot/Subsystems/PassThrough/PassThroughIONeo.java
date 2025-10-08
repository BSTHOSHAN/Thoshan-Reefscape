package frc.robot.Subsystems.PassThrough;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.PassThrough.PassThroughConstants.*;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.AngularVelocityUnit;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class PassThroughIONeo implements PassThroughIO{
    TalonFX climberMotor;
    PIDController climbController;
    AngularVelocity targetSpeed;

    public PassThroughIONeo() {
        climberMotor = new TalonFX(PASS_THROUGH_MOTOR_ID);

        climbController = WHEEL_SPEED_CONTROLLER.get();
    }

    @Override
    public void setWheelSpeed(AngularVelocity WheelSpeed) {
        targetSpeed = WheelSpeed;
        climberMotor.set(climbController.calculate(climberMotor.getVelocity().getValueAsDouble() / 60, targetSpeed.in(RotationsPerSecond)));
    }

    @Override
    public void logData() {
        Logger.recordOutput("Climber/Wheel Speed", climberMotor.getVelocity().getValueAsDouble());
        Logger.recordOutput("Climber/Target Position", targetSpeed);
    }
    


}
