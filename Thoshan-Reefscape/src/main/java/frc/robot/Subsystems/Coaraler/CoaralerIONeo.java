package frc.robot.Subsystems.Coaraler;


import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Coaraler.CoaralerConstants.*;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;

public class CoaralerIONeo implements CoaralerIO{
    SparkMax wheelMotor;
    PIDController wheelController;
    AngularVelocity targetSpeed;

    public CoaralerIONeo() {
        wheelMotor = new SparkMax(WHEEL_MOTOR_ID, MotorType.kBrushless);

        wheelController = WHEEL_CONTROLLER.get();
    }

    @Override
    public void setWheelSpeed(AngularVelocity wheelSpeed) {
        targetSpeed = wheelSpeed;

        wheelMotor.set(wheelController.calculate(wheelMotor.getAbsoluteEncoder().getVelocity() / 60, wheelSpeed.in(RotationsPerSecond)));

    }

    @Override
    public void logData() {
        Logger.recordOutput("Coaraler/Wheel Speed", wheelMotor.getAbsoluteEncoder().getVelocity());
        Logger.recordOutput("Coaraler/Target Speed", targetSpeed);
    }


}
