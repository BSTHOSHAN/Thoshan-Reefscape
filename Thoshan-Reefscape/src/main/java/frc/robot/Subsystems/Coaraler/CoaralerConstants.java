package frc.robot.Subsystems.Coaraler;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.GlobalConstants.ROBOT_MODE;

import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.AngularVelocity;

public class CoaralerConstants {
    public static final AngularVelocity IDLE_WHEELVELOCITY = RotationsPerSecond.of(0);
    public static final AngularVelocity INTAKING_WHEELVELOCITY = RotationsPerSecond.of(10);
    public static final AngularVelocity SCORING_WHEELVELOCITY = RotationsPerSecond.of(30);

    public static final int WHEEL_MOTOR_ID = 1;

    public static final Supplier<PIDController> WHEEL_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
	};

    
}
