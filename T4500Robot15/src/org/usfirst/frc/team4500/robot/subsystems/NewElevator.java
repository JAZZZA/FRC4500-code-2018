package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NewElevator extends Subsystem {
	Talon winchmotor = new Talon(RobotMap.elevatorMotor);
    
    public void initDefaultCommand() {
        winchmotor.set(Robot.oi.getElevator());
    }
}

