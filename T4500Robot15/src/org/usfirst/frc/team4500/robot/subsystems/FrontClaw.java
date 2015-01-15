package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FrontClaw extends Subsystem {
    
	
	Talon winch = new Talon(RobotMap.clawWinch);
	private int speedWinch = 1;
	//Some Kind of sensor set in here!!!
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pickUp() {
    	
    	//while sensor =! is at a certain point
    	winch.set(speedWinch);
    }

	private void backAway() {
		
		//Make this do shit
		
	}
	
	public void winchControl(int speed) {
		winch.set(speed);
	}
	
	
	
}

