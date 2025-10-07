package frc.robot.Subsystems.Elevator;

import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Meters;
import static frc.robot.GlobalConstants.ROBOT_MODE;

import java.util.function.Supplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.Distance;

public class ElevotorConstants {

	public static final DCMotor GEARBOX = DCMotor.getKrakenX60(2);
	public static final double GEARING = 9;
	public static final Distance DRUM_RADIUS = Inches.of(1.751).div(2);

    public static final Distance L4_HEIGHT = Inches.of(23.2);
	public static final Distance L3_HEIGHT = Inches.of(14.5);
	public static final Distance L2_HEIGHT = Inches.of(9.5);
	public static final Distance L1_HEIGHT = Inches.of(6.1);
    public static final Distance IDLE_HEIGHT = Inches.of(0);
    public static final Distance ALGAE_LOW_HEIGHT = Inches.of(0);
    public static final Distance ALGAE_HIGH_HEIGHT = Inches.of(0);
    public static final Distance CLIMBING_HEIGHT = Inches.of(0);

	public static final Distance METERS_PER_ROTATION = Meters.of((1 / GEARING) * (2 * Math.PI * DRUM_RADIUS.in(Meters)));	


    public static final Supplier<PIDController> ELEVATOR_CONTROLLER = () ->
	switch (ROBOT_MODE) {
		case REAL -> new PIDController(0.1, 0, 0);
		case TESTING -> new PIDController(0.1, 0, 0);
	};


}
