package frc.robot.Subsystems.Coraler;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

public class Coraler extends Subsystem<CoralerStates>{

    public static Coraler instance;
    CoralerIO io;

    private Coraler() {
        super("Coraler",  CoralerStates.IDLE);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new CoraleIOReal();
            case SIM -> new CoralerIOSim();
            case TESTING -> new CoraleIOReal();
        };
    }
    public static Coraler getInstance() {
		if (instance == null) {
			instance = new Coraler();
		}
		return instance;
	}


    @Override
    protected void runState() {
        io.setWheelSpeed(getState().getWheelSpeed());
        io.logData();
    }

}
