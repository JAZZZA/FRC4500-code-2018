package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TopClaw extends Subsystem {
	
	DoubleSolenoid actuOne = new DoubleSolenoid(RobotMap.topClawOne1, RobotMap.topClawOne2);
	DoubleSolenoid actuTwo = new DoubleSolenoid(RobotMap.topClawTwo1, RobotMap.topClawTwo2);
	
	
	public void toggleClaw() {
		if (actuOne.get().equals(DoubleSolenoid.Value.kForward)) {
			actuOne.set(DoubleSolenoid.Value.kReverse);
			actuTwo.set(DoubleSolenoid.Value.kReverse);
		}
    	else {
    		actuOne.set(DoubleSolenoid.Value.kForward);
    		actuTwo.set(DoubleSolenoid.Value.kForward);
    	}
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

