package frc.robot.Subsystems.PassThrough;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.PassThrough.PassThroughConstants.*;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class PassThroughIOSim implements PassThroughIO {

    FlywheelSim wheels;
    PIDController wheelController;
    AngularVelocity targetSpeed;

    public PassThroughIOSim() {
		wheels = new FlywheelSim(
			LinearSystemId.createFlywheelSystem(DCMotor.getNEO(1), 2, 1),
			DCMotor.getNEO(1)
		);
        wheelController = WHEEL_SPEED_CONTROLLER.get();

    }   


    @Override
    public void setWheelSpeed(AngularVelocity wheelSpeed) {
        targetSpeed = wheelSpeed;
        wheels.setInputVoltage(12 * wheelController.calculate(wheels.getAngularVelocityRPM() / 60, targetSpeed.in(RotationsPerSecond)));
    }

    @Override
    public void logData() {
        wheels.update(0.02);
        Logger.recordOutput("PassThrough/Calculation", wheelController.calculate( wheels.getAngularVelocityRPM() / 60, targetSpeed.in(RotationsPerSecond)));
        Logger.recordOutput("PassThrough/Wheel Speed", wheels.getAngularVelocityRPM() / 60);
        Logger.recordOutput("PassThrough/Target Speed", targetSpeed.in(RotationsPerSecond));
    }
}
