package frc.robot.Subsystems.Drive;

import org.team7525.subsystem.SubsystemStates;
import static frc.robot.Subsystems.Drive.DriveConstants.*;

public enum DriveStates implements SubsystemStates{
    DRIVE_SLOW(DRIVE_SLOW_ROTATION_MULTIPLER, DRIVE_SLOW_TRANSITIONAL_MULTIPLER),
    DRIVE_NORMAL(DRIVE_NORMAL_ROTATION_MULTIPLER, DRIVE_NORMAL_TRANSITIONAL_MULTIPLER);

    double rotMultiplier;
    double translationalonalMultiplier;

    private DriveStates(double rotMultiplier, double translationalMultiplier) {
        this.rotMultiplier = rotMultiplier;
        this.translationalonalMultiplier = translationalMultiplier;
    }

    public double getRotMultiplier() {
        return rotMultiplier;
    }
    public double getTranslationalMultiplier() {
        return translationalonalMultiplier;
    }
}
