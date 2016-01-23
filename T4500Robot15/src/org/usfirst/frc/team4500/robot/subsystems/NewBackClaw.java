package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NewBackClaw extends Subsystem {
	
	static DoubleSolenoid backSol = new DoubleSolenoid(RobotMap.backCl1, RobotMap.backCl2);
	
	public static void raise() {
		backSol.set(DoubleSolenoid.Value.kReverse);
	}
	
	public static void lower() {
		backSol.set(DoubleSolenoid.Value.kForward);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

