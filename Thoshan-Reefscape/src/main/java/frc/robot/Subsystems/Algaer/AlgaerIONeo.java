// package frc.robot.Subsystems.Algaer;

// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.SparkLowLevel.MotorType;

// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.units.measure.Angle;
// import edu.wpi.first.units.measure.AngularVelocity;

// import static edu.wpi.first.units.Units.RotationsPerSecond;
// import static frc.robot.Subsystems.Algaer.AlgaerConstants.*;

// import org.littletonrobotics.junction.Logger;

// public class AlgaerIONeo implements AlgaerIO{
//     SparkMax wheelMotor;
//     SparkMax PivotMotor;
//     PIDController wheelController;
//     PIDController pivotController;
//     AngularVelocity targetSpeed;
//     Angle targetPosition;

//     public AlgaerIONeo() {
//         wheelMotor = new SparkMax( WHEEL_MOTOR_ID, MotorType.kBrushless);
//         PivotMotor = new SparkMax( POSITION_MOTOR_ID, MotorType.kBrushless);

//         wheelController = WHEEL_CONTROLLER.get();
//         pivotController = POSITION_CONTROLLER.get();
//     }

//     @Override
//     public void setPosition(Angle position) {
//         targetPosition = position;

//         PivotMotor.set(pivotController.calculate(PivotMotor.getAbsoluteEncoder().getPosition()));
//     }

//     @Override
//     public void setWheelSpeed(AngularVelocity wheelSpeed) {
//         targetSpeed = wheelSpeed;
//         wheelMotor.set(wheelController.calculate(wheelMotor.getAbsoluteEncoder().getVelocity() / 60, wheelSpeed.in(RotationsPerSecond)));
//     }

//     @Override
//     public void logData() {
//         Logger.recordOutput("Algaer/Wheel Speed", wheelMotor.getAbsoluteEncoder().getVelocity());
//         Logger.recordOutput("Algaer/Position", PivotMotor.getAbsoluteEncoder().getPosition());
//         Logger.recordOutput("Algaer/Target Speed", targetSpeed);
//         Logger.recordOutput("Algaer/Target Position", targetPosition);
//     }


// }
