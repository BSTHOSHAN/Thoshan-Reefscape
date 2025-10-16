package frc.robot.Subsystems.Drive;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.wpilibj.XboxController;

public class Drive extends Subsystem<DriveStates>{
    
    XboxController xboxController = new XboxController(0);
    DriveIO io;
    private static Drive instance;
    private Drive() {
        super("Drive", DriveStates.DRIVE_NORMAL);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new DriveIOReal();
            case SIM -> new DriveIOSim();
            case TESTING -> new DriveIOReal();
        };
    }
    public static Drive getInstance() {
        if (instance == null) {
            instance = new Drive();
        }
        return instance;
    }
    

    @Override
    protected void runState() {
        io.setTranslationalMultiplier(getState().getTranslationalMultiplier());
        io.setRotMultiplier(getState().rotMultiplier);
        io.driveCommands(xboxController.getLeftX(), xboxController.getLeftY(), xboxController.getRightX(), false);
        io.logData();
    }
    
    
}
