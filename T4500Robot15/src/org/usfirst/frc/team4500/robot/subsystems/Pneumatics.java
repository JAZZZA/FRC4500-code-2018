package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	Compressor compress = new Compressor(RobotMap.pneumaticsPort);
	Solenoid openDemo = new Solenoid(RobotMap.pneumaticsPort, RobotMap.openDemo);
	Solenoid closeDemo = new Solenoid(RobotMap.pneumaticsPort, RobotMap.closeDemo);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startCompressor() {
    	compress.start();
    }
    
    public void openDemo(boolean set) {
    	if (set)
    		openDemo.set(true);
    	else 
    		openDemo.set(false);
    }
    
    public void closeDemo(boolean set) {
    	if (set)
    		closeDemo.set(true);
    	else 
    		closeDemo.set(false);
    }
    
}

