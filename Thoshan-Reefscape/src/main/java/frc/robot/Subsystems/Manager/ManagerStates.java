package frc.robot.Subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Subsystems.PassThrough.PassThroughStates;
import frc.robot.Subsystems.Coaraler.CoarlerStates;
import frc.robot.Subsystems.Elevator.ElevatorStates;

import static frc.robot.Subsystems.Manager.ManagerConstants.*;



public enum ManagerStates implements SubsystemStates{
    IDLE(
        "Idle", 
        CoarlerStates.IDLE,
        PassThroughStates.IDLE,
        ElevatorStates.IDLE      
    ),
    INTAKING_CORALER(
        "Intaking Coraler", 
        CoarlerStates.INTAKING,
        PassThroughStates.INTAKING,
        ElevatorStates.IDLE
    ),
    TRANSITIONING_SCORING_REEF(
		"Transitioning Scoring",
		CoarlerStates.IDLE,
        PassThroughStates.IDLE,
    	REEF_SCORING_LEVELS.get(Manager.getInstance().getReefScoringLevel())
	),
    SCORING_REEF(
		"Transitioning Scoring",
		CoarlerStates.SCORING,
        PassThroughStates.IDLE,
    	REEF_SCORING_LEVELS.get(Manager.getInstance().getReefScoringLevel())
	);




    private String stateString;
	private CoarlerStates coaralerState;
	private PassThroughStates passThroughState;

	private ElevatorStates elevatorState;


    private ManagerStates ( String stateString, CoarlerStates coaralerState, PassThroughStates passThroughStates, ElevatorStates elevatorState) {
        this.stateString = stateString;
        this.coaralerState = coaralerState;
        this.passThroughState = passThroughStates;
        this.elevatorState = elevatorState;
    }


    public CoarlerStates getCoarlerState() {
        return coaralerState;

    }
    public PassThroughStates getPassThoughState() {
        return passThroughState;
    }
    public ElevatorStates getElevatorState() {
        return elevatorState;
    }
}   

