package frc.robot.Subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Subsystems.Algaer.AlgaerStates;
import frc.robot.Subsystems.PassThrough.PassThroughStates;
import frc.robot.Subsystems.Coaraler.CoarlerStates;
import frc.robot.Subsystems.Elevator.ElevatorStates;



public enum ManagerStates implements SubsystemStates{
    IDLE(
        "Idle", 
        CoarlerStates.IDLE,
        PassThroughStates.IDLE,
        AlgaerStates.IDLE,
        ElevatorStates.IDLE      
    ),
    INTAKING_ALGAE_LOW(
        "Intaking Algae Low", 
        CoarlerStates.IDLE,
        PassThroughStates.IDLE,
        AlgaerStates.INTAKING,
        ElevatorStates.ALGAE_LOW
    ), 



    private String stateString = "";
	private CoarlerStates coaralerState;
	private PassThroughStates passThroughState;
	private AlgaerStates algaerState;
	private ElevatorStates ElavotorState;


    private ManagerStates ( String stateString, CoarlerStates coaralerState, PassThroughStates passThoughState, AlgaerStates algaerState, ElevatorStates ElavatorState) {
        this.stateString = stateString;
        this.coaralerState = coaralerState;
        this.passThroughState = passThroughState;
        this.algaerState = algaerState;
        this.ElavotorState = ElavatorState;
    }
}   

