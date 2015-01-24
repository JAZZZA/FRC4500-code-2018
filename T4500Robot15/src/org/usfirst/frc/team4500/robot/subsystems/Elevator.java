package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Elevator extends PIDSubsystem {

	private static double 
	kp = 1, //TODO: PID 
	ki = 0, 
	kd = 0;

	Encoder winchEncoder;
	SpeedController winch;

    // Initialize your subsystem here
    public Elevator() {
    	super("Winch", kp, ki, kd);
    	winch = new Talon(RobotMap.elevatorMotor);
    	winchEncoder = new Encoder(RobotMap.winchDriveEncoder1, RobotMap.winchDriveEncoder2);
        //setSetpoint(RobotMap.winchSetpoint); //Sets where the PID controller should move the system - may not need here
        setAbsoluteTolerance(RobotMap.winchTolerance);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return winchEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
    	winch.pidWrite(output);
    }
    
    public void setHeightBottom() {
    	/*if (winchEncoder.get() <= RobotMap.winchBottom){
    	while(winchEncoder.get() <= RobotMap.winchBottom)
    		winch.setDirection(Relay.Direction.kForward);
    	}
    	else if (winchEncoder.get() >= RobotMap.winchBottom){
    		while(winchEncoder.get() >= RobotMap.winchBottom)
        		winch.setDirection(Relay.Direction.kReverse);
    	} else {
    		winch.set(Relay.Value.kOff);
    	}*/		
    }
    
    public void setHeightPickUp() {
    	/*if (winchEncoder.get() <= RobotMap.winchPickup){
    	while(winchEncoder.get() <= RobotMap.winchPickup)
    		winch.setDirection(Relay.Direction.kForward);
    	}
    	else if (winchEncoder.get() >= RobotMap.winchPickup){
    		while(winchEncoder.get() >= RobotMap.winchPickup)
        		winch.setDirection(Relay.Direction.kReverse);
    	} else {
    		winch.set(Relay.Value.kOff);
    	}	*/	
    }
}
