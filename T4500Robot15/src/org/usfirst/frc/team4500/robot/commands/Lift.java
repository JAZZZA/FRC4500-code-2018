package org.usfirst.frc.team4500.robot.commands;

import org.usfirst.frc.team4500.robot.Robot;
import org.usfirst.frc.team4500.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lift extends Command {

	Timer timer = new Timer();
	double time;

	public Lift() {
		requires(Robot.newElevator);
		this.time = 0;
	}

	public Lift(double time) {
		requires(Robot.newElevator);
		this.time = time;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.newElevator.winchmotor.set(.5); // Auto-Lift set to half speed
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (time == 0) {
			return timer.get() >= RobotMap.liftTime; // Returns true when lift
														// time is less than
														// current time
		} else {
			return timer.get() >= time;
		}

	}

	// Called once after isFinished returns true
	protected void end() {
		timer.stop();
		Robot.newElevator.winchmotor.set(.1);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
