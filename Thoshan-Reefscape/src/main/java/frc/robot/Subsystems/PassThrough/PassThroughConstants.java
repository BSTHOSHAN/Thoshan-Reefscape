package frc.robot.Subsystems.PassThrough;

import static edu.wpi.first.units.Units.Degree;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.GlobalConstants.ROBOT_MODE;

import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public class PassThroughConstants {
    public static final AngularVelocity IDLE_WHEEL_SPEED = RotationsPerSecond.of(0);
    public static final AngularVelocity INTAKING_WHEEL_SPEED = RotationsPerSecond.of(-0.7);

    public static final int POSITION_MOTOR_ID = 29;

    	public static final Supplier<PIDController> WHEEL_SPEED_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};

}
