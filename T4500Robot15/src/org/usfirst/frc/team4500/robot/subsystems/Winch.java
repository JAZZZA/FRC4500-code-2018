package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Winch extends PIDSubsystem {

	static double 
	kp = 0, 
	ki = 0,
	kd = 0;

    // Initialize your subsystem here
    public Winch() {

    	super("Winch", kp, ki, kd);
        // Use these to get going:
        setSetpoint(RobotMap.winchSetpoint); //Sets where the PID controller should move the system
        setAbsoluteTolerance(RobotMap.winchTolerance);
        enable();// Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
