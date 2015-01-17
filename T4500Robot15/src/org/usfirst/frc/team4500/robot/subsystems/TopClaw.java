package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TopClaw extends Subsystem {
	
	DoubleSolenoid actuOne = new DoubleSolenoid(RobotMap.topClawOne1, RobotMap.topClawOne2);
	DoubleSolenoid actuTwo = new DoubleSolenoid(RobotMap.topClawTwo1, RobotMap.topClawTwo2);
	
	/**
	 * Toggles the top claw depending on its current state
	 */
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
	
	/**
	 * Puts the current state of the top claw onto the smart dashboard with a string
	 */
	public void putTopClawDashData() {
		String clawStatus = new String();
		if (actuOne.get().equals(DoubleSolenoid.Value.kForward)) {
			clawStatus = "Open";
		}
		else if (actuOne.get().equals(DoubleSolenoid.Value.kOff)) {
			clawStatus = "Off";
		}
		else if (actuOne.get().equals(DoubleSolenoid.Value.kReverse)) {
			clawStatus = "Closed";
		}
		else {
			clawStatus = "NO DATA";
		}
		SmartDashboard.putString("Top claw status", clawStatus);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

