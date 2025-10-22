package frc.robot.Subsystems.PassThrough;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.PassThrough.PassThroughConstants.*;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;

public class PassThroughIONeo implements PassThroughIO{
    // Change variable names so that it's not climber
    TalonFX PassMotor;
    PIDController PassController;
    AngularVelocity targetSpeed;

    public PassThroughIONeo() {
        PassMotor = new TalonFX(PASS_THROUGH_MOTOR_ID);

        PassController = WHEEL_SPEED_CONTROLLER.get();
    }

    @Override
    public void setWheelSpeed(AngularVelocity WheelSpeed) {
        targetSpeed = WheelSpeed;
        PassMotor.set(PassController.calculate(PassMotor.getVelocity().getValueAsDouble() / 60, targetSpeed.in(RotationsPerSecond)));
    }

    @Override
    public void logData() {
        Logger.recordOutput("Climber/Wheel Speed", PassMotor.getVelocity().getValueAsDouble());
        Logger.recordOutput("Climber/Target Position", targetSpeed);
    }
    


}
