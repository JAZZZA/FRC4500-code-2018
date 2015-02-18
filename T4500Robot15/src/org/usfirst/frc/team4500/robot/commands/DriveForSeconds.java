package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForSeconds extends Command {
	Timer timer = new Timer();
	double seconds;
	double speed;
	
    public DriveForSeconds(double speed, double seconds) {
        requires(Robot.drivetrain);
        this.seconds = seconds;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.driveStraight(-speed, Robot.drivetrain.gyroscope, Robot.drivetrain.drive);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= seconds;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
