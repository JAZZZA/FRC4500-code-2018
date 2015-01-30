package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BottomClaw extends Subsystem {
    
	Timer t1;
    
	Talon sdMotor = new Talon(RobotMap.screwdriveMotor);
	//Encoder screwEncoder = new Encoder(RobotMap.screwDriveEncoder1, RobotMap.screwDriveEncoder2);
	DigitalInput limitClose = new DigitalInput(RobotMap.limitBottomClawC); //Limit Top Switch  = Port 3
	DigitalInput limitOpen = new DigitalInput(RobotMap.limitBottomClawO);
	
	
	//int initialEncode = screwEncoder.get();

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void closeClaw() {
    	while(limitClose.get() == false) {
        	sdMotor.set(RobotMap.screwSpeed);
    	}
    }
    
    public void openClaw() {
    	while(limitOpen.get() == false) {
        	sdMotor.set(-1*RobotMap.screwSpeed);
    	}
    }
    
    public void noEncodeCloseClaw() {
    	while(t1.get() < RobotMap.timeToMoveScrew) {
    		sdMotor.set(RobotMap.screwSpeed);
    	}
    }
    public void noEncodeOpenClaw() {
    	while(t1.get() < RobotMap.timeToMoveScrew) {
    		sdMotor.set(RobotMap.screwSpeed);
    	}
    }
}

