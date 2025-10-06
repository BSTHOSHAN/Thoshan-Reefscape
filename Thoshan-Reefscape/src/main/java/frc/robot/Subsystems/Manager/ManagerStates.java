package frc.robot.Subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Subsystems.Algaer.AlgaerStates;
import frc.robot.Subsystems.Climber.ClimberStates;
import frc.robot.Subsystems.Coaraler.CoarlerStates;
import frc.robot.Subsystems.Elavator.ElavotorStates;

public enum ManagerStates implements SubsystemStates{
    IDLE(
        "Idle", 
        CoarlerStates.IDLE,
        ClimberStates.DOWN,
        AlgaerStates.IDLE,
        ElavotorStates.IDLE        
    ),
    CLIMB(El),



    private String stateString = "";
	private CoarlerStates coaralerState;
	private ClimberStates climberState;
	private AlgaerStates algaerState;
	private ElavotorStates ElavotorState;


    private ManagerStates ( String stateString, CoarlerStates coaralerState, ClimberStates climberState, AlgaerStates algaerState, ElavatorStates ElavatorState,) {
        this.stateString = stateString;
        this.coaralerState = coaralerState;
        this.climberState = climberState;
        this.algaerState = algaerState;
        this.ElavotorState = ElavatorState;
    }
}   

