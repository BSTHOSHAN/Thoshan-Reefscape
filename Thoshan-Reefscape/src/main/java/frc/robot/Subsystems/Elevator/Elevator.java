package frc.robot.Subsystems.Elevator;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

public class Elevator extends Subsystem<ElevatorStates>{
    
    ElevatorIO io;
    private static Elevator instance;
    
    private Elevator() {
        super("Elevator", ElevatorStates.IDLE);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new ElevatorIONeo();
            case SIM -> new ElevatorIOSim();
            case TESTING -> new ElevatorIONeo();
        };
    }
    
    public static Elevator getInstance() {
        if(instance == null) {
            instance = new Elevator();
        }
        return instance;
    }


    @Override
    protected void runState() {
        io.setHeight(getState().getPosition());
        io.logData();
    }
    
}
