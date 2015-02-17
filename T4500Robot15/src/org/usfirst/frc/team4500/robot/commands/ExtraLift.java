package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class ExtraLift extends Command {

    Timer time = new Timer();
	
    public ExtraLift() {
        requires(Robot.newElevator);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.newElevator.winchmotor.set(.5); //Auto-Lift set to half speed 	 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time.get() >= .5; //Returns true when lift time is less than current time
    }

    // Called once after isFinished returns true
    protected void end() {
    	time.stop();
    	Robot.newElevator.winchmotor.set(.1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
