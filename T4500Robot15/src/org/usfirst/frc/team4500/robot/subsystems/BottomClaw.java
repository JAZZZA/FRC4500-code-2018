package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BottomClaw extends Subsystem {
    
	Timer t1;
    
	Talon winch = new Talon(RobotMap.screwdriveMotor);
	Encoder screwEncoder = new Encoder(RobotMap.screwDriveEncoder1, RobotMap.screwDriveEncoder2);
	
	//int initialEncode = screwEncoder.get();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void closeClaw() {
    	while(screwEncoder.get() <= RobotMap.bottomClawClosed) {
        	winch.set(RobotMap.screwSpeed);
    	}
    }
    
    public void openClaw() {
    	while(screwEncoder.get() >= RobotMap.bottomClawOpen) {
        	winch.set(-1*RobotMap.screwSpeed);
    	}
    }
    
    public void noEncodeCloseClaw() {
    	while(t1.get() < RobotMap.timeToMoveScrew) {
    		winch.set(RobotMap.screwSpeed);
    	}
    }
    public void noEncodeOpenClaw() {
    	while(t1.get() < RobotMap.timeToMoveScrew) {
    		winch.set(RobotMap.screwSpeed);
    	}
    }
}

