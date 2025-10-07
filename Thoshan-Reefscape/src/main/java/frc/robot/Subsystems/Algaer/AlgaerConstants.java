// package frc.robot.Subsystems.Algaer;

// import static edu.wpi.first.units.Units.Degree;
// import static edu.wpi.first.units.Units.RotationsPerSecond;
// import static frc.robot.GlobalConstants.ROBOT_MODE;

// import java.util.function.Supplier;

// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.units.measure.Angle;
// import edu.wpi.first.units.measure.AngularVelocity;

// public class AlgaerConstants {
//     public static final AngularVelocity IDLE_WHEELSPEED = RotationsPerSecond.of(0);
//     public static final AngularVelocity INTAKING_WHEELSPEED = RotationsPerSecond.of(10);
//     public static final AngularVelocity SHOOTING_WHEELSPEED = RotationsPerSecond.of(-30);

//     public static final Angle IDLE_POSITION = Degree.of(0);
//     public static final Angle INTAKING_POSITION = Degree.of(90);
//     public static final Angle SHOOTING_POSITION = Degree.of(90);

//     public static final int WHEEL_MOTOR_ID = 1;
//     public static final int POSITION_MOTOR_ID = 2;

//     public static final Supplier<PIDController> POSITION_CONTROLLER = () ->
// 		switch (ROBOT_MODE) {
// 			case REAL -> new PIDController(0.1, 0, 0);
// 			case TESTING -> new PIDController(0.1, 0, 0);
// 	};

//     public static final Supplier<PIDController> WHEEL_CONTROLLER = () ->
//     switch (ROBOT_MODE) {
//         case REAL -> new PIDController(0.1, 0, 0);
//         case TESTING -> new PIDController(0.1, 0, 0);
// };

// }
