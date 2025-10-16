package frc.robot.Subsystems.Drive;

public interface DriveIO {
    public void setTranslationalMultiplier(double TranslationalMultiplier);
    
    public void setRotMultiplier(double rotMultiplier);

    // also come up with a better method name
    public void driveCommands(double xTranslation, double yTranslation, double rotation, boolean fieldRelative); //camel case pls

    public void logData();
    
}