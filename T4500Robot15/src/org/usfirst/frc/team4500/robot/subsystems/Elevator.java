package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.BreakElevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
  
	DigitalInput limitTop = new DigitalInput(RobotMap.limitTop); //Limit Top Switch  = Port 3
	//DigitalInput limitBottom = new DigitalInput(RobotMap.limitBottom); //Limit Bottom Switch = Port 4
	Talon winch = new Talon(RobotMap.elevatorMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new BreakElevator());
    }

    /*public void setHeightBottom(){
    	while(limitBottom.get() == false)
    		winch.set(-1);
    	}*/
    
    public void setHeightTop(){
    	while (limitTop.get() == false) //changed while to if for hold down
    		winch.set(1);
    }
    
    public void breakElevator(boolean stay)  {
    	if(limitTop.get() == false && stay)
    		winch.set(RobotMap.breakSpeed);
    	else winch.set(RobotMap.goDownResistance);
    }
    
}


