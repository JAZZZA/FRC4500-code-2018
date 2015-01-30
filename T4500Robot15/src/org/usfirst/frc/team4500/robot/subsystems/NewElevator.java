package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.DefaultElevatorCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NewElevator extends Subsystem {
	public Talon winchmotor = new Talon(RobotMap.elevatorMotor);
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DefaultElevatorCommand());
    	//if (Robot.oi.getTrigger());
        //winchmotor.set(.25);
    }
}

