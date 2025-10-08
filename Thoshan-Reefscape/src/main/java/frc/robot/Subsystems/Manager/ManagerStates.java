package frc.robot.Subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Subsystems.PassThrough.PassThroughStates;
import frc.robot.Subsystems.Coaraler.CoarlerStates;
import frc.robot.Subsystems.Elevator.ElevatorStates;



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
    );

    





    private String stateString = "";
	private CoarlerStates coaralerState;
	private PassThroughStates passThroughState;

	private ElevatorStates elevatorState;


    private ManagerStates ( String stateString, CoarlerStates coaralerState, PassThroughStates passThoughState, ElevatorStates elevatorState) {
        this.stateString = stateString;
        this.coaralerState = coaralerState;
        this.passThroughState = passThroughState;
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

