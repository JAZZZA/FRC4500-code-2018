package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.Solenoid;
/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon rightIntake1;
	private Talon leftIntake1;
	private Talon rightIntake2;
	private Talon leftIntake2;
	private Solenoid rightPistonIntake;  
	private Solenoid leftPistonIntake;
	public Intake() {
		rightIntake1= new Talon(RobotMap.rightIntake1);
		leftIntake1 = new Talon(RobotMap.leftIntake1);
		rightIntake2 = new Talon(RobotMap.rightIntake2);
		leftIntake2 = new Talon(RobotMap.leftIntake2);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void ObtainBlcok (double speed) {
    	rightIntake1.set(speed);
    	leftIntake1.set(-speed);
    }
    public void Release (double speed) {
    	rightIntake1.set(-speed);
    	leftIntake1.set(speed);
    }
    public void FoldIntake1 (double speed) {
    	rightIntake2.set(speed);
    	leftIntake2.set(-speed);
    }
    public void UnbfoldIntake1 (double speed) {
    	rightIntake2.set(-speed);
    	leftIntake2.set(speed);
    }
    public void FoldIntake (boolean openIndicator) {
    	rightPistonIntake.set(openIndicator);
    	leftPistonIntake.set(openIndicator);
    }

}

