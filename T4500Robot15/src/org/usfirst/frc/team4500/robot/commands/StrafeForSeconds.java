package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StrafeForSeconds extends Command {

	/**
	 * Strafes robot for a set amount of time in a set direction.
	 * 
	 * @param time
	 *            (seconds)
	 * @param direction
	 *            : true = right, false = left.
	 */
	
	double seconds;
	boolean dir;
	public StrafeForSeconds(double time, boolean direction) {
		requires(Robot.drivetrain);
		seconds = time;
		dir = direction;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.strafe(seconds, dir);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
