package frc.robot.Subsystems.Coraler;


import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Coraler.CoralerConstants.*;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;

public class CoraleIOReal implements CoralerIO{
    TalonFX wheelMotor;
    PIDController wheelController;
    AngularVelocity targetSpeed;

    public CoraleIOReal() {
        wheelMotor = new TalonFX(WHEEL_MOTOR_ID);
        wheelController = WHEEL_CONTROLLER.get();
    }

    @Override
    public void setWheelSpeed(AngularVelocity wheelSpeed) {
        targetSpeed = wheelSpeed;
        wheelMotor.set(wheelController.calculate(wheelMotor.getVelocity().getValueAsDouble() / 60, wheelSpeed.in(RotationsPerSecond)));
    }

    @Override
    public void logData() {
        Logger.recordOutput("Coaraler/Wheel Speed", wheelMotor.getVelocity().getValueAsDouble());
        Logger.recordOutput("Coaraler/Target Speed", targetSpeed);
    }


}
