package frc.robot.Subsystems.Manager;

import static frc.robot.GlobalConstants.xboxController;

import java.util.function.BooleanSupplier;

import org.littletonrobotics.junction.Logger;
import org.team7525.subsystem.Subsystem;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.Coaraler.Coaraler;
import frc.robot.Subsystems.Drive.Drive;
import frc.robot.Subsystems.Elevator.Elevator;
import frc.robot.Subsystems.PassThrough.PassThrough;

import static frc.robot.Subsystems.Manager.ManagerStates.*;

public class Manager extends Subsystem<ManagerStates>{

    private static Manager instance = new Manager();

    public int reefScoringLevel = 3;

    XboxController xboxController = new XboxController(0);

    private Manager() {
        super( "Manager", ManagerStates.IDLE);

        addRunnableTrigger(() -> this.reefScoringLevel = 1, () -> xboxController.getPOV() == 180);
        addRunnableTrigger(() -> this.reefScoringLevel = 2, () -> xboxController.getPOV() == 90);
        addRunnableTrigger(() -> this.reefScoringLevel = 3, () -> xboxController.getPOV() == 270);
        addRunnableTrigger(() -> this.reefScoringLevel = 4, () -> xboxController.getPOV() == 0);

        addTrigger( IDLE, INTAKING_CORALER, () -> xboxController.getLeftBumperButtonPressed());
        addTrigger( INTAKING_CORALER, IDLE , () -> xboxController.getLeftBumperButtonPressed());


    }

    public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}


    @Override
    protected void runState() {
        PassThrough.getInstance().setState(getState().getPassThoughState());
        Coaraler.getInstance().setState(getState().getCoarlerState());
        Elevator.getInstance().setState(getState().getElevatorState());

        Logger.recordOutput("Manger/ State tine", getStateTime());
		Logger.recordOutput("Manager/ State String", getState().getStateString());

        PassThrough.getInstance().periodic();
        Coaraler.getInstance().periodic();
        Elevator.getInstance().periodic();
        Drive.getInstance().periodic();
    }
}
