package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorSetPickup extends Command {

    public ElevatorSetPickup() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.enable();
    	Robot.elevator.setSetpoint(RobotMap.winchBottom);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.elevator.setHeightPickUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
