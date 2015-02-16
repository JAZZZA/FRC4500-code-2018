package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToFace extends Command {
	private static final double TOLERANCE = 2; //Degrees
	double angle;

	public TurnToFace(double angle) {
		requires(Robot.drivetrain);
		this.angle = angle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.turnToFace(angle, Robot.drivetrain.gyroscope,
				Robot.drivetrain.drive);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.drivetrain.getAngle() > angle - TOLERANCE
				&& Robot.drivetrain.getAngle() < angle + TOLERANCE;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
