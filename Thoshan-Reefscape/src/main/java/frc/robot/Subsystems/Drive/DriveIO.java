package frc.robot.Subsystems.Drive;

public interface DriveIO {
    public void setTranslationalMultiplier(double translationalonalMultiplier);
    
    public void setRotMultiplier(double rotMultiplier);

    // also come up with a better method name
    public void driveCommands(double xtranslation, double ytranslation, double rotation, boolean fieldrelative); //camel case pls

    public void logData();
    
}