package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BottomClaw extends Subsystem {
    
	Relay winch = new Relay(RobotMap.clawWinch);
	Encoder screwEncoder = new Encoder(RobotMap.screwDriveEncoder1, RobotMap.screwDriveEncoder2);
	
	//int initialEncode = screwEncoder.get();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void closeClaw() {
    	while(screwEncoder.get() <= RobotMap.bottomClawClosed) {
        	winch.set(Relay.Value.kForward);
    	}
    }
    
    public void openClaw() {
    	while(screwEncoder.get() >= RobotMap.bottomClawOpen) {
        	winch.set(Relay.Value.kReverse);
    	}
    }
    


	/*private void backAway() {
		
		//What exactly do we need to back away for again?
		
	}*/	
}

