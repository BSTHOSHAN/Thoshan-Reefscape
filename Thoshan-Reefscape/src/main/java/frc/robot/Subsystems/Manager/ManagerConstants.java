package frc.robot.Subsystems.Manager;

import java.util.Map;

import frc.robot.Subsystems.Elevator.ElevatorStates;

public class ManagerConstants {
    public static final Map<Integer, ElevatorStates> REEF_SCORING_LEVELS = Map.of(1, ElevatorStates.L1, 2, ElevatorStates.L2, 3, ElevatorStates.L3, 4, ElevatorStates.L4);
}
