package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TopClaw extends Subsystem {
	
	DoubleSolenoid actuOne = new DoubleSolenoid(RobotMap.TopClaw1,RobotMap.TopClaw2);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleClaw() {
    	if (actuOne.get().equals(DoubleSolenoid.Value.kForward)) {
    		actuOne.set(DoubleSolenoid.Value.kReverse);
    	} else {
    		actuOne.set(DoubleSolenoid.Value.kForward);  		
    	}
    }

    public void openClaw() {
    	actuOne.set(DoubleSolenoid.Value.kForward);
    }

}


