package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BottomClaw extends Subsystem {
	
	DoubleSolenoid actuator = new DoubleSolenoid(RobotMap.bottomCl1,RobotMap.bottomCl2);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleClaw() {
    	if (actuator.get().equals(DoubleSolenoid.Value.kForward)) {
    		actuator.set(DoubleSolenoid.Value.kReverse);
    	} else {
    		actuator.set(DoubleSolenoid.Value.kForward);  		
    	}
    }
}

