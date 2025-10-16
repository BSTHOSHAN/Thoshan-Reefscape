package frc.robot.Subsystems.PassThrough;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

public class PassThrough extends Subsystem<PassThroughStates>{

    PassThroughIO io;
    private static PassThrough instance;

    private PassThrough() {
        super("Pass Through", PassThroughStates.IDLE);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new PassThroughIONeo();
            case SIM -> new PassThroughIOSim();
            case TESTING -> new PassThroughIONeo();
        };
    }
    public static PassThrough getInstance() {
        if (instance == null) {
           instance = new PassThrough();
        }
        return instance;
    }

    @Override
    protected void runState() {
        io.setWheelSpeed(getState().getWheelSpeed());
        io.logData();
    }
    
}
