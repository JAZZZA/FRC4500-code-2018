package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.CompressorStart;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticsDemo extends Subsystem {
	
	Compressor compress = new Compressor(RobotMap.pneumaticsModule);
	DoubleSolenoid demoSolenoid = new DoubleSolenoid(RobotMap.pneumaticsModule, RobotMap.openDemo, RobotMap.closeDemo);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
     
    	setDefaultCommand(new CompressorStart());
    	
    }
    
    public void startCompressor() {
    	compress.start();
    }
    
    public void toggleDemo() {
    	if (demoSolenoid.get().equals(DoubleSolenoid.Value.kForward))
    		demoSolenoid.set(DoubleSolenoid.Value.kReverse);
    	else demoSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
}

