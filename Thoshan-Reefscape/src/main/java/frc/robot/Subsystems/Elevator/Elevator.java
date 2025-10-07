package frc.robot.Subsystems.Elevator;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

import frc.robot.Subsystems.PassThrough.PassThroughStates;

public class Elevator extends Subsystem<ElevatorStates>{
    
    ElevatorIO io;
    private static Elevator instance;
    
    
    private Elevator() {
        super("Elevator", ElevatorStates.IDLE);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new ElevatorIONeo();
            case TESTING -> new ElevatorIONeo();
        };
    }



    @Override
    protected void runState() {
        io.setHieght(getState().getPosition());
        io.logData();
    }
    
}
