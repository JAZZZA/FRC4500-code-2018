package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 *
 */
public class DriveUntilSonar extends Command {

	double range;
	double mySpeed;

	/**
	 * Function drives robot forward at a specified speed until a specified
	 * range (proximity in inches) from the sonar value.
	 * 
	 * @param proximity
	 *            (inches)
	 * @param speed
	 *            (motor speed 0 - 1)
	 */
	public DriveUntilSonar(double proximity, double speed) {
		requires(Robot.drivetrain);
		range = proximity;
		mySpeed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.driveForward(mySpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.drivetrain.isInRange(range);
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
