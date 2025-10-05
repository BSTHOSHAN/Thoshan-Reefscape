package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class GlobalConstants {
    
	public static final double UPDATE_PERIOD = 0.02;
	public static final XboxController xboxController = new XboxController(0);

	public enum RobotMode {
		REAL,
		TESTING
	}

    public static final RobotMode ROBOT_MODE = "Crash".equals(System.getenv("CI_NAME")) ||
    !Robot.isReal()
    ? RobotMode.TESTING
    : RobotMode.REAL;
}

   

