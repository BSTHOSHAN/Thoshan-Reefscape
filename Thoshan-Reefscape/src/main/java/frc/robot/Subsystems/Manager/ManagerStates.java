package frc.robot.Subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Subsystems.PassThrough.PassThroughStates;
import frc.robot.Subsystems.Coraler.CoralerStates;
import frc.robot.Subsystems.Elevator.ElevatorStates;

import static frc.robot.Subsystems.Manager.ManagerConstants.*;

import java.util.function.Supplier;



public enum ManagerStates implements SubsystemStates{
    IDLE(
        "Idle", 
        CoralerStates.IDLE,
        PassThroughStates.IDLE,
        () ->ElevatorStates.IDLE      
    ),
    INTAKING_CORALER(
        "Intaking Coraler", 
        CoralerStates.INTAKING,
        PassThroughStates.INTAKING,
        () ->ElevatorStates.IDLE
    ),
    TRANSITIONING_SCORING_REEF(
		"Transitioning Scoring",
		CoralerStates.IDLE,
        PassThroughStates.IDLE,
    	() -> REEF_SCORING_LEVELS.get(Manager.getInstance().getReefScoringLevel())
	),
    SCORING_REEF(
		"Scoring Reef",
		CoralerStates.SCORING,
        PassThroughStates.IDLE,
    	() -> REEF_SCORING_LEVELS.get(Manager.getInstance().getReefScoringLevel())
	),
    PASS_THORUGH_INTAKE( "Pass Through Intake",
        CoralerStates.IDLE,
        PassThroughStates.INTAKING,
        () -> ElevatorStates.IDLE
    );




    private String stateString;
	private CoralerStates coaralerState;
	private PassThroughStates passThroughState;
	private Supplier<ElevatorStates> elevatorState;


    private ManagerStates ( String stateString, CoralerStates coaralerState, PassThroughStates passThroughStates, Supplier<ElevatorStates> elevatorState) {
        this.stateString = stateString;
        this.coaralerState = coaralerState;
        this.passThroughState = passThroughStates;
        this.elevatorState = elevatorState;
    }
    public String getStateString() {
        return stateString;
    }


    public CoralerStates getCoarlerState() {
        return coaralerState;

    }
    public PassThroughStates getPassThoughState() {
        return passThroughState;
    }
    public Supplier<ElevatorStates> getElevatorState() {
        return elevatorState;
    }
}   

