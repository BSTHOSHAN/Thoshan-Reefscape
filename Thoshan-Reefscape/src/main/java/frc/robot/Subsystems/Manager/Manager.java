package frc.robot.Subsystems.Manager;

import static frc.robot.GlobalConstants.xboxController;

import java.util.function.BooleanSupplier;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.wpilibj.XboxController;

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

        addTrigger(ManagerStates.IDLE, , () -> XboxController.getLeftBumperButtonPressed());
    }



    @Override
    protected void runState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runState'");
    }
}
