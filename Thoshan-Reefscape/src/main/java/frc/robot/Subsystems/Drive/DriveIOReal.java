package frc.robot.Subsystems.Drive;

import java.io.File;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

import static frc.robot.Subsystems.Drive.DriveConstants.*;
public class DriveIOReal implements DriveIO{
    SwerveDrive swerveDrive;
    double translationalMultiplier;
    double rotMultiplier;

    public DriveIOReal() {
        try {
			File directory = new File(Filesystem.getDeployDirectory(), "swerve");
			double maxSpeed = Units.feetToMeters(MAX_SPEED);
			swerveDrive = new SwerveParser(directory).createSwerveDrive(maxSpeed, STARTING_POSE);
		} catch (Exception e) {
			System.out.println("hello");
		}
    }

    @Override
    public void setTranslationalMultiplier(double translationalMultiplier) {
        this.translationalMultiplier = translationalMultiplier;
    }

    @Override
    public void setRotMultiplier(double rotMultiplier) {
        this.rotMultiplier = rotMultiplier;
    }

    @Override
    public void driveCommands(double xTranslation, double yTranslation, double rotation, boolean fieldRelative) { 
        swerveDrive.drive(new Translation2d(translationalMultiplier * xTranslation, translationalMultiplier * yTranslation), rotMultiplier * rotation, fieldRelative, false);
    }

    @Override
    public void logData() {
        Logger.recordOutput("Drive/ Translational Multiplier", translationalMultiplier);
        Logger.recordOutput("Drive/ Rotational Multiplier", rotMultiplier);
        Logger.recordOutput("Drive/ Position", swerveDrive.getPose());
    }
}
