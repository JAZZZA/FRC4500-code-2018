package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Elevator extends PIDSubsystem {

	static double 
	kp = 0, 
	ki = 0,
	kd = 0;
	
	Encoder winchEncoder = new Encoder(RobotMap.winchDriveEncoder1, RobotMap.winchDriveEncoder2);
	Relay winch = new Relay(RobotMap.clawWinch);

    // Initialize your subsystem here
    public Elevator() {
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
    
    public void setHeightBottom() {
    	if (winchEncoder.get() <= RobotMap.winchBottom){
    	while(winchEncoder.get() <= RobotMap.winchBottom)
    		winch.setDirection(Relay.Direction.kForward);
    	}
    	else if (winchEncoder.get() >= RobotMap.winchBottom){
    		while(winchEncoder.get() >= RobotMap.winchBottom)
        		winch.setDirection(Relay.Direction.kReverse);
    	} else {
    		winch.set(Relay.Value.kOff);
    	}		
    }
    
    public void setHeightPickUp() {
    	if (winchEncoder.get() <= RobotMap.winchPickup){
    	while(winchEncoder.get() <= RobotMap.winchPickup)
    		winch.setDirection(Relay.Direction.kForward);
    	}
    	else if (winchEncoder.get() >= RobotMap.winchPickup){
    		while(winchEncoder.get() >= RobotMap.winchPickup)
        		winch.setDirection(Relay.Direction.kReverse);
    	} else {
    		winch.set(Relay.Value.kOff);
    	}		
    }
}
