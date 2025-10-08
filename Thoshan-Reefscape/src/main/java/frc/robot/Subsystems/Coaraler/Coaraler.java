package frc.robot.Subsystems.Coaraler;

import static frc.robot.GlobalConstants.ROBOT_MODE;

import org.team7525.subsystem.Subsystem;

public class Coaraler extends Subsystem<CoarlerStates>{

    public static Coaraler instance;
    CoaralerIO io;

    private Coaraler() {
        super("Coaraler",  CoarlerStates.IDLE);
        this.io = switch(ROBOT_MODE) {
            case REAL -> new CoaralerIONeo();
            case TESTING -> new CoaralerIONeo();
        };
    }
    public static Coaraler getInstance() {
		if (instance == null) {
			instance = new Coaraler();
		}
		return instance;
	}


    @Override
    protected void runState() {
        io.setWheelSpeed(getState().getWheelSpeed());
        io.logData();
    }

}
