package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticsMain extends Subsystem {
	
	Compressor compress = new Compressor(RobotMap.pneumaticsModule);
	DoubleSolenoid mainSolenoid = new DoubleSolenoid(RobotMap.pneumaticsModule, RobotMap.openDemo, RobotMap.closeDemo);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startCompressor() {
    	compress.start();
    }
    
    public void toggleMain() {
    	if (mainSolenoid.get().equals(DoubleSolenoid.Value.kForward))
    		mainSolenoid.set(DoubleSolenoid.Value.kReverse);
    	else mainSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
}

