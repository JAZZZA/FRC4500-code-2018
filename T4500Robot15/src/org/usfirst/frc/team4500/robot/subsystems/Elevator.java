package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */



public class Elevator extends Subsystem {
  
	DigitalInput limitTop = new DigitalInput(RobotMap.limitTop); //Limit Top Switch  = Port 3
	DigitalInput limitBottom = new DigitalInput(RobotMap.limitBottom); //Limit Bottom Switch = Port 4
	Talon winch = new Talon(RobotMap.elevatorMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void setHeightBottom(){
    	while(limitBottom.get() == false)
    		winch.set(0.75);
    		}
    
    public void setHeightTop(){
    	while(limitTop.get() == false)
    		winch.set(0.75);
    }
}


