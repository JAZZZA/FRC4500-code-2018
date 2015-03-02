package org.usfirst.frc.team4500.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	Timer time = new Timer();
	double waitTime;
	

	/** Causes the robot to wait for a certain amount of time, waitTime.
	 * @param double waitTime
	 */
    public Wait(double waitTime) {
    	this.waitTime = waitTime;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time.get() >= waitTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	time.start();
    	time.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
