package frc.robot.Subsystems.Coraler;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Subsystems.Coraler.CoralerConstants.*;

import org.littletonrobotics.junction.Logger;

public class CoralerIOSim implements CoralerIO {

    FlywheelSim wheels;
    PIDController wheelController;
    AngularVelocity targetSpeed;


    public CoralerIOSim() {
        wheels = new FlywheelSim(
			LinearSystemId.createFlywheelSystem(DCMotor.getNEO(2), 1, 1),
			DCMotor.getNEO(2)
		);

		wheelController = WHEEL_CONTROLLER.get();
		targetSpeed = RotationsPerSecond.zero();
    }

    @Override
    public void setWheelSpeed(edu.wpi.first.units.measure.AngularVelocity wheelSpeed) {
        wheels.setInputVoltage(12 *  wheelController.calculate(
				wheels.getAngularVelocityRPM() / 60,
				wheelSpeed.in(RotationsPerSecond)
			)
		);
        targetSpeed = wheelSpeed;
        
    }

    @Override
    public void logData() {
        wheels.update(0.02);
        Logger.recordOutput("Coraler/Wheel Speed", wheels.getAngularVelocityRPM() / 60);
        Logger.recordOutput("Coraler/Target Speed", targetSpeed.in(RotationsPerSecond));
        
    }
    
}
