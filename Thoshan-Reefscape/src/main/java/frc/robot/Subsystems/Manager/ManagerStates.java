package frc.robot.Subsystems.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Subsystems.Climber.ClimberStates;
import frc.robot.Subsystems.Coaraler.CoarlerStates;
import frc.robot.Subsystems.Elavator.ElavotorStates;

public enum ManagerStates implements SubsystemStates{
    IDLE(
        "Idle", 
        ElavotorStates.IDLE,
        ClimberStates.DOWN,
        CoarlerStates.IDLE,
        
    ),


    private String stateString;
	private CoarlerStates coaralerState;
	private ClimberStates climberState;
	private AlgaerStates algaerState;
	private ElavatorStates ElavotorState;
	private AutoAlignStates autoAlignStates;

    private ManagerStates ( String stateString, CoarlerStates coaralerState, ClimberStates climberState, AlgaerStates algaerState, ElavatorStates ElavatorState, AutoAlignStates autoAlignStates) {
        this.stateString = stateString;
        this.coaralerState = coaralerState;
        this.climberState = climberState;
        this.algaerState = algaerState;
        this.ElavotorState = ElavatorState;
        this.autoAlignStates = autoAlignStates;
    }
    
}
