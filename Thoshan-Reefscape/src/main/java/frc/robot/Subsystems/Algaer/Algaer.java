// package frc.robot.Subsystems.Algaer;

// import static frc.robot.GlobalConstants.ROBOT_MODE;

// import org.team7525.subsystem.Subsystem;


// public class Algaer extends Subsystem<AlgaerStates> {
    
//     AlgaerIO io;
//     public static Algaer instance;

//     private Algaer() {
//         super("Algaer", AlgaerStates.IDLE); 
//         this.io = switch(ROBOT_MODE) {
//             case REAL -> new AlgaerIONeo();
//             case TESTING -> new AlgaerIONeo();
//         };
//     }     
//     public static Algaer getInstance() {
//         if (instance == null) {
//            instance = new Algaer();
//         }
//         return instance;
//     }

//     @Override
//     protected void runState() {
//         io.setPosition(getState().getPosition());
//         io.setWheelSpeed(getState().getWheelSpeed());
//         io.logData();
//     }

// }
