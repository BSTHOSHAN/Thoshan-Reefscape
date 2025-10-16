package frc.robot.Subsystems.Elevator;

import static edu.wpi.first.units.Units.Meter;
import static edu.wpi.first.units.Units.Meters;
import static frc.robot.Subsystems.Elevator.ElevotorConstants.*;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;

public class ElevatorIOSim implements ElevatorIO {

    SingleJointedArmSim armSim;
    PIDController heightController;
    Distance targetHeight;

    public ElevatorIOSim() {
        armSim = new SingleJointedArmSim(
		LinearSystemId.createSingleJointedArmSystem(DCMotor.getNEO(1), 0.192383865, 67.5),
		DCMotor.getNEO(1),
		67.5,
		.3,
		0,
		Units.degreesToRadians(180),
		true,
		0);
        heightController = new PIDController(1, 0, 0);

        heightController = ELEVATOR_CONTROLLER.get();
    }



    @Override
    public void setHeight(Distance Height) {
        targetHeight = Height;
        armSim.setInput(heightController.calculate(armSim.getAngleRads(), targetHeight.in(Meters)));
    }

    @Override
    public void logData() {
        armSim.update(0.02);

        Logger.recordOutput("Elevator/ Target Height", targetHeight);
        Logger.recordOutput("Elevator/ Current Height", armSim.getAngleRads());
        Logger.recordOutput("Intake/ Intake Pose", new Pose3d(ZEROED_POSITION_TRANSLATION, new Rotation3d(0, armSim.getAngleRads(), 0)));
    }
    
    
    
    

    
}
