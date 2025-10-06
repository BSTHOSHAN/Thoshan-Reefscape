package frc.robot.Subsystems.Elavator;

import static frc.robot.Subsystems.Elavator.ElavotorConstants.*;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Distance;

public class ElavatorIONeo implements ElavatorIO{
    TalonFX upMotor;
    TalonFX downMotor;
    PIDController upController;
    PIDController downController;
    Distance targetHeight;

    private ElavatorIONeo() {

        upMotor = new TalonFX(1);
        downMotor = new TalonFX(0);

        upController = UP_CONTROLLER.get();
        downController = DOWN_CONTROLLER.get();
    }

    @Override
    public void setHieght(Distance Height) {
        targetHeight = Height;

        upMotor.set(upController.calculate(upMotor.getPosition()), targetHeight);
    }

    @Override
    public void logData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logData'");
    }
}
