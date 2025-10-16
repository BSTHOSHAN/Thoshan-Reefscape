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
			LinearSystemId.createFlywheelSystem(DCMotor.getNEO(2), 1, 1),
			DCMotor.getNEO(2)
		);
        wheelController = WHEEL_SPEED_CONTROLLER.get();
        targetSpeed = RotationsPerSecond.zero();
    }


    @Override
    public void setWheelSpeed(edu.wpi.first.units.measure.AngularVelocity wheelSpeed) {
        wheels.setInputVoltage(
			MAX_VOLTAGE *
			wheelController.calculate(
				wheels.getAngularVelocityRPM() / 60,
				wheelSpeed.in(RotationsPerSecond)
			)
		);
    }

    @Override
    public void logData() {
        Logger.recordOutput("PassThrough/Wheel Speed", wheels.getAngularVelocityRPM() / 60);
        Logger.recordOutput("PassThrough/Target Speed", targetSpeed);
    }
}
