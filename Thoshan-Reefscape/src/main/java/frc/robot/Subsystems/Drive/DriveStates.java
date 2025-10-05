package frc.robot.Subsystems.Drive;

import org.team7525.subsystem.SubsystemStates;
import static frc.robot.Subsystems.Drive.DriveConstants.*;

public enum DriveStates implements SubsystemStates{
    DRIVE_SLOW(DRIVE_SLOW_ROTATION_MULTIPLER, DRIVE_SLOW_TRANSITIONAL_MULTIPLER),
    DRIVE_NORMAL(DRIVE_NORMAL_ROTATION_MULTIPLER, DRIVE_NORMAL_TRANSITIONAL_MULTIPLER);

    double rotMultiplier;
    double transitionalMultiplier;

    private DriveStates(double rotMultiplier, double translationalonalMultiplier) {
        this.rotMultiplier = rotMultiplier;
        this.transitionalMultiplier = transitionalMultiplier;
    }

    public double getRotMultiplier() {
        return rotMultiplier;
    }
    public double getTransitionalMultiplier() {
        return transitionalMultiplier;
    }
}
