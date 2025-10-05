package frc.robot.Subsystems.Drive;

public interface DriveIO {
    public void setTranslationalMultiplier(double translationalonalMultiplier);
    
    public void setRotMultiplier(double rotMultiplier);

    public void driveCommands(double xtranslation, double ytranslation, double rotation, boolean fieldrelative);

    public void logData();
    
}