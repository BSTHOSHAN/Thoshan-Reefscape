package frc.robot.Subsystems.Climber;

import static edu.wpi.first.units.Units.Degree;
import static frc.robot.GlobalConstants.ROBOT_MODE;

import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;

public class ClimberConstants {
    public static final Angle UP_POSITION = Degree.of(90);
    public static final Angle DOWN_POSITION = Degree.of(0);

    public static final int POSITION_MOTOR_ID = 1;

    	public static final Supplier<PIDController> POSITION_CONTROLLER = () ->
		switch (ROBOT_MODE) {
			case REAL -> new PIDController(0.1, 0, 0);
			case TESTING -> new PIDController(0.1, 0, 0);
		};

}
