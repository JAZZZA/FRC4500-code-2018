package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BackClaw extends Subsystem {
    
    Talon backMotor = new Talon(RobotMap.backClawMotor);
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void backClawUp(){
    	backMotor.set(1);
    }

    public void backClawDown(){
    	backMotor.set(-0.5);
    }
    
}

