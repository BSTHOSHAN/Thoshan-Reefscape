package frc.robot.Subsystems.Climber;

import static frc.robot.Subsystems.Climber.ClimberConstants.*;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;

public class ClimberIONeo implements ClimberIO{
    SparkMax climberMotor;
    PIDController climbController;
    Angle targetPosition;

    public ClimberIONeo() {
        climberMotor = new SparkMax( POSITION_MOTOR_ID, MotorType.kBrushless);

        climbController = POSITION_CONTROLLER.get();
    }

    @Override
    public void setPosition(Angle position) {
        targetPosition = position;
        climberMotor.set(climbController.calculate(climberMotor.getAbsoluteEncoder().getPosition()));
    }

    @Override
    public void logData() {
        Logger.recordOutput("Climber/Position", climberMotor.getAbsoluteEncoder().getPosition());
        Logger.recordOutput("Climber/Target Position", targetPosition);
    }
    


}
