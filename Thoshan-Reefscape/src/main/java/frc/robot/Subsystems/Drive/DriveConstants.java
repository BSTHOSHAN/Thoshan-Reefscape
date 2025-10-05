package frc.robot.Subsystems.Drive;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class DriveConstants {
    public static final double DRIVE_NORMAL_ROTATION_MULTIPLER = 1;
	public static final double DRIVE_NORMAL_TRANSITIONAL_MULTIPLER = 1;
	public static final double DRIVE_SLOW_ROTATION_MULTIPLER = 0.5;
	public static final double DRIVE_SLOW_TRANSITIONAL_MULTIPLER = 0.5;

    public static final Pose2d STARTING_POSE = new Pose2d(3, 3, Rotation2d.kZero);
    public static final double MAX_SPEED = 20;
}
